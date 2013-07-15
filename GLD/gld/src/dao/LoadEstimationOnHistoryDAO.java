/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Soundbank;
import model.Mensuration;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import utils.DatabaseInterface;

/**
 *
 * @author Fernando
 */
public class LoadEstimationOnHistoryDAO {
    
    private final int NUMBER_REG_WEEK = 604800;
    private final int NUMBER_REG_DAY = 86400;
    private final int NUMBER_REG_HOUR = 3600;
    private DatabaseInterface dbInterface = new DatabaseInterface();

    public List<Mensuration> getMensurationLast168Hours() throws SQLException {
        List<Mensuration> measurementList;

        measurementList = new ArrayList<>();

        String sql = "SELECT * "
                + " FROM mensuration "
                + " LIMITE 0, " + String.valueOf(NUMBER_REG_WEEK)
                + " ORDER BY  `mensuration`.`timestamp` DESC ";

        dbInterface.connect();
        ResultSet rs = dbInterface.executeQuery(sql);
        while (rs.next()) {
            Mensuration mensuration;
            mensuration = new Mensuration();
            mensuration.setIdMensuration(rs.getInt("id_mensuration"));
            mensuration.setFlow(rs.getDouble("flow"));
            mensuration.setTension(rs.getDouble("tension"));
            mensuration.setTimestamp(rs.getString("timestamp"));
            measurementList.add(mensuration);
        }
        dbInterface.disconnect();
        return measurementList;
    }

    public List<Mensuration> getMensurationLast672Hours() throws SQLException {
        List<Mensuration> measurementList;

        measurementList = new ArrayList<>();

        String sql = "SELECT * "
                + " FROM mensuration "
                + " LIMITE 0, " + String.valueOf(NUMBER_REG_WEEK*4)
                + " ORDER BY  `mensuration`.`timestamp` DESC ";

        dbInterface.connect();
        ResultSet rs = dbInterface.executeQuery(sql);
        while (rs.next()) {
            Mensuration mensuration;
            mensuration = new Mensuration();
            mensuration.setIdMensuration(rs.getInt("id_mensuration"));
            mensuration.setFlow(rs.getDouble("flow"));
            mensuration.setTension(rs.getDouble("tension"));
            mensuration.setTimestamp(rs.getString("timestamp"));
            measurementList.add(mensuration);
        }
        dbInterface.disconnect();
        return measurementList;
    }

    public List<Mensuration> getMensurationLast60Minutes() throws SQLException {
        List<Mensuration> measurementList;

        measurementList = new ArrayList<>();

        String sql = "SELECT * "
                + " FROM mensuration "
                + " LIMITE 0, " + String.valueOf(NUMBER_REG_HOUR)
                + " ORDER BY  `mensuration`.`timestamp` DESC ";

        dbInterface.connect();
        ResultSet rs = dbInterface.executeQuery(sql);
        while (rs.next()) {
            Mensuration mensuration;
            mensuration = new Mensuration();
            mensuration.setIdMensuration(rs.getInt("id_mensuration"));
            mensuration.setFlow(rs.getDouble("flow"));
            mensuration.setTension(rs.getDouble("tension"));
            mensuration.setTimestamp(rs.getString("timestamp"));
            measurementList.add(mensuration);
        }
        dbInterface.disconnect();
        return measurementList;
    }

    public List<Mensuration> getMensurationLast24Hours() throws SQLException {
        List<Mensuration> measurementList;

        measurementList = new ArrayList<>();

        String sql = "SELECT * "
                + " FROM mensuration "
                + " LIMITE 0, " + String.valueOf(NUMBER_REG_DAY)
                + " ORDER BY  `mensuration`.`timestamp` DESC ";

        dbInterface.connect();
        ResultSet rs = dbInterface.executeQuery(sql);
        while (rs.next()) {
            Mensuration mensuration;
            mensuration = new Mensuration();
            mensuration.setIdMensuration(rs.getInt("id_mensuration"));
            mensuration.setFlow(rs.getDouble("flow"));
            mensuration.setTension(rs.getDouble("tension"));
            mensuration.setTimestamp(rs.getString("timestamp"));
            measurementList.add(mensuration);
        }
        dbInterface.disconnect();
        return measurementList;
    }

    public List<Mensuration> getMensurationADayLastWeek() throws SQLException {

        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE,-14);
               
        List<Mensuration> measurementList;
        measurementList = new ArrayList<>();
        
        String sql = "SELECT * "
                + " FROM mensuration "
                + " WHERE  `timestamp`" 
                + " BETWEEN  ' " + now.get(Calendar.YEAR) + "-"+ (now.get(Calendar.MONTH) +1 ) +"-"+ now.get(Calendar.DAY_OF_MONTH) +" 00:00:00'";
                
        
        sql  +=   " AND  ' " + now.get(Calendar.YEAR) + "-"+ (now.get(Calendar.MONTH) +1 )+"-"+ now.get(Calendar.DAY_OF_MONTH) +" 23:59:59' ";

        dbInterface.connect();
        ResultSet rs = dbInterface.executeQuery(sql);

        while (rs.next()) {
            Mensuration mensuration;
            mensuration = new Mensuration();
            mensuration.setIdMensuration(rs.getInt("id_mensuration"));
            mensuration.setFlow(rs.getDouble("flow"));
            mensuration.setTension(rs.getDouble("tension"));
            mensuration.setTimestamp(rs.getString("timestamp"));
            measurementList.add(mensuration);
        }
        dbInterface.disconnect();
        return measurementList;
    }

    public Mensuration getLastMensuration() throws SQLException {
        Mensuration mensuration = new Mensuration();

        dbInterface.connect();
        int lastId = dbInterface.getLastId("mensuration");

        String sql = "SELECT * FROM mensuration WHERE id_mensuration =" + lastId;

        ResultSet rs = dbInterface.executeQuery(sql);

        while (rs.next()) {
            mensuration.setIdMensuration(rs.getInt("id_mensuration"));
            mensuration.setFlow(rs.getDouble("flow"));
            mensuration.setTension(rs.getDouble("tension"));
            mensuration.setTimestamp(rs.getString("timestamp"));
        }

        dbInterface.disconnect();

        return mensuration;
    }

    

}
