/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
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
    public UserDAO(){
    }
    
    public void createUser(User user){
    }
    
    public List<User> readUsers(){
        return null;
    }
        
    public void updateUser(User user){
    }
            
    public void deleteUser(User user){
    }
}
