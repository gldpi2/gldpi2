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
import model.Mensuration;
import utils.DatabaseInterface;

/**
 *
 * @author Fernando
 */
public class CostEstimationOnHistoryDAO {
    
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
            
            System.out.println("ID: " + mensuration.getIdMensuration());            
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

    public List<Mensuration> getMensurationADayLastWeek(int offset) throws SQLException {

        Calendar now = Calendar.getInstance();
        
        // Para semana passada
        //now.add(Calendar.DATE,-6 );
        
        int timenow = now.getTime().getDay();
        now.add(Calendar.DATE, + offset );
        int timethem = now.getTime().getDay();
        
        now.add(Calendar.DATE, - offset );
        
        if( timenow > timethem ) {
            now.add(Calendar.DATE, -6+(timenow - timethem +1));
        } else if ( timethem > timenow ) {
            now.add(Calendar.DATE, -6+(timethem - timenow ));
        } else {
             now.add(Calendar.DATE, -6);
        }
        
        //Para variar como semana passada do offset;
        //now.add(Calendar.DATE,-6+offset);
               
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
    
    public List<Mensuration> getMensurationLast30Days(int offset) throws SQLException {

        Calendar now = Calendar.getInstance();
       
        List<Mensuration> measurementList;
        measurementList = new ArrayList<>();
        now.add(Calendar.DATE,-30+offset);
        
        String sql = "SELECT * "
                + " FROM mensuration "
                + " WHERE  `timestamp`" 
                + " BETWEEN  ' " + now.get(Calendar.YEAR) + "-"+ (now.get(Calendar.MONTH) +1 ) +"-"+ now.get(Calendar.DAY_OF_MONTH) +" 23:59:59'";
                
        now.add(Calendar.DATE,+30);
        
        sql  +=   " AND  ' " + now.get(Calendar.YEAR) + "-"+ (now.get(Calendar.MONTH) +1 )+"-"+ now.get(Calendar.DAY_OF_MONTH) +" 00:00:01' ";

        System.out.println(sql);
        
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
