/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author greg
 */
public class Contract {

    private int idContract;
    private int idRate;
    private String peakDemand = null;
    private String offPeakDemand = null;
    private String timestamp = null;
    private int year;
    private int month;
    private int day;

    public Contract(String peakDemand, String offPeakDemand, int idRate, String timestamp) {
        this.peakDemand = peakDemand;
        this.offPeakDemand = offPeakDemand;
        this.idRate = idRate;
        this.timestamp = timestamp;
    }

    public Contract() {
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdRate() {
        return idRate;
    }

    public void setIdRate(int idRate) {
        this.idRate = idRate;
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

    public String getTimestamp() {
        return timestamp;
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

        this.year = year;
        this.month = month;
        this.day = day;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
