
package sistema.automatizado;
import java.util.ArrayList;
import sistema.automatizado.Sabana;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Irene
 */
public class DistribucionSabana {
    
    private String dia;
    ArrayList<Sabana> sabana = new  ArrayList<Sabana>();

    public DistribucionSabana(String dia) {
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public ArrayList<Sabana> getSabana() {
        return sabana;
    }

    public void setSabana(ArrayList<Sabana> sabana) {
        this.sabana = sabana;
    }
    
    public void addSabana(Sabana dato) {
        this.sabana.add(dato);
    }

    
}
