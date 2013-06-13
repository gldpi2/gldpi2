package classes;

import java.util.Date;
/**
 *
 * @author itallorossi
 */
public class Reserva {
    private int idreserva;
    private String idusuario;
    private int idsala;
    private int idlab;
    private int diasemana;
    private Date data;
    private int hora;
    private int nbacanda;
    private String status;

    public int getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(int diasemana) {
        this.diasemana = diasemana;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
   
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getIdlab() {
        return idlab;
    }

    public void setIdlab(int idlab) {
        this.idlab = idlab;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public int getNbacanda() {
        return nbacanda;
    }

    public void setNbacanda(int nbacanda) {
        this.nbacanda = nbacanda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
