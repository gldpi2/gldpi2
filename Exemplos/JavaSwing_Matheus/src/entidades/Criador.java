package entidades;

public class Criador extends Colaborador implements Imprimiveis{
	
	private Double mediaAval;
	private Integer qtdColab;

	public Double getMediaAval() {
		return mediaAval;
	}

	public void setMediaAval(Double mediaAval) {
		this.mediaAval = mediaAval;
	}
	
	public Integer getQtdColab() {
		return qtdColab;
	}

	public void setQtdColab(Integer qtdColab) {
		this.qtdColab = qtdColab;
	}

	@Override
	Double bonificacao(Double media) {
		Double boni=0.0;
			
		if(media <= 5)
			boni = 300.0;
		else if(media > 5 && media <= 8)
			boni = 800.0;
		else if(media > 8)
			boni = 1500.0;
		
		return boni;
	}
	
	@Override
	public Double calculoSalario() {
		Double sal;
			sal = salarioFixo + (qtdColab *100) + bonificacao(mediaAval);
		return sal;
	}
	
	@Override
	public String toString() {
		return super.toString()+
				"Quantidade de Colaborações: "+getQtdColab()+ "\n"+
				"Media de Avaliações: "+getMediaAval()+"\n";
	}

	@Override
	public void imprimir() {
		System.out.println(toString());		
	}



}
