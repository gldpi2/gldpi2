package utils;

/**
 *
 * @author itallorossi
 */
public class UserManagement {
    String matricula;
    String senha;
    String tipo;
    DatabaseInterface dbInterface;
            
    public UserManagement(){
        dbInterface = new DatabaseInterface();
    }
    
    public void InsertUser(){
        matricula = "090038070";
        senha = "senha1234";
        tipo = "1";
        
        String sql = "INSERT INTO user (matricula, senha, tipo) VALUES (?,?,?)";
        String params[] = dbInterface.getParamsString(matricula,senha,tipo);
        
        dbInterface.connect();
        dbInterface.insert(sql, params);
        dbInterface.disconnect();
    }
}
