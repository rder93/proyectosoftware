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
    
    private boolean indicador;
    private String profesor;
    private String cod_asignatura;        

    public Seccion(boolean indicador, String profesor) {
        this.indicador = indicador;
        this.profesor = profesor;
    }

    public Seccion(boolean indicador, String profesor, String cod_asignatura) {
        this.indicador = indicador;
        this.profesor = profesor;
        this.cod_asignatura = cod_asignatura;
    }
    
    public Seccion() {
        this.indicador = false;
        this.profesor = "";
    }
    
    public boolean isIndicador() {
        return indicador;
    }

    public void setIndicador(boolean indicador) {
        this.indicador = indicador;
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

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    
    
    
}
