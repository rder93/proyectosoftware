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
public class DistribubcionSemanal {
    
    private String asignatura;
    private int id_seccion;
    private int horasSemanales;
    private int horasDistribuidas;

    public DistribubcionSemanal(String asignatura, int id_seccion, int horasSemanales, int horasDistribuidas) {
        this.asignatura = asignatura;
        this.id_seccion = id_seccion;
        this.horasSemanales = horasSemanales;
        this.horasDistribuidas = horasDistribuidas;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getHorasDistribuidas() {
        return horasDistribuidas;
    }

    public void setHorasDistribuidas(int horasDistribuidas) {
        this.horasDistribuidas = horasDistribuidas;
    }
    
    
    
}
