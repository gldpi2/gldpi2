package db;

import java.sql.*;
import classes.*;
import java.util.ArrayList;
import java.util.List;

public class LabDAO {
    
    private Connection conex;

    public LabDAO() throws SQLException{
        this.conex = Conectar.conectar();
    }

    public void inserirLab(Laboratorio lab) throws SQLException{
        String sql =  "insert into lab (nbancada,nporbancada,locallab,tipolab) values (?,?,?,?)";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setInt(1, lab.getNbancada());
        stmt.setInt(2, lab.getNporbancada());
        stmt.setString(3, lab.getLocallab());
        stmt.setString(4, lab.getTipolab());

        stmt.execute();
        stmt.close();
    }

    public List<Laboratorio> labListar() throws SQLException
    {
        String sql = "select * from lab order by idlab";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Laboratorio> labLista = new ArrayList<Laboratorio>();

        while(rs.next()){
            Laboratorio lab = new Laboratorio();

            lab.setIdlab(rs.getInt("idlab"));
            lab.setLocallab(rs.getString("locallab"));
            lab.setNbancada(rs.getInt("nbancada"));
            lab.setNporbancada(rs.getInt("nporbancada"));
            lab.setTipolab(rs.getString("tipolab"));

            labLista.add(lab);
        }

        rs.close();
        stmt.close();

        return labLista;
    }

    public Laboratorio laboratorio(int idLab) throws SQLException
    {
        Laboratorio lab = new Laboratorio();

        String sql = "select * from lab where idlab='"+idLab+"'";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            lab.setIdlab(rs.getInt("idlab"));
            lab.setLocallab(rs.getString("locallab"));
            lab.setNbancada(rs.getInt("nbancada"));
            lab.setNporbancada(rs.getInt("nporbancada"));
            lab.setTipolab(rs.getString("tipolab"));
        }

        return lab;
    }

    public void editarLab(Laboratorio lab) throws SQLException
    {
        String sql = "update lab set nbancada=?, nporbancada=?, locallab=?, tipolab=? where idlab='"+lab.getIdlab()+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setInt(1, lab.getNbancada());
        stmt.setInt(2, lab.getNporbancada());
        stmt.setString(3, lab.getLocallab());
        stmt.setString(4, lab.getTipolab());

        stmt.execute();
        stmt.close();
    }

    public Laboratorio lab(int idLab) throws SQLException
    {
        Laboratorio lab = new Laboratorio();

        String sql = "select * from lab where idlab='"+idLab+"'";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            lab.setNbancada(rs.getInt("nbancada"));
            lab.setNporbancada(rs.getInt("nporbancada"));
            lab.setLocallab(rs.getString("locallab"));
            lab.setTipolab(rs.getString("tipolab"));
        }

        return lab;
    }

    public void removerLab(int idLab) throws SQLException
    {
        String sql = "delete from lab where idlab='"+idLab+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }
}
