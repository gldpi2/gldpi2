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
    private String peakDemandContracted = null;
    private String outPeakDemandContracted = null;
    private String humidSeason = null;
    private String drySeason = null;
    private String timestamp = null;
    private int year;
    private int month;
    private int day;

    public Contract(String peakDemandContracted, String outPeakDemandContracted, String humidSeason,
                    String drySeason, String timestamp){
        this.peakDemandContracted = peakDemandContracted;
        this.outPeakDemandContracted = outPeakDemandContracted;
        this.humidSeason = humidSeason;
        this.drySeason = drySeason;
        this.timestamp = timestamp;
    }
    
    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getPeakDemandContracted() {
        return peakDemandContracted;
    }

    public void setPeakDemandContracted(String peakDemandContracted) {
        this.peakDemandContracted = peakDemandContracted;
    }

    public String getOutPeakDemandContracted() {
        return outPeakDemandContracted;
    }

    public void setOutPeakDemandContracted(String outPeakDemandContracted) {
        this.outPeakDemandContracted = outPeakDemandContracted;
    }

    public String getHumidSeason() {
        return humidSeason;
    }

    public void setHumidSeason(String humidSeason) {
        this.humidSeason = humidSeason;
    }

    public String getDrySeason() {
        return drySeason;
    }

    public void setDrySeason(String drySeason) {
        this.drySeason = drySeason;
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
