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
    private String timeHour;
    private double peakContracted;
    private double OutPeakContracted;

    public void setTime(String timeHour) {
        this.timeHour = timeHour;
    }

    public String getTime() {
        return timeHour;
    }
    /**
     * Método que irá pegar as mediçõe através da DAO e aqui irá fazer o cálculo
     * do custo
     *
     * @return vetor de custo já calculados
     * @throws Exceção de SQL, pois se não houver conexão ou dados, irá falhar.
     */
    public List<Mensuration> allMeasurements() {
        List<Mensuration> mensurationList = new ArrayList<>();


        String sql = "SELECT * FROM mensuration";
        conectDB();

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

                setTime(mensuration.getTimestamp().substring(8, 10));
                mensurationList.add(mensuration);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconectDB();

        return mensurationList;
    }

    public Mensuration singleMensuration() {
        Mensuration mensuration = new Mensuration();
        conectDB();
        
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconectDB();
        return mensuration;
    }
    
     public List<Mensuration> getMensurationByDay(int day, int mounth, int year) {
        List<Mensuration> measurementList;
        measurementList = new ArrayList<>();

        String sql = "SELECT * FROM `mensuration` "
                + "WHERE timestamp >= \"" + year + "-" + mounth + "-" + day + " 00:00:00\""
                + " AND timestamp <= \"" + year + "-" + mounth + "-" + day + " 23:59:59\"";

        conectDB();
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

                measurementList.add(mensuration);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoadCurveDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        disconectDB();

        return measurementList;
    }
    
    
    public double getPeakDemandContracted(){
        Contract contract = new Contract();
        conectDB();
        
        int last = dbInterface.getLastId("contract");
        String sql = "SELECT * FROM contract WHERE id_contract=" +last;
        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while(rs.next()){
                contract.setPeakDemand(rs.getString("peak_demand"));
                peakContracted = Double.parseDouble(contract.getPeakDemand());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconectDB();
        return peakContracted;
    }
    
    public double getOutPeakContracted(){
        Contract contract = new Contract();
        conectDB();
        int last = dbInterface.getLastId("contract");
        String sql = "SELECT * FROM contract WHERE id_contract=" +last;
        
        ResultSet rs = dbInterface.executeQuery(sql);
        try {
            while(rs.next()){
               contract.setOffPeakDemand(rs.getString("off_peak_demand"));
               OutPeakContracted = Double.parseDouble(contract.getOffPeakDemand());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        disconectDB();
        return OutPeakContracted;
    }
    

    private void conectDB() {
        dbInterface.connect();
    }

    private void disconectDB() {
        dbInterface.disconnect();
    }
}
