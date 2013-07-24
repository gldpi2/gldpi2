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
import view.GuidelineRateWindow;

/**
 *
 * @author greg
 */
public class GuidelineRateDAO {

    private DatabaseInterface dbint = new DatabaseInterface();
    public static final String searchGuidelineRate = "SELECT * FROM guideline_rate";

    public GuidelineRateDAO() {
    }

    public void createGuidelineRate(GuidelineRate guidelineRate) {

        if (GuidelineRateWindow.guidelineComboBox.getSelectedItem().toString().equals("Horo-Sazonal Azul")){
            String insertGuidelineRate = "INSERT INTO guideline_rate (guideline_rate, category, peak_demand, off_peak_demand, consumption_dry_peak, "
                    + "consumption_dry_off_peak, consumption_humid_peak, consumption_humid_off_peak, transpassed_peak, transpassed_off_peak, icms) VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?,?)";

            String[] params = new String[11];
            params[0] = guidelineRate.getGuidelineRate();
            params[1] = guidelineRate.getCategory();
            params[2] = guidelineRate.getPeakDemand();
            params[3] = guidelineRate.getOffPeakDemand();
            params[4] = guidelineRate.getConsumptionDryPeak();
            params[5] = guidelineRate.getConsumptionDryOffPeak();
            params[6] = guidelineRate.getConsumptionHumidPeak();
            params[7] = guidelineRate.getConsumptionHumidOffPeak();
            params[8] = guidelineRate.getTranspassedPeak();
            params[9] = guidelineRate.getTranspassedOffPeak();
            params[10] = guidelineRate.getIcms();

            dbint.connect();

            dbint.insert(insertGuidelineRate, params);

            dbint.disconnect();
            
        } else {
                    String insertGuidelineRate = "INSERT INTO guideline_rate (guideline_rate, category, consumption_dry_peak, "
                    + "consumption_dry_off_peak, consumption_humid_peak, consumption_humid_off_peak, normal_demand, transpassed_demand, icms) VALUES "
                    + "(?,?,?,?,?,?,?,?,?)";

            String[] params = new String[9];
            params[0] = guidelineRate.getGuidelineRate();
            params[1] = guidelineRate.getCategory();
            params[2] = guidelineRate.getConsumptionDryPeak();
            params[3] = guidelineRate.getConsumptionDryOffPeak();
            params[4] = guidelineRate.getConsumptionHumidPeak();
            params[5] = guidelineRate.getConsumptionHumidOffPeak();
            params[6] = guidelineRate.getNormalDemand();
            params[7] = guidelineRate.getTranspassedDemand();
            params[8] = guidelineRate.getIcms();

            dbint.connect();

            dbint.insert(insertGuidelineRate, params);

            dbint.disconnect();
        
        }

    }

    public List<GuidelineRate> readGuidelineRate() throws SQLException {
        List<GuidelineRate> listGuideline;

        listGuideline = new ArrayList<>();

        dbint.connect();
        ResultSet rs = dbint.executeQuery(searchGuidelineRate);

        while (rs.next()) {
            GuidelineRate guidelineRate;

//            guidelineRate = new GuidelineRate(rs.getString("guideline_rate"), rs.getString("category"), rs.getString("peak_demand"),
//                    rs.getString("off_peak_demand"), rs.getString("consumption_dry_peak"), rs.getString("consumption_dry_off_peak"), 
//                    rs.getString("consumption_humid_peak"), rs.getString("consumption_humid_off_peak"), rs.getString("normal_demand"), 
//                    rs.getString("transpassed_demand"), rs.getString("transpassed_peak"), rs.getString("transpassed_off_peak"), 
//                    rs.getString("icms"), rs.getString("timestamp"));
            
            guidelineRate = new GuidelineRate();
            guidelineRate.setIdGuidelineRate(Integer.parseInt(rs.getString("id_rate")));
            guidelineRate.setGuidelineRate(rs.getString("guideline_rate"));
            guidelineRate.setCategory(rs.getString("category"));
            guidelineRate.setPeakDemand(rs.getString("peak_demand"));
            guidelineRate.setOffPeakDemand(rs.getString("off_peak_demand"));
            guidelineRate.setConsumptionDryPeak(rs.getString("consumption_dry_peak"));
            guidelineRate.setConsumptionDryOffPeak(rs.getString("consumption_dry_off_peak"));
            guidelineRate.setConsumptionHumidPeak(rs.getString("consumption_humid_peak"));
            guidelineRate.setConsumptionHumidOffPeak(rs.getString("consumption_humid_off_peak"));
            guidelineRate.setNormalDemand(rs.getString("normal_demand"));
            guidelineRate.setTranspassedDemand(rs.getString("transpassed_demand"));
            guidelineRate.setTranspassedPeak(rs.getString("transpassed_peak"));
            guidelineRate.setTranspassedOffPeak(rs.getString("transpassed_off_peak"));
            guidelineRate.setIcms(rs.getString("icms"));
            guidelineRate.setCoolTimestamp(rs.getString("timestamp"));
//                    , , , 
//                    , , , 
//                    , 
            
            
            listGuideline.add(guidelineRate);
        }

        dbint.disconnect();

        return listGuideline;
    }

