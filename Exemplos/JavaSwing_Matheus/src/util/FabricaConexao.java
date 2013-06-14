package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {


	Connection conexao = null;
	
	public Connection conexaoInicial(){
		try{
			conexao = DriverManager.getConnection("jdbc:mysql://localhost", "root", "root");
			System.out.println("Conectado");
		}
		catch (Exception e){
			System.out.println("Falhou");
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	public Connection criarConexao(){
		try{
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/sistemaweb", "root", "root");
			System.out.println("Sucesso");
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Falhou");
		}
		
		return conexao;
	}
	
	
}
