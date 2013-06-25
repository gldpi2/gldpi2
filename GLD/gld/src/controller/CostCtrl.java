/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Cost;

/**
 *
 * @author Matheus
 */
public class CostCtrl {
    public final static double HOUR = 3600;
    public final static double PEAK = 19.65/HOUR;
    public final static double VALUE_OFFPEAK = 5.22/HOUR;
    Cost cost = new Cost();
    
    /**
     * Método para cálculo da hora/kWh
     * @param tension tensão no momento atual
     * @param flow corrente no momento atual
     * @return custo atual.
     */
    
    public double energyValue(double flow, double tension){
        GregorianCalendar gc = new GregorianCalendar();
        
        /**
         * Método que verifica a hora do computador e 
         * coloca o valor do kWh de acordo com o documento da CEB (Companhia Energética de Brasília)
         * Hora de ponta é entre 19 e 21 e o restante tem valor menor
         */
        if(gc.get(Calendar.HOUR_OF_DAY)>=18 && gc.get(Calendar.HOUR_OF_DAY)<21){
            cost.setValueEnergy(PEAK);
        } else {
            cost.setValueEnergy(VALUE_OFFPEAK);
        }
        double costValue = flow*tension*cost.getValueEnergy();
        
        
        return costValue;
    }
}
