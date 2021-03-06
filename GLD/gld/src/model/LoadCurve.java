package model;

import dao.CostDAO;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import utils.DatabaseInterface;

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
    public XYDataset mensurationDataSet;
    private boolean verticalTick = false;
    private DateAxis domainAxis;

    public ChartPanel createLoadCurveGraphPanel() {
        mensurationDataSet = createMensurationDataSet();
        XYBarRenderer x = new XYBarRenderer();
        XYBarRenderer.setDefaultShadowsVisible(false);
        x.setDrawBarOutline(true);
        x.setMargin(0.2);

        final XYItemRenderer mensurationRender = x;

        mensurationRender.setSeriesPaint(0, Color.GREEN);
        mensurationRender.setSeriesPaint(1, Color.RED);
        mensurationRender.setSeriesPaint(2, Color.BLUE);

        domainAxis = new DateAxis("Hora");
        domainAxis.setVerticalTickLabels(true);
        domainAxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR, 1));
        domainAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
        domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);

        final ValueAxis rangeAxis = new NumberAxis("Potência (kW)");

        final XYPlot plot = new XYPlot(mensurationDataSet, domainAxis, rangeAxis, mensurationRender);

        final XYDataset alertDataSet = createAlertDataSet();
        final StandardXYItemRenderer alertRender = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);

        plot.setDataset(1, alertDataSet);
        plot.setRenderer(1, alertRender);

        final XYDataset contractDataSet = createContractDataSet();
        final StandardXYItemRenderer contractRender = new StandardXYItemRenderer(StandardXYItemRenderer.SHAPES_AND_LINES);

        plot.setDataset(2, contractDataSet);
        plot.setRenderer(2, contractRender);

        final JFreeChart chartCurve = new JFreeChart("Perfil do Consumidor", plot);
        chartPanel = new ChartPanel(chartCurve);
        chartPanel.setMouseZoomable(false, false);

        return this.chartPanel;
    }

    public ChartPanel createMontlyLoadCurvePanel() {
        mensurationDataSet = createMensurationDataSet();
        XYBarRenderer x = new XYBarRenderer();
        XYBarRenderer.setDefaultShadowsVisible(false);
        x.setDrawBarOutline(true);
        x.setMargin(0.2);

        final XYItemRenderer mensurationRender = x;

        mensurationRender.setSeriesPaint(0, Color.GREEN);
        mensurationRender.setSeriesPaint(1, Color.RED);
        mensurationRender.setSeriesPaint(2, Color.BLUE);

        domainAxis = new DateAxis("Dias");
        domainAxis.setVerticalTickLabels(true);
        domainAxis.setTickUnit(new DateTickUnit(DateTickUnit.DAY, 1));
        domainAxis.setDateFormatOverride(new SimpleDateFormat("dd"));
        domainAxis.setRange(new Date("07/01/2013"), new Date("07/31/2013"));

        domainAxis.setLowerMargin(0.01);
        domainAxis.setUpperMargin(0.01);

        final ValueAxis rangeAxis = new NumberAxis("Potência (kW)");

        final XYPlot plot = new XYPlot(mensurationDataSet, domainAxis, rangeAxis, mensurationRender);

        final JFreeChart chartCurve = new JFreeChart("Perfil do Consumidor", plot);
        chartPanel = new ChartPanel(chartCurve);
        chartPanel.setMouseZoomable(false, false);

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
        final Minute m1 = new Minute(0, new Hour(18, today));
        final Minute m2 = new Minute(0, new Hour(21, today));
        final Minute m3 = new Minute(0, new Hour(24, today));
        s1.add(new SimpleTimePeriod(m0.getStart(), m0.getEnd()), getOutPeakContracted());
        s1.add(new SimpleTimePeriod(m1.getStart(), m1.getEnd()), getOutPeakContracted());
        s1.add(new SimpleTimePeriod(m1.getStart(), m1.getEnd()), getPeakDemandContracted());
        s1.add(new SimpleTimePeriod(m2.getStart(), m2.getEnd()), getPeakDemandContracted());
        s1.add(new SimpleTimePeriod(m2.getStart(), m2.getEnd()), getOutPeakContracted());
        s1.add(new SimpleTimePeriod(m3.getStart(), m3.getEnd()), getOutPeakContracted());

        final TimePeriodValuesCollection dataset = new TimePeriodValuesCollection();
        dataset.addSeries(s1);

        return dataset;
    }

    public double getPeakDemandContracted() {
        DatabaseInterface dbInterface = new DatabaseInterface();
        Contract contract = new Contract();
        dbInterface.connect();

        double peakContracted = 0;

        int last = dbInterface.getLastId("contract");
        String sql = "SELECT * FROM contract WHERE id_contract=" + last;
        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                contract.setPeakDemand(rs.getString("peak_demand"));
                peakContracted = Double.parseDouble(contract.getPeakDemand());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbInterface.disconnect();
        return peakContracted;
    }

    public double getOutPeakContracted() {
        DatabaseInterface dbInterface = new DatabaseInterface();
        Contract contract = new Contract();
        dbInterface.connect();
        int last = dbInterface.getLastId("contract");
        String sql = "SELECT * FROM contract WHERE id_contract=" + last;

        double offPeakContracted = 0;

        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                contract.setOffPeakDemand(rs.getString("off_peak_demand"));
                offPeakContracted = Double.parseDouble(contract.getOffPeakDemand());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbInterface.disconnect();
        return offPeakContracted;
    }
}
