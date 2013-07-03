/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller.CostCtrl;
import dao.CostDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.GaussJordan;
import model.Mensuration;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author artur, Matheus
 */
public class EstimationOnRealCostThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private CostDAO costDao = new CostDAO();
    CostCtrl ctrl = new CostCtrl();
    GaussJordan gj = new GaussJordan();
    private TimeSeries series;
    private TimeSeries estimate;
    private JLabel flowValue;
    private JLabel tensionValue;
    private JLabel potencyvalue;
    private JLabel maxCostValue;
    private JLabel minCostValue;
    private JLabel estimateValue;
    private static final int NUM_ESTIMATES = 3;

    public EstimationOnRealCostThread(TimeSeries series, TimeSeries estimate) {
        this.series = series;
        this.estimate = estimate;
    }

    public EstimationOnRealCostThread(TimeSeries series, TimeSeries estimate, JLabel flowValue, JLabel tensionValue, JLabel potencyValue,
            JLabel estimateValue, JLabel maxCostValue, JLabel minCostValue) {
        this.series = series;
        this.estimate = estimate;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
        this.maxCostValue = maxCostValue;
        this.minCostValue = minCostValue;
        this.estimateValue = estimateValue;
    }

    /**
     *
     */
    @Override
    public void run() {
        List<Mensuration> mensuration = this.costDao.parameters();
        double[] cost = new double[mensuration.size()];
        ArrayList<Mensuration> estimate_data = new ArrayList();
        while (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                series.addOrUpdate(m.getMillisecond(), m.getPotency() * costDao.getCostValue());
                for (int i = 0; i < mensuration.size(); i++) {
                    cost[i] = costDao.getCostValue() * m.getPotency();
                    double costNext = costDao.getCostValue() * mensuration.iterator().next().getPotency();
                    if (cost[i] > costNext) {
                        updateCostMax(cost[i]);
                        updateCostMin(costNext);
                    }
                }

                if (estimate_data.size() < NUM_ESTIMATES) {
                    estimate_data.add(m);
                } else {
                    estimate_data.remove(0);
                    estimate_data.add(m);
                    int estimationNumber = Integer.parseInt(estimateValue.getText());
                    double[] fx = new double[NUM_ESTIMATES];
                    double[] estimation = new double[NUM_ESTIMATES];
                    int k;
                    int i = 0;
                    while (i < NUM_ESTIMATES) {
                        fx[i] = estimate_data.get(i).getPotency() * costDao.getCostValue();
                        i++;
                    }
                    gj.loadFx(fx);
                    estimation = gj.estimate(estimationNumber);
                    Second estimativeTime;
                    for (i = 0; i < estimation.length; i++) {
                        estimativeTime = m.getMillisecond().getSecond();
                        for (k = 0; k < i; k++) {
                            estimativeTime = (Second) estimativeTime.next();
                        }
                        estimate.addOrUpdate(estimativeTime, estimation[i]);
                    }
                }

                if (this.tensionValue != null) {
                    if (this.tensionValue.isShowing()) {
                        try {
                            updateButton(m);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EstimationOnRealCostThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            try {
                Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateButton(Mensuration m) throws InterruptedException {
        if (this.flowValue != null) {
            this.flowValue.setText(String.valueOf(m.getFlow()));
            this.tensionValue.setText(String.valueOf(m.getTension()));
            this.potencyvalue.setText(String.valueOf(m.getPotency()));
        }
        Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
    }

    private void updateCostMax(double maxCost) {
        if (maxCostValue != null) {
            maxCostValue.setText(String.format("%.2f", maxCost));
        }

    }

    private void updateCostMin(double minCost) {
        if (minCostValue != null) {
            minCostValue.setText(String.format("%.2f", minCost));
        }
    }
}
