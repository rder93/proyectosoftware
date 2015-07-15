/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.automatizado;

/**
 *
 * @author RICARDO
 */
public class Carreras {
    
    private String cod_carrera;
    private String nombre;

    public Carreras(String cod_carrera, String nombre) {
        this.cod_carrera = cod_carrera;
        this.nombre = nombre;
    }
    
    public Carreras(){
        
    }
    
    public String getCod_carrera() {
        return cod_carrera;
    }

    public void setCod_carrera(String cod_carrera) {
        this.cod_carrera = cod_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
