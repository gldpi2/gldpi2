package view;

import dao.CostDAO;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;



public class CostGraphic extends JFrame {

    
    public TimeSeries series;

    private CostGraphic(String title) {
       super(title);
        series = new TimeSeries("R$/kWh", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(series);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);
        

        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
       chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(content);
        
        
  }
   
   
    private JFreeChart createChart(XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart("Gráfico de Custo","Hora", "Valor em Real (R$)",dataset,true,true,false);
        final XYPlot plot = result.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(60000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 200.0); 
        return result;
}
 
    public static void main(final String[] args) {
        CostGraphic graphic = new CostGraphic("Gráfico de Custo");
        graphic.pack();
        RefineryUtilities.centerFrameOnScreen(graphic);
        
        Thread th = new Thread(graphic.new UpdaterThread());
        th.setDaemon(true);
        th.start();       
        graphic.setVisible(true);
   }
    
    class UpdaterThread implements Runnable {

        private double SIZE = 100;

        @Override
        public void run() {

            int i = 1;
            while (true) {
                i++;

                final int j = (int) (Math.random() * SIZE);

                if (i % 2 == 0) {
                    series.add(new Millisecond(), j);
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    
}
    