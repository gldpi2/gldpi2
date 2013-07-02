/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.EstimationOnHistory;

/**
 *
 * @author Fernando
 */
public class EstimationCtrl {
    
    EstimationOnHistory est = new EstimationOnHistory();
    String minor;
    double greater;
    double better;
    private double minorIndex;

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public double getGreater() {
        return greater;
    }

    public void setGreater(double greater) {
        this.greater = greater;
    }

    public double getBetter() {
        return better;
    }

    public void setBetter(double better) {
        this.better = better;
    }    
}
