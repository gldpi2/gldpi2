package _tests;

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
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * An example of....
 *
 */
public class HistogramTest extends ApplicationFrame {

    /**
     * A demonstration application showing how to....
     *
     * @param title the frame title.
     */
    public HistogramTest(final String title) {

        super(title);

        final XYDataset data1 = createDataset1();
        final XYItemRenderer renderer1 = new XYBarRenderer();

        final DateAxis domainAxis = new DateAxis("Date");
        domainAxis.setVerticalTickLabels(true);
        domainAxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR, 1));
        domainAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
        domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);
        final ValueAxis rangeAxis = new NumberAxis("Value");

        final XYPlot plot = new XYPlot(data1, domainAxis, rangeAxis, renderer1);

        final XYDataset data2 = createAlertDataSet();
        final StandardXYItemRenderer renderer2 = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);
        renderer2.setShapesFilled(true);

        plot.setDataset(1, data2);
        plot.setRenderer(1, renderer2);

        final XYDataset data3 = createContractDataSet();
        final StandardXYItemRenderer renderer3 = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);
        renderer3.setShapesFilled(true);

        plot.setDataset(2, data3);
        plot.setRenderer(2, renderer3);

        final JFreeChart chart = new JFreeChart("Supply and Demand", plot);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        setContentPane(chartPanel);
    }

    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return the dataset.
     */
    public XYDataset createDataset1() {

        final TimePeriodValues s1 = new TimePeriodValues("Supply");
        final TimePeriodValues s2 = new TimePeriodValues("Demand");
        final Day today = new Day();
        for (int i = 0; i < 12; i++) {
            final Minute m0 = new Minute(0, new Hour(i, today));
            final Minute m1 = new Minute(15, new Hour(i, today));
            final Minute m2 = new Minute(30, new Hour(i, today));
            final Minute m3 = new Minute(45, new Hour(i, today));
            final Minute m4 = new Minute(0, new Hour(i + 1, today));
            s1.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), Math.random());
            s1.add(new SimpleTimePeriod(m1.getStart(), m2.getStart()), Math.random());
            s1.add(new SimpleTimePeriod(m2.getStart(), m3.getStart()), Math.random());
            s1.add(new SimpleTimePeriod(m3.getStart(), m4.getStart()), Math.random());
        }

        for (int i = 12; i < 24; i++) {
            final Minute m0 = new Minute(0, new Hour(i, today));
            final Minute m1 = new Minute(15, new Hour(i, today));
            final Minute m2 = new Minute(30, new Hour(i, today));
            final Minute m3 = new Minute(45, new Hour(i, today));
            final Minute m4 = new Minute(0, new Hour(i + 1, today));
            s2.add(new SimpleTimePeriod(m0.getStart(), m1.getStart()), Math.random());
            s2.add(new SimpleTimePeriod(m1.getStart(), m2.getStart()), Math.random());
            s2.add(new SimpleTimePeriod(m2.getStart(), m3.getStart()), Math.random());
            s2.add(new SimpleTimePeriod(m3.getStart(), m4.getStart()), Math.random());
        }

        final TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);

        return dataset;
    }

    public XYDataset createAlertDataSet() {
        final TimePeriodValues s1 = new TimePeriodValues("WebCOINS");
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
        final TimePeriodValues s1 = new TimePeriodValues("WebCOINS");
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

    public static void main(final String[] args) {

        final HistogramTest demo = new HistogramTest("Time Period Values Demo 1");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
}
