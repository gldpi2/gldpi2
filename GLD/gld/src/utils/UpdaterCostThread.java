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

    public UpdaterCostThread(TimeSeries series) {
        this.series = series;
    }

    public UpdaterCostThread(TimeSeries series, JLabel flowValue, JLabel tensionValue, JLabel potencyValue) {
        this.series = series;
        this.flowValue = flowValue;
        this.tensionValue = tensionValue;
        this.potencyvalue = potencyValue;
    }

    /**
     *
     */
    @Override
    public void run() {
        List<Mensuration> mensuration = this.costDao.parameters();

        while (mensuration.size() > 0) {
            for (Mensuration m : mensuration) {
                series.addOrUpdate(m.getMillisecond(), m.getPotency() * costDao.getCostValue());
                if (this.tensionValue != null) {
                    if (this.tensionValue.isShowing()) {
                        try {
                            updateButton(m);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(UpdaterCostThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("");
                        System.out.println("Tension: " + m.getTension());
                        System.out.println("Flow: " + m.getFlow());
                        System.out.println("Potency: " + m.getPotency());

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
        flowValue.setText(String.valueOf(m.getFlow()));
        tensionValue.setText(String.valueOf(m.getTension()));
        potencyvalue.setText(String.valueOf(m.getPotency()));
        Thread.sleep(1000);

    }
}
