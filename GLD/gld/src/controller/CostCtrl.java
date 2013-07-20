package controller;

import dao.CostDAO;
import java.util.List;
import model.Cost;
import model.Mensuration;
import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author Matheus
 */
public class CostCtrl {

    private final static double PEAK = 0.3260544 / 3600000;
    private final static double VALUE_OFFPEAK = 0.2079277 / 3600000;
    private final static double DEMANDPEAK = 19.65;
    private final static double DEMANDOFFPEAK = 5.22;
    private CostDAO cDao = new CostDAO();
    private Mensuration mensuration = new Mensuration();
    private List<Mensuration> listMensuration;
    private Cost cost = new Cost();
    private double hour;
    private double initial;
    private double countValue = initialCount();

    public List<Mensuration> allMensuration() {
        listMensuration = cDao.allMeasurements();

        return listMensuration;
    }

    public Mensuration lastMensuration() {
        mensuration = cDao.singleMensuration();

        return mensuration;
    }

    public double initialCount() {
        cost.setOutPeak(cDao.getOutPeakContracted());
        cost.setPeak(cDao.getOutPeakContracted());

        initial = cost.getOutPeak() * DEMANDOFFPEAK + cost.getPeak() * DEMANDPEAK;

        return initial;
    }

    public double countValue(double actual) {
        countValue += actual;

        return countValue;
    }

    /**
     * Método para cálculo da hora/kWh
     *
     * @param tension tensão no momento atual
     * @param flow corrente no momento atual
     * @return custo atual.
     */
    public double energyValue() {

        /**
         * Método que verifica a hora do banco de dados e coloca o valor do kWh
         * de acordo com o documento da CEB (Companhia Energética de Brasília)
         * Hora de ponta é entre 18 e 21 e o restante tem valor menor
         */
        hour = Double.parseDouble(cDao.getTime());
        if (hour >= 18 && hour < 21) {
            cost.setKwValue(PEAK);
        } else {
            cost.setKwValue(VALUE_OFFPEAK);
        }
        double costValue = cost.getKwValue();


        return costValue;
    }

    public void setMensuration(Mensuration mensuration) {
        cost.mensuration = mensuration;
    }

    public Mensuration getMensuration() {
        return cost.mensuration;
    }

    public ChartPanel createCostChart() {
        return cost.createCostChart();
    }

    public TimeSeries getAllSeries() {
        return cost.series;
    }

    public TimeSeries limitSeries() {
        return cost.seriesLimit;
    }

    public double kWValue() {
        return cost.getKwValue() * 3600000;
    }
}