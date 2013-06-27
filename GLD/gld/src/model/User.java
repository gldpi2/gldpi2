/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author artur
 */
public class User {

    private String name = null;
    private String register = null;
    private String password = null;
    private String email = null;
    private String cell_oi = null;
    private String cell_vivo = null;
    private String cell_tim = null;
    private String cell_claro = null;
    private Integer profile = null;

    public User(String name, String register, String password, String email, String cell_oi, String cell_vivo, String cell_tim, String cell_claro, int profile) {
        this.name = name;
        this.register = register;
        this.password = password;
        this.email = email;
        this.cell_oi = cell_oi;
        this.cell_vivo = cell_vivo;
        this.cell_tim = cell_tim;
        this.cell_claro = cell_claro;
        this.profile = (Integer) profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell_oi() {
        return cell_oi;
    }

    public void setCell_oi(String cell_oi) {
        this.cell_oi = cell_oi;
    }

    public String getCell_vivo() {
        return cell_vivo;
    }

    public void setCell_vivo(String cell_vivo) {
        this.cell_vivo = cell_vivo;
    }

    public String getCell_tim() {
        return cell_tim;
    }

    public void setCell_tim(String cell_tim) {
        this.cell_tim = cell_tim;
    }

    public String getCell_claro() {
        return cell_claro;
    }

    public void setCell_claro(String cell_claro) {
        this.cell_claro = cell_claro;
    }

    public Integer getProfile() {
        return profile;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }
}
