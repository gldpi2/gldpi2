/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoadEstimationOnHistoryDAO;
import java.sql.SQLException;
import java.util.List;
import model.Mensuration;

/**
 *
 * @author Fernando
 */
public class CostEstimationOnHistoryCtrl {
    double minor;
    double greater;
    double better;
    private LoadEstimationOnHistoryDAO dao = new LoadEstimationOnHistoryDAO();
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

    private double pert(double greater, double minor, double better) {
        double index = ((greater + minor + (4 * better)) / 6);
        return index;
    }
    
    public double getPert(int interval){
        try {
            List<Mensuration> data;
            switch (interval) {
                case INTERVAL_LAST_60_MIM:
                    data = dao.getMensurationLast60Minutes();
                    break;
                //Estimativa conforme o último dia da semana passada (ex: terça passada)
                case INTERVAL_LAST_DAY:
                    data = dao.getMensurationADayLastWeek();
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
                    System.err.print("No correct interval passed for PERL function");
                    return 0;
            }

            Mensuration tempMensuration = data.get(0);
            minor = tempMensuration.getFlow();
            greater = tempMensuration.getFlow();
            double avarage = 0;
            for (Mensuration item : data) {
                if (item.getFlow() > greater) {
                    greater = item.getFlow();
                }
                if (item.getFlow() < minor) {
                    minor = item.getFlow();
                }
                avarage += item.getFlow();
            }
            return this.pert(greater, minor, avarage / data.size());
        } catch (SQLException e){
            System.err.print(e.getSQLState());
            return 0;
        }

    }
} 

