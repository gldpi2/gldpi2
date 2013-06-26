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
    private String name;
    private String idRegister;
    private String password;
    private String email;
    private String cell_oi;
    private String cell_vivo;
    private String cell_tim;
    private String cell_claro;
    private Integer idProfile;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getIdRegister() {
        return idRegister;
    }
    
    public void setIdRegister(String idRegister) {
        this.idRegister = idRegister;
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
    
    public Integer getIdProfile() {
        return idProfile;
    }
    
    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }
    
}
