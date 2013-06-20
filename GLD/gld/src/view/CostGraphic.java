package view;

import dao.CostDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;


public class CostGraphic extends JFrame {

    
    //Parameter param = new Parameter();
    private TimeSeries series;
    final Millisecond now = new Millisecond();
    final CostDAO dao = new CostDAO();

    /**
     * Constructs a new demonstration application.
     *
     * @param title  the frame title.
     */
    public CostGraphic(final String title) {

        super(title);
        this.series = new TimeSeries("Custo Energético em R$ por hora", Millisecond.class);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);
        
        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(content);
}
  public double getParameters(){
        double i = dao.getParameter();
    
        return i;
}
    
private JFreeChart createChart(final XYDataset dataset) {
       final JFreeChart costGraphic = ChartFactory.createXYLineChart("Custo","Dia/Hora","Valor em Real (R$)",dataset,PlotOrientation.VERTICAL,true,true,false);
       //final JFreeChart result = ChartFactory.createX
       //final JFreeChart result = ChartFactory.createXYStepAreaChart("Custo", "Dia", "Valor em Real (R$)", dataset, PlotOrientation.VERTICAL,true, true, false);
       final XYPlot plot = costGraphic.getXYPlot();
        ValueAxis xAxis = plot.getDomainAxis();

        xAxis.setTickMarkPaint(Color.black);
        xAxis.setRange(0, 100.0);

        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setRange(0, 100);
        
        /*
         * O parâmetro de limite deve ser o máximo de custo verificado
         * em um certo momento do tempo de medição, ou seja, se em um momento, 
         * o sistema aferiu que teve um custo de R$ 30000,00, o limite será esse.
         */
        
       xAxis.setAutoRange(true);
       xAxis.setFixedAutoRange(60000.0);  // 60 seconds
       yAxis.setRange(0.0, 200.0); 
       
       
       this.series.add(now,1);
        
         return costGraphic;
}
 /*
    public static void main(final String[] args) {
       final CostGraphic cost = new CostGraphic("Custo Energético");
          cost.pack();
        cost.setVisible(true);
        

    }
*/
    

}