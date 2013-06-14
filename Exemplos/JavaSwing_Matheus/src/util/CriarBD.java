package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CriarBD {
	
Connection conexao = null;
	
	String l1 = "CREATE DATABASE IF NOT EXISTS sistemaweb;";
	String l2 = "USE sistemaweb;";
	String l3 = "CREATE TABLE IF NOT EXISTS `revisor`("+
				"`id` int(2) NOT NULL AUTO_INCREMENT,"+
				"`nome` varchar(30) NOT NULL,"+
				"`email` varchar(30) NOT NULL,"+
				"`nomeusuario` varchar(30) NOT NULL,"+
				"`salario` double(10,00),"+
				"`qtdRevisoes` int(10),"+
				"`medRevisor` double(10,00),"+
				"PRIMARY KEY(`id`));";
	
	String l4 = "CREATE TABLE IF NOT EXISTS `criador`("+
				"`id` int(2) NOT NULL AUTO_INCREMENT,"+
				"`nome` varchar(30) NOT NULL,"+
				"`email` varchar(30) NOT NULL,"+
				"`nomeusuario` varchar(30) NOT NULL,"+
				"`salario` double(10,00),"+
				"`qtdColab` int(10),"+
				"`mediaAval` double(10,00),"+
				"PRIMARY KEY(`id`));";
	
	String l5 = "CREATE TABLE IF NOT EXISTS `usuario`("+
				"`id` int(2) NOT NULL AUTO_INCREMENT,"+
				"`nome` varchar(30) NOT NULL,"+
				"`email` varchar(30) NOT NULL,"+
				"`nomeusuario` varchar(30) NOT NULL,"+
				"`anoNasci` varchar(10),"+
				"PRIMARY KEY(`id`));";
	
	public void criarBanco(){
		try{
			conexao = new FabricaConexao().conexaoInicial();
			PreparedStatement stmt1 = conexao.prepareStatement(l1);
			PreparedStatement stmt2 = conexao.prepareStatement(l2);
			PreparedStatement stmt3 = conexao.prepareStatement(l3);
			PreparedStatement stmt4 = conexao.prepareStatement(l4);
			PreparedStatement stmt5 = conexao.prepareStatement(l5);
			
			stmt1.execute();
			stmt2.execute();
			stmt3.execute();
			stmt4.execute();
			stmt5.execute();
			
			stmt1.close();
			stmt2.close();
			stmt3.close();
			stmt4.close();
			stmt5.close();
			
			conexao.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

}
