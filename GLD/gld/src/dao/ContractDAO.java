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
    }

    public List<Contract> readContract() throws SQLException {
        List<Contract> listContract;

        listContract = new ArrayList<>();

        dbint.connect();
        ResultSet rs = dbint.executeQuery(searchContract);

        while (rs.next()) {
            Contract contract;


            contract = new Contract(rs.getString("peak_demand"), rs.getString("off_peak_demand"),
                    rs.getInt("id_rate"), rs.getString("timestamp"));

            contract = new Contract();
            contract.setPeakDemand(rs.getString("peak_demand"));
            contract.setOffPeakDemand(rs.getString("off_peak_demand"));
            contract.setIdRate(rs.getInt("id_rate"));
            contract.setCoolTimestamp(rs.getString("timestamp"));

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

    public Contract getLastContract() {
        Contract c = new Contract();
        int last;

        dbint.connect();
        last = dbint.getLastId("contract");
        String sql = "SELECT * FROM contract WHERE id_contract = '" + last + "'";

        ResultSet rs = dbint.executeQuery(sql);
        try {
            while (rs.next()) {
                c.setIdRate(rs.getInt("id_rate"));
                c.setPeakDemand(rs.getString("peak_demand"));
                c.setOffPeakDemand(rs.getString("off_peak_demand"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsumptionMonthDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        dbint.disconnect();

        return c;
    }
}
