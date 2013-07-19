/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import org.jfree.data.time.Millisecond;

/**
 *
 * @author greg
 */
public class GuidelineRate {

    private int idGuidelineRate;
    private String guidelineRate = null;
    private String category = null;
    private String peakDemand = null;
    private String outPeakDemand = null;
    private String peakEnergyDry = null;
    private String outPeakEnergyDry = null;
    private String peakEnergyHumid = null;
    private String outPeakEnergyHumid = null;
    private String valueTranspassed = null;
    private int dryMonthStart;
    private int humidMonthStart;
    private String timestamp = null;

    public GuidelineRate(String guidelineRate, String category, String peakDemand, String outPeakDemand,
            String peakEnergyDry, String outPeakEnergyDry, String peakEnergyHumid,
            String outPeakEnergyHumid, String valueTranspassed, int dryMonthStart,
            int humidMonthStart, String timestamp) {

        this.guidelineRate = guidelineRate;
        this.category = category;
        this.outPeakDemand = outPeakDemand;
        this.outPeakEnergyDry = outPeakEnergyDry;
        this.outPeakEnergyHumid = outPeakEnergyHumid;
        this.peakDemand = peakDemand;
        this.peakEnergyDry = peakEnergyDry;
        this.peakEnergyHumid = peakEnergyHumid;
        this.valueTranspassed = valueTranspassed;
        this.dryMonthStart = dryMonthStart;
        this.humidMonthStart = humidMonthStart;

    }

    public GuidelineRate() {
    }

    public String getGuidelineRate() {
        return guidelineRate;
    }

    public int getIdGuidelineRate() {
        return idGuidelineRate;
    }

    public void setIdGuidelineRate(int idGuidelineRate) {
        this.idGuidelineRate = idGuidelineRate;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTimestamp(String timestamp) {
        timestamp = timestamp.replace(":", "");
        timestamp = timestamp.replace("-", "");
        timestamp = timestamp.replace(".", "");
        timestamp = timestamp.replace(" ", "");

        int year, month, day;

        year = Integer.parseInt(timestamp.substring(0, 4));
        month = Integer.parseInt(timestamp.substring(4, 6));
        day = Integer.parseInt(timestamp.substring(6, 8));

        this.timestamp = timestamp;
    }

    public void setGuidelineRate(String guidelineRate) {
        this.guidelineRate = guidelineRate;
    }

    public String getPeakDemand() {
        return peakDemand;
    }

    public void setPeakDemand(String peakDemand) {
        this.peakDemand = peakDemand;
    }

    public String getOutPeakDemand() {
        return outPeakDemand;
    }

    public void setOutPeakDemand(String outPeakDemand) {
        this.outPeakDemand = outPeakDemand;
    }

    public String getPeakEnergyDry() {
        return peakEnergyDry;
    }

    public void setPeakEnergyDry(String peakEnergyDry) {
        this.peakEnergyDry = peakEnergyDry;
    }

    public String getOutPeakEnergyDry() {
        return outPeakEnergyDry;
    }

    public void setOutPeakEnergyDry(String outPeakEnergyDry) {
        this.outPeakEnergyDry = outPeakEnergyDry;
    }

    public String getPeakEnergyHumid() {
        return peakEnergyHumid;
    }

    public void setPeakEnergyHumid(String peakEnergyHumid) {
        this.peakEnergyHumid = peakEnergyHumid;
    }

    public int getDryMonthStart() {
        return dryMonthStart;
    }

    public void setDryMonthStart(int dryMonthStart) {
        this.dryMonthStart = dryMonthStart;
    }

    public int getHumidMonthStart() {
        return humidMonthStart;
    }

    public void setHumidMonthStart(int humidMonthStart) {
        this.humidMonthStart = humidMonthStart;
    }

    public String getOutPeakEnergyHumid() {
        return outPeakEnergyHumid;
    }

    public void setOutPeakEnergyHumid(String outPeakEnergyHumid) {
        this.outPeakEnergyHumid = outPeakEnergyHumid;
    }

    public String getValueTranspassed() {
        return valueTranspassed;
    }

    public void setValueTranspassed(String valueTranspassed) {
        this.valueTranspassed = valueTranspassed;
    }

}
