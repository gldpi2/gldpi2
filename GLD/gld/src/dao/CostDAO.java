/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Cost;
import model.Mensuration;
import utils.DatabaseInterface;

/**
 *
 * @author Matheus
 */
public class CostDAO {

    DatabaseInterface dbInterface = new DatabaseInterface();
    Mensuration mensuration = new Mensuration();
    Cost cost = new Cost();
    //MensurationDAO menDao = new Mensuration();
    MensuratioDAO menDao = new MensurationDAO();
    
     
    /**
     * Método que irá pegar as mediçõe através da DAO
     * e aqui irá fazer o cálculo do custo
     */
    public double[] getCost() throws SQLException{
        List<Mensuration> listDAO;
        listDAO = menDAO.getMensuration();
        double[] costMens = new double[listDAO.size()];
        for(int i = 0; i<listDAO.size(); i++){
            mensuration = listDAO.get(i);
            costMens[i] = cost.energyValue(mensuration.getFlow(), mensuration.getTension());
        }
        
        return costMens;
    }
}
