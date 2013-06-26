package dao;

import controller.CostCtrl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Mensuration;
import utils.DatabaseInterface;

/**
 *
 * @author Matheus
 */
public class CostDAO {

    Mensuration mensuration = new Mensuration();
    CostCtrl ctrl = new CostCtrl();
    DatabaseInterface dbInterface;

    /**
     * Método que irá pegar as mediçõe através da DAO e aqui irá fazer o cálculo
     * do custo
     *
     * @return vetor de custo já calculados
     * @throws Exceção de SQL, pois se não houver conexão ou dados, irá falhar.
     */
    public ArrayList<Mensuration> parameters() throws SQLException {
        ArrayList<Mensuration> mensurationList = new ArrayList<>();


        String sql = "SELECT * FROM mensuration";

        dbInterface.connect();

        ResultSet rsMensuration = dbInterface.executeQuery(sql);
        try {
            while (rsMensuration.next()) {
                mensuration.setFlow(rsMensuration.getDouble(2));
                mensuration.setTension(rsMensuration.getDouble(3));
                mensuration.setTimestamp(rsMensuration.getString(4));
                ctrl.energyValue(mensuration.getFlow(), mensuration.getTension());
                ctrl.setTime(mensuration.getTimestamp());
                mensurationList.add(mensuration);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        dbInterface.disconnect();

        return mensurationList;
    }
}
