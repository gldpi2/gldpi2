package controller;

import dao.LoginDAO;
import java.sql.SQLException;
import model.Login;

/**
 *
 * @author itallorossi
 */
public class LoginCtrl {

    private Login login;
    private LoginDAO loginDAO;

    public LoginCtrl() {
        loginDAO = new LoginDAO();
        login = new Login();
    }

    public int verifyLogin(String register, String password) {
        int isLogged = 0;

        try {
            isLogged = loginDAO.verificarLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isLogged;
    }

    public void setLogin(String register, String password) {
        login.setRegister(register);
        login.setPassword(password);
    }

    public Login getLogin() {
        return this.login;
    }
}
