package utils;

import controller.CostCtrl;
import dao.CostDAO;
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
        List<Mensuration> mensuration = ctrl.allMensuration();

        
        while (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                double cost = m.getPotency();
                series.addOrUpdate(m.getMillisecond(), calculateCost(m));

                if (this.tensionValue != null) {
                    if (this.tensionValue.isShowing()) {
                        try {                        
                            updateButton(m);
                            
                            if(cost > ctrl.getCostMax()){
                                ctrl.setMensuration(m);
                            }
                            if(ctrl.getCostMin() == 0 || cost < ctrl.getCostMin()){
                                ctrl.setMensuration(m);
                            }
                            
                            updateCostMax(ctrl.getCostMax());
                            updateCostMin(ctrl.getCostMin());
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

        while (!(mensuration.isEmpty())) {
            Mensuration menSingle = ctrl.getMensuration();
            if(menSingle.getIdMensuration() == 0){
                double costActual = calculateCost(menSingle);
                
                if(costActual > ctrl.getCostMax()){
                    updateCostMax(costActual);
                }
                
                if(costActual == 0 || costActual < ctrl.getCostMin()){
                    updateCostMin(costActual);
                }
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
            maxCostValue.revalidate();
            maxCostValue.repaint(10);
        }

    }

    private void updateCostMin(double minCost) {
        if (minCostValue != null) {
            minCostValue.setText(String.format("%.2f", minCost));
            minCostValue.revalidate();
            minCostValue.repaint(10);
        }
    }

    private double calculateCost(Mensuration m) {
        return m.getPotency() * ctrl.energyValue();
    }
}
