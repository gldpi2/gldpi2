package model;

/**
 *
 * @author itallorossi
 */
public class Login {

    private String register;
    private String password;
    private String permission;

    public Login() {
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String matricula) {
        this.register = matricula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String tipo) {
        this.permission = tipo;
    }
}
