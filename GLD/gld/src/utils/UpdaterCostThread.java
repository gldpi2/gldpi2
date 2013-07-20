package utils;

import controller.CostCtrl;
import java.util.List;
import java.util.ResourceBundle;
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
    private JLabel potencyValue;
    private JLabel countValue;
    private JLabel kwValue;
    private double costActual;

    public UpdaterCostThread(TimeSeries series, TimeSeries seriesLimit) {
        this.series = series;
        this.seriesLimit = seriesLimit;
    }

    public UpdaterCostThread(TimeSeries series, TimeSeries seriesLimit, JLabel flowValue,
            JLabel tensionValue, JLabel potencyValue, JLabel countValue, JLabel kwValue) {
        this.series = series;
        this.seriesLimit = seriesLimit;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyValue = potencyValue;
        this.countValue = countValue;
        this.kwValue = kwValue;
    }

    /**
     *
     */
    @Override
    public void run() {
        Mensuration lastMensuration = new Mensuration();
        List<Mensuration> mensuration = ctrl.allMensuration();

        for (Mensuration m : mensuration) {
            if (lastMensuration.getIdMensuration() != m.getIdMensuration()) {
                costActual = calculateCost(m);
                series.addOrUpdate(m.getMillisecond(), calculateCost(m));
                seriesLimit.addOrUpdate(m.getMillisecond(), 50);
                if (this.potencyValue != null) {
                    System.out.println("Cost Initial: "+ctrl.initialCount());
                    updateLabel(m, lastMensuration);
                    updateCountValue(costActual);
                    kwValue();
                }
            }
        }
            try {
                Thread.sleep(900);
            } catch (Exception e) {
                e.printStackTrace();
            }
  } 
    private void updateCountValue(double actual){
        double count = ctrl.countValue(actual);
        countValue.setText(String.format("%.2f",count));
        countValue.revalidate();
        countValue.repaint();
    }     
    private double calculateCost(Mensuration m) {
        return m.getPotency() * ctrl.energyValue();
    }
    
    private void updateLabel(Mensuration actual, Mensuration last) {
        updateLabelValue(potencyValue, actual.getPotency(), last.getPotency());
        updateLabelValue(flowValue, actual.getFlow(), last.getFlow());
        updateLabelValue(tensionValue, actual.getTension(), last.getTension());
     }

    

    private void updateLabelValue(JLabel label, double actual, double last) {
       label.setText(String.format("%.2f", actual));
        if (actual > last) {
            label.setIcon(new ImageIcon("src/icons/arrow_up_small.png"));
        } else {
            label.setIcon(new ImageIcon("src/icons/arrow_down_small.png"));
        }
        label.revalidate();
        label.repaint();
    }

    private void kwValue() {
        ctrl.kWValue();
        kwValue.revalidate();
        kwValue.repaint();
    }
}
