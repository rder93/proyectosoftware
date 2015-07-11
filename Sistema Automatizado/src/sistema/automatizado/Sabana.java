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
    private String materia;
    private String modulo;
    private String aula;
    private int bhora;

    public Sabana(String materia, String modulo, String aula, int bhora) {
        this.materia = materia;
        this.modulo = modulo;
        this.aula = aula;
        this.bhora = bhora;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getBhora() {
        return bhora;
    }

    public void setBhora(int bhora) {
        this.bhora = bhora;
    }

    
    
    
}
