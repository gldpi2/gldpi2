package controlle;

import dao.PessoaDAO;
import entidades.Criador;
import entidades.Revisor;
import entidades.UsuarioCad;

public class Controle{
	
	PessoaDAO dao = new PessoaDAO();
	
	public void salvarRevisor(String nome, String email, String nomeUsuario, Double mediaRevi, Integer qtdRevi){
		Revisor r = new Revisor();
		
		r.setNome(nome);
		r.setEmail(email);
		r.setNomeUsuario(nomeUsuario);
		r.setMedRevisor(mediaRevi);
		r.setQtdRevisoes(qtdRevi);
		r.setSalario(r.calculoSalario());
		
				
		dao.salvarRevisor(r);
	}
	
	public void salvarCriador(String nome, String email, String nomeUsuario, Integer qtdColab, Double mediaAval){
		Criador c = new Criador();
		
		c.setNome(nome);
		c.setEmail(email);
		c.setNomeUsuario(nomeUsuario);
		c.setQtdColab(qtdColab);
		c.setMediaAval(mediaAval);
		c.setSalario(c.calculoSalario());
		
		dao.salvarCriador(c);
	}
	
	public void salvarUsuario(String nome, String email, String nomeUsuario, String anoNasci){
		UsuarioCad uc = new UsuarioCad();
		
		uc.setNome(nome);
		uc.setEmail(email);
		uc.setNomeUsuario(nomeUsuario);
		uc.setAnoNasci(anoNasci);
		
		dao.salvarUsuario(uc);
	}

	public void imprimir() {
		System.out.println(dao.toString());
		
	}

}
