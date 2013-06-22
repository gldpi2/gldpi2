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
}
