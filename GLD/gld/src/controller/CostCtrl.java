/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CostDAO;
import model.Cost;
import model.Mensuration;

/**
 *
 * @author Matheus
 */
public class CostCtrl {

    public final static double HOUR = 3600;
    public final static double PEAK = 19.65 / HOUR;
    public final static double VALUE_OFFPEAK = 5.22 / HOUR;
    Mensuration mens = new Mensuration();
    Cost cost = new Cost();
    double hour;
    double costValue;

    

    /**
     * Método para cálculo da hora/kWh
     *
     * @param tension tensão no momento atual
     * @param flow corrente no momento atual
     * @return custo atual.
     */
    public double energyValue(double potency) {

        /**
         * Método que verifica a hora do banco de dados e coloca o valor do kWh de
         * acordo com o documento da CEB (Companhia Energética de Brasília) Hora
         * de ponta é entre 18 e 21 e o restante tem valor menor
         */
        hour = Double.parseDouble(mens.getTimestamp().substring(8, 10));
        if (hour >= 18.0 && hour < 21.0) {
            cost.setValueEnergy(PEAK);
            
        } else {
            cost.setValueEnergy(VALUE_OFFPEAK);
           
        }
        costValue = potency * cost.getValueEnergy() *100;
        System.out.println(cost.getValueEnergy());
        System.out.println(potency);
        

        return costValue;
    }
}
