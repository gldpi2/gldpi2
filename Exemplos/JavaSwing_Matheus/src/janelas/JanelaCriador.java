package janelas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlle.Controle;

public class JanelaCriador extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public JanelaCriador() {
		// TODO Auto-generated constructor stub
		super("Janela de Criador");
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
	JLabel lbQtdeColab;
	JLabel lbMediaAval;
	
	JTextField txtNome;
	JTextField txtEmail;
	JTextField txtNomeusuario;
	JTextField txtQtdeColab;
	JTextField txtMediaAval;
	
	public void telaCriador(){
		criador = new JPanel();
		botoes= new JPanel();
		
		lbNome = new JLabel("Nome: ");
		txtNome = new JTextField(30);
		lbEmail = new JLabel("Email: ");
		txtEmail = new JTextField(30);
		lbNomeusuario = new JLabel("Nome de Usuario: ");
		txtNomeusuario = new JTextField(10);
		lbQtdeColab = new JLabel("Quantidade de Colaborações: ");
		txtQtdeColab = new JTextField(10);
		lbMediaAval = new JLabel("Media de Avaliações: ");
		txtMediaAval = new JTextField(10);
			
		criador.add(lbNome);
		criador.add(txtNome);
		criador.add(lbEmail);
		criador.add(txtEmail);
		criador.add(lbNomeusuario);
		criador.add(txtNomeusuario);
		criador.add(lbQtdeColab);
		criador.add(txtQtdeColab);
		criador.add(lbMediaAval);
		criador.add(txtMediaAval);
		
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(this);
		limpar = new JButton("Limpar");
		limpar.addActionListener(this);
		voltar = new JButton("Voltar");
		voltar.addActionListener(this);
		sair = new JButton("Sair");
		sair.addActionListener(this);
		
		criador.setLayout(new GridLayout(5, 2));
			
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
			try{
				if(txtNome != null )
				ctr.salvarCriador(txtNome.getText(), txtEmail.getText(), txtNomeusuario.getText(),  Integer.parseInt(txtQtdeColab.getText()), Double.parseDouble(txtMediaAval.getText()));
				System.out.println("Criador "+txtNome.getText()+ " cadastrado com sucesso");
			}
			catch(Exception a){
				JOptionPane.showMessageDialog(null, "Campos não podem ser vazios");
				a.printStackTrace();
			}
			
		}
		
		else if(e.getSource() == limpar){
			System.out.println("Limpando");
			txtNome.setText("");
			txtEmail.setText("");
			txtNomeusuario.setText("");
			txtMediaAval.setText("");
			txtQtdeColab.setText("");
		}
		
		else if(e.getSource() == voltar){
			System.out.println("Voltando");
			JanelaADDColab jColab = new JanelaADDColab();
			jColab.telaAddColab();
			JanelaCriador.this.dispose();
		}
		
		else if(e.getSource() == sair){
			System.out.println("Saindo");
			System.exit(0);
		}
	}

}
