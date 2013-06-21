/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cost;
import model.Mensuration;
import utils.DatabaseInterface;

/**
 *
 * @author Matheus
 */
public class CostDAO {

    private Connection conex;
    DatabaseInterface dbInterface = new DatabaseInterface();
    Mensuration mensuration = new Mensuration();
    Cost cost = new Cost();
     

    public ArrayList<Mensuration> getParameter() throws SQLException{
        ArrayList<Mensuration> mensurationList = new ArrayList<>();
                
        
        String sql = "SELECT * FROM mensuration";
        
        dbInterface.connect();

        ResultSet rsMensuration = dbInterface.executeQuery(sql);
        try{
            while(rsMensuration.next()){
                mensuration.setIdMensuration(rsMensuration.getInt(1));
                mensuration.setFlow(rsMensuration.getDouble(2));
                mensuration.setTension(rsMensuration.getDouble(3));
                mensuration.setTimestamp(rsMensuration.getString(4));
                cost.energyValue(mensuration.getFlow(), mensuration.getTension());
                mensurationList.add(mensuration);
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }          
       

        dbInterface.disconnect();

        return mensurationList;
    }
    /*
     * Método para pegar uma medição, não necessariamente a última
     */
    public Mensuration getMensuration() throws SQLException{
        
        dbInterface.connect();
        int lastId = dbInterface.getLastId("mensuration");
        String sql = "SELECT * FROM mensuration WHERE id_mensuration="+lastId;
        
        ResultSet rsMensuration = dbInterface.executeQuery(sql);
        try{
            if(lastId!=0){
                mensuration.setIdMensuration(rsMensuration.getInt(1));
                mensuration.setFlow(rsMensuration.getDouble(2));
                mensuration.setTension(rsMensuration.getDouble(3));
                mensuration.setTimestamp(rsMensuration.getString(4));
                cost.energyValue(mensuration.getFlow(), mensuration.getTension());
            }
            
        } catch (Exception e){      
            e.printStackTrace();
        }
        return mensuration;
    }
}
