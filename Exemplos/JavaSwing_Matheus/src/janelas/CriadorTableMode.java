package janelas;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import entidades.Criador;

public class CriadorTableMode extends DefaultTableModel{
	private static final long serialVersionUID = 1L;

	private static final int COL_ID = 0;
	private static final int COL_NOME = 1;
	private static final int COL_EMAIL = 2;
	private static final int COL_NOMEU = 3;
	private static final int COL_SAL = 4;
	private static final int COL_QTD = 5;
	private static final int COL_MED = 6;
	
	private List <Criador> lista;
	
	public CriadorTableMode(List<Criador> listaCriador){
		this.lista = listaCriador;
	}
	
	
	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Criador titulo = lista.get(rowIndex);
		
		switch(columnIndex){
		case 0:
			return titulo.getId();
		case 1:
			return titulo.getNome();
		case 2:
			return titulo.getEmail();
		case 3:
			return titulo.getNomeUsuario();
		case 4:
			return titulo.getSalario();
		case 5:
			return titulo.getQtdColab();
		case 6:
			return titulo.getMediaAval();
		default:
			throw new IndexOutOfBoundsException("column index out of bounds");
		}
	}
	
	
	public String getColumnName(int column){
		if (column == COL_ID) return "Id";
		else if(column == COL_NOME) return "Nome";
		else if(column == COL_EMAIL) return "Email";
		else if(column == COL_NOMEU) return "Nome Usuário";
		else if(column == COL_SAL) return "Salário";
		else if(column == COL_QTD) return "Quantidade de Colaboração";
		else if(column == COL_MED) return "Média de Avaliações";
		return "";
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex){
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return Double.class;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return true;
	}
}
