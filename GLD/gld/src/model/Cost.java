/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    /*
     * Método para cálculo da hora/kWh
     */
    public double energyValue(double flow, double tension){
        /*
         * Verificar como eu diferencio a hora para alterar o valor da energia
         * Criar if ou while para setar o valor da energia
         */
        setValueEnergy(valueEnergy);
        costValue = flow*tension*getValueEnergy();
        
        
        return costValue;
    }
}
