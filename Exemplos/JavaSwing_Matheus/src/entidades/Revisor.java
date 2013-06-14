package entidades;

public class Revisor extends Colaborador implements Imprimiveis{

	private Integer qtdRevisoes;
	private Double medRevi;
	
	public Integer getQtdRevisoes() {
		return qtdRevisoes;
	}

	public void setQtdRevisoes(Integer qtdRevisoes) {
		this.qtdRevisoes = qtdRevisoes;
	}

	public Double getMedRevisor() {
		return medRevi;
	}

	public void setMedRevisor(Double medRevisor) {
		this.medRevi = medRevisor;
	}


	@Override
	Double bonificacao(Double media) {
		Double boni = 0.0;
			if(media<=10)
				boni = 300.0;
			else if(media > 10 && media <=20)
				boni = 800.0;
			else if( media > 20)
				boni = 1500.0;
				
		return boni;
		
	}

	@Override
	public Double calculoSalario() {
		Double sal;
			sal = salarioFixo + (qtdRevisoes *50)+ bonificacao(medRevi);
		
		return sal;
	}
	
	@Override
	public String toString() {
		return super.toString()+
				"Quantidade de Revisões: "+getQtdRevisoes()+ "\n"+
				"Media de Revisões: "+getMedRevisor()+"\n";
	}

	@Override
	public void imprimir() {
		System.out.println(toString());	
	}

	

	

}
