package entidades;

public class UsuarioCad extends Pessoa implements Imprimiveis{
	
	private String anoNasci;

	public String getAnoNasci() {
		return anoNasci;
	}

	public void setAnoNasci(String anoNasci) {
		this.anoNasci = anoNasci;
	}
	
	@Override
	public String toString() {
		return super.toString()+
				"Ano Nascimento: "+getAnoNasci()+ "\n";
	}

	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		System.out.println(toString());
	}

}
