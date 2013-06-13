/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;
import java.sql.*;

/**
 *
 * @author itallorossi
 */
public class LocalDAO {

    private Connection conex;

    public LocalDAO() throws SQLException{
        this.conex = Conectar.conectar();
    }

    public String[] comboLocal() throws SQLException{
        String sql = "select * from local";
        PreparedStatement stmt = conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        PreparedStatement stmt1 = conex.prepareStatement(sql);
        ResultSet rs1 = stmt1.executeQuery();
        
        int j=0;
        int tam=0;

        while(rs.next()){
            tam++;
        }

        String[] local = new String[tam];

        while(rs1.next()){
            local[j] = rs1.getString("nomelocal");
            j++;
        }

        return local;
    }
}
