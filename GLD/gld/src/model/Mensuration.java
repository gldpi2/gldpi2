package model;

import java.util.Date;
import org.jfree.data.time.Millisecond;

/**
 *
 * @author wagner
 */
public class Mensuration {

    private int idMensuration;
    private double flow;
    private double tension;
    private double powerFactor;
    private double frequency;
    private double flowPanel;
    private double flowAeroGenerator;
    private double bateryTension;
    private double bateryLoad;
    private int activeSystem;
    private int energyAvailable;
    private String timestamp;
    private int year;
    private int mounth;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private Millisecond millisecond;

    /**
     * Método para configurar o identificador da medição.
     *
     * @param idMensuration int Identificador da medição.
     */
    public void setIdMensuration(int idMensuration) {
        this.idMensuration = idMensuration;
    }

    /**
     * Método para configurar a corrente da medição.
     *
     * @param flow double Corrente da medição.
     */
    public void setFlow(double flow) {
        this.flow = flow;
    }

    /**
     * Método para configurar a tensão da medição.
     *
     * @param tension double Tensão da medição.
     */
    public void setTension(double tension) {
        this.tension = tension;
    }

    /**
     * Método para configurar a data e hora da medição.
     *
     * @param timestamp String Data e hora da medição.
     */
    public void setTimestamp(String timestamp) {
        timestamp = timestamp.replace(":", "");
        timestamp = timestamp.replace("-", "");
        timestamp = timestamp.replace(".", "");
        timestamp = timestamp.replace(" ", "");

        year = Integer.parseInt(timestamp.substring(0, 4));
        mounth = Integer.parseInt(timestamp.substring(4, 6));
        day = Integer.parseInt(timestamp.substring(6, 8));
        hour = Integer.parseInt(timestamp.substring(8, 10));
        minute = Integer.parseInt(timestamp.substring(10, 12));
        second = Integer.parseInt(timestamp.substring(12, 14));

        Date time = new Date(year, mounth, day, hour, minute, second);

        this.millisecond = new Millisecond(time);
        this.timestamp = timestamp;
    }

    /**
     * Método para receber o identificador da medição.
     *
     * @return int Identificador da medição.
     */
    public int getIdMensuration() {
        return idMensuration;
    }

    /**
     * Método para receber a corrente da medição.
     *
     * @return double Corrente da medição.
     */
    public double getFlow() {
        return flow;
    }

    /**
     * Método para receber a tensão da medição.
     *
     * @return double Tensão da medição.
     */
    public double getTension() {
        return tension;
    }

    /**
     * Método para receber a data e hora da medição.
     *
     * @return String Data e hora da medição.
     */
    public String getTimestamp() {
        return timestamp;
    }

    public Millisecond getMillisecond() {
        return millisecond;
    }

    public double getPotency() {
        return tension * flow;
    }

    public String getTime() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public int getMinute() {
        //TESTE!!!!
        return this.minute;
    }

    public int getHour() {
        //TESTE!!!!
        return this.hour;
    }

    public int getSecond() {
        return this.second;
    }

    public int getDay() {
        return this.day;
    }

    public int getMounth() {
        return this.mounth;
    }

    public int getYear() {
        return this.year;
    }

    public void setPowerFactor(double powerFactor) {
        this.powerFactor = powerFactor;
    }

    public void setFlowPanel(double flowPanel) {
        this.flowPanel = flowPanel;
    }

    public void setFlowAeroGenerator(double flowAeroGenerator) {
        this.flowAeroGenerator = flowAeroGenerator;
    }

    public void setBateryTension(double bateryTension) {
        this.bateryTension = bateryTension;
    }

    public void setBateryLoad(double bateryLoad) {
        this.bateryLoad = bateryLoad;
    }

    public void setActiveSystem(int activeSystem) {
        this.activeSystem = activeSystem;
    }

    public void setEnergyAvailable(int energyAvailable) {
        this.energyAvailable = energyAvailable;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getPowerFactor() {
        return powerFactor;
    }

    public double getFrequency() {
        return frequency;
    }

    public double getFlowPanel() {
        return flowPanel;
    }

    public double getFlowAeroGenerator() {
        return flowAeroGenerator;
    }

    public double getBateryTension() {
        return bateryTension;
    }

    public double getBateryLoad() {
        return bateryLoad;
    }

    public int getActiveSystem() {
        return activeSystem;
    }

    public int getEnergyAvailable() {
        return energyAvailable;
    }

    public String getDate() {
        return "" + this.day + "/" + this.mounth + "/" + this.year;
    }
}
