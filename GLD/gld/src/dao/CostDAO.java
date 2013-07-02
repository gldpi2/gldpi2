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

    
    CostCtrl ctrl = new CostCtrl();
    DatabaseInterface dbInterface = new DatabaseInterface();
    
    double costValue;

    
    public double getCostValue() {
        return costValue;
    }

    public void setCostValue(double costValue) {
        this.costValue = costValue;
    }

    /**
     * Método que irá pegar as mediçõe através da DAO e aqui irá fazer o cálculo
     * do custo
     *
     * @return vetor de custo já calculados
     * @throws Exceção de SQL, pois se não houver conexão ou dados, irá falhar.
     */
    public ArrayList<Mensuration> parameters() {
        ArrayList<Mensuration> mensurationList = new ArrayList<>();


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
                ctrl.setTime(mensuration.getTimestamp().substring(8, 10));
                setCostValue(ctrl.energyValue());
                mensurationList.add(mensuration);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        dbInterface.disconnect();

        return mensurationList;
    }
    
    public Mensuration singleMensuration(){
        Mensuration mensuration = new Mensuration();
        
        return mensuration;
    }
    
}
