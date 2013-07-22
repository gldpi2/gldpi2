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

    public List<ConsumptionMonth> getAllConsumptions() {
        return consumptionMonthDAO.getAllConsumptionMonth();
    }

    public String printConsumptions() {
        return consumptionMonth.toString();
    }
}
