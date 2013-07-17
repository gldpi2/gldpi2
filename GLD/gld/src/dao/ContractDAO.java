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
    public static final String insertContract = "INSERT INTO contract (peak_demand, out_peak_demand, "
            + "humid_season, dry_season) VALUES "
            + "(?,?,?,?)";
    public static final String searchContract = "SELECT * FROM contract";

    public ContractDAO() {
    }

    public void savingContract(Contract contract) {
        dbint.executeQuery(insertContract);

        String[] params = new String[3];
        params[0] = contract.getPeakDemandContracted();
        params[1] = contract.getOutPeakDemandContracted();
        params[2] = contract.getHumidSeason();
        params[3] = contract.getDrySeason();

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
                    rs.getString("humid_season"), rs.getString("dry_humid"), rs.getString("timestamp"));

        }

        dbint.disconnect();

        return listContract;
    }

    public void updateContract(Contract contract) {
        
    }

    public void savingContract(List<Contract> contract) {
    }

    public void updateContract(List<Contract> contract) {
    }
}
