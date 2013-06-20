/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cost;
import utils.DatabaseInterface;

/**
 *
 * @author Matheus
 */
public class CostDAO {

    private Connection conex;
    DatabaseInterface dbInterface = new DatabaseInterface();
    double tension;
    double flow;
    double parameters;
    Cost cost = new Cost();
    /*
     * Fonte retirada do site da aneel
     * Disponível em: http://www.aneel.gov.br/area.cfm?idarea=493
     * Acessado em 19/06 as 13:00
     */
    double cebValue = 0.24253;

    public double getParameter() {
        String sqlFlow = "SELECT flow, id_meter FROM mensuration INNER JOIN meter ON id_meter mensuration.id_meter = meter.id_meter";
        String sqlTension = "SELECT tension, id_meter flow FROM mensuration INNER JOIN meterid_meter ON mensuration.id_meter = meter.id_meter ";

        dbInterface.connect();

        ResultSet rsFlow = dbInterface.executeQuery(sqlFlow);
        ResultSet rsTension = dbInterface.executeQuery(sqlTension);

        flow = Double.parseDouble(sqlFlow);
        cost.setFlow(flow);
        tension = Double.parseDouble(sqlTension);
        cost.setTension(tension);
        parameters = cost.getFlow() * cost.getTension() * cebValue;

        dbInterface.disconnect();

        return parameters;
    }
}
