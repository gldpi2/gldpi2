package entidades;

public abstract class Pessoa {

	private String nome;
	private String email;
	private String nomeUsuario;
	private Integer id;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return ("\n\n"+
				"Nome: "+getNome()+"\n"+
				"Email: "+getEmail()+ "\n"+
				"Nome de Usuario: " +getNomeUsuario()+"\n");
	}
	
	
}
