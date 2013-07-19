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
 * @author Matheus
 */
public class CostDAO {

    private DatabaseInterface dbInterface = new DatabaseInterface();
    private String timeHour;

    public void setTime(String timeHour) {
        this.timeHour = timeHour;
    }

    public String getTime() {
        return timeHour;
    }
    /**
     * Método que irá pegar as mediçõe através da DAO e aqui irá fazer o cálculo
     * do custo
     *
     * @return vetor de custo já calculados
     * @throws Exceção de SQL, pois se não houver conexão ou dados, irá falhar.
     */
    public List<Mensuration> allMeasurements() {
        List<Mensuration> mensurationList = new ArrayList<>();


        String sql = "SELECT * FROM mensuration";
        conectDB();

        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                Mensuration mensuration;
                mensuration = new Mensuration();
                mensuration.setIdMensuration(rs.getInt("id_mensuration"));
                mensuration.setFlow(rs.getDouble("flow"));
                mensuration.setTension(rs.getDouble("tension"));
                mensuration.setTimestamp(rs.getString("timestamp"));
                setTime(mensuration.getTimestamp().substring(8, 10));
                mensurationList.add(mensuration);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        disconectDB();

        return mensurationList;
    }

    public Mensuration singleMensuration(int id) {
        Mensuration mensuration = new Mensuration();
        conectDB();
        String sql = "SELECT * FROM mensuration WHERE id_mensuration =" + id;
        ResultSet rs = dbInterface.executeQuery(sql);

        try {
            if (rs.next()) {

                mensuration.setIdMensuration(rs.getInt("id_mensuration"));
                mensuration.setFlow(rs.getDouble("flow"));
                mensuration.setTension(rs.getDouble("tension"));
                mensuration.setTimestamp(rs.getString("timestamp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconectDB();
        return mensuration;
    }

    private void conectDB() {
        dbInterface.connect();
    }

    private void disconectDB() {
        dbInterface.disconnect();
    }
}
