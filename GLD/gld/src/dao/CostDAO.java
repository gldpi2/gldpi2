/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.CostCtrl;
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

    Mensuration mensuration = new Mensuration();
    CostCtrl ctrl = new CostCtrl();
    MensurationDAO menDao = new MensurationDAO();
    
     
    /**
     * Método que irá pegar as mediçõe através da DAO
     * e aqui irá fazer o cálculo do custo
     * @return vetor de custo já calculados
     * @throws Exceção de SQL, pois se não houver conexão ou
     * dados, irá falhar.
     */
    public double[] getCost() throws SQLException{
        List<Mensuration> listDAO;
        listDAO = menDao.getMensuration();
        double[] costMens = new double[listDAO.size()];
        for(int i = 0; i<listDAO.size(); i++){
            mensuration = listDAO.get(i);
            costMens[i] = ctrl.energyValue(mensuration.getFlow(), mensuration.getTension());
        }
        
        return costMens;
    }
}
