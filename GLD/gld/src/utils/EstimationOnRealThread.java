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
 * @author wagner
 */
public class EstimationOnRealThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private LoadCurveCtrl loadCurveCtrl = new LoadCurveCtrl();
    private TimeSeries series, estimated;
    private JLabel flowValue;
    private JLabel tensionValue;
    private JLabel potencyvalue;
    private JLabel estimates;


    /**
     * Método construtor da classe UpdaterLoadCurveThread.
     *
     * @param series XYSeries Referência da série apresentada no gráfico.
     */
    public EstimationOnRealThread(TimeSeries series) {
        this.series = series;
    }

    public EstimationOnRealThread(TimeSeries series,
            JLabel flowValue, JLabel tensionValue, JLabel potencyValue, 
            JLabel estimates) {
        this.series = series;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
        this.estimates = estimates;

    }

    /**
     * Método que executa as funcionalidades da thread UpdaterLoadCurveThread.
     */
    @Override
    public void run() {
        Mensuration lastMensuration = null;

        List<Mensuration> mensuration = this.loadCurveCtrl.getAllMensuration();
        List<Double> dados = new ArrayList();

        if (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                double currentPotency = m.getPotency();
                dados.add(currentPotency);
                series.addOrUpdate(m.getMillisecond(), currentPotency);
                if (currentPotency > loadCurveCtrl.getMaxMensuration().getPotency()) {
                    loadCurveCtrl.setMaxMensuration(m);
                }
                if (currentPotency < loadCurveCtrl.getMinMensuration().getPotency() || loadCurveCtrl.getMinMensuration().getPotency() == 0) {
                    loadCurveCtrl.setMinMensuration(m);
                }
                lastMensuration = m;
            }
        }

        while (true) {
            Mensuration m = this.loadCurveCtrl.getLastMensuration();
            GaussJordan gj = new GaussJordan();
            double[] data = new double[Integer.parseInt(estimates.getText())];

            if (lastMensuration == null) {
                lastMensuration = m;
            }

            if (!(lastMensuration.getIdMensuration() == m.getIdMensuration())) {
                double currentPotency = m.getPotency();
                dados.add(currentPotency);
                series.addOrUpdate(m.getMillisecond(), currentPotency);
                for(int i = dados.size()-1;i>(dados.size()-Integer.parseInt(estimates.getText())-1);i--){
                    Second millisecond = m.getMillisecond().getSecond();
                    for(int j = 0; j <= i; j++){
                        millisecond.next();
                    }
                }
                updateJLabel(flowValue, m.getFlow(), lastMensuration.getFlow());
                updateJLabel(tensionValue, m.getTension(), lastMensuration.getTension());
                updateJLabel(potencyvalue, m.getPotency(), currentPotency);

                lastMensuration = m;
            }

            try {
                Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
            } catch (InterruptedException ex) {
                Logger.getLogger(EstimationOnRealThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateJLabel(JLabel jLabel, double current, double last) {
        if (jLabel != null) {
            jLabel.setText(String.format("%.3f", current));
            if (last > current) {
                jLabel.setIcon(new ImageIcon("/icons/arow_down.png"));
            } else {
                jLabel.setIcon(new ImageIcon("/icons/arow_up.png"));
            }
            jLabel.revalidate();
            jLabel.repaint();
        }
    }
}