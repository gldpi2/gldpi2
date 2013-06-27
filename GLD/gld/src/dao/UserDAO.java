/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.User;
import utils.DatabaseInterface;

/**
 *
 * @author artur
 */
public class UserDAO {

    private DatabaseInterface dbint = new DatabaseInterface();

    public UserDAO() {
    }

    public void createUser(User user) {
        
        
        String sql = "INSERT INTO user (name, register, password, email, "
                + "cell_oi, cell_vivo, cell_tim, cell_claro, profile) VALUES "
                + "(?,?,?,?,?,?,?,?,?)";
        
        String[] params = new String[9];
        params[0] = user.getName();
        params[1] = user.getRegister();
        params[2] = user.getPassword();
        params[3] = user.getEmail();
        params[4] = user.getCell_oi();
        params[5] = user.getCell_vivo();
        params[6] = user.getCell_tim();
        params[7] = user.getCell_claro();
        params[8] = user.getProfile().toString(); 

        dbint.connect();

        dbint.insert(sql, params);
        
        dbint.disconnect();

    }

    public List<User> readUsers(){
        return null;
    }

    public void updateUser(User user){
    }

    public void deleteUser(User user){
    }
}
