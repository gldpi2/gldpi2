package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mensuration;
import utils.DatabaseInterface;

/**
 *
 * @author wagner
 */
public class LoadCurveDAO {

    private DatabaseInterface dbInterface = new DatabaseInterface();

    public List<Mensuration> getAllMensuration() {
        List<Mensuration> measurementList;

        measurementList = new ArrayList<>();

        String sql = "SELECT * FROM mensuration";

        dbInterface.connect();
        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                Mensuration mensuration;

                mensuration = new Mensuration();
                mensuration.setIdMensuration(rs.getInt("id_mensuration"));
                mensuration.setFlow(rs.getDouble("flow"));
                mensuration.setTension(rs.getDouble("tension"));
                mensuration.setTimestamp(rs.getString("timestamp"));

                measurementList.add(mensuration);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadCurveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        dbInterface.disconnect();

        return measurementList;
    }

    public List<Mensuration> getMensurationByDay(int day, int mounth, int year) {
        List<Mensuration> measurementList;

        measurementList = new ArrayList<>();

        String sql = "SELECT * FROM `mensuration` "
                + "WHERE timestamp >= \"" + year + "-" + mounth + "-" + day + " 00:00:00\""
                + " AND timestamp <= \"" + year + "-" + mounth + "-" + day + " 23:59:59\"";

        dbInterface.connect();
        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                Mensuration mensuration;

                mensuration = new Mensuration();
                mensuration.setIdMensuration(rs.getInt("id_mensuration"));
                mensuration.setFlow(rs.getDouble("flow"));
                mensuration.setTension(rs.getDouble("tension"));
                mensuration.setTimestamp(rs.getString("timestamp"));

                measurementList.add(mensuration);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadCurveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        dbInterface.disconnect();

        return measurementList;
    }

    public Mensuration getLastMensuration() {
        Mensuration mensuration = new Mensuration();

        dbInterface.connect();
        int lastId = dbInterface.getLastId("mensuration");

        String sql = "SELECT * FROM mensuration WHERE id_mensuration =" + lastId;

        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                mensuration.setIdMensuration(rs.getInt("id_mensuration"));
                mensuration.setFlow(rs.getDouble("flow"));
                mensuration.setTension(rs.getDouble("tension"));
                mensuration.setTimestamp(rs.getString("timestamp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadCurveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        dbInterface.disconnect();

        return mensuration;
    }
}
