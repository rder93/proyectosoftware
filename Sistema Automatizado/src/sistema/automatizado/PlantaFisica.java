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
public class PlantaFisica {
    
    private int modulo;
    private String numero;
    private String id;
    private JTable tblCargaData;
    private DefaultTableModel modeloDeTabla;

    public PlantaFisica(int modulo,String numero, String id) {
        this.modulo = modulo;
        this.numero = numero;
        this.id = id;
    }

    public PlantaFisica(JTable tblCargaData) {
        this.tblCargaData = tblCargaData;
        this.modulo = 0;
        this.numero = "";
        
        
        //Construcción a pie de la tabla que se va a mostrar
        //no tiene caso modificar la que esta en el frame VentanaCargaData.java
        String datos[][]={};
        String columnas[]={"Módulo","Número","Id"};
        
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
    
    
    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    
    public boolean agregar(int modulo, String numero, String tipo ){
        
        //Se obtiene la cantidad registros que se encuentran actualmente en la tabla
        int numFilas = tblCargaData.getRowCount();
        
        //Se inserta una nueva fila a la tabla
        modeloDeTabla.insertRow(numFilas,new Object[]{});
        
        //Se añaden valores a los campos de la fila recién insertada
        //específicando el valor, el numero de la fila y el numero de la columna
        modeloDeTabla.setValueAt(modulo,numFilas,0);
        modeloDeTabla.setValueAt(numero,numFilas,1);
        modeloDeTabla.setValueAt(tipo,numFilas,2);
        
        return true;
    }
    
    
    /*
        Este método actualiza el registro seleccionado en la tabla tomando como parámetros
        los strings presentes en los campos de texto, recibe como parámetro posición de la fila seleccionada. 
    
    */
    
    public boolean modificar(int modulo, String numero, String tipo, int numFila){
        
        //Se actualizan los valores de los campos de la fila que se va a modificar
        //específicando el nuevo valor, el numero de la fila y el numero de la columna
        
        modeloDeTabla.setValueAt(modulo,numFila,0);
        modeloDeTabla.setValueAt(numero,numFila,1);
        modeloDeTabla.setValueAt(tipo,numFila,2);
        
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
