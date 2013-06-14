package janelas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.PessoaDAO;

public class JanelaListarCriador extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	public JanelaListarCriador(){
		super("Listar Criador");
	}
	
	JPanel panelPrincipal;
	JPanel botao;
	JTable tabela;
	JScrollPane scroll;
	JButton btnVoltar;
	
	public void janelaListar(){
		panelPrincipal = new JPanel();
		botao = new JPanel();
		btnVoltar = new JButton("Voltar");
		tabela = new JTable();
		
		PessoaDAO dao = new PessoaDAO();
		
		tabela.setModel(new CriadorTableMode(dao.listar()));
		
		scroll = new JScrollPane(tabela);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		panelPrincipal.add(scroll);
		botao.add(btnVoltar);
		btnVoltar.addActionListener(this);
		
		getContentPane().add(panelPrincipal, BorderLayout.NORTH);
		getContentPane().add(botao, BorderLayout.SOUTH);
		
	
		pack();
		
		setSize(500,505);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnVoltar){
			JanelaMenu jM = new JanelaMenu();
			jM.telaInicial();
			JanelaListarCriador.this.dispose();
		}
	}
}
