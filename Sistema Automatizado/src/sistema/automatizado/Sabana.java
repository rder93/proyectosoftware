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
public class Sabana {
    private String asignatura;
    private String lapso;
    private int id_seccion;
    private int aula;
    private int modulo;
    private String dia;
    private int horaInicial;
    private int horaFinal;

    public Sabana(String asignatura, String lapso, int id_seccion, 
                  int aula, int modulo, String dia, 
                  int horaInicial, int horaFinal) {
        this.asignatura = asignatura;
        this.lapso = lapso;
        this.id_seccion = id_seccion;
        this.aula = aula;
        this.modulo = modulo;
        this.dia = dia;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getLapso() {
        return lapso;
    }

    public void setLapso(String lapso) {
        this.lapso = lapso;
    }

    public int getId_seccion() {
        return id_seccion;
    }

    public void setId_seccion(int id_seccion) {
        this.id_seccion = id_seccion;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }

    
    
}
