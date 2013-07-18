/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ContractDAO;
import java.sql.SQLException;
import java.util.List;
import model.Contract;

/**
 *
 * @author gld-pi2
 */
public class ContractCtrl {

    ContractDAO dao = new ContractDAO();

    public void createContract(String peakDemandContracted, String outPeakDemandContracted,
            String humidSeason, String drySeason, String timestamp) {

        Contract contract = new Contract();

        contract.setPeakDemandContracted(peakDemandContracted);
        contract.setOutPeakDemandContracted(outPeakDemandContracted);
        contract.setHumidSeason(humidSeason);
        contract.setDrySeason(drySeason);
        
        dao.createContract(contract);
    }
    
    public void updateContract(String peakDemandContracted, String outPeakDemandContracted,
            String humidSeason, String drySeason, String timestamp){
    
        Contract contract = new Contract();

        contract.setPeakDemandContracted(peakDemandContracted);
        contract.setOutPeakDemandContracted(outPeakDemandContracted);
        contract.setHumidSeason(humidSeason);
        contract.setDrySeason(drySeason);
        
        dao.updateContract(contract);
    }
    
    public List<Contract> readContract() throws SQLException{
        return dao.readContract();
    }
}
