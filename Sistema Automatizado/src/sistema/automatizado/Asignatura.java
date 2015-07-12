/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.automatizado;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Irene
 */
public class Asignatura {
    
    private String codigo;
    private int uc;
    private int horas;
    private String nombre;
    //private String tipo;
    private int nivel;
    private String departamento;
    private String carrera;
    private JTable tblCargaData;
    private DefaultTableModel modeloDeTabla;

    public Asignatura(int nivel, String codigo, int uc, int horas, String nombre, String departamento, String carrera) {
        this.codigo = codigo;
        this.uc = uc;
        this.horas = horas;
        this.nombre = nombre;
        this.nivel = nivel;
        this.departamento = departamento;
        this.carrera = carrera;
        this.tblCargaData = null;
        this.modeloDeTabla = null;
    }

   
    public Asignatura(JTable tblAsignatura) {
        this.tblCargaData = tblAsignatura;
        this.codigo = "";
        this.uc = 0;
        this.horas = 0;
        this.nombre = "";
        this.departamento = "";
        this.carrera = "";
        //this.tipo = "";
        this.nivel = 0;
        
        //Construcción a pie de la tabla que se va a mostrar
        //no tiene caso modificar la que esta en el frame VentanaAsignatura.java
        String datos[][]={};
        String columnas[]={"Nivel","Código","U.C.","Horas","Nombre","Departamento", "Carrera"};
        
        modeloDeTabla= new DefaultTableModel(datos,columnas){
            //Se impide que el usuario pueda alterar los datos sobre la tabla directamente,
            //para obligarlo a usar los campos de texto en conjunto con los botones,
            //ya que se hace más fácil controlar las operaciones con estos componentes. 
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        
        //Se sustituye el modelo que tiene la tabla del frama VentanaCargaData.java
        //con nuestro modelo creado anteriormente
        tblCargaData.setModel(modeloDeTabla);
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    public int getUc() {
        return uc;
    }

    public void setUc(int uc) {
        this.uc = uc;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel(){
        return nivel;
    }
    
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    
    public JTable getTblCargaData() {
        return tblCargaData;
    }

    public void setTblCargaData(JTable tblCargaData) {
        this.tblCargaData = tblCargaData;
    }

    public DefaultTableModel getModeloDeTabla() {
        return modeloDeTabla;
    }

    public void setModeloDeTabla(DefaultTableModel modeloDeTabla) {
        this.modeloDeTabla = modeloDeTabla;
    }
    
    
    
    public boolean agregar(String codigo, int uc, int hora, String nombre, int nivel, String departamento, String carrera){
        
        //Se obtiene la cantidad registros que se encuentran actualmente en la tabla
        int numFilas = tblCargaData.getRowCount();
        
        //Se inserta una nueva fila a la tabla
        modeloDeTabla.insertRow(numFilas,new Object[]{});
        
        //Se añaden valores a los campos de la fila recién insertada
        //específicando el valor, el numero de la fila y el numero de la columna
        modeloDeTabla.setValueAt(nivel,numFilas,0);
        modeloDeTabla.setValueAt(codigo,numFilas,1);
        modeloDeTabla.setValueAt(uc,numFilas,2);
        modeloDeTabla.setValueAt(hora,numFilas,3);
        modeloDeTabla.setValueAt(nombre,numFilas,4);
        modeloDeTabla.setValueAt(departamento,numFilas,5);
        modeloDeTabla.setValueAt(carrera,numFilas,6);
        
        return true;
    }
    
    
    /*
        Este método actualiza el registro seleccionado en la tabla tomando como parámetros
        los strings presentes en los campos de texto, recibe como parámetro posición de la fila seleccionada. 
    
    */
    
    public boolean modificar(String codigo, int uc, int hora, String nombre, int numFila, int nivel, String departamento, String carrera){
        
        //Se actualizan los valores de los campos de la fila que se va a modificar
        //específicando el nuevo valor, el numero de la fila y el numero de la columna
        
        modeloDeTabla.setValueAt(nivel,numFila,0);
        modeloDeTabla.setValueAt(codigo,numFila,1);
        modeloDeTabla.setValueAt(uc,numFila,2);
        modeloDeTabla.setValueAt(hora,numFila,3);
        modeloDeTabla.setValueAt(nombre,numFila,4);
        modeloDeTabla.setValueAt(departamento,numFila,5);
        modeloDeTabla.setValueAt(carrera,numFila,6);
        
        return true;
    }
    
    /*
        Este método elimina un registro de la tabla recibiendo como parámetro
        la posición de la fila seleccionada en la que se encuentra dicho registro.
       
    */
    public boolean eliminar(int numFila){
        
        //Se elimina el registro que se encuentre en la posición numFila.
        modeloDeTabla.removeRow(numFila);
        
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
