/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Matheus
 */
public class Cost {
  
    double valueEnergy = 0.0;
    double costValue;

    public double getValueEnergy() {
        return valueEnergy;
    }

    public void setValueEnergy(double valueEnergy) {
        this.valueEnergy = valueEnergy;
    }

    public double getCostValue() {
        return costValue;
    }

    public void setCostValue(double costValue) {
        this.costValue = costValue;
    }
    
}
