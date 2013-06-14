package janelas;

import impressora.Impressora;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlle.Controle;

public class JanelaRevisor extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public JanelaRevisor() {
		super("Janela Revisor");
	}
	
	JPanel revisor;
	JPanel botoes;
	
	JButton cadastrar;
	JButton limpar;
	JButton sair;
	JButton voltar;
	
	JLabel lbNome;
	JLabel lbEmail;
	JLabel lbNomeusuario;
	JLabel lbQtdeRevi;
	JLabel lbMediaRevi;
	
	JTextField txtNome;
	JTextField txtEmail;
	JTextField txtNomeusuario;
	JTextField txtQtdeRevi;
	JTextField txtMediaRevi;
	
	public void telaRevisor(){
		revisor = new JPanel();
		botoes= new JPanel();
		
		lbNome = new JLabel("Nome: ");
		txtNome = new JTextField(30);
		lbEmail = new JLabel("Email: ");
		txtEmail = new JTextField(30);
		lbNomeusuario = new JLabel("Nome de Usuario: ");
		txtNomeusuario = new JTextField(10);
		lbQtdeRevi = new JLabel("Quantidade de Revisões: ");
		txtQtdeRevi = new JTextField(10);
		lbMediaRevi = new JLabel("Media de Revisões: ");
		txtMediaRevi = new JTextField(10);
			
		revisor.add(lbNome);
		revisor.add(txtNome);
		revisor.add(lbEmail);
		revisor.add(txtEmail);
		revisor.add(lbNomeusuario);
		revisor.add(txtNomeusuario);
		revisor.add(lbQtdeRevi);
		revisor.add(txtQtdeRevi);
		revisor.add(lbMediaRevi);
		revisor.add(txtMediaRevi);
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(this);
		limpar = new JButton("Limpar");
		limpar.addActionListener(this);
		voltar = new JButton("Voltar");
		voltar.addActionListener(this);
		sair = new JButton("Sair");
		sair.addActionListener(this);
		
		revisor.setLayout(new GridLayout(5, 4));
			
		botoes.add(cadastrar);
		botoes.add(limpar);
		botoes.add(voltar);
		botoes.add(sair);
		
		
		botoes.setLayout(new GridLayout(1,3));
		
		getContentPane().add(revisor,BorderLayout.NORTH);
		getContentPane().add(botoes,BorderLayout.SOUTH);
		
		pack();
		
		setSize(400,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == cadastrar){
			System.out.println("Cadastro");
			Controle ctr = new Controle();
			ctr.salvarRevisor(txtNome.getText(), txtEmail.getText(), txtNomeusuario.getText(), Double.parseDouble(txtMediaRevi.getText()), Integer.parseInt(txtQtdeRevi.getText()));
			System.out.println("Revisor "+txtNome.getText()+ " cadastrado com sucesso");
			Impressora imp = new Impressora();
			imp.imprimir(ctr);
		}
		
		else if(e.getSource() == limpar){
			System.out.println("Limpando");
			txtNome.setText("");
			txtEmail.setText("");
			txtNomeusuario.setText("");
			txtMediaRevi.setText("");
			txtQtdeRevi.setText("");
		}
		
		else if(e.getSource() == voltar){
			System.out.println("Voltando");
			JanelaADDColab jColab = new JanelaADDColab();
			jColab.telaAddColab();
			JanelaRevisor.this.dispose();
		}
		
		else if(e.getSource() == sair){
			System.out.println("Saindo");
			System.exit(0);
		}
	}

}
