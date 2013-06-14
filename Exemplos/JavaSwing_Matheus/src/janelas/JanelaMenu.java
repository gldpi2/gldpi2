package janelas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaMenu extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	public JanelaMenu() {
		super("Menu");
	}
	
	JPanel inicio;
	JPanel botoes;
	
	JButton Add;
	JButton sair;
	JButton listar;
		
	public void telaInicial(){
		
		inicio = new JPanel();
		botoes = new JPanel();
				
		Add = new JButton("Adicionar");
		sair = new JButton("Sair");
		listar = new JButton("Listar");
				
		Add.addActionListener(this);
		sair.addActionListener(this);
		listar.addActionListener(this);
				
		botoes.add(Add);
		botoes.add(sair);
		botoes.add(listar);
				
		getContentPane().add(inicio, BorderLayout.NORTH);
		getContentPane().add(botoes, BorderLayout.SOUTH);
		
		pack();
		
		setSize(300, 110);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sair){
			System.out.println("Saindo");
			System.exit(0);
		}
		
		else if(e.getSource() == Add){
			JanelaADD jADD = new JanelaADD();
			jADD.telaDeAdicionar();
			System.out.println("Tela de ADD");
			JanelaMenu.this.dispose();
			
		}
		else if(e.getSource() == listar){
			JanelaListarCriador jLC = new JanelaListarCriador();
			jLC.janelaListar();
			JanelaMenu.this.dispose();
		}
		
	}

}
