package utils;

import controller.CostCtrl;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Mensuration;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author Matheus
 */
public class UpdaterCostThread implements Runnable {

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    CostCtrl ctrl = new CostCtrl();
    private TimeSeries series;
    private TimeSeries seriesLimit;
    private JLabel flowValue;
    private JLabel tensionValue;
    private JLabel potencyvalue;

    public UpdaterCostThread(TimeSeries series) {
        this.series = series;
    }

    public UpdaterCostThread(TimeSeries series, TimeSeries seriesLimit, JLabel flowValue,
            JLabel tensionValue, JLabel potencyValue) {
        this.series = series;
        this.seriesLimit = seriesLimit;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
    }

    /**
     *
     */
    @Override
    public void run() {
        Mensuration previusMensuration = null;
        List<Mensuration> mensuration = ctrl.allMensuration();

        if (previusMensuration == null) {
            previusMensuration = ctrl.verifyMensuration();
        }
        for (Mensuration m : mensuration) {
            if (previusMensuration.getIdMensuration() != m.getIdMensuration()) {
                series.addOrUpdate(m.getMillisecond(), calculateCost(m));
                seriesLimit.addOrUpdate(m.getMillisecond(), 22000);
                if (this.potencyvalue != null) {
                    try {
                        updateButton(m, previusMensuration);
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


    private void updateButton(Mensuration m, Mensuration previus) throws InterruptedException{
        updateFlow(m, previus);
        updateTension(m, previus);
        updatePotency(m, previus);

        Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
    }

    private double calculateCost(Mensuration m) {
        return m.getPotency() * ctrl.energyValue();
    }

    private void updateFlow(Mensuration m, Mensuration previus) {
        this.flowValue.setText(String.format("%.2f", m.getFlow()));
        if (m.getFlow() > previus.getFlow()) {
            this.flowValue.setIcon(new ImageIcon("src/icons/arrow_down_small.png"));
        } else {
            this.flowValue.setIcon(new ImageIcon("src/icons/arrow_up_small.png"));
        }
        this.flowValue.revalidate();
        this.flowValue.repaint();
    }

    private void updateTension(Mensuration m, Mensuration previus) {
        this.tensionValue.setText(String.format("%.2f", m.getTension()));
        if (m.getTension() > previus.getTension()) {
            this.tensionValue.setIcon(new ImageIcon("src/icons/arrow_down_small.png"));
        } else {
            this.tensionValue.setIcon(new ImageIcon("src/icons/arrow_up_small.png"));
        }
        this.tensionValue.revalidate();
        this.tensionValue.repaint();
    }

    private void updatePotency(Mensuration m, Mensuration previus) {
        this.potencyvalue.setText(String.format("%.2f", m.getPotency()));
        if (m.getTension() > previus.getTension()) {
            this.potencyvalue.setIcon(new ImageIcon("src/icons/arrow_down_small.png"));
        } else {
            this.potencyvalue.setIcon(new ImageIcon("src/icons/arrow_up_small.png"));
        }
        this.potencyvalue.revalidate();
        this.potencyvalue.repaint();
    }
}
