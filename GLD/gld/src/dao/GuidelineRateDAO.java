/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.SQLRegisterException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.GuidelineRate;
import model.User;
import utils.DatabaseInterface;

/**
 *
 * @author greg
 */
public class GuidelineRateDAO {

    private DatabaseInterface dbint = new DatabaseInterface();
    public static final String insertGuidelineRate = "INSERT INTO guideline_rate (guideline_rate, peak_demand, out_peak_demand, peak_energy_dry, "
            + "out_peak_energy_dry, pea_energ_humid, out_peak_energy_humid, value_transpassed) VALUES "
            + "(?,?,?,?,?,?,?,?)";
    public static final String searchGuidelineRate = "SELECT * FROM guideline_rate";

    public GuidelineRateDAO() {
    }

    public void savingGuidelineRate(GuidelineRate guidelineRate) {

        dbint.executeQuery(insertGuidelineRate);

        String[] params = new String[8];
        params[0] = guidelineRate.getGuidelineRate();
        params[1] = guidelineRate.getPeakDemand();
        params[2] = guidelineRate.getOutPeakDemand();
        params[3] = guidelineRate.getPeakEnergyDry();
        params[4] = guidelineRate.getOutPeakEnergyDry();
        params[5] = guidelineRate.getPeakEnergyHumid();
        params[6] = guidelineRate.getOutPeakEnergyHumid();
        params[7] = guidelineRate.getValueTranspassed();

        dbint.connect();

        dbint.insert(insertGuidelineRate, params);

        dbint.disconnect();
    }

    public List<GuidelineRate> readGuidelineRate() throws SQLException {
        List<GuidelineRate> listGuideline;

        listGuideline = new ArrayList<>();

        dbint.connect();
        ResultSet rs = dbint.executeQuery(searchGuidelineRate);

        while (rs.next()) {
            GuidelineRate guidelineRate;

            guidelineRate = new GuidelineRate(rs.getString("guideline_rate"), rs.getString("peak_demand"),
                    rs.getString("out_peak_demand"), rs.getString("peak_energy_dry"),
                    rs.getString("out_peak_energy_dry"), rs.getString("peak_energy_humid"),
                    rs.getString("out_peak_energy_humid"), rs.getString("value_transpassed"),
                    rs.getString("timestamp"));

        }

        dbint.disconnect();

        return listGuideline;
    }

    public void updateGuidelineRate(GuidelineRate guidelineRate) {

        String sql = "SELECT id_rate FROM guideline_rate";

        sql = "UPDATE guideline_rate set guideline_rate = ?, peak_demand = ?, out_peak_demand = ?, "
                + "peak_energy_dry = ?, out_peak_energy_dry = ?, peak_energy_humid = ?, "
                + "out_peak_energy_humid = ?, value_transpassed = ?";

        String[] params = new String[8];
        params[0] = guidelineRate.getGuidelineRate();
        params[1] = guidelineRate.getPeakDemand();
        params[2] = guidelineRate.getOutPeakDemand();
        params[3] = guidelineRate.getPeakEnergyDry();
        params[4] = guidelineRate.getOutPeakEnergyDry();
        params[5] = guidelineRate.getPeakEnergyHumid();
        params[6] = guidelineRate.getOutPeakEnergyHumid();
        params[7] = guidelineRate.getValueTranspassed();

        dbint.connect();

        dbint.insert(insertGuidelineRate, params);

        dbint.disconnect();

    }

    public void savingGuidelineRate(List<GuidelineRate> guidelineRete) {
    }

    public void updateGuidelineRate(List<GuidelineRate> guidelineRate) {
    }
}
