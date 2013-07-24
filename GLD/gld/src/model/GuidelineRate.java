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
    private String offPeakDemand = null;
    private String consumptionDryPeak = null;
    private String consumptionDryOffPeak = null;
    private String consumptionHumidPeak = null;
    private String consumptionHumidOffPeak = null;
    private String normalDemand = null;
    private String transpassedDemand = null;
    private String transpassedPeak = null;
    private String transpassedOffPeak = null;
    private String icms = null;
    private String timestamp = null;

    public GuidelineRate(String guidelineRate, String category, String peakDemand, String offPeakDemand,
            String consumptionDryPeak, String consumptionDryOffPeak, String consumptionHumidPeak,
            String consumptionHumidOffPeak, String normalDemand, String transpassedDemand, String transpassedPeak,
            String transpassedOffPeak, String icms, String timestamp) {

        this.guidelineRate = guidelineRate;
        this.category = category;
        this.offPeakDemand = offPeakDemand;
        this.consumptionDryOffPeak = consumptionDryOffPeak;
        this.consumptionHumidOffPeak = consumptionHumidOffPeak;
        this.peakDemand = peakDemand;
        this.consumptionDryPeak = consumptionDryPeak;
        this.consumptionHumidPeak = consumptionHumidPeak;
        this.normalDemand = normalDemand;
        this.transpassedDemand = transpassedDemand;
        this.transpassedPeak = transpassedPeak;
        this.transpassedOffPeak = transpassedOffPeak;
        this.icms = icms;
    }

    public GuidelineRate() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getIcms() {
        return icms;
    }

    public void setIcms(String icms) {
        this.icms = icms;
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

    public void setCoolTimestamp(String uglyTimestamp){
        uglyTimestamp = uglyTimestamp.replace(":", "");
        uglyTimestamp = uglyTimestamp.replace("-", "");
        uglyTimestamp = uglyTimestamp.replace(".", "");
        uglyTimestamp = uglyTimestamp.replace(" ", "");

        String year, month, day;

        year = (uglyTimestamp.substring(0, 4));
        month = (uglyTimestamp.substring(4, 6));
        day = (uglyTimestamp.substring(6, 8));

        this.timestamp =  year + " - " + month + " - " + day; 
    }
    
    public String getCoolTimestamp(String uglyTimestamp){
        timestamp = timestamp.replace(":", "");
        timestamp = timestamp.replace("-", "");
        timestamp = timestamp.replace(".", "");
        timestamp = timestamp.replace(" ", "");

        String year, month, day;

        year = (timestamp.substring(0, 4));
        month = (timestamp.substring(4, 6));
        day = (timestamp.substring(6, 8));

        return day + "/" + month + "/" + year; 
        //return year + " - " + month + " - " + day + " - "; 
    }
    
    public int getIdGuidelineRate() {
        return idGuidelineRate;
    }

    public void setIdGuidelineRate(int idGuidelineRate) {
        this.idGuidelineRate = idGuidelineRate;
    }

    public String getGuidelineRate() {
        return guidelineRate;
    }

    public void setGuidelineRate(String guidelineRate) {
        this.guidelineRate = guidelineRate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPeakDemand() {
        return peakDemand;
    }

    public void setPeakDemand(String peakDemand) {
        this.peakDemand = peakDemand;
    }

    public String getOffPeakDemand() {
        return offPeakDemand;
    }

    public void setOffPeakDemand(String offPeakDemand) {
        this.offPeakDemand = offPeakDemand;
    }

    public String getConsumptionDryPeak() {
        return consumptionDryPeak;
    }

    public void setConsumptionDryPeak(String consumptionDryPeak) {
        this.consumptionDryPeak = consumptionDryPeak;
    }

    public String getConsumptionDryOffPeak() {
        return consumptionDryOffPeak;
    }

    public void setConsumptionDryOffPeak(String consumptionDryOffPeak) {
        this.consumptionDryOffPeak = consumptionDryOffPeak;
    }

    public String getConsumptionHumidPeak() {
        return consumptionHumidPeak;
    }

    public void setConsumptionHumidPeak(String consumptionHumidPeak) {
        this.consumptionHumidPeak = consumptionHumidPeak;
    }

    public String getConsumptionHumidOffPeak() {
        return consumptionHumidOffPeak;
    }

    public void setConsumptionHumidOffPeak(String consumptionHumidOffPeak) {
        this.consumptionHumidOffPeak = consumptionHumidOffPeak;
    }

    public String getTranspassedPeak() {
        return transpassedPeak;
    }

    public void setTranspassedPeak(String transpassedPeak) {
        this.transpassedPeak = transpassedPeak;
    }

    public String getTranspassedOffPeak() {
        return transpassedOffPeak;
    }

    public void setTranspassedOffPeak(String transpassedOffPeak) {
        this.transpassedOffPeak = transpassedOffPeak;
    }

    public String getNormalDemand() {
        return normalDemand;
    }

    public void setNormalDemand(String normalDemand) {
        this.normalDemand = normalDemand;
    }

    public String getTranspassedDemand() {
        return transpassedDemand;
    }

    public void setTranspassedDemand(String transpassedDemand) {
        this.transpassedDemand = transpassedDemand;
    }

}
