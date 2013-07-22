package model;

import controller.LoadEstimationOnHistoryCtrl;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Vector;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Fernando
 */
public class CostEstimationOnHistory {

    public JFreeChart chart;
    public ChartPanel chartPanel;
    private ValueAxis xAxis;
    public ValueAxis yAxis;
    public TimeSeries series;
    public TimeSeries seriesLimit = new TimeSeries("Limite", Millisecond.class);
    public int state = 0;
    public Mensuration maxMensuration = new Mensuration();
    public Mensuration minMensuration = new Mensuration();                
    private double finalCost;

    public ChartPanel createLoadEstimationOnHistoryGraphPanel(Vector<Double> interval,int type) {
        
        final XYDataset mensurationDataSet = createMensurationDataSet(interval, type);
        XYBarRenderer x = new XYBarRenderer();
        XYBarRenderer.setDefaultShadowsVisible(false);
        x.setDrawBarOutline(true);
        x.setMargin(0.3);

        final XYItemRenderer mensurationRender = x;

        mensurationRender.setSeriesPaint(0, new Color(0, 255, 0, 255));
        mensurationRender.setSeriesPaint(1, Color.RED);
        mensurationRender.setSeriesPaint(2, Color.BLUE);

        final DateAxis domainAxis = new DateAxis("Date");
        domainAxis.setVerticalTickLabels(true);
        switch(type){
            case LoadEstimationOnHistoryCtrl.INTERVAL_LAST_DAY:
                domainAxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR, 1));
                domainAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
                break;
            case LoadEstimationOnHistoryCtrl.INTERVAL_MONTH:
                domainAxis.setTickUnit(new DateTickUnit(DateTickUnit.DAY, 1));
                domainAxis.setDateFormatOverride(new SimpleDateFormat("dd/MM"));
                break;
            default:
                domainAxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR, 1));
                domainAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
                break;
                
        }
        domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);
        final ValueAxis rangeAxis = new NumberAxis("Value");

        final XYPlot plot = new XYPlot(mensurationDataSet, domainAxis, rangeAxis, mensurationRender);

        final StandardXYItemRenderer alertRender = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);
        //alertRender.setShapesFilled(true);

        plot.setRenderer(1, alertRender);

        final StandardXYItemRenderer contractRender = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);
        //contractRender.setShapesFilled(true);

        plot.setRenderer(2, contractRender);

        final JFreeChart chartCurve = new JFreeChart("Estimativa de Curva de Carga", plot);
        chartPanel = new ChartPanel(chartCurve);
        chartPanel.setMouseZoomable(true, false);

        return this.chartPanel;
    }

    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return the dataset.
     */
    public XYDataset createMensurationDataSet(Vector<Double> interval,int type) {
        //final TimePeriodValues offPeakSerie = new TimePeriodValues("Fora de Ponta");
        //final TimePeriodValues peakSerie = new TimePeriodValues("Ponta");
        final TimePeriodValues costEstimationOnHistorySerie = new TimePeriodValues("Estimativa");

        final Day today = new Day();
        double measure = interval.get(0);
        for (int i = 0; i < type ; i++) {
            final Minute m0 = new Minute(0, new Hour(i, today));
            final Minute m1 = new Minute(0, new Hour(i + 1, today));
            costEstimationOnHistorySerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), measure);             
            measure += interval.get(i);
        }  
        setFinalCost(measure);
        final TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();

        dataset.addSeries(costEstimationOnHistorySerie);

        return dataset;
    }

    public void setFinalCost(double value) {
        this.finalCost = value;
    }
    
    public double getFinalCost() {
        return this.finalCost;
    }

}
