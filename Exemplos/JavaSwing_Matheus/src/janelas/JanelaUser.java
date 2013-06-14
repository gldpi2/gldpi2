package janelas;

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

public class JanelaUser extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public JanelaUser() {
		// TODO Auto-generated constructor stub
		super("Janela de Usuário Normal");
	}
	
	JPanel criador;
	JPanel botoes;
	
	JButton cadastrar;
	JButton limpar;
	JButton sair;
	JButton voltar;
	
	JLabel lbNome;
	JLabel lbEmail;
	JLabel lbNomeusuario;
	JLabel lbAnoNasci;
		
	JTextField txtNome;
	JTextField txtEmail;
	JTextField txtNomeusuario;
	JTextField txtAnoNasci;
		
	public void telaUsuario(){
		criador = new JPanel();
		botoes= new JPanel();
		
		lbNome = new JLabel("Nome: ");
		txtNome = new JTextField(30);
		lbEmail = new JLabel("Email: ");
		txtEmail = new JTextField(30);
		lbNomeusuario = new JLabel("Nome de Usuario: ");
		txtNomeusuario = new JTextField(10);
		lbAnoNasci = new JLabel("Ano de Nascimento: ");
		txtAnoNasci = new JTextField(10);
					
		criador.add(lbNome);
		criador.add(txtNome);
		criador.add(lbEmail);
		criador.add(txtEmail);
		criador.add(lbNomeusuario);
		criador.add(txtNomeusuario);
		criador.add(lbAnoNasci);
		criador.add(txtAnoNasci);
		
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(this);
		limpar = new JButton("Limpar");
		limpar.addActionListener(this);
		voltar = new JButton("Voltar");
		voltar.addActionListener(this);
		sair = new JButton("Sair");
		sair.addActionListener(this);
		
		criador.setLayout(new GridLayout(4, 2));
			
		botoes.add(cadastrar);
		botoes.add(limpar);
		botoes.add(voltar);
		botoes.add(sair);
		
		
		botoes.setLayout(new GridLayout(1,3));
		
		getContentPane().add(criador,BorderLayout.NORTH);
		getContentPane().add(botoes,BorderLayout.SOUTH);
		
		pack();
		
		setSize(400,200);
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
			ctr.salvarUsuario(txtNome.getText(), txtEmail.getText(), txtNomeusuario.getText(), txtAnoNasci.getText());
			System.out.println("Usuário "+txtNome.getText()+ "cadastrado com sucesso");
		}
		
		else if(e.getSource() == limpar){
			System.out.println("Limpando");
			txtNome.setText("");
			txtEmail.setText("");
			txtNomeusuario.setText("");
			txtAnoNasci.setText("");
		}
		
		else if(e.getSource() == voltar){
			System.out.println("Voltando para tela de add");
			JanelaADD jA = new JanelaADD();
			jA.telaDeAdicionar();
			JanelaUser.this.dispose();
		}
		
		else if(e.getSource() == sair){
			System.out.println("Saindo");
			System.exit(0);
		}
	}

}
