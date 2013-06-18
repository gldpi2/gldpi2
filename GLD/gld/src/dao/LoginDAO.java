/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DatabaseInterface;

/**
 *
 * @author itallorossi
 */
public class LoginDAO {
    private Connection conex;
    DatabaseInterface dbInterface = new DatabaseInterface();
    
    public int verificarLogin(Login user) throws SQLException{
        int i=0;
        
        String sql = "SELECT * FROM user WHERE matricula = '"+user.getMatricula()+"' AND senha = '"+user.getSenha()+"'";
        
        dbInterface.connect();
        
        ResultSet rs = dbInterface.executeQuery(sql);

        while(rs.next()){
            i++;
            user.setTipo(rs.getString("tipo"));
        }

        dbInterface.disconnect();
        return i;
    }
}
