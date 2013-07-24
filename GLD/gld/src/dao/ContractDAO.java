/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contract;
import utils.Communication;
import utils.DatabaseInterface;

/**
 *
 * @author greg
 */
public class ContractDAO {

    private DatabaseInterface dbint = new DatabaseInterface();
    
    public static final String searchContract = "SELECT * FROM contract";

    public ContractDAO() {
    }

    public void createContract(Contract contract) {
        
        String insertContract = "INSERT INTO contract (peak_demand, off_peak_demand, id_rate"
            + ") VALUES "
            + "(?,?,?)";
        
        String[] params = new String[3];
        params[0] = contract.getPeakDemand();
        params[1] = contract.getOffPeakDemand();
        params[2] = String.valueOf((contract.getIdRate()));
        

        dbint.connect();

        dbint.insert(insertContract, params);

        dbint.disconnect();
        
//        try {
//            Communication.UDPClient.sendData("idContrato", 9876, contract.getPeakDemand(), contract.getOffPeakDemand());
//        } catch (Exception ex) {
//            Logger.getLogger(ContractDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }

    public List<Contract> readContract() throws SQLException {
        List<Contract> listContract;

        listContract = new ArrayList<>();

        dbint.connect();
        ResultSet rs = dbint.executeQuery(searchContract);

        while (rs.next()) {
            Contract contract;

            contract = new Contract();
            contract.setPeakDemand(rs.getString("peak_demand")); 
            contract.setOffPeakDemand(rs.getString("off_peak_demand"));
            contract.setIdRate(rs.getInt("id_rate"));
            contract.setCoolTimestamp(rs.getString("timestamp"));

            listContract.add(contract);
        }

        dbint.disconnect();

        return listContract;
    }

    public void updateContract(Contract contract) {
        String updateContract = "SELECT id_contract FROM contract";
        
        updateContract = "UPDATE contract set peak_demand = ?, off_peak_demand = ?, id_rate = ?, "
                + "timestamp = ? ";
        
        String[] params = new String[3];
        params[0] = contract.getPeakDemand();
        params[1] = contract.getOffPeakDemand();
        params[2] = String.valueOf(contract.getIdRate());


        dbint.connect();

        dbint.insert(updateContract, params);

        dbint.disconnect();
    }

    public void createContract(List<Contract> contract) {
    }

    public void updateContract(List<Contract> contract) {
    }
}
