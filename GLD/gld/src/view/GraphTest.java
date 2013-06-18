package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

public class GraphTest extends JFrame {

    XYSeries series = new XYSeries("Carga kW");
    private static final long serialVersionUID = 1L;
    int count = 0;

    public GraphTest(String applicationTitle, String chartTitle) {
        super(applicationTitle);

        JFreeChart chart = createChart();

        ChartPanel chartPanel = new ChartPanel(chart);

        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

        setContentPane(chartPanel);
    }

    private JFreeChart createChart() {
        series = new XYSeries("XYGraph");

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYAreaChart("Curva de Carga", "Hora", "Potência Ativa", dataset, PlotOrientation.VERTICAL, true, true, false);

        XYPlot xyplot = (XYPlot) chart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setForegroundAlpha(0.65F);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);

        ValueAxis xAxis = xyplot.getDomainAxis();

        xAxis.setTickMarkPaint(Color.black);
        xAxis.setRange(0, 100);

        ValueAxis yAxis = xyplot.getRangeAxis();
        yAxis.setRange(0, 100);

        XYPointerAnnotation xypointerannotation = new XYPointerAnnotation("Test", 5D, -500D, 2.3561944901923448D);
        xypointerannotation.setTipRadius(0.0D);
        xypointerannotation.setBaseRadius(35D);
        xypointerannotation.setFont(new Font("SansSerif", 0, 9));
        xypointerannotation.setPaint(Color.blue);
        xypointerannotation.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
        xyplot.addAnnotation(xypointerannotation);

        return chart;
    }

    public static void main(String[] args) {
        GraphTest graph = new GraphTest("Comparison", "Curva de Carga");
        graph.pack();

        Thread th = new Thread(graph.new UpdaterThread());
        th.setDaemon(true);
        th.start();

        graph.setVisible(true);

    }

    private class UpdaterThread implements Runnable {

        private double SIZE = 100;

        @Override
        public void run() {

            int i = 1;
            while (true) {
                i++;

                final int j = (int) (Math.random() * SIZE);

                if (i % 2 == 0) {
                    series.addOrUpdate(i, j);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
