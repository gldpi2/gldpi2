/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mensuration;
import utils.DatabaseInterface;

/**
 *
 * @author Fernando
 */
public class EstimationOnHistoryDAO {
    
    private final int NUMBER_REG_WEEK = 604800;
    private final int NUMBER_REG_DAY = 86400;
    private final int NUMBER_REG_HOUR = 3600;
    private DatabaseInterface dbInterface = new DatabaseInterface();

    public List<Mensuration> getMensurationLast168Hours() throws SQLException {
        List<Mensuration> measurementList;

        measurementList = new ArrayList<>();

        String sql = "SELECT * "
                + "FROM mensuration "
                + "LIMITE 0, " + String.valueOf(NUMBER_REG_WEEK)
                + "ORDER BY  `mensuration`.`timestamp` DESC ";

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
                + "FROM mensuration "
                + "LIMITE 0, " + String.valueOf(NUMBER_REG_WEEK*4)
                + "ORDER BY  `mensuration`.`timestamp` DESC ";

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

    
}
