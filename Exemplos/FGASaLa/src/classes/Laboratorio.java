/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 * 
 * @author Matheus Freire
 */

public class Laboratorio {
    private int idlab;
    private int nbancada;
    private int nporbancada;
    private String locallab;
    private String tipolab;

    public int getIdlab() {
        return idlab;
    }

    public void setIdlab(int idlab) {
        this.idlab = idlab;
    }

    public String getLocallab() {
        return locallab;
    }

    public void setLocallab(String locallab) {
        this.locallab = locallab;
    }

    public int getNbancada() {
        return nbancada;
    }

    public void setNbancada(int nbancada) {
        this.nbancada = nbancada;
    }

    public int getNporbancada() {
        return nporbancada;
    }

    public void setNporbancada(int nporbancada) {
        this.nporbancada = nporbancada;
    }

    public String getTipolab() {
        return tipolab;
    }

    public void setTipolab(String tipolab) {
        this.tipolab = tipolab;
    }
}
