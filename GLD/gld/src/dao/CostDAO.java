package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contract;
import model.Mensuration;
import utils.DatabaseInterface;

/**
 *
 * @author Matheus
 */
public class CostDAO {

    private DatabaseInterface dbInterface = new DatabaseInterface();
    private String Hour;
    private double peakContracted;
    private double OffPeakContracted;

    public void setHour(String hour) {
        this.Hour = hour;
    }

    public String getHour() {
        return Hour;
    }

    /**
     * Método que irá pegar as mediçõe através da DAO e aqui irá fazer o cálculo
     * do custo
     *
     * @return vetor de custo já calculados
     */
    public List<Mensuration> allMeasurements() {
        List<Mensuration> mensurationList = new ArrayList<>();


        String sql = "SELECT * FROM mensuration";
        connectDB();

        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                Mensuration mensuration;
                mensuration = new Mensuration();
                mensuration.setIdMensuration(rs.getInt("id_mensuration"));
                mensuration.setFlow(rs.getDouble("flow"));
                mensuration.setTension(rs.getDouble("tension"));
                mensuration.setTimestamp(rs.getString("timestamp"));
                mensuration.setEnergyAvailable(rs.getInt("energy_available"));
                setHour(mensuration.getTimestamp().substring(8, 10));
                mensurationList.add(mensuration);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectDB();

        return mensurationList;
    }

    public Mensuration singleMensuration() {
        Mensuration mensuration = new Mensuration();
        connectDB();

        int last = dbInterface.getLastId("mensuration");
        String sql = "SELECT * FROM mensuration WHERE id_mensuration =" + last;
        ResultSet rs = dbInterface.executeQuery(sql);

        try {
            if (rs.next()) {
                mensuration.setIdMensuration(rs.getInt("id_mensuration"));
                mensuration.setFlow(rs.getDouble("flow"));
                mensuration.setTension(rs.getDouble("tension"));
                mensuration.setTimestamp(rs.getString("timestamp"));
                mensuration.setEnergyAvailable(rs.getInt("energy_available"));
                //setHour(mensuration.getTimestamp().substring(8, 10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnectDB();
        return mensuration;
    }

    public List<Mensuration> getMensurationByDay(int day, int mounth, int year) {
        List<Mensuration> measurementList;
        measurementList = new ArrayList<>();

        String sql = "SELECT * FROM `mensuration` "
                + "WHERE timestamp >= \"" + year + "-" + mounth + "-" + day + " 00:00:00\""
                + " AND timestamp <= \"" + year + "-" + mounth + "-" + day + " 23:59:59\"";

        connectDB();
        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                Mensuration mensuration;
                mensuration = new Mensuration();
                mensuration.setIdMensuration(rs.getInt("id_mensuration"));
                mensuration.setFlow(rs.getDouble("flow"));
                mensuration.setTension(rs.getDouble("tension"));
                mensuration.setTimestamp(rs.getString("timestamp"));
                mensuration.setEnergyAvailable(rs.getInt("energy_available"));
                setHour(mensuration.getTimestamp().substring(8, 10));
                measurementList.add(mensuration);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadCurveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconnectDB();

        return measurementList;
    }

    public double getPeakDemandContracted() {
        Contract contract = new Contract();
        connectDB();

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
        disconnectDB();
        return peakContracted;
    }

    public double getOutPeakContracted() {
        Contract contract = new Contract();
        connectDB();
        int last = dbInterface.getLastId("contract");
        String sql = "SELECT * FROM contract WHERE id_contract=" + last;

        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while (rs.next()) {
                contract.setOffPeakDemand(rs.getString("off_peak_demand"));
                OffPeakContracted = Double.parseDouble(contract.getOffPeakDemand());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconnectDB();
        return OffPeakContracted;
    }

    private void connectDB() {
        dbInterface.connect();
    }

    private void disconnectDB() {
        dbInterface.disconnect();
    }
}
