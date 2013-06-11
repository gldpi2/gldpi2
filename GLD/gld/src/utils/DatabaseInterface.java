package utils;

import java.sql.*;

/**
 *
 * @author wagner
 */
public class DatabaseInterface {

    private String host;
    private String database;
    private String user;
    private String pass;
    
    private boolean status;
    
    public Connection conn = null;
    
    /**
     * Construtor padrão da classe
     */
    public DatabaseInterface(){
        this.status = false;
    }

    /**
     * Construtor da classe
     *
     * @param host Host em que se deseja conectar
     * @param database Nome do database em que se deseja conectar
     * @param user Nome do usuário
     * @param pass Senha do usuário
     */
    public DatabaseInterface(String host, String database, String user, String pass) {
        this.host = host;
        this.database = database;
        this.user = user;
        this.pass = pass;
        
        this.status = false;
    }
    
    /**
     * Método que altera os parametros do banco de dados
     *
     * @return True se conseguir conectar, falso em caso contrário.
     */
    public void configureConnection(String host, String database, String user, String pass){
        if(!isConnected()){
            this.host = host;
            this.database = database;
            this.user = user;
            this.pass = pass;
        }else{
            System.out.println("Feche a conexão antes de alterar os dados do banco de dados.");
        }
    }

    /**
     * Método que estabelece a conexão com o banco de dados
     *
     * @return True se conseguir conectar, falso em caso contrário.
     */
    public void connect() {
        try {
            if (!isConnected()) {
                String url;

                url = "jdbc:mysql://";
                url += this.host + "/";
                url += this.database + "?";
                url += "user=" + this.user;
                url += "&password=" + this.pass;

                Class.forName("com.mysql.jdbc.Driver");
                this.conn = DriverManager.getConnection(url);
                this.status = true;

                System.out.println("A conexão foi um sucesso.");
            }else{
                System.out.println("Conexão já estabelecida.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Exceção classe não encontrada");
        } catch (SQLException e) {
            System.out.println("SQL Exception. Não conectado.");
        }
    }

    /**
     * Método que fecha conexão com o banco de dados
     *
     * @return True se conseguir desconectar, falso em caso contrário.
     */
    public void disconnect() {
        try {
            if(isConnected()){
                this.conn.close();
                this.status = false;
            }else{
                System.out.println("Não é possível desconectar. Nnão conectado.");
            }
            
            System.out.println("Fechando a conexão");
        } catch (SQLException erro) {
            System.out.println("Erro no fechamento");
        }
    }

    public boolean isConnected() {
        return this.status;
    }
}
