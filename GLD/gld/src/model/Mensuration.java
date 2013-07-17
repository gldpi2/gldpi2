/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wagner
 */
public class Mensuration {

    private int idMensuration;
    private double flow;
    private double tension;
    private String timestamp;
    private int year;
    private int mounth;
    private int day;
    private int hour;
    private int minute;
    private int second;

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
}
