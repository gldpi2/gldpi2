package utils;

import _tests.GraphPanel;
import controller.LoadCurveCtrl;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JLabel;
import model.Mensuration;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author wagner
 */
public class UpdaterLoadCurveThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private LoadCurveCtrl loadCurveCtrl = new LoadCurveCtrl();
    private TimeSeries series;
    private JLabel flowValue;
    private JLabel tensionValue;
    private JLabel potencyvalue;
    private JLabel maxPotencyValue;
    private JLabel maxPotencyTime;

    /**
     * Método construtor da classe UpdaterLoadCurveThread.
     *
     * @param series XYSeries Referência da série apresentada no gráfico.
     */
    public UpdaterLoadCurveThread(TimeSeries series, JLabel flowValue, JLabel tensionValue, JLabel potencyValue, JLabel maxPotencyValue, JLabel maxPotencyTime) {
        this.series = series;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
        this.maxPotencyValue = maxPotencyValue;
        this.maxPotencyTime = maxPotencyTime;
    }

    /**
     * Método que executa as funcionalidades da thread UpdaterLoadCurveThread.
     */
    @Override
    public void run() {

        Mensuration lastMensuration = null;

        List<Mensuration> mensuration = this.loadCurveCtrl.getAllMensuration();

        if (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                double currentPotency = m.getPotency();

                series.addOrUpdate(m.getMillisecond(), currentPotency);

                if (currentPotency > loadCurveCtrl.getMaxMensuration().getPotency()) {
                    loadCurveCtrl.setMaxMensuration(m);
                }

                lastMensuration = m;
            }

            updateMaxPotency(loadCurveCtrl.getMaxMensuration());
        }



        while (true) {
            Mensuration m = this.loadCurveCtrl.getLastMensuration();
            boolean wasEmpty = false;
            
            if (lastMensuration == null){
                lastMensuration = m;
                wasEmpty = true;
            }

            if (!(lastMensuration.getIdMensuration() == m.getIdMensuration())) {
                double currentPotency = m.getPotency();

                series.addOrUpdate(m.getMillisecond(), currentPotency);

                if (currentPotency > loadCurveCtrl.getMaxMensuration().getPotency()) {
                    updateMaxPotency(m);
                }

                updateJLabel(flowValue, m.getFlow(), lastMensuration.getFlow());
                updateJLabel(tensionValue, m.getTension(), lastMensuration.getTension());
                updateJLabel(potencyvalue, m.getPotency(), currentPotency);

                lastMensuration = m;
            }

            try {
                Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
            } catch (InterruptedException ex) {
                Logger.getLogger(GraphPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateJLabel(JLabel jLabel, double current, double last) {
        jLabel.setText(String.format("%.3f", current));
        if (last > current) {
            jLabel.setIcon(new ImageIcon("/icons/arow_up.png"));
        } else {
            jLabel.setIcon(new ImageIcon("/icons/arow_up.png"));
        }
        jLabel.revalidate();
        jLabel.repaint();
    }

    private void updateMaxPotency(Mensuration m) {
        loadCurveCtrl.setMaxMensuration(m);
        this.maxPotencyValue.setText(String.format("%.3f", loadCurveCtrl.getMaxMensuration().getPotency()));
        this.maxPotencyValue.revalidate();
        this.maxPotencyValue.repaint();

        this.maxPotencyTime.setText(m.getTime());
        this.maxPotencyTime.revalidate();
        this.maxPotencyTime.repaint();
    }
}
