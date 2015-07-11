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
    
    private String Asignatura;
    private int profesor;
    private int nroSecciones;
    private Seccion [] secciones = new Seccion[14]; 

    public Oferta(String Asignatura, int profesor, int nroSecciones) {
        this.secciones = new Seccion [14];
        this.Asignatura = Asignatura;
        this.profesor = profesor;
        this.nroSecciones = nroSecciones;
    }
   
    public Oferta() {
        this.secciones = new Seccion [14];
        this.Asignatura = "";
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
        return Asignatura;
    }

    public void setAsignatura(String Asignatura) {
        this.Asignatura = Asignatura;
    }

    public Seccion[] getSecciones() {
        return secciones;
    }

    public void setSecciones(Seccion[] secciones) {
        this.secciones = secciones;
    }
    
    
}
