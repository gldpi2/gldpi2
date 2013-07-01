/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Cost;

/**
 *
 * @author Matheus
 */
public class CostCtrl {

    public final static double HOUR = 3600;
    public final static double PEAK = 19.65 / HOUR;
    public final static double VALUE_OFFPEAK = 5.22 / HOUR;
    Cost cost = new Cost();
    String time;
    double hour;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Método para cálculo da hora/kWh
     *
     * @param tension tensão no momento atual
     * @param flow corrente no momento atual
     * @return custo atual.
     */
    public double energyValue() {

        /**
         * Método que verifica a hora do banco de dados e coloca o valor do kWh de
         * acordo com o documento da CEB (Companhia Energética de Brasília) Hora
         * de ponta é entre 18 e 21 e o restante tem valor menor
         */
        hour = Double.parseDouble(getTime());
        if (hour >= 18 && hour < 21) {
            cost.setValueEnergy(PEAK);
        } else {
            cost.setValueEnergy(VALUE_OFFPEAK);
        }
        double costValue = cost.getValueEnergy()*100;
        

        return costValue;
    }
}
