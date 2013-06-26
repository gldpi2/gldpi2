package _tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mensuration;
import utils.DatabaseInterface;

/**
 *
 * @author wagner
 */
public class GraphPanelDAO {

    private DatabaseInterface dbInterface = new DatabaseInterface();

    public List<Mensuration> getMensuration() throws SQLException {
        List<Mensuration> measurementList;

        measurementList = new ArrayList<>();

        String sql = "SELECT * FROM mensuration";

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
//    public static void main(final String[] args) throws SQLException {
//        GraphPanelDAO g = new GraphPanelDAO();
//
//        List<Mensuration> array = g.getMensuration();
//
//        for (Mensuration m : array) {
//            System.out.println(m.getIdMensuration());
//            System.out.println(m.getFlow());
//            System.out.println(m.getTension());
//            System.out.println(m.getTimestamp());
//        }
//    }
}
