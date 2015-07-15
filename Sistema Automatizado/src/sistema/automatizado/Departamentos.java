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
public class Departamentos {
    
    private int cod_departamento;
    private String nombre;

    public Departamentos(int cod_departamento, String nombre) {
        this.cod_departamento = cod_departamento;
        this.nombre = nombre;
    }

    public Departamentos() {
    }

    public int getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(int cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
