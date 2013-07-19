package model;

import java.awt.Color;
import java.text.SimpleDateFormat;
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
import org.jfree.data.time.Minute;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Wagner Santos
 */
public class LoadCurve {

    public JFreeChart chart;
    public ChartPanel chartPanel;
    private ValueAxis xAxis;
    public ValueAxis yAxis;
    public TimeSeries series;
    public TimePeriodValues offPeakSerie = new TimePeriodValues("Fora de Ponta");
    public TimePeriodValues peakSerie = new TimePeriodValues("Ponta");
    public TimePeriodValues alternativeSerie = new TimePeriodValues("Energia");
    public int state = 0;
    public Mensuration maxMensuration = new Mensuration();
    public Mensuration minMensuration = new Mensuration();
    private boolean verticalTick = false;

    public ChartPanel createLoadCurveGraphPanel() {
        final XYDataset mensurationDataSet = createMensurationDataSet();
        XYBarRenderer x = new XYBarRenderer();
        XYBarRenderer.setDefaultShadowsVisible(false);
        x.setDrawBarOutline(true);
        x.setMargin(0.2);

        final XYItemRenderer mensurationRender = x;

        mensurationRender.setSeriesPaint(0, Color.GREEN);
        mensurationRender.setSeriesPaint(1, Color.RED);
        mensurationRender.setSeriesPaint(2, Color.BLUE);

        final DateAxis domainAxis = new DateAxis("Hora");
        domainAxis.setVerticalTickLabels(this.verticalTick);
        domainAxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR, 1));
        domainAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
        domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);

        final ValueAxis rangeAxis = new NumberAxis("Potência (kW)");

        final XYPlot plot = new XYPlot(mensurationDataSet, domainAxis, rangeAxis, mensurationRender);

        final XYDataset alertDataSet = createAlertDataSet();
        final StandardXYItemRenderer alertRender = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);
        //alertRender.setShapesFilled(true);

        plot.setDataset(1, alertDataSet);
        plot.setRenderer(1, alertRender);

        final XYDataset contractDataSet = createContractDataSet();
        final StandardXYItemRenderer contractRender = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);
        //contractRender.setShapesFilled(true);

        plot.setDataset(2, contractDataSet);
        plot.setRenderer(2, contractRender);

        final JFreeChart chartCurve = new JFreeChart("Curva de Carga", plot);
        chartPanel = new ChartPanel(chartCurve);
        chartPanel.setMouseZoomable(true, false);

        return this.chartPanel;
    }

    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return the dataset.
     */
    public XYDataset createMensurationDataSet() {
        offPeakSerie = new TimePeriodValues("Fora de Ponta");
        peakSerie = new TimePeriodValues("Ponta");
        alternativeSerie = new TimePeriodValues("Fontes Alternativas");

        final TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();

        dataset.addSeries(offPeakSerie);
        dataset.addSeries(peakSerie);
        dataset.addSeries(alternativeSerie);

        return dataset;
    }

    public XYDataset createAlertDataSet() {
        final TimePeriodValues s1 = new TimePeriodValues("Alerta");
        final Day today = new Day();

        final Minute m0 = new Minute(0, new Hour(0, today));
        final Minute m1 = new Minute(0, new Hour(0, today));
        final Minute m2 = new Minute(0, new Hour(48, today));
        s1.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), 1);
        s1.add(new SimpleTimePeriod(m1.getStart(), m2.getEnd()), 1);

        final TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();
        dataset.addSeries(s1);

        return dataset;
    }

    public XYDataset createContractDataSet() {
        final TimePeriodValues s1 = new TimePeriodValues("Contratado");
        final Day today = new Day();

        final Minute m0 = new Minute(0, new Hour(0, today));
        final Minute m1 = new Minute(0, new Hour(0, today));
        final Minute m2 = new Minute(0, new Hour(48, today));
        s1.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), 0.95);
        s1.add(new SimpleTimePeriod(m1.getStart(), m2.getEnd()), 0.95);

        final TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();
        dataset.addSeries(s1);

        return dataset;
    }
}
