package utils;

import controller.LoadCurveCtrl;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JLabel;
import model.GaussJordan;
import model.Mensuration;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author artur, wagner
 */
public class EstimationOnRealLoadThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private LoadCurveCtrl loadCurveCtrl = new LoadCurveCtrl();
    private TimeSeries series, estimate;
    private JLabel flowValue;
    private JLabel tensionValue;
    private JLabel potencyvalue;
    private JLabel estimateValue;
    private JLabel maxPotencyValue;
    private JLabel maxPotencyTime;
    private JLabel minPotencyValue;
    private JLabel minPotencyTime;
    private static final int NUM_ESTIMATES = 3;
    GaussJordan gj = new GaussJordan();

    /**
     * Método construtor da classe EstimationOnRealLoadThread.
     *
     * @param series XYSeries Referência da série apresentada no gráfico.
     */
    public EstimationOnRealLoadThread(TimeSeries series, TimeSeries estimate) {
        this.series = series;
        this.estimate = estimate;
    }

    public EstimationOnRealLoadThread(TimeSeries series, TimeSeries estimate,
            JLabel flowValue, JLabel tensionValue, JLabel potencyValue, JLabel estimateValue,
            JLabel maxPotencyValue, JLabel maxPotencyTime,
            JLabel minPotencyValue, JLabel minPotencyTime) {
        this.series = series;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
        this.estimateValue = estimateValue;
        this.maxPotencyValue = maxPotencyValue;
        this.maxPotencyTime = maxPotencyTime;
        this.minPotencyValue = minPotencyValue;
        this.minPotencyTime = minPotencyTime;
    }

    /**
     * Método que executa as funcionalidades da thread UpdaterLoadCurveThread.
     */
    @Override
    public void run() {
        Mensuration lastMensuration = null;

        List<Mensuration> mensuration = this.loadCurveCtrl.getAllMensuration();
        ArrayList<Mensuration> estimate_data = new ArrayList();
        double[] potency = new double[mensuration.size()];
        int k;

        if (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                double currentPotency = m.getPotency();
                series.addOrUpdate(m.getMillisecond(), currentPotency);

                if (currentPotency > loadCurveCtrl.getMaxMensuration().getPotency()) {
                    loadCurveCtrl.setMaxMensuration(m);
                }

                if (currentPotency < loadCurveCtrl.getMinMensuration().getPotency() || loadCurveCtrl.getMinMensuration().getPotency() == 0) {
                    loadCurveCtrl.setMinMensuration(m);
                }

                lastMensuration = m;
            }

            updateMaxPotency(loadCurveCtrl.getMaxMensuration());
            updateMinPotency(loadCurveCtrl.getMinMensuration());
        }

        while (true) {
            Mensuration m = this.loadCurveCtrl.getLastMensuration();

            if (lastMensuration == null) {
                lastMensuration = m;
            }

            if (!(lastMensuration.getIdMensuration() == m.getIdMensuration())) {
                double currentPotency = m.getPotency();

                series.addOrUpdate(m.getMillisecond(), currentPotency);

                if (currentPotency > loadCurveCtrl.getMaxMensuration().getPotency()) {
                    updateMaxPotency(m);
                }

                if (currentPotency < loadCurveCtrl.getMinMensuration().getPotency() || loadCurveCtrl.getMinMensuration().getPotency() == 0) {
                    updateMinPotency(m);
                }

                updateJLabel(flowValue, m.getFlow(), lastMensuration.getFlow());
                updateJLabel(tensionValue, m.getTension(), lastMensuration.getTension());
                updateJLabel(potencyvalue, m.getPotency(), currentPotency);

                lastMensuration = m;

                if (estimate_data.size() < NUM_ESTIMATES) {
                    estimate_data.add(m);
                } else {
                    estimate_data.remove(0);
                    estimate_data.add(m);
                    int estimationNumber = Integer.parseInt(estimateValue.getText());
                    double[] fx = new double[NUM_ESTIMATES];
                    double[] estimation = new double[NUM_ESTIMATES];
                    int i = 0;
                    while (i < NUM_ESTIMATES) {
                        fx[i] = estimate_data.get(i).getPotency();
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
            }

            try {
                Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
            } catch (InterruptedException ex) {
                Logger.getLogger(EstimationOnRealLoadThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateJLabel(JLabel jLabel, double current, double last) {
        if (jLabel != null) {
            jLabel.setText(String.format("%.3f", current));
            if (last > current) {
                jLabel.setIcon(new ImageIcon("/icons/arow_up.png"));
            } else {
                jLabel.setIcon(new ImageIcon("/icons/arow_down.png"));
            }
            jLabel.revalidate();
            jLabel.repaint();
        }
    }

    private void updateMaxPotency(Mensuration m) {
        if (this.maxPotencyValue != null) {
            loadCurveCtrl.setMaxMensuration(m);
            this.maxPotencyValue.setText(String.format("%.3f", loadCurveCtrl.getMaxMensuration().getPotency()));
            this.maxPotencyValue.revalidate();
            this.maxPotencyValue.repaint();

            this.maxPotencyTime.setText(m.getTime());
            this.maxPotencyTime.revalidate();
            this.maxPotencyTime.repaint();
        }
    }

    private void updateMinPotency(Mensuration m) {
        if (this.maxPotencyValue != null) {
            loadCurveCtrl.setMinMensuration(m);
            this.minPotencyValue.setText(String.format("%.3f", loadCurveCtrl.getMinMensuration().getPotency()));
            this.minPotencyValue.revalidate();
            this.minPotencyValue.repaint();

            this.minPotencyTime.setText(m.getTime());
            this.minPotencyTime.revalidate();
            this.minPotencyTime.repaint();
        }
    }
}