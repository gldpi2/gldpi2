/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.CostDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mensuration;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author Matheus
 */
public class UpdaterCostThread implements Runnable{

    ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");
    private CostDAO costDao = new CostDAO();
    private TimeSeries series;

    public UpdaterCostThread(TimeSeries series) {
        this.series = series;
    }
    
    
    @Override
    public void run() {
      try{
           List<Mensuration> mensuration = this.costDao.parameters();
          costDao.parameters();
          //while(!mensuration.isEmpty())
          for (Mensuration m : mensuration) {
             double costValues = costDao.getCostValue();
              series.addOrUpdate(new Millisecond(),costValues);
              
          }
                   

      } catch (SQLException ex) {  
            Logger.getLogger(UpdaterCostThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
}

