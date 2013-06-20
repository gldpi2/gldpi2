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

    public void setIdMensuration(int idMensuration) {
        this.idMensuration = idMensuration;
    }

    public int getIdMensuration() {
        return idMensuration;
    }
    
    public double getFlow() {
        return flow;
    }

    public double getTension() {
        return tension;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public void setTension(double tension) {
        this.tension = tension;
    }

    public void setTimestamp(String timestamp) {
        timestamp = timestamp.replace(":", "");
        timestamp = timestamp.replace("-", "");
        timestamp = timestamp.replace(".", "");
        timestamp = timestamp.replace(" ", "");

        this.timestamp = timestamp;
    }

    
}
