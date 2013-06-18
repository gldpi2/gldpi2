package view;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraphTest extends JFrame {

    XYSeries series = new XYSeries("XYGraph");
    private static final long serialVersionUID = 1L;

    public GraphTest(String applicationTitle, String chartTitle) {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart chart = createChart();
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);

    }

    private JFreeChart createChart() {
        series = new XYSeries("XYGraph");


        // Add the series to your data set
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYAreaChart("graph", "Potência Ativa", "Hora", dataset, PlotOrientation.VERTICAL, true, true, false);

        return chart;

    }

    public static void main(String[] args) {
        GraphTest graph = new GraphTest("Comparison", "Which operating system are you using?");
        graph.pack();

        Thread th = graph.new UpdaterThread();
        th.setDaemon(true);
        th.start();
        
        graph.setVisible(true);
    }

    private class UpdaterThread extends Thread {
        private double SIZE = 100;

        @Override
        public void run() {
            setPriority(MIN_PRIORITY); 

            int i = 1;
            while (true) {
                i++;
                final int j = (int) (Math.random() * SIZE);

                series.addOrUpdate(i, j);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    
                }
            }
        }
    }
}
