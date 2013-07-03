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
 * @author Matheus
 */
public class CostCtrl {

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
}