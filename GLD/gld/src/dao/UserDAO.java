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
        String[] registers;
        int i = 0;
        int rowcount = 0;

        dbint.connect();
        ResultSet rs = dbint.executeQuery(sql);
        if (rs.last()) {
            rowcount = rs.getRow();
            rs.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
        }
        registers = new String[rowcount];
        System.out.println(rowcount);
        while (rs.next()) {
            registers[i] = rs.getString("register");
            i++;
        }
        dbint.disconnect();
        for (i = 0; i < registers.length; i++) {
            if (user.getRegister().equals(registers[i])) {
                throw new SQLRegisterException();
            }
        }


        sql = "INSERT INTO user (name, register, password, email, "
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
                    rs.getString("cell_claro"), rs.getInt("profile"));

            usersList.add(user);
        }

        dbint.disconnect();

        return usersList;
    }

    public void updateUser(User user) {
    }

    public void deleteUser(User user) {
    }

    public void createUsers(List<User> users) {
    }

    public void updateUsers(List<User> users) {
    }
}
