package utils;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wagner
 */
public class DatabaseInterface {

    private String host;
    private String database;
    private String user;
    private String pass;
    private boolean connected;
    private boolean configured;
    private Connection conn = null;

    /**
     * Construtor da classe DatabaseInterface.
     */
    public DatabaseInterface() {
        ResourceBundle properties = ResourceBundle.getBundle("utils.PropertiesFile");

        this.host = properties.getString("HOST");
        this.database = properties.getString("DATABASE");
        this.user = properties.getString("USER");
        this.pass = properties.getString("PASS");

        this.connected = false;
        this.configured = true;
    }

    /**
     * Método que altera os parametros do banco de dados.
     *
     * @param host
     * @param database
     * @param user
     * @param pass
     */
    public void configureConnection(String host, String database, String user, String pass) {
        if (!isConnected()) {
            this.host = host;
            this.database = database;
            this.user = user;
            this.pass = pass;

            this.configured = true;
        } else {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.WARNING, "A conexão está estabelecida. Impossível configurar no momento.");
        }
    }

    /**
     * Método que estabelece a conexão com o banco de dados.
     */
    public void connect() {
        try {
            if (this.isConfigured() && !this.isConnected()) {
                String url;

                url = "jdbc:mysql://";
                url += this.host + "/";
                url += this.database + "?";
                url += "user=" + this.user;
                url += "&password=" + this.pass;

                Class.forName("com.mysql.jdbc.Driver");

                this.conn = DriverManager.getConnection(url);
                this.connected = true;

                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Conexão estabalecida.");
            } else {
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Conexão não configurada ou já estabelecida.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, "connect() não realizado.", ex);
        }
    }

    /**
     * Método que fecha conexão com o banco de dados.
     */
    public void disconnect() {
        try {
            if (this.isConnected()) {
                this.conn.close();
                this.connected = false;

                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Conexão com o banco de dados fechada.");
            } else {
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Não conectado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, "disconnect() não realizado.", ex);
        }
    }

    /**
     * Método que faz inserção no banco de dados.
     *
     * @param sql String Comando SQL para fazer o insert na Base de Dados
     * @param params String[] Parametros da sql em um array de string
     * (this.getParamString())
     * @return result int Retorna o resultado da execução
     *
     */
    public synchronized int insert(String sql, String[] params) {
        PreparedStatement st;
        int key = 0;
        int result = 0;

        try {
            if (this.isConnected()) {
                st = this.conn.prepareStatement(sql, key);

                for (int i = 1; i <= params.length; i++) {
                    st.setString(i, params[i - 1]);
                }

                result = st.executeUpdate();
                st.close();

                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Inserção bem efetuada com sucesso.");
            } else {
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.WARNING, "Não conectado.");
            }
        } catch (MySQLIntegrityConstraintViolationException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, "insert() não realizado. Erro na constraint do insert. "
                    + "(provavel: referencia PK não existe.)", ex.getErrorCode());
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, "insert() não realizado.", ex);
        }

        return result;
    }

    /**
     * Método que realiza a consulta no banco de dados.
     *
     * @param sql String Comando SQL para fazer a consulta na Base de Dados
     * @return rs ResultSet Valor do conjunto de resultados obtidos do banco de
     * dados.
     */
    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;

        PreparedStatement st;

        try {
            st = this.conn.prepareStatement(sql);

            if (sql.contains("TRUNCATE")) {
                st.execute();
            } else {
                rs = st.executeQuery();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    /**
     * @param table Nome da tabela que se deseja receber o último id inserido
     * @return lastId int Valor do último id inserido
     */
    public int getLastId(String table) {
        PreparedStatement st;
        ResultSet rs;
        String sql;
        int lastId = -1;

        try {
            sql = "select MAX(id_" + table + ") as last_id from " + table;
            st = this.conn.prepareStatement(sql);

            rs = st.executeQuery();

            if (rs != null && rs.next()) {
                lastId = rs.getInt("last_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lastId;
    }

    /**
     * @param args - Parametros a serem adicionados ao vetor de string
     * @return args[] - Vetor de strings dos parametros
     */
    public String[] getParamsString(String... args) {
        return args;
    }

    /**
     * Método que verifica status da conexão do banco de dados.
     *
     * @return True se conseguir estiver conectado, falso caso contrário.
     */
    public boolean isConnected() {
        return this.connected;
    }

    /**
     * Método que verifica se a interface de conexão com o banco está
     * configurada.
     *
     * @return True se conseguir estiver configurado, falso caso contrário.
     */
    public boolean isConfigured() {
        return this.configured;
    }

    public Date[] getMaxAndMinDates() {
        PreparedStatement st;
        ResultSet rs;
        String sql;
        Date[] dates = new Date[2];

        try {
            sql = "select min(timestamp) as minimo, max(timestamp) as maximo from mensuration";
            st = this.conn.prepareStatement(sql);

            rs = st.executeQuery();

            if (rs != null && rs.next()) {
                dates[0] = rs.getDate("minimo");
                dates[1] = rs.getDate("maximo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dates;
    }
}
