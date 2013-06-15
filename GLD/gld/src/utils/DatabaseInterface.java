package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
    
    public Connection conn = null;
    
    /**
     * Construtor da classe DatabaseInterface.
     */
    public DatabaseInterface() {
        this.host = "gld.zapto.org";
        this.database = "gld_database";
        this.user = "admin";
        this.pass = "admin";
        
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
    public void configureConnection(String host, String database, String user, String pass){
        if(!isConnected()){
            this.host = host;
            this.database = database;
            this.user = user;
            this.pass = pass;
            
            this.configured = true;
        }else{
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
            }else{
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Conexão não configurada ou já estabelecida.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, "connect() não realizado.", ex);
        }
    }

    /**
     * Método que fecha conexão com o banco de dados
     */
    public void disconnect() {
        try {
            if(this.isConnected()){
                this.conn.close();
                this.connected = false;
                
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Conexão com o banco de dados fechada.");
            }else{
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Não conectado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, "disconnect() não realizado.", ex);
        }
    }

    /** 
     * @param sql - Recebe a String sql para fazer o insert na Base de Dados
     * @param params -  Parametros da sql em um array de string (this.getParamString())
     * @return result - Retorna o resultado da execução
     * */
    public synchronized boolean insert(String sql, String[] params){
        PreparedStatement st;
        boolean result = false;
        
        try {
            if(this.isConnected()){
                st = this.conn.prepareStatement(sql);
                
                for (int i = 1; i <= params.length; i++){
                    st.setString(i, params[i-1]);
                }
                
                result = st.execute();
                st.close();
                
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.INFO, "Medição inserida no banco de dados.");
            }else{
                Logger.getLogger(DatabaseInterface.class.getName()).log(Level.WARNING, "Não conectado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, "insert() não realizado.", ex);
        }

        return result;
    }
    
    /**
     * @param args[] - Parametros a serem adicionados ao vetor de string
     * @return args[] - Vetor de strings dos parametros
     */
    
    public String[] getParamsString(String... args){
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
     * Método que verifica se a interface de conexão com o banco está configurada.
     *
     * @return True se conseguir estiver configurado, falso caso contrário.
     */
    public boolean isConfigured(){
        return this.configured;
    }
}
