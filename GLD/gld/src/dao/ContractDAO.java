/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Contract;
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
        
        String insertContract = "INSERT INTO contract (peak_demand, off_peak_demand"
            + ") VALUES "
            + "(?,?,?,?)";
        
        String[] params = new String[2];
        params[0] = contract.getPeakDemand();
        params[1] = contract.getOffPeakDemand();
        

        dbint.connect();

        dbint.insert(insertContract, params);

        dbint.disconnect();
    }

    public List<Contract> readContract() throws SQLException {
        List<Contract> listContract;

        listContract = new ArrayList<>();

        dbint.connect();
        ResultSet rs = dbint.executeQuery(searchContract);

        while (rs.next()) {
            Contract contract;

            contract = new Contract(rs.getString("contracted_peak_demand"), rs.getString("out_peak_demand"),
                     rs.getString("timestamp"));

            listContract.add(contract);
        }

        dbint.disconnect();

        return listContract;
    }

    public void updateContract(Contract contract) {
        String updateContract = "SELECT id_contract FROM contract";
        
        updateContract = "UPDATE contract set peak_demand = ?, off_peak_demand = ?, "
                + "timestamp = ? ";
        
        String[] params = new String[4];
        params[0] = contract.getPeakDemand();
        params[1] = contract.getOffPeakDemand();


        dbint.connect();

        dbint.insert(updateContract, params);

        dbint.disconnect();
    }

    public void createContract(List<Contract> contract) {
    }

    public void updateContract(List<Contract> contract) {
    }
}
