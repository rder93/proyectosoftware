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
public class Oferta {
    
    private String asignatura;
    private String lapso;
    private int profesor;
    private int nroSecciones;
    private Seccion [] secciones = new Seccion[14]; 

    public Oferta(String asignatura, int profesores, int nroSecciones) {
        this.secciones = new Seccion [14];
        this.asignatura = asignatura;
        this.lapso = "2015-01";
        this.profesor = profesores;
        this.nroSecciones = nroSecciones;
    }

    public Oferta(String asignatura, String lapso, int profesor, int nroSecciones) {}{
        this.secciones = new Seccion [14];
        this.asignatura = asignatura;
        this.lapso = lapso;
        this.profesor = profesor;
        this.nroSecciones = nroSecciones;
    }
    
    public Oferta(String asignatura, String lapso, int nroSecciones){
        this.secciones = new Seccion [14];
        this.asignatura = asignatura;
        this.lapso = lapso;
        this.profesor = 0; //luego vemos esto...
        this.nroSecciones = nroSecciones;
    }
    
    public Oferta() {
        this.secciones = new Seccion [14];
        this.asignatura = "";
        this.lapso = "";
        this.profesor = 0;
        this.nroSecciones = 0;
    }   

    public int getNroSecciones() {
        return nroSecciones;
    }

    public void setNroSecciones(int nroSecciones) {
        this.nroSecciones = nroSecciones;
    }
    
    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }
    
    
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String Asignatura) {
        this.asignatura = Asignatura;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }

    public String getLapso() {
        return lapso;
    }

    public void setLapso(String lapso) {
        this.lapso = lapso;
    }

}
