package model;

import java.awt.Color;
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
    public TimeSeries seriesLimit = new TimeSeries("Limite", Millisecond.class);
    public JFreeChart costChart;
    public ChartPanel myChartPanel;
    public Mensuration mensuration = new Mensuration();
    
    private double kwValue = 0.0;
    private double costValue;
    private String time;
    private double peak;
    private double outPeak;
    
    
    /**
     * Método para configurar o valor de energia
     * @param kwValue 
     */
    public void setKwValue(double kwValue) {
        this.kwValue = kwValue;
    }
    /**
     * Método que irá pegar o valor da energia
     * @return valor da energia
     */
    public double getKwValue() {
        return kwValue;
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

    public double getPeak() {
        return peak;
    }

    public void setPeak(double peak) {
        this.peak = peak;
    }

    public double getOutPeak() {
        return outPeak;
    }

    public void setOutPeak(double outPeak) {
        this.outPeak = outPeak;
    }
    
    public ChartPanel createCostChart(){
        series = new TimeSeries("R$/kWh", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        dataset.addSeries(seriesLimit);
   
        costChart = ChartFactory.createTimeSeriesChart("Gráfico de Custo","Hora", "Valor em Reais (R$)",dataset,true,true,false);
        
        
        final XYPlot plot = costChart.getXYPlot();
        costChart.setBackgroundPaint(Color.getColor("opaco"));
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        ValueAxis xAxis = plot.getDomainAxis();
        //ValueAxis yAxis = plot.getRangeAxis();
        xAxis.setAutoRange(true);
        xAxis.setFixedAutoRange(60000.0);
        //xAxis.setRange(0, 86400000);
        
        
        
        myChartPanel = new ChartPanel(costChart,true);
        myChartPanel.setMouseZoomable(false, false);
        
        return myChartPanel;
    }
    
    
}
