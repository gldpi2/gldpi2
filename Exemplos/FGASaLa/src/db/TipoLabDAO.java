/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.*;
import classes.*;

public class TipoLabDAO {
    
    private Connection conex;

    public TipoLabDAO() throws SQLException{
        this.conex = Conectar.conectar();
    }

    public String[] comboTipo() throws SQLException{
        String sql = "select * from tipo_lab";
        PreparedStatement stmt = conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        PreparedStatement stmt1 = conex.prepareStatement(sql);
        ResultSet rs1 = stmt1.executeQuery();

        int j=0;
        int tam=0;
        
        while(rs.next()){
            tam++;
        }

        String[] tipo = new String[tam];

        while(rs1.next()){
            tipo[j] = rs1.getString("nometipo");
            j++;
        }

        return tipo;
    }
}
