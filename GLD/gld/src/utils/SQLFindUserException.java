/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.UserDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artur
 */
public class SQLFindUserException extends SQLException {

    public SQLFindUserException() {
        Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Usuário não encontrado!", new SQLException());
    }
}
