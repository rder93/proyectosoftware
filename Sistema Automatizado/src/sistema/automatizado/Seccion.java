/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.automatizado;

/**
 *
 * @author Irene
 */
public class Seccion {
    
    private int profesor;
    private String lapso;
    private String modalidad;
    private String status;
    private boolean publicado;
    private String cod_asignatura;
    private int nro;

    public Seccion(int profesor, String lapso, String modalidad, String status, boolean publicado, String cod_asignatura, int nro) {
        this.profesor = profesor;
        this.lapso = lapso;
        this.modalidad = modalidad;
        this.status = status;
        this.publicado = publicado;
        this.cod_asignatura = cod_asignatura;
        this.nro = nro;
    }

    
    public Seccion(){
        
    }
    
    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getCod_asignatura() {
        return cod_asignatura;
    }

    public void setCod_asignatura(String cod_asignatura) {
        this.cod_asignatura = cod_asignatura;
    }

    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }

    public String getLapso() {
        return lapso;
    }

    public void setLapso(String lapso) {
        this.lapso = lapso;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

   
}
