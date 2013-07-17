package model;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Matheus
 */
public class Cost {

    public TimeSeries series;
    public JFreeChart costChart;
    public ChartPanel myChartPanel;
    
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
    
    public ChartPanel createCostChart(){
        series = new TimeSeries("R$/kWh", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(series);
                       
        costChart = ChartFactory.createTimeSeriesChart("Gráfico de Custo","Hora", "Valor em Real (R$)",dataset,true,true,false);
        final XYPlot plot = costChart.getXYPlot();
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setAutoRange(true);
        xAxis.setFixedAutoRange(60000.0);
        //xAxis.setRange(0, 86400000);
        
        ValueAxis yAxis;
        yAxis = plot.getRangeAxis();
        //yAxis.setRange(0.0, 10.0);
        yAxis.setAutoRange(true);
        myChartPanel = new ChartPanel(costChart,true);
        
        return myChartPanel;
    }
    
    
}
