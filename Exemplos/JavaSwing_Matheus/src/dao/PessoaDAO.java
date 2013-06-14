package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Criador;
import entidades.Revisor;
import entidades.UsuarioCad;


import util.FabricaConexao;

public class PessoaDAO {
	
	Connection conexao = null;
	
	public static final String INSERIRREVISOR = "insert into revisor"+
						"(nome, email, nomeUsuario, salario, qtdRevisoes, medRevisor)"+
						"VALUES (?, ?, ?, ?, ?, ?)";
	
	public static final String INSERIRCRIADOR = "insert into criador"+
						"(nome, email, nomeUsuario, salario, qtdColab, mediaAval)"+
						"VALUES (?, ?, ?, ?, ?, ?)";
	public static final String INSERIRUSUARIO = "insert into usuario"+
						"(nome, email, nomeUsuario, anoNasci)"+
						"VALUES (?, ?, ?, ?)";
	
	public static final String BUSCARREVISOR = "select * from revisor";
	public static final String BUSCARCRIADOR = "select * from criador";
	public static final String BUSCARUSUARIO = "select * from usuario";

	public void salvarRevisor(Revisor r){
		try{
			conexao = new FabricaConexao().criarConexao();
			PreparedStatement pst = conexao.prepareStatement(INSERIRREVISOR);
				pst.setString(1, r.getNome());
				pst.setString(2, r.getEmail());
				pst.setString(3, r.getNomeUsuario());
				pst.setDouble(4, r.getSalario());
				pst.setDouble(5, r.getQtdRevisoes());
				pst.setDouble(6, r.getMedRevisor());

				imprimir(1);
				
				pst.execute();
				pst.close();
				conexao.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void salvarCriador(Criador c){
		try{
			conexao = new FabricaConexao().criarConexao();
			PreparedStatement pst = conexao.prepareStatement(INSERIRCRIADOR);
				pst.setString(1, c.getNome());
				pst.setString(2, c.getEmail());
				pst.setString(3, c.getNomeUsuario());
				pst.setDouble(4, c.getSalario());
				pst.setDouble(5, c.getQtdColab());
				pst.setDouble(6, c.getMediaAval());
				
				imprimir(2);
				
				pst.execute();
				pst.close();
				conexao.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void salvarUsuario(UsuarioCad uc){
		try{
			conexao = new FabricaConexao().criarConexao();
			PreparedStatement pst = conexao.prepareStatement(INSERIRUSUARIO);
			pst.setString(1, uc.getNome());
			pst.setString(2, uc.getEmail());
			pst.setString(3, uc.getNomeUsuario());
			pst.setString(4, uc.getAnoNasci());
			
			
			imprimir(3);
			
			pst.execute();
			pst.close();
			conexao.close();
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public String imprimir(int pessoa) {
		String relatorio = "";
		if(pessoa == 1){
			Revisor r = new Revisor();
			relatorio = r.toString();
		}
		
		else if(pessoa == 2){
			Criador c = new Criador();
			relatorio = c.toString();
		}
		else if (pessoa == 3){
			UsuarioCad uc = new UsuarioCad();
			relatorio = uc.toString();
		}
			
		
		return relatorio;		
	}
	
	public List<Criador> listar(){
		List<Criador> listaCriador = new ArrayList<>();
		conexao = new FabricaConexao().criarConexao();
		
		try{
			PreparedStatement stmt = conexao.prepareStatement(BUSCARCRIADOR);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()){
				Criador c = new Criador();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setNomeUsuario(rs.getString(4));
				c.setSalario(rs.getDouble(5));
				c.setQtdColab(rs.getInt(6));
				c.setMediaAval(rs.getDouble(7));
				listaCriador.add(c);
			}
			
			rs.close();
			stmt.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return listaCriador;
		
	}
	
	
}