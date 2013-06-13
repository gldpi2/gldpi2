package db;
import java.sql.*;
/**
 *
 * @author Itallo
 */
public class Conectar {

    /**
     * DRIVER - representa o driver para conexão com o banco de dados
     */
    private static String DRIVER = "com.mysql.jdbc.Driver";
    /**
     * URL - representa caminho para o banco locadora
     */
    private static String URL    = "jdbc:mysql://localhost/FGASaLa";
    /**
     * USER - representa o usuario usado para acessar o banco de dados
     */
    private static String USER;
    /**
     * PW - representa a senha usada para acessar o banco de dados
     */
    private static String PW;
    /**
     * Metodo usado para fazer uma primeira conexão com o mysql
     * quando os bancos de dados do programa ainda não foram criados
     * @return
     * @throws SQLException
     */
    public static Connection conectar() throws SQLException
    {
        try
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PW);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public static String getPW() {
        return PW;
    }

    public static void setPW(String PW) {
        Conectar.PW = PW;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        Conectar.USER = USER;
    }
}
