package utils;

import controller.CostCtrl;
import java.util.Date;
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
    Mensuration lastMensuration;
    Mensuration nextMensuration;
    private TimeSeries series;
    private TimeSeries seriesLimit;
    private JLabel flowValue;
    private JLabel tensionValue;
    private JLabel potencyValue;
    private JLabel countValue;
    private JLabel kwValue;
    private JLabel sourceLabel;
    private double costActual;
    private Date date;
    private double count = ctrl.initialCount();
    private boolean run = true;

    public UpdaterCostThread(TimeSeries series, TimeSeries seriesLimit, Date date) {
        this.series = series;
        this.seriesLimit = seriesLimit;
        this.date = date;
    }

    public UpdaterCostThread(TimeSeries series, TimeSeries seriesLimit,Date date, JLabel flowValue,
            JLabel tensionValue, JLabel potencyValue, JLabel countValue, JLabel kwValue, JLabel source) {
        this.series = series;
        this.seriesLimit = seriesLimit;
        this.date = date;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyValue = potencyValue;
        this.countValue = countValue;
        this.kwValue = kwValue;
        this.sourceLabel = source;
    }
    
    @Override
    public void run() {
        
        //List<Mensuration> mensuration = ctrl.allMensuration();
        List<Mensuration> mensuration = ctrl.mensurationsByDay(date.getDate(), date.getMonth() + 1, date.getYear() + 1900);

        lastMensuration = ctrl.lastMensuration();
        for (Mensuration m : mensuration) {
            if (lastMensuration.getIdMensuration() != m.getIdMensuration()) {
                costActual = calculateCost(m);
                series.addOrUpdate(m.getMillisecond(), costActual);
                seriesLimit.addOrUpdate(m.getMillisecond(), 0.061);
                if (this.potencyValue != null) {
                        updateLabel(m, lastMensuration);
                        updateCountValue(costActual);
                        kwValue();
                        updateSourceAvaible(m);
                        kwValue.setText(String.format("%.3f",ctrl.kWValue()));
                    
                }
            }
        }
  } 
    private void updateCountValue(double actual){
        count = ctrl.countValue(actual);
        countValue.setText(String.format("%.2f",count));
        countValue.revalidate();
        countValue.repaint();
    }     
    private double calculateCost(Mensuration m) {
        return m.getPotency() * ctrl.energyValue();
    }
    
    private void updateLabel(Mensuration actual, Mensuration last){
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
    
    private void updateSourceAvaible(Mensuration m) {
        if (this.sourceLabel != null) {
            if (m.getEnergyAvailable() == 1) {
                this.sourceLabel.setText("Disponível");
            } else {
                this.sourceLabel.setText("Indisponível");
            }
        }
    } 
    
    public void stopExecution (){
        run = false;
    }
}
