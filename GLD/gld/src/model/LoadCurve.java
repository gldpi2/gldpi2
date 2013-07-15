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
    public int state = 0;
    public Mensuration maxMensuration = new Mensuration();
    public Mensuration minMensuration = new Mensuration();

    public ChartPanel createLoadCurveGraphPanel() {
//        this.series = new TimeSeries("kWh", Millisecond.class);
//        TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
//
//        this.chart = ChartFactory.createTimeSeriesChart("Curva de Carga", "Hora", "Potência Ativa (kWh)", dataset, false, false, false);
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
//        this.xAxis.setRange(0, 86400000); // 24 horas = 86400000 mili
//        this.xAxis.setAutoRange(true);
//        this.xAxis.setFixedAutoRange(60000.0);
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

        final XYDataset mensurationDataSet = createMensurationDataSet();
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
        domainAxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR, 1));
        domainAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
        domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);
        final ValueAxis rangeAxis = new NumberAxis("Value");

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
        final TimePeriodValues offPeakSerie = new TimePeriodValues("Fora de Ponta");
        final TimePeriodValues peakSerie = new TimePeriodValues("Ponta");
        final TimePeriodValues alternativeSerie = new TimePeriodValues("Ponta");

        final Day today = new Day();
        for (int i = 0; i < 6; i++) {
            final Minute m0 = new Minute(0, new Hour(i, today));
            final Minute m1 = new Minute(15, new Hour(i, today));
            final Minute m2 = new Minute(30, new Hour(i, today));
            final Minute m3 = new Minute(45, new Hour(i, today));
            final Minute m4 = new Minute(0, new Hour(i + 1, today));
            offPeakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), Math.random());
            offPeakSerie.add(new SimpleTimePeriod(m1.getStart(), m2.getStart()), Math.random());
            offPeakSerie.add(new SimpleTimePeriod(m2.getStart(), m3.getStart()), Math.random());
            offPeakSerie.add(new SimpleTimePeriod(m3.getStart(), m4.getStart()), Math.random());
        }

        for (int i = 6; i < 12; i++) {
            final Minute m0 = new Minute(0, new Hour(i, today));
            final Minute m1 = new Minute(15, new Hour(i, today));
            final Minute m2 = new Minute(30, new Hour(i, today));
            final Minute m3 = new Minute(45, new Hour(i, today));
            final Minute m4 = new Minute(0, new Hour(i + 1, today));
            peakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), Math.random());
            peakSerie.add(new SimpleTimePeriod(m1.getStart(), m2.getStart()), Math.random());
            peakSerie.add(new SimpleTimePeriod(m2.getStart(), m3.getStart()), Math.random());
            peakSerie.add(new SimpleTimePeriod(m3.getStart(), m4.getStart()), Math.random());
        }

        for (int i = 12; i < 18; i++) {
            final Minute m0 = new Minute(0, new Hour(i, today));
            final Minute m1 = new Minute(15, new Hour(i, today));
            final Minute m2 = new Minute(30, new Hour(i, today));
            final Minute m3 = new Minute(45, new Hour(i, today));
            final Minute m4 = new Minute(0, new Hour(i + 1, today));
            offPeakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), Math.random());
            offPeakSerie.add(new SimpleTimePeriod(m1.getStart(), m2.getStart()), Math.random());
            offPeakSerie.add(new SimpleTimePeriod(m2.getStart(), m3.getStart()), Math.random());
            offPeakSerie.add(new SimpleTimePeriod(m3.getStart(), m4.getStart()), Math.random());
        }

        for (int i = 18; i < 24; i++) {
            final Minute m0 = new Minute(0, new Hour(i, today));
            final Minute m1 = new Minute(15, new Hour(i, today));
            final Minute m2 = new Minute(30, new Hour(i, today));
            final Minute m3 = new Minute(45, new Hour(i, today));
            final Minute m4 = new Minute(0, new Hour(i + 1, today));
            peakSerie.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), Math.random());
            peakSerie.add(new SimpleTimePeriod(m1.getStart(), m2.getStart()), Math.random());
            peakSerie.add(new SimpleTimePeriod(m2.getStart(), m3.getStart()), Math.random());
            peakSerie.add(new SimpleTimePeriod(m3.getStart(), m4.getStart()), Math.random());
        }

        final TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();

        dataset.addSeries(offPeakSerie);
        dataset.addSeries(peakSerie);

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
