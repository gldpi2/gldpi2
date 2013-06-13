/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;
import java.sql.*;
import classes.*;
/**
 *
 * @author itallorossi
 */
public class UsuarioDAO {

    private Connection conex;

    public UsuarioDAO() throws SQLException{
        this.conex = Conectar.conectar();
    }

    public int verificarLogin(Usuario user, String matricula, String senha) throws SQLException{
        int i=0;
        
        String sql = "select * from usuario where user = '"+matricula+"' AND senha='"+senha+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            i++;
            user.setTipo(rs.getString("tipo"));
        }

        return i;
    }

    public void carregarUser(String matricula, Usuario user) throws SQLException{
        String sql = "select * from usuario where user = '"+matricula+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            user.setNome(rs.getString("nome"));
            user.setUser(rs.getString("user"));
        }
    }
    
    public void usuarioInserir(Usuario user) throws SQLException
    {
        String sql = "insert into usuario (user,senha,nome,email,telefone,tipo)"
                + "values (?,?,?,?,?,?)";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setString(1, user.getUser());
        stmt.setString(2, user.getSenha());
        stmt.setString(3, user.getNome());
        stmt.setString(4, user.getEmail());
        stmt.setString(5, user.getTelefone());
        stmt.setString(6, user.getTipo());
        
        stmt.execute();
        stmt.close();
    }
}
