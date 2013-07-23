/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GuidelineRateDAO;
import java.sql.SQLException;
import java.util.List;
import model.GuidelineRate;

/**
 *
 * @author greg
 */
public class GuidelineRateCtrl {

    GuidelineRateDAO dao = new GuidelineRateDAO();

    public void createGuidelineRate(String guidelineRate, String category, String peakDemand, 
            String offPeakDemand, String consumptionDryPeak, String consumptionDryOffPeak,
            String consumptionHumidPeak, String consumptionHumidOffPeak, String normalDemand,
            String transpassedDemand, String transpassedPeak, String transpassedOffPeak, 
            String icms, String timestamp) {

        GuidelineRate guideline = new GuidelineRate();

        guideline.setGuidelineRate(guidelineRate);
        guideline.setCategory(category);
        guideline.setPeakDemand(peakDemand);
        guideline.setOffPeakDemand(offPeakDemand);
        guideline.setConsumptionDryPeak(consumptionDryPeak);
        guideline.setConsumptionDryOffPeak(consumptionDryOffPeak);
        guideline.setConsumptionHumidPeak(consumptionHumidPeak);
        guideline.setConsumptionHumidOffPeak(consumptionHumidOffPeak);
        guideline.setNormalDemand(normalDemand);
        guideline.setTranspassedDemand(transpassedDemand);
        guideline.setTranspassedPeak(transpassedPeak);
        guideline.setTranspassedOffPeak(transpassedOffPeak);
        guideline.setIcms(icms);

        //guideline.setTimestamp(timestamp);

        dao.createGuidelineRate(guideline);
    }

    public void updateGuidelineRate(String guidelineRate, String category, String peakDemand, 
            String offPeakDemand, String consumptionDryPeak, String consumptionDryOffPeak,
            String consumptionHumidPeak, String consumptionHumidOffPeak, String normalDemand,
            String transpassedDemand, String transpassedPeak, String transpassedOffPeak, 
            String icms, String timestamp) {

        GuidelineRate guideline = new GuidelineRate();

        guideline.setGuidelineRate(guidelineRate);
        guideline.setCategory(category);
        guideline.setPeakDemand(peakDemand);
        guideline.setOffPeakDemand(offPeakDemand);
        guideline.setConsumptionDryPeak(consumptionDryPeak);
        guideline.setConsumptionDryOffPeak(consumptionDryOffPeak);
        guideline.setConsumptionHumidPeak(consumptionHumidPeak);
        guideline.setConsumptionHumidOffPeak(consumptionHumidOffPeak);
        guideline.setNormalDemand(normalDemand);
        guideline.setTranspassedDemand(transpassedDemand);
        guideline.setTranspassedPeak(transpassedPeak);
        guideline.setTranspassedOffPeak(transpassedOffPeak);
        guideline.setIcms(icms);
        dao.updateGuidelineRate(guideline);
    }
    
     public List<GuidelineRate> readGuidelineRate() throws SQLException{
         return dao.readGuidelineRate();
     }
}
