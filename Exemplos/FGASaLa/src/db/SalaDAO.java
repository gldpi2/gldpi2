/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;
import java.sql.*;
import classes.*;
import java.util.*;
/**
 *
 * @author itallorossi
 */
public class SalaDAO {

    private Connection conex;
    
    public SalaDAO() throws SQLException{
        this.conex = Conectar.conectar();
    }

    public void inserirSala(Sala sala) throws SQLException{
        String sql =  "insert into sala (qtdlugares,localsala,tiposala) values (?,?,?)";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setInt(1, sala.getQtdlugares());
        stmt.setString(2, sala.getLocalsala());
        stmt.setString(3, sala.getTiposala());

        stmt.execute();
        stmt.close();
    }

    public List<Sala> salaListar() throws SQLException
    {
        String sql = "select * from sala order by idsala";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Sala> salaLista = new ArrayList<Sala>();

        while(rs.next()){
            Sala sala = new Sala();
            sala.setIdsala(rs.getInt("idsala"));
            sala.setLocalsala(rs.getString("localsala"));
            sala.setQtdlugares(rs.getInt("qtdlugares"));
            sala.setTiposala(rs.getString("tiposala"));

            salaLista.add(sala);
        }

        rs.close();
        stmt.close();

        return salaLista;
    }

    public Sala sala(int idSala) throws SQLException
    {
        Sala sala = new Sala();

        String sql = "select * from sala where idsala='"+idSala+"'";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            sala.setIdsala(rs.getInt("idsala"));
            sala.setLocalsala(rs.getString("localsala"));
            sala.setTiposala(rs.getString("tiposala"));
            sala.setQtdlugares(rs.getInt("qtdlugares"));
        }

        return sala;
    }

    public void removerSala(int idSala) throws SQLException
    {
        String sql = "delete from sala where idsala='"+idSala+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public void editarSala(Sala sala) throws SQLException
    {
        String sql = "update sala set qtdlugares=?, localsala=?, tiposala=? where idsala='"+sala.getIdsala()+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setInt(1, sala.getQtdlugares());
        stmt.setString(2, sala.getLocalsala());
        stmt.setString(3, sala.getTiposala());

        stmt.execute();
        stmt.close();
    }
}
