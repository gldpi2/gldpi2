/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import controller.CostCtrl;
import dao.CostDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import model.Mensuration;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author Matheus
 */
public class UpdaterCostThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private CostDAO costDao = new CostDAO();
    CostCtrl ctrl = new CostCtrl();
    private TimeSeries series;
    private JLabel flowValue;
    private JLabel tensionValue;
    private JLabel potencyvalue;
    private JLabel maxCostValue;
    private JLabel minCostValue;

    public UpdaterCostThread(TimeSeries series) {
        this.series = series;
    }

    public UpdaterCostThread(TimeSeries series, JLabel flowValue, JLabel tensionValue, JLabel potencyValue,
            JLabel maxCostValue, JLabel minCostValue) {
        this.series = series;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
        this.maxCostValue = maxCostValue;
        this.minCostValue = minCostValue;
    }

    /**
     *
     */
    @Override
    public void run() {
        List<Mensuration> mensuration = this.costDao.parameters();
        double[] cost = new double[mensuration.size()];
        while (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                series.addOrUpdate(m.getMillisecond(), m.getPotency() * costDao.getCostValue());
                for (int i = 0; i < mensuration.size(); i++) {
                    cost[i] = costDao.getCostValue() * m.getPotency();
                    double costNext = costDao.getCostValue() * mensuration.iterator().next().getPotency();
                    if(cost[i]>costNext)    {
                        updateCostMax(cost[i]);
                        updateCostMin(costNext);
                    }
                }

                if (this.tensionValue != null) {
                    if (this.tensionValue.isShowing()) {
                        try {
                            updateButton(m);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(UpdaterCostThread.class.getName()).log(Level.SEVERE, null, ex);
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
        if(this.flowValue != null){
            this.flowValue.setText(String.valueOf(m.getFlow()));
            this.tensionValue.setText(String.valueOf(m.getTension()));
            this.potencyvalue.setText(String.valueOf(m.getPotency()));
          }
            Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
  }

    private void updateCostMax(double maxCost) {
        if(maxCostValue != null){
            maxCostValue.setText(String.format("%.2f", maxCost));
        }
        
   }
    
    private void updateCostMin(double minCost){
        if(minCostValue != null){
            minCostValue.setText(String.format("%.2f", minCost));
        }
    }
}
