/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Fernando
 */
public class EstimationOnHistory {
    
    public JFreeChart chart;
    public ChartPanel chartPanel;
    public ValueAxis xAxis;
    public ValueAxis yAxis;
    public TimeSeries series;
    public int state = 0;
    
    private double index;
    
    public double pert(double greater, double minor, double better){
        
        index = ((greater + minor + (4*better))/6);
        
        return index;
        
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }
    
    public static void main(String args[]){
            System.out.println("Indice");
            
            EstimationOnHistory est = new EstimationOnHistory();
            
            System.out.println("Resultado: "+est.pert(5,2,3));
            
        }

//    public ChartPanel createEstimationGraphPanel() {
//        this.series = new TimeSeries("kWh", Millisecond.class);
//        TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
//
//        this.chart = ChartFactory.createTimeSeriesChart("Estimativa", "Dia", "Potência Ativa (kWh)", dataset, true, true, false);
//
//        XYPlot xyplot = (XYPlot) this.chart.getPlot();
//        xyplot.setBackgroundPaint(Color.lightGray);
//        xyplot.setForegroundAlpha(0.65F);
//        xyplot.setDomainGridlinePaint(Color.white);
//        xyplot.setRangeGridlinePaint(Color.white);
//
//        this.xAxis = xyplot.getDomainAxis();
//
//        this.xAxis.setTickMarkPaint(Color.black);
//        this.xAxis.setRange(0, 1440); // 24 horas = 86400000 mili - 24 horas = 1440 minutos
//        this.xAxis.setAutoRange(true);
//        this.xAxis.setFixedAutoRange(60000000.0);
//
//        this.yAxis = xyplot.getRangeAxis();
//        this.yAxis.setRange(0, 6);
//        this.yAxis.setAutoRange(true);
//
//        XYPointerAnnotation xypointerannotation = new XYPointerAnnotation("Test", 5D, -500D, 2.3561944901923448D);
//        xypointerannotation.setTipRadius(0.0D);
//        xypointerannotation.setBaseRadius(35D);
//        xypointerannotation.setFont(new Font("SansSerif", 0, 9));
//        xypointerannotation.setPaint(Color.blue);
//        xypointerannotation.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
//        xyplot.addAnnotation(xypointerannotation);
//
//        this.chartPanel = new ChartPanel(this.chart, true);
//
//        return this.chartPanel;
//    }
}
