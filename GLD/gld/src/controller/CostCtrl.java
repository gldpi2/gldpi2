/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.CostCtrl.HOUR;
import static controller.CostCtrl.PEAK;
import static controller.CostCtrl.VALUE_OFFPEAK;
import dao.CostDAO;
import java.util.List;
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
    private CostDAO cDao = new CostDAO();
    private List<Mensuration> listMensuration;
    private Cost cost = new Cost();
    private double hour;
    

    public List<Mensuration> allMensuration(){
       listMensuration = cDao.allMeasurements();
        
        return listMensuration;
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
        hour = Double.parseDouble(cDao.getTime());
        if (hour >= 18 && hour < 21) {
            cost.setValueEnergy(PEAK);
        } else {
            cost.setValueEnergy(VALUE_OFFPEAK);
        }
        double costValue = cost.getValueEnergy()*100;
        
        
        return costValue;
    }
    
    public void setCostMax(double maxCost){
         cost.setMaxCost(maxCost);
    }
    
    public void setCostMin(double minCost){
        cost.setMinCost(minCost);
    }
    
    public double getCostMax(){
        return cost.getMaxCost();
    }
    
    public double getCostMin(){
        return cost.getMinCost();
    }
    
    public void setMensuration(Mensuration mensuration){
        cost.mensuration = mensuration;
    }
    
    public Mensuration getMensuration(){
        return cost.mensuration;
    }
}