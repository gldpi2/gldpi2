/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import dao.UserDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artur
 */
public class NotEnoughDataException extends SQLException {

    public NotEnoughDataException() {
        //Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Não existe dados suficientes para executar a operação!", null);
    }
}
