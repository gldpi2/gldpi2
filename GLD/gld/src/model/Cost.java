package model;

/**
 *
 * @author Matheus
 */
public class Cost {

    double valueEnergy = 0.0;
    double costValue;
    String time;
    public double maxCost;
    public double minCost;
    public Mensuration mensuration = new Mensuration();

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

    public double getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(double maxCost) {
        this.maxCost = maxCost;
    }

    public double getMinCost() {
        return minCost;
    }

    public void setMinCost(double minCost) {
        this.minCost = minCost;
    }
    
    
    
}
