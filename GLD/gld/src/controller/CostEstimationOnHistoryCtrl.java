/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CostEstimationOnHistoryDAO;
import exceptions.NotEnoughDataException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CostEstimationOnHistory;
import model.Mensuration;
import org.jfree.chart.ChartPanel;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import view.CostEstimationOnHistoryFailInfo;
/**
 *
 * @author Matheus
 */
public class CostEstimationOnHistoryCtrl {

    private CostEstimationOnHistory costEstimationOnHistory;
    private CostEstimationOnHistoryDAO dao;
    private CostCtrl costControl;
    public TimeSeries series;
    public TimeSeries seriesLimit = new TimeSeries("Limite", Millisecond.class);
    //TODO, NOT IMPLEMENTED YET
    public static final int INTERVAL_HOUR = 1;
    public static final int INTERVAL_LAST_60_MIM = 1;
    //TODO, NOT IMPLEMENTED YET
    public static final int INTERVAL_DAY = 2;
    public static final int INTERVAL_LAST_DAY = 24;
    public static final int INTERVAL_LAST_24_HOURS = 4;
    //TODO, NOT IMPLEMENTED YET
    public static final int INTERVAL_WEEK = 5;
    public static final int INTERVAL_LAST_168_HOURS = 6;
    //TODO, NOT IMPLEMENTED YET
    public static final int INTERVAL_MONTH = 30;
    public static final int INTERVAL_LAST_672_HOURS = 8;
    double minor;
    double greater;
    double better;

    /**
     * Interface com a camada de apresentacao
     */
    public CostEstimationOnHistoryCtrl() {
        this.costEstimationOnHistory = new CostEstimationOnHistory();
        this.dao = new CostEstimationOnHistoryDAO();
        this.costControl = new CostCtrl();
    }

    public ChartPanel createCostEstimationOnHistoryGraphPanel(int interval, int offset) {
        List<Mensuration> data;
        Vector<Double> ret_fail ;
        Vector<Double> ret = new Vector<>();
        try {
            switch (interval) {
                case INTERVAL_LAST_60_MIM:
                    data = dao.getMensurationLast60Minutes();
                    break;
                case INTERVAL_LAST_DAY:
                    //Estimativa conforme o último dia da semana passada (ex: terça passada)
                    data = dao.getMensurationADayLastWeek(offset);
                    ret = this.getPertByHour(data);
                    break;
                case INTERVAL_LAST_24_HOURS:
                    data = dao.getMensurationLast24Hours();
                    break;
                case INTERVAL_LAST_168_HOURS:
                    data = dao.getMensurationLast168Hours();
                    break;
                case INTERVAL_MONTH:
                    data = dao.getMensurationLast30Days(offset);
                    ret = this.getPertByDays(data,30);
                    break;
                default:
                    System.err.print("No correct interval passed for PERT function");
                    break;
            }
        } catch (NotEnoughDataException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Não existe dados necessários para apresentar a estimativa "
                    + "no período selecionado", "Erro", JOptionPane.WARNING_MESSAGE);
            ret_fail = new Vector<>();
            for(int i = 0 ; i < 24; i++){
                ret_fail.add(0.0);
            }
            return costEstimationOnHistory.createLoadEstimationOnHistoryGraphPanel(ret_fail, 24);
        } catch (Exception ex) {
            Logger.getLogger(CostEstimationOnHistoryCtrl.class.getName()).log(Level.SEVERE, "Erro no banco de dados.", ex);
        }
        return costEstimationOnHistory.createLoadEstimationOnHistoryGraphPanel(ret, interval);
    }

    public void setState(int state) {
        this.costEstimationOnHistory.state = state;
    }

    public void setSize(int x, int y) {
        this.costEstimationOnHistory.chartPanel.setSize(x, y);
    }

    public int getState() {
        return this.costEstimationOnHistory.state;
    }
    
    public TimeSeries getAllSeries() {
        return costEstimationOnHistory.series;
    }

    public TimeSeries limitSeries() {
        return costEstimationOnHistory.seriesLimit;
    }

    /**
     * Área para controle lógico.
     */
    public double pert(double greater, double minor, double better) {
        double index = ((greater + minor + (4 * better)) / 6);
        return index;
    }

    public double[] getPert(int interval) {
        double[] ret = {0};
        return ret;
    }

    private Vector<Double> getPertByHour(List<Mensuration> data) throws NotEnoughDataException {
        
        if(data.size() < 24){
            throw new NotEnoughDataException();
        }
         
        Vector<Double> ret = new Vector<>();
        int regPerHour = data.size() / 24;
        //Para cada hora
        for (int i = 0; i < 24; i++) {
            Mensuration tempMensuration = data.get(i * regPerHour);
            minor = tempMensuration.getFlow();
            greater = tempMensuration.getFlow();
            double average = 0;
            //1 hora
            for (int j = 0, index = i * regPerHour; j < regPerHour; j++, index++) {
                if (data.get(index).getFlow() > greater) {
                    greater = data.get(index).getFlow();
                }
                if (data.get(index).getFlow() < minor) {
                    minor = data.get(index).getFlow();
                }
                average += data.get(index).getFlow();
            }
            average /= regPerHour;
            ret.add(this.pert(greater, minor, average) * 60 * costControl.metodoNovo(tempMensuration.getHour()) * 1000 );
        }
        return ret;
    }

    private Vector<Double> getPertByDays(List<Mensuration> data, int days) throws NotEnoughDataException {

        List<Mensuration> tempDay;
        Vector<Double> tempDayPERT;
        
        if(data.size() < days){
            throw new NotEnoughDataException();
        }
        
        Vector<Double> ret = new Vector<>();
        int regPerDays = data.size() / days;

        //Para cada dia
        for (int i = 0; i < days; i++) {
            //1 dia 
            tempDay = data.subList(i*regPerDays, (i*regPerDays)+regPerDays );
            tempDayPERT = getPertByHour(tempDay);
            
            Mensuration tempMensuration = data.get(i * regPerDays);
            minor = tempMensuration.getFlow();
            greater = tempMensuration.getFlow();
            double average = 0;
            
            for (int j = 0 ; j < tempDayPERT.size(); j++) {
                double flowTemp = tempDayPERT.get(j);
                if ( flowTemp > greater) {
                    greater = flowTemp;
                }
                if ( flowTemp < minor) {
                    minor = flowTemp;
                }
                average += flowTemp;
            }
            
            average /= regPerDays;
            ret.add(this.pert(greater, minor, average) * 24);
        }
        return ret;
    }

    public double getFinalCost() {
        return costEstimationOnHistory.getFinalCost();
    }

}

/**
    public static void main(String args[])  {

        LoadEstimationOnHistoryCtrl dao = new LoadEstimationOnHistoryCtrl();
        double[] tempMensuration;

        tempMensuration = dao.getPert(LoadEstimationOnHistoryCtrl.INTERVAL_LAST_DAY);
        double avarage = 0;
        for (double item : tempMensuration) {
            System.out.println("Pert: " + item);
        }


    }
    */
