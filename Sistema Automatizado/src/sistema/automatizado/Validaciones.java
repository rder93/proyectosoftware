/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.automatizado;

import javax.swing.JOptionPane;

/**
 *
 * @author RICARDO
 */
public class Validaciones {
    
    public static boolean autenticarUsuario(String usuario, String clave){
        
        ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario,clave);
        
        if(conexion.conectar()!=null)
            return true;
        else
            return false;
    }
    
    public static boolean validarAsignatura(String nombre, String uc, String horas, String carrera, String departamento, String nivel){
        
        
            if(verificarSoloNumeros(uc))
                if(verificarSoloNumeros(horas))
                    if(verificarSoloNumeros(carrera))
                        if(verificarSoloNumeros(departamento) || departamento.length()==0)
                            if(verificarSoloNumeros(nivel))
                                return true;
                            else{
                                JOptionPane.showMessageDialog(null, "El nivel debe ser un valor entero");
                                return false;
                            }
                        else{
                            JOptionPane.showMessageDialog(null, "El número de departamento debe ser un valor entero");
                            return false;
                        }
                    else{
                        JOptionPane.showMessageDialog(null, "El código de carrera debe ser un valor entero");
                        return false;
                    }
                else{
                    JOptionPane.showMessageDialog(null, "El número Horas debe ser un valor entero");
                    return false;
                }
            else{
                JOptionPane.showMessageDialog(null, "El número de UC debe ser un valor entero");
                return false;
            }
    }
    
    public static boolean validarPlantaFisica(String modulo, String id){
        
        if(verificarSoloNumeros(modulo)){
            if(verificarSoloNumeros(id))
                return true;
            else{
                JOptionPane.showMessageDialog(null, "El id solo debe contener numeros");
                return false;
            }
        }else{
                JOptionPane.showMessageDialog(null, "El modulo  solo debe contener numeros");
                return false;
            }
    
    }
    
    public static boolean verificarSoloNumeros(String cadena){
        
        if(cadena.length()==0){
            return false;
        }
        //Irene prueba algo q tu digas q da error lo viste
        //escucha la nota de voz conesen..
        for(int i = 0; i < cadena.length(); ++i){
            
            char caracter = cadena.charAt(i);
            
            if(!Character.isDigit(caracter)){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean verificarSoloLetras(String cadena){ 
        
        for(int i = 0; i < cadena.length(); ++i){
            
            char caracter = cadena.charAt(i);
            
            if(!Character.isLetter(caracter)){
                return false;
            }
        }
        return true;  
    }
    
    
}