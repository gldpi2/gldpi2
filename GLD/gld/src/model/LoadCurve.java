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
 * @author Wagner Santos
 */
public class LoadCurve {

    public JFreeChart chart;
    public ChartPanel chartPanel;
    public ValueAxis xAxis;
    public ValueAxis yAxis;
    public TimeSeries series;
    public int state = 0;
    
    public Mensuration maxMensuration = new Mensuration();

    public ChartPanel createLoadCurveGraphPanel() {
        this.series = new TimeSeries("kWh", Millisecond.class);
        TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);

        this.chart = ChartFactory.createTimeSeriesChart("Curva de Carga", "Hora", "Potência Ativa (kWh)", dataset, true, true, false);

        XYPlot xyplot = (XYPlot) this.chart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setForegroundAlpha(0.65F);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);

        this.xAxis = xyplot.getDomainAxis();

        this.xAxis.setTickMarkPaint(Color.black);
        this.xAxis.setRange(0, 86400000); // 24 horas = 86400000 mili
        this.xAxis.setAutoRange(true);
        this.xAxis.setFixedAutoRange(60000.0);

        this.yAxis = xyplot.getRangeAxis();
        this.yAxis.setRange(0, 6);
        this.yAxis.setAutoRange(true);

        XYPointerAnnotation xypointerannotation = new XYPointerAnnotation("Test", 5D, -500D, 2.3561944901923448D);
        xypointerannotation.setTipRadius(0.0D);
        xypointerannotation.setBaseRadius(35D);
        xypointerannotation.setFont(new Font("SansSerif", 0, 9));
        xypointerannotation.setPaint(Color.blue);
        xypointerannotation.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
        xyplot.addAnnotation(xypointerannotation);

        this.chartPanel = new ChartPanel(this.chart, true);

        return this.chartPanel;
    }
}
