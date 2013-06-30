/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import utils.DatabaseInterface;
import utils.SQLFindUserException;
import utils.SQLRegisterException;

/**
 *
 * @author artur
 */
public class UserDAO {

    private DatabaseInterface dbint = new DatabaseInterface();

    public UserDAO() {
    }

    public void createUser(User user) throws SQLException {

        String sql = "SELECT register FROM user";

        dbint.connect();
        ResultSet rs = dbint.executeQuery(sql);

        while (rs.next()) {
            if(user.getRegister().equals(rs.getString("register"))){
                throw new SQLRegisterException();
            }
        }
        dbint.disconnect();


        sql = "INSERT INTO user (name, register, password, email, "
                + "cell_oi, cell_vivo, cell_tim, cell_claro, profile, enable) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?)";

        String[] params = new String[10];
        params[0] = user.getName();
        params[1] = user.getRegister();
        params[2] = user.getPassword();
        params[3] = user.getEmail();
        params[4] = user.getCell_oi();
        params[5] = user.getCell_vivo();
        params[6] = user.getCell_tim();
        params[7] = user.getCell_claro();
        params[8] = user.getProfile().toString();
        params[9] = user.getEnable().toString();

        dbint.connect();

        dbint.insert(sql, params);

        dbint.disconnect();

    }

    public List<User> readUsers() throws SQLException {
        List<User> usersList;

        usersList = new ArrayList<>();

        String sql = "SELECT * FROM user";

        dbint.connect();
        ResultSet rs = dbint.executeQuery(sql);

        while (rs.next()) {
            User user;

            user = new User(rs.getString("name"), rs.getString("register"), rs.getString("password"),
                    rs.getString("email"), rs.getString("cell_oi"), rs.getString("cell_vivo"), rs.getString("cell_tim"),
                    rs.getString("cell_claro"), rs.getInt("profile"), rs.getInt("enable"));

            usersList.add(user);
        }

        dbint.disconnect();

        return usersList;
    }

    public void updateUser(User user) throws SQLException{
        
        String sql = "SELECT register FROM user";
        int i = 0;
        int rowcount = 0;
        boolean UserFound = false;

        dbint.connect();
        ResultSet rs = dbint.executeQuery(sql);
        while (rs.next()) {
            if(rs.getString("register").equals(user.getRegister()))
                UserFound = true;
        }
        dbint.disconnect();

        if(!UserFound){
            throw new SQLFindUserException();
        }
        

        sql = "UPDATE user set name = ?, password = ?, email = ?, "
                + "cell_oi = ?, cell_vivo = ?, cell_tim = ?, cell_claro = ?, "
                + "profile = ?, enable = ? where register = ?";

        String[] params = new String[10];
        params[0] = user.getName();
        params[1] = user.getPassword();
        params[2] = user.getEmail();
        params[3] = user.getCell_oi();
        params[4] = user.getCell_vivo();
        params[5] = user.getCell_tim();
        params[6] = user.getCell_claro();
        params[7] = user.getProfile().toString();
        params[8] = user.getEnable().toString();
        params[9] = user.getRegister();

        dbint.connect();

        dbint.insert(sql, params);

        dbint.disconnect();

    }

    public void deleteUser(User user) throws SQLException {
        user.setEnable(0);
        updateUser(user);
    }

    public void createUsers(List<User> users) {
    }

    public void updateUsers(List<User> users) {
    }
}
