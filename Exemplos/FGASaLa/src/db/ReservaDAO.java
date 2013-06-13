/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import classes.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author itallorossi
 */
public class ReservaDAO {
    private Connection conex;

    public ReservaDAO() throws SQLException{
        this.conex = Conectar.conectar();
    }


    public List<Reserva> reservaLista(int idsala) throws SQLException
    {
        String sql = "select * from solicitacao where idsala='"+idsala+"' order by diasemana";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Reserva> lista = new ArrayList<Reserva>();

        while(rs.next()){
            Reserva res = new Reserva();
            res.setIdreserva(rs.getInt("idsolic"));
            res.setIdusuario(rs.getString("idusuario"));
            res.setIdlab(rs.getInt("idlab"));
            res.setData(rs.getDate("data"));
            res.setDiasemana(rs.getInt("diasemana"));
            res.setHora(rs.getInt("hora"));
            res.setNbacanda(rs.getInt("nbancada"));
            res.setStatus(rs.getString("status"));

            lista.add(res);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    public List<Reserva> reservaListaTudo(int idsala) throws SQLException
    {
        String sql = "select * from solicitacao";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Reserva> lista = new ArrayList<Reserva>();

        while(rs.next()){
            Reserva res = new Reserva();
            res.setIdreserva(rs.getInt("idsolic"));
            res.setIdusuario(rs.getString("idusuario"));
            res.setIdlab(rs.getInt("idlab"));
            res.setData(rs.getDate("data"));
            res.setDiasemana(rs.getInt("diasemana"));
            res.setHora(rs.getInt("hora"));
            res.setNbacanda(rs.getInt("nbancada"));
            res.setStatus(rs.getString("status"));

            lista.add(res);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    public List<Reserva> reservaListaSala(String idUsuario) throws SQLException
    {
        String sql = "select * from solicitacao where idlab='0' and idusuario='"+idUsuario+"' order by data";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Reserva> lista = new ArrayList<Reserva>();

        while(rs.next()){
            Reserva res = new Reserva();
            res.setIdreserva(rs.getInt("idsolic"));
            res.setIdusuario(rs.getString("idusuario"));
            res.setIdsala(rs.getInt("idsala"));
            res.setIdlab(rs.getInt("idlab"));
            res.setData(rs.getDate("data"));
            res.setDiasemana(rs.getInt("diasemana"));
            res.setHora(rs.getInt("hora"));
            res.setNbacanda(rs.getInt("nbancada"));
            res.setStatus(rs.getString("status"));

            lista.add(res);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    public List<Reserva> reservaListaSalaTudo() throws SQLException
    {
        String sql = "select * from solicitacao where idlab='0' AND status='PENDENTE' order by data";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Reserva> lista = new ArrayList<Reserva>();

        while(rs.next()){
            Reserva res = new Reserva();
            res.setIdreserva(rs.getInt("idsolic"));
            res.setIdusuario(rs.getString("idusuario"));
            res.setIdsala(rs.getInt("idsala"));
            res.setIdlab(rs.getInt("idlab"));
            res.setData(rs.getDate("data"));
            res.setDiasemana(rs.getInt("diasemana"));
            res.setHora(rs.getInt("hora"));
            res.setNbacanda(rs.getInt("nbancada"));
            res.setStatus(rs.getString("status"));

            lista.add(res);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    public void inserirSolic(Reserva solic) throws SQLException{
        String sql =  "insert into solicitacao (idusuario,idsala,idlab,data,diasemana,hora,nbancada,status) values (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setString(1, solic.getIdusuario());
        stmt.setInt(2, solic.getIdsala());
        stmt.setInt(3, solic.getIdlab());
        stmt.setDate(4, new java.sql.Date(solic.getData().getTime()));
        stmt.setInt(5, solic.getDiasemana());
        stmt.setInt(6, solic.getHora());
        stmt.setInt(7, solic.getNbacanda());
        stmt.setString(8, solic.getStatus());

        stmt.execute();
        stmt.close();
    }

    public void removerSolicSala(int idSala) throws SQLException{
        String sql = "delete from solicitacao where idsala='"+idSala+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public void removerSolicLab(int idLab) throws SQLException{
        String sql = "delete from solicitacao where idlab='"+idLab+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public void removerSolic(int idSolic) throws SQLException{
        String sql = "delete from solicitacao where idsolic='"+idSolic+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public void negarSolic(int idSolic) throws SQLException
    {
        String sql = "update solicitacao set status='NEGADA' where idsolic='"+idSolic+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public void confirmarSolic(int idSolic) throws SQLException
    {
        String sql = "update solicitacao set status='RESERVADA' where idsolic='"+idSolic+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public List<Reserva> reservaListaSalaTudoReserva() throws SQLException
    {
        String sql = "select * from solicitacao where idlab='0' AND status='RESERVADA' order by data";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Reserva> lista = new ArrayList<Reserva>();

        while(rs.next()){
            Reserva res = new Reserva();
            res.setIdreserva(rs.getInt("idsolic"));
            res.setIdusuario(rs.getString("idusuario"));
            res.setIdsala(rs.getInt("idsala"));
            res.setIdlab(rs.getInt("idlab"));
            res.setData(rs.getDate("data"));
            res.setDiasemana(rs.getInt("diasemana"));
            res.setHora(rs.getInt("hora"));
            res.setNbacanda(rs.getInt("nbancada"));
            res.setStatus(rs.getString("status"));

            lista.add(res);
        }

        rs.close();
        stmt.close();

        return lista;
    }
}
