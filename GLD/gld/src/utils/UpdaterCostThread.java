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
        for (Mensuration m : mensuration) {
            series.addOrUpdate(m.getMillisecond(), m.getPotency() * costDao.getCostValue());
           // if (this.tensionValue.isShowing()) {
            //    updateButton(m);
            //}

        }
        try {
            Thread.sleep(Integer.parseInt(properties.getString("REFRESH_TIME")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateButton(Mensuration m) {
        flowValue.setText(String.valueOf(m.getFlow()));
        tensionValue.setText(String.valueOf(m.getTension()));
        potencyvalue.setText(String.valueOf(m.getPotency()));
        
        flowValue.revalidate();
        flowValue.repaint();
    }
}
