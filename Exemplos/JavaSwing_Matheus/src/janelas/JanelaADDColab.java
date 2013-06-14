package janelas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaADDColab extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public JanelaADDColab() {
		// TODO Auto-generated constructor stub
		super("ADD Colaborador");
	}

	JPanel addColab;
	JPanel botoes;
	
	JButton criador;
	JButton revisor;
	JButton voltar;
	JButton sair;
	
	
	public void telaAddColab(){
		
		addColab = new JPanel();
		botoes = new JPanel();
		
		criador = new JButton("Criador");
		criador.addActionListener(this);
		revisor = new JButton("Revisor");
		revisor.addActionListener(this);
		voltar = new JButton("Voltar");
		voltar.addActionListener(this);
		sair = new JButton("Sair");
		sair.addActionListener(this);
		
		
		addColab.add(criador);
		addColab.add(revisor);
		botoes.add(voltar);
		botoes.add(sair);
				
		getContentPane().add(addColab, BorderLayout.NORTH);
		getContentPane().add(botoes, BorderLayout.SOUTH);
		
		pack();
		
		setSize(300, 110);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == voltar){
			JanelaADD jADD = new JanelaADD();
			jADD.telaDeAdicionar();
			System.out.println("Voltando para menu ADD");
			JanelaADDColab.this.dispose();
		}
		
		else if(e.getSource() == sair){
			System.out.println("Saindo");
			System.exit(0);
		
		}
		
		else if(e.getSource() == criador){
			JanelaCriador jC = new JanelaCriador();
			jC.telaCriador();
			System.out.println("Janela Criador");
			JanelaADDColab.this.dispose();
			
		}
		else if(e.getSource() == revisor){
			JanelaRevisor jR = new JanelaRevisor();
			jR.telaRevisor();
			System.out.println("Janela Revisor");
			JanelaADDColab.this.dispose();
		}
	}

}
