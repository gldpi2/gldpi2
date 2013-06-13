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
public class EquipDAO {
    
    private Connection conex;

    public EquipDAO() throws SQLException{
        this.conex = Conectar.conectar();
    }

    public void inserirEquipamento(Equipamento equip) throws SQLException{
        String sql =  "insert into equip (nome,descricao,status) values (?,?,?)";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setString(1, equip.getNome());
        stmt.setString(2, equip.getDescricao());
        stmt.setString(3, equip.getStatus());

        stmt.execute();
        stmt.close();
    }

    public List<Equipamento> equipListar() throws SQLException
    {
        String sql = "select * from equip";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Equipamento> equipLista = new ArrayList<Equipamento>();

        while(rs.next()){
            Equipamento equip = new Equipamento();

            equip.setIdequip(rs.getInt("idequip"));
            equip.setNome(rs.getString("nome"));
            equip.setDescricao(rs.getString("descricao"));
            equip.setStatus(rs.getString("status"));

            equipLista.add(equip);
        }

        rs.close();
        stmt.close();

        return equipLista;
    }

    public List<Equipamento> equipListarRemover(int id) throws SQLException
    {
        String sql = "select * from equip where idequip='"+id+"'";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Equipamento> equipLista = new ArrayList<Equipamento>();

        while(rs.next()){
            Equipamento equip = new Equipamento();

            equip.setIdequip(rs.getInt("idequip"));
            equip.setNome(rs.getString("nome"));
            equip.setDescricao(rs.getString("descricao"));
            equip.setStatus(rs.getString("status"));

            equipLista.add(equip);
        }

        rs.close();
        stmt.close();

        return equipLista;
    }

    public void editarEquip(Equipamento equip) throws SQLException
    {
        String sql = "update equip set nome=?,descricao=? where idequip='"+equip.getIdequip()+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setString(1, equip.getNome());
        stmt.setString(2, equip.getDescricao());
        
        stmt.execute();
        stmt.close();
    }

    public void removerEquip(Equipamento equip) throws SQLException
    {
        String sql = "delete from equip where idequip=?";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setInt(1, equip.getIdequip());

        stmt.execute();
        stmt.close();
    }

    public List<Equipamento> equipListarDispo() throws SQLException
    {
        String sql = "select * from equip where status='DISPONIVEL'";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Equipamento> equipLista = new ArrayList<Equipamento>();

        while(rs.next()){
            Equipamento equip = new Equipamento();

            equip.setIdequip(rs.getInt("idequip"));
            equip.setNome(rs.getString("nome"));
            equip.setDescricao(rs.getString("descricao"));
            equip.setStatus(rs.getString("status"));

            equipLista.add(equip);
        }

        rs.close();
        stmt.close();

        return equipLista;
    }

    public int[] idsEquip(int idSala) throws SQLException
    {
        String sql = "select * from sala_equip where idsala='"+idSala+"' order by idequip";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        int tam=0;

        while(rs.next()){
            tam++;
        }

        ResultSet rs1 = stmt.executeQuery();

        int ids[] = new int[tam];
        int i = 0;

        while(rs1.next()){
            ids[i] = rs1.getInt("idequip");
            i++;
        }

        return ids;
    }

    public Equipamento equipSala(int id) throws SQLException
    {
        Equipamento equip = new Equipamento();

        String sql = "select * from equip where idequip='"+id+"'";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            equip.setIdequip(rs.getInt("idequip"));
            equip.setNome(rs.getString("nome"));
            equip.setDescricao(rs.getString("descricao"));
        }

        return equip;
    }

    public void editarEquipStatus(int idEquip) throws SQLException
    {
        String sql = "update equip set status=? where idequip='"+idEquip+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setString(1, "EMUSO");
        
        stmt.execute();
        stmt.close();
    }

    public void editarEquipStatus1(int idEquip) throws SQLException
    {
        String sql = "update equip set status=? where idequip='"+idEquip+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setString(1, "DISPONIVEL");

        stmt.execute();
        stmt.close();
    }

    public void inserirEquipamentoSala(int idSala, int idEquip) throws SQLException{
        String sql =  "insert into sala_equip (idsala,idequip) values (?,?)";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setInt(1, idSala);
        stmt.setInt(2, idEquip);

        stmt.execute();
        stmt.close();
    }

    public void removerEquipSala(int idEquip) throws SQLException
    {
        String sql = "delete from sala_equip where idequip='"+idEquip+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public int[] idsEquipLab(int idLab) throws SQLException
    {
        String sql = "select * from lab_equip where idlab='"+idLab+"' order by idequip";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        int tam=0;

        while(rs.next()){
            tam++;
        }

        ResultSet rs1 = stmt.executeQuery();

        int ids[] = new int[tam];
        int i = 0;

        while(rs1.next()){
            ids[i] = rs1.getInt("idequip");
            i++;
        }

        return ids;
    }

    public Equipamento equipLab(int id) throws SQLException
    {
        Equipamento equip = new Equipamento();

        String sql = "select * from equip where idequip='"+id+"'";
        PreparedStatement stmt = this.conex.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            equip.setIdequip(rs.getInt("idequip"));
            equip.setNome(rs.getString("nome"));
            equip.setDescricao(rs.getString("descricao"));
        }

        return equip;
    }

    public void inserirEquipamentoLab(int idLab, int idEquip) throws SQLException{
        String sql =  "insert into lab_equip (idlab,idequip) values (?,?)";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.setInt(1, idLab);
        stmt.setInt(2, idEquip);

        stmt.execute();
        stmt.close();
    }

    public void removerEquipLab(int idEquip) throws SQLException
    {
        String sql = "delete from lab_equip where idequip='"+idEquip+"'";
        PreparedStatement stmt = conex.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }
}
