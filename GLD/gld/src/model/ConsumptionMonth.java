package model;

/**
 *
 * @author itallorossi
 */
public class ConsumptionMonth {

    private int id;
    private int year;
    private int month;
    private double peakConsumption;
    private double offPeakConsumption;
    private double peakDemand;
    private double offPeakDemand;
    private double peakExtra;
    private double offPeakExtra;
    private int dryOrHumid;

    public ConsumptionMonth() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPeakConsumption() {
        return peakConsumption;
    }

    public void setPeakConsumption(double peakConsumption) {
        this.peakConsumption = peakConsumption;
    }

    public double getOffPeakConsumption() {
        return offPeakConsumption;
    }

    public void setOffPeakConsumption(double offPeakConsumption) {
        this.offPeakConsumption = offPeakConsumption;
    }

    public double getPeakDemand() {
        return peakDemand;
    }

    public void setPeakDemand(double peakDemand) {
        this.peakDemand = peakDemand;
    }

    public double getOffPeakDemand() {
        return offPeakDemand;
    }

    public void setOffPeakDemand(double offPeakDemand) {
        this.offPeakDemand = offPeakDemand;
    }

    public double getPeakExtra() {
        return peakExtra;
    }

    public void setPeakExtra(double peakExtra) {
        this.peakExtra = peakExtra;
    }

    public double getOffPeakExtra() {
        return offPeakExtra;
    }

    public void setOffPeakExtra(double offPeakExtra) {
        this.offPeakExtra = offPeakExtra;
    }

    public int getDryOrHumid() {
        return dryOrHumid;
    }

    public void setDryOrHumid(int dryOrHumid) {
        this.dryOrHumid = dryOrHumid;
    }

    @Override
    public String toString() {
        return "ConsumptionMonth{" + "id=" + id + ", year=" + year + ", month=" + month + ", peakConsumption=" + peakConsumption + ", offPeakConsumption=" + offPeakConsumption + ", peakDemand=" + peakDemand + ", offPeakDemand=" + offPeakDemand + ", peakExtra=" + peakExtra + ", offPeakExtra=" + offPeakExtra + ", dryOrHumid=" + dryOrHumid + '}';
    }
}
