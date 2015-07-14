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
public class Areas {
    
    private int cod_area;
    private String nombre;
    private int cod_departamento;

    public Areas() {
    }

    public Areas(int cod_area, String nombre, int cod_departamento) {
        this.cod_area = cod_area;
        this.nombre = nombre;
        this.cod_departamento = cod_departamento;
    }

    public int getCod_area() {
        return cod_area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(int cod_departamento) {
        this.cod_departamento = cod_departamento;
    }
    
    
    
    
}
