/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoadEstimationOnHistoryDAO;
import java.sql.SQLException;
import java.util.List;
import model.LoadEstimationOnHistory;
import model.Mensuration;
import org.jfree.chart.ChartPanel;
import org.jfree.data.time.TimeSeries;

/**
 *
 * @author Matheus
 */
public class LoadEstimationOnHistoryCtrl {

    private LoadEstimationOnHistory loadEstimationOnHistory;
    private LoadEstimationOnHistoryDAO dao;
    //TODO, NOT IMPLEMENTED YET
    public static final int INTERVAL_HOUR = 1;
    public static final int INTERVAL_LAST_60_MIM = 1;
    //TODO, NOT IMPLEMENTED YET
    public static final int INTERVAL_DAY = 2;
    public static final int INTERVAL_LAST_DAY = 3;
    public static final int INTERVAL_LAST_24_HOURS = 4;
    //TODO, NOT IMPLEMENTED YET
    public static final int INTERVAL_WEEK = 5;
    public static final int INTERVAL_LAST_168_HOURS = 6;
    //TODO, NOT IMPLEMENTED YET
    public static final int INTERVAL_MONTH = 7;
    public static final int INTERVAL_LAST_672_HOURS = 8;
    double minor;
    double greater;
    double better;

    /**
     * Interface com a camada de apresentacao
     */
    public LoadEstimationOnHistoryCtrl() {
        this.loadEstimationOnHistory = new LoadEstimationOnHistory();
        this.dao = new LoadEstimationOnHistoryDAO();

    }

    public ChartPanel createLoadEstimationOnHistoryGraphPanel(int interval) {
        List<Mensuration> data;
        double[] ret = {0};
        try {
            switch (interval) {
                case INTERVAL_LAST_60_MIM:
                    data = dao.getMensurationLast60Minutes();
                    break;
                case INTERVAL_LAST_DAY:
                    //Estimativa conforme o último dia da semana passada (ex: terça passada)
                    data = dao.getMensurationADayLastWeek();
                    ret = this.getPertByHour(data);
                    break;
                case INTERVAL_LAST_24_HOURS:
                    data = dao.getMensurationLast24Hours();
                    break;
                case INTERVAL_LAST_168_HOURS:
                    data = dao.getMensurationLast168Hours();
                    break;
                case INTERVAL_LAST_672_HOURS:
                    data = dao.getMensurationLast672Hours();
                    break;
                default:
                    System.err.print("No correct interval passed for PERT function");
                    break;
            }
        } catch (Exception ex) {
            
        }
        return loadEstimationOnHistory.createLoadEstimationOnHistoryGraphPanel(ret);
    }

    public void setState(int state) {
        this.loadEstimationOnHistory.state = state;
    }

    public void setSize(int x, int y) {
        this.loadEstimationOnHistory.chartPanel.setSize(x, y);
    }

    public TimeSeries getSeries() {
        return this.loadEstimationOnHistory.series;
    }

    public int getState() {
        return this.loadEstimationOnHistory.state;
    }

    /**
     * Área para controle lógico.
     */
    private double pert(double greater, double minor, double better) {
        double index = ((greater + minor + (4 * better)) / 6);
        return index;
    }

    public double[] getPert(int interval) {
        double[] ret = {0};
        return ret;
    }

    private double[] getPertByHour(List<Mensuration> data) {

        double[] ret = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int regPerHour = data.size() / 24;

        //O numero de horas 
        for (int i = 0; i < 24; i++) {

            Mensuration tempMensuration = data.get(i * regPerHour);
            minor = tempMensuration.getFlow();
            greater = tempMensuration.getFlow();
            double average = 0;

            //O numero de registros dentro das horas
            for (int j = 0, index = i * regPerHour; j < regPerHour; j++, index++) {

                if (data.get(index).getFlow() > greater) {
                    greater = data.get(index).getFlow();
                }
                if (data.get(index).getFlow() < minor) {
                    minor = data.get(index).getFlow();
                }
                average += data.get(index).getFlow();

                //for (Mensuration item : data) {
                //}              

            }
            average /= regPerHour;
            ret[i] = this.pert(greater, minor, average);
        }

        return ret;

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