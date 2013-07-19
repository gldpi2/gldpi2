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

    public void createGuidelineRate(String guidelineRate, String category, String peakDemand, String outPeakDemand,
            String peakEnergyDry, String outPeakEnergyDry, String peakEnergyHumid,
            String outPeakEnergyHumid, String valueTranspassed, String timestamp) {

        GuidelineRate guideline = new GuidelineRate();

        guideline.setGuidelineRate(guidelineRate);
        guideline.setCategory(category);
        guideline.setPeakDemand(peakDemand);
        guideline.setOutPeakDemand(outPeakDemand);
        guideline.setPeakEnergyDry(peakEnergyDry);
        guideline.setOutPeakEnergyDry(outPeakEnergyDry);
        guideline.setPeakEnergyHumid(peakEnergyHumid);
        guideline.setOutPeakEnergyHumid(outPeakEnergyHumid);
        guideline.setValueTranspassed(valueTranspassed);
        //guideline.setTimestamp(timestamp);

        dao.createGuidelineRate(guideline);
    }

    public void updateGuidelineRate(String guidelineRate, String category, String peakDemand, String outPeakDemand,
            String peakEnergyDry, String outPeakEnergyDry, String peakEnergyHumid,
            String outPeakEnergyHumid, String valueTranspassed, String timestamp) {

        GuidelineRate guideline = new GuidelineRate();

        guideline.setGuidelineRate(guidelineRate);
        guideline.setCategory(category);
        guideline.setPeakDemand(peakDemand);
        guideline.setOutPeakDemand(outPeakDemand);
        guideline.setPeakEnergyDry(peakEnergyDry);
        guideline.setOutPeakEnergyDry(outPeakEnergyDry);
        guideline.setPeakEnergyHumid(peakEnergyHumid);
        guideline.setOutPeakEnergyHumid(outPeakEnergyHumid);
        guideline.setValueTranspassed(valueTranspassed);
        guideline.setTimestamp(timestamp);

        dao.updateGuidelineRate(guideline);
    }
    
     public List<GuidelineRate> readGuidelineRate() throws SQLException{
         return dao.readGuidelineRate();
     }
}
