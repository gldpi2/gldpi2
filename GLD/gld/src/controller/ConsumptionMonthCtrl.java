package controller;

import dao.ConsumptionMonthDAO;
import java.util.List;
import model.ConsumptionMonth;

/**
 *
 * @author itallorossi
 */
public class ConsumptionMonthCtrl {

    private ConsumptionMonth consumptionMonth;
    private ConsumptionMonthDAO consumptionMonthDAO;

    public ConsumptionMonthCtrl() {
        this.consumptionMonth = new ConsumptionMonth();
        this.consumptionMonthDAO = new ConsumptionMonthDAO();
    }

    public List<ConsumptionMonth> getAllConsumptions(int year) {
        return consumptionMonthDAO.getAllConsumptionMonth(year);
    }

    public List<Integer> getYears() {
        return consumptionMonthDAO.getAllYears();
    }

    public String printConsumptions() {
        return consumptionMonth.toString();
    }
}
