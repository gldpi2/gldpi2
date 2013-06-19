/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fernando
 */
public class MedicaoDao {
    private String tensao;
    private String corrente;
    private String frequencia;
    private String tempo;
    private String fatorDePotencia;
    private String potenciaAtiva;

    public void setTensao(String tensao) {
        this.tensao = tensao;
    }

    public void setCorrente(String corrente) {
        this.corrente = corrente;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public void setFatorDePotencia(String fatorDePotencia) {
        this.fatorDePotencia = fatorDePotencia;
    }

    public void setPotenciaAtiva(String potenciaAtiva) {
        this.potenciaAtiva = potenciaAtiva;
    }

    public String getTensao() {
        return tensao;
    }

    public String getCorrente() {
        return corrente;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public String getTempo() {
        return tempo;
    }

    public String getFatorDePotencia() {
        return fatorDePotencia;
    }

    public String getPotenciaAtiva() {
        return potenciaAtiva;
    }
    
    
    
}
