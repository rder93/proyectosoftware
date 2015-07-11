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
public class Docente {
    
    private String nombre;
    private String ci;
    private String dedicacion;
    private String areaconocimiento;
    private JTable tblCargaData;
    private DefaultTableModel modeloDeTabla;

    public Docente(String nombre, String ci, String dedicacion, String areaconocimiento) {
        this.nombre = nombre;
        this.ci = ci;
        this.dedicacion = dedicacion;
        this.areaconocimiento = areaconocimiento;
        this.tblCargaData = null;
        this.modeloDeTabla = null;
    }

    

    public Docente(JTable tblCargaData) {
        this.tblCargaData = tblCargaData;
        this.nombre = "";
        this.ci = "";
        this.dedicacion = "";
        this.areaconocimiento = "";
        
        //Construcción a pie de la tabla que se va a mostrar
        //no tiene caso modificar la que esta en el frame VentanaDocente.java
        String datos[][]={};
        String columnas[]={"Nombre","C.I.","Dedicación","Area de conocimiento"};
        
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

    public String getAreaconocimiento() {
        return areaconocimiento;
    }

    public void setAreaconocimiento(String areaconocimiento) {
        this.areaconocimiento = areaconocimiento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getDedicacion() {
        return dedicacion;
    }

    public void setDedicacion(String dedicacion) {
        this.dedicacion = dedicacion;
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
    
    public void setTodo(String nombre, String ci, String dedicacion) {
        this.nombre = nombre;
        this.ci = ci;
        this.dedicacion = dedicacion;
    }
    
   
    public boolean agregar(String nombre, String ci, String dedicacion, String areaconocimiento ){
        
        //Se obtiene la cantidad registros que se encuentran actualmente en la tabla
        int numFilas = tblCargaData.getRowCount();
        
        //Se inserta una nueva fila a la tabla
        modeloDeTabla.insertRow(numFilas,new Object[]{});
        
        //Se añaden valores a los campos de la fila recién insertada
        //específicando el valor, el numero de la fila y el numero de la columna
        modeloDeTabla.setValueAt(nombre,numFilas,0);
        modeloDeTabla.setValueAt(ci,numFilas,1);
        modeloDeTabla.setValueAt(dedicacion,numFilas,2);
        modeloDeTabla.setValueAt(areaconocimiento, numFilas, 3);
        
        return true;
    }
    
    
    /*
        Este método actualiza el registro seleccionado en la tabla tomando como parámetros
        los strings presentes en los campos de texto, recibe como parámetro posición de la fila seleccionada. 
    
    */
    
    public boolean modificar(String nombre, String ci, String dedicacion, int numFila){
        
        //Se actualizan los valores de los campos de la fila que se va a modificar
        //específicando el nuevo valor, el numero de la fila y el numero de la columna
        
        modeloDeTabla.setValueAt(nombre,numFila,0);
        modeloDeTabla.setValueAt(ci,numFila,1);
        modeloDeTabla.setValueAt(dedicacion,numFila,2);;
        
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
