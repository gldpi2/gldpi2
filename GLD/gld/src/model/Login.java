package model;

/**
 *
 * @author itallorossi
 */
public class Login {

    private String matricula;
    private String senha;
    private String tipo;
    private static Login uniqueInstance;

    public static Login getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Login();
        }

        return uniqueInstance;
    }

    public Login() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
