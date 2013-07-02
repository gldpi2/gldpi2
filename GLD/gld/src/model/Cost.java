package model;

/**
 *
 * @author Matheus
 */
public class Cost {

    double valueEnergy = 0.0;
    double costValue;
    String time;

    /**
     * Método para configurar o valor de energia
     * @param valueEnergy 
     */
    public void setValueEnergy(double valueEnergy) {
        this.valueEnergy = valueEnergy;
    }
    /**
     * Método que irá pegar o valor da energia
     * @return valor da energia
     */
    public double getValueEnergy() {
        return valueEnergy;
    }
    
    /**
     * Método para configurar o valor da energia
     * @param costValue 
     */
    public void setCostValue(double costValue) {
        this.costValue = costValue;
    }

    /**
     * Método que pegar o configura
     * @return valor da energia
     */
    public double getCostValue() {
        return costValue;
    }    
    
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
