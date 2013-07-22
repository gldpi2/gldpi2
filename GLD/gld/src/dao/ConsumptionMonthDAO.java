package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConsumptionMonth;
import utils.DatabaseInterface;

/**
 *
 * @author itallorossi
 */
public class ConsumptionMonthDAO {

    DatabaseInterface dbInterface = new DatabaseInterface();

    public List<ConsumptionMonth> getAllConsumptionMonth() {
        List<ConsumptionMonth> consumptionList;

        consumptionList = new ArrayList<>();

        String sql = "SELECT * FROM mensuration_month";

        dbInterface.connect();
        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                ConsumptionMonth consumption;
                consumption = new ConsumptionMonth();

                consumption.setId(rs.getInt("id"));
                consumption.setYear(rs.getInt("year"));
                consumption.setMonth(rs.getInt("month"));
                consumption.setPeakConsumption(rs.getDouble("peak_consumption"));
                consumption.setOffPeakDemand(rs.getDouble("off_peak_consumption"));
                consumption.setPeakDemand(rs.getDouble("peak_demand"));
                consumption.setOffPeakDemand(rs.getDouble("off_peak_demand"));
                consumption.setPeakExtra(rs.getDouble("peak_extra"));
                consumption.setOffPeakExtra(rs.getDouble("off_peak_extra"));
                consumption.setDryOrHumid(rs.getBoolean("dry_or_humid"));
                consumption.setPeakAverageDemand(rs.getDouble("peak_average_demand"));
                consumption.setOffPeakAverageDemand(rs.getDouble("off_peak_average_demand"));

                consumptionList.add(consumption);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsumptionMonthDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        dbInterface.disconnect();

        return consumptionList;
    }
}
