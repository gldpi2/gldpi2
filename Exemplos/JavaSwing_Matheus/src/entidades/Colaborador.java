package entidades;

public abstract class Colaborador extends Pessoa{
	
	private Double salario;
	
	public abstract Double calculoSalario();
	public static final Integer salarioFixo = 1000;
	abstract Double bonificacao(Double media);
	
	@Override
	public String toString() {
		return super.toString()+"\n"+
				"Salario: "+ getSalario()+ "\n";
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
