package janelas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaADD extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	public JanelaADD() {
		super("Janela de Adicionar Usuário");
	}
	
	JPanel principal;
	JPanel botoes;
	
	JButton colab;
	JButton user;
	JButton voltar;
	JButton sair;
		
	public void telaDeAdicionar(){
		
		principal = new JPanel();
		botoes = new JPanel();
		
		colab = new JButton("Colaborador");
		colab.addActionListener(this);
		user = new JButton ("Usuário");
		user.addActionListener(this);
		voltar = new JButton("Voltar");
		voltar.addActionListener(this);
		sair = new JButton("Sair");
		sair.addActionListener(this);
			
		principal.add(colab);
		principal.add(user);
		botoes.add(voltar);
		botoes.add(sair);
				
		getContentPane().add(principal, BorderLayout.NORTH);
		getContentPane().add(botoes, BorderLayout.SOUTH);
		
		pack();
		
		setSize(300, 110);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == voltar){
			JanelaMenu jM = new JanelaMenu();
			jM.telaInicial();
			System.out.println("Voltando");
			JanelaADD.this.dispose();
			
		}
		
		else if(e.getSource() == sair){
			System.out.println("Saindo");
			System.exit(0);
		}
		else if(e.getSource() == colab){
			JanelaADDColab jB = new JanelaADDColab();
			System.out.println("Colaborador");
			jB.telaAddColab();
			JanelaADD.this.dispose();
		}
		else if(e.getSource() == user){
			JanelaUser jU = new JanelaUser();
			System.out.println("Usuário");
			jU.telaUsuario();
			JanelaADD.this.dispose();
		}
		
	}

}
