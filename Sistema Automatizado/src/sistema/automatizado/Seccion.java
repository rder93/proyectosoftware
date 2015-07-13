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
    
    private String profesor;
    private String lapso;
    private String modalidad;
    private String status;
    private boolean publicado;
    private String cod_asignatura;
    private int nro;

    public Seccion(String profesor, String lapso, String modalidad, String status, boolean publicado, String cod_asignatura, int nro) {
        this.profesor = profesor;
        this.lapso = lapso;
        this.modalidad = modalidad;
        this.status = status;
        this.publicado = publicado;
        this.cod_asignatura = cod_asignatura;
        this.nro = nro;
    }

    public Seccion(String profesor,String cod_asignatura,int nro){
        this.profesor = profesor;
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

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String id_profesor) {
        this.profesor = id_profesor;
    }
    
}