    public void updateGuidelineRate(GuidelineRate guidelineRate) {

//        String updateGuidelineRate = "UPDATE guideline_rate SET guideline_rate = ?, category = ?, demand = ?, peak_demand = ?, "
//                + "off_peak_demand = ?, consumption = ?, "
//                + "consumption_dry_peak = ?, consumption_dry_off_peak = ?, consumption_humid_peak = ?, "
//                + "consumption_humid_off_peak = ?, transpassed_peak = ?, transpassed_off_peak = ?, "
//                + "max_limit = ?, icms = ?"
//                + "WHERE id_rate = ?";
//
//        String[] params = new String[15];
//        params[0] = guidelineRate.getGuidelineRate();
//        params[1] = guidelineRate.getCategory();
//        params[2] = guidelineRate.getDemand();
//        params[3] = guidelineRate.getPeakDemand();
//        params[4] = guidelineRate.getOffPeakDemand();
//        params[5] = guidelineRate.getConsumption();
//        params[6] = guidelineRate.getConsumptionDryPeak();
//        params[7] = guidelineRate.getConsumptionDryOffPeak();
//        params[8] = guidelineRate.getConsumptionHumidPeak();
//        params[9] = guidelineRate.getConsumptionHumidOffPeak();
//        params[10] = guidelineRate.getTranspassedPeak();
//        params[11] = guidelineRate.getTranspassedOffPeak();
//        params[12] = guidelineRate.getMaxLimit();
//        params[13] = guidelineRate.getIcms();
//        params[14] = String.valueOf(guidelineRate.getIdGuidelineRate());

        if (GuidelineRateWindow.guidelineComboBox.getSelectedItem().toString().equals("Horo-Sazonal Azul")) {
        String updateGuidelineRate = "UPDATE guideline_rate SET guideline_rate = ?, category = ?, peak_demand = ?, "
                + "off_peak_demand = ?, "
                + "consumption_dry_peak = ?, consumption_dry_off_peak = ?, consumption_humid_peak = ?, "
                + "consumption_humid_off_peak = ?, transpassed_peak = ?, transpassed_off_peak = ?, "
                + "icms = ?"
                + "WHERE id_rate = ?";

        String[] params = new String[12];
        params[0] = guidelineRate.getGuidelineRate();
        params[1] = guidelineRate.getCategory();
        params[2] = guidelineRate.getPeakDemand();
        params[3] = guidelineRate.getOffPeakDemand();
        params[4] = guidelineRate.getConsumptionDryPeak();
        params[5] = guidelineRate.getConsumptionDryOffPeak();
        params[6] = guidelineRate.getConsumptionHumidPeak();
        params[7] = guidelineRate.getConsumptionHumidOffPeak();
        params[8] = guidelineRate.getTranspassedPeak();
        params[9] = guidelineRate.getTranspassedOffPeak();
        params[10] = guidelineRate.getIcms();
        params[11] = String.valueOf(guidelineRate.getIdGuidelineRate());

            dbint.connect();

            dbint.insert(updateGuidelineRate, params);

            dbint.disconnect();

        } else {
                String updateGuidelineRate = "UPDATE guideline_rate SET guideline_rate = ?, category = ?, "
                + "consumption_dry_peak = ?, consumption_dry_off_peak = ?, consumption_humid_peak = ?, "
                + "consumption_humid_off_peak = ?, normal_demand = ?, transpassed_demand = ?, "
                + "icms = ?"
                + "WHERE id_rate = ?";

        String[] params = new String[10];
        params[0] = guidelineRate.getGuidelineRate();
        params[1] = guidelineRate.getCategory();
        params[2] = guidelineRate.getConsumptionDryPeak();
        params[3] = guidelineRate.getConsumptionDryOffPeak();
        params[4] = guidelineRate.getConsumptionHumidPeak();
        params[5] = guidelineRate.getConsumptionHumidOffPeak();
        params[6] = guidelineRate.getNormalDemand();
        params[7] = guidelineRate.getTranspassedDemand();
        params[8] = guidelineRate.getIcms();
        params[9] = String.valueOf(guidelineRate.getIdGuidelineRate());

            dbint.connect();

            dbint.insert(updateGuidelineRate, params);

            dbint.disconnect();

        }

        
        
//        dbint.connect();
//
//        dbint.insert(updateGuidelineRate, params);
//
//        dbint.disconnect();

    }

    public void updateGuidelineRate(List<GuidelineRate> guidelineRate) {
    }
}
