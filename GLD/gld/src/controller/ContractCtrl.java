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

    public void createContract(String peakDemand, String offPeakDemand, int idRate,
            String timestamp) {

        Contract contract = new Contract();

        contract.setPeakDemand(peakDemand);
        contract.setOffPeakDemand(offPeakDemand);
        contract.setIdRate(idRate);
        
        dao.createContract(contract);
    }
    
    public void updateContract(String peakDemand, String offPeakDemand, int idRate,
             String timestamp){
    
        Contract contract = new Contract();

        contract.setPeakDemand(peakDemand);
        contract.setOffPeakDemand(offPeakDemand);
        contract.setIdRate(idRate);
        
        dao.updateContract(contract);
    }
    
    public List<Contract> readContract() throws SQLException{
        return dao.readContract();
    }
}
