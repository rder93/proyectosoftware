/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.automatizado;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        
        if(verificarNombre(nombre))
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
        else{
            return false;
        }
    }
    
    public static boolean validarPlantaFisica(String modulo, String id, String nombre){
        
        if(verificarSoloNumeros(modulo)){
            if(verificarSoloNumeros(id))
                if(verificarPatronAula(nombre))
                    return true;
                else
                    return false;
            else{
                JOptionPane.showMessageDialog(null, "El id solo debe contener numeros");
                return false;
            }
        }else{
                JOptionPane.showMessageDialog(null, "El modulo  solo debe contener numeros");
                return false;
        }
    
     }
    
    public static boolean verificarPatronAula(String nombre){
       
        
        Pattern pat = Pattern.compile("A-\\d\\d");
        Matcher mat = pat.matcher(nombre);
        if (mat.matches()) {
            if(nombre.charAt(2)=='0' && nombre.charAt(3)=='0' ){
                JOptionPane.showMessageDialog(null, "Las aulas deben comenzar a enumerarse del numero 01");
                return false;
            }
            else
                return true;
        } else {
            JOptionPane.showMessageDialog(null, "El nombre del aula debe tener el siguiente formato: A-##");
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
    
    public static boolean verificarNombre(String nombre){
        
        if(nombre.length()==0){
            JOptionPane.showMessageDialog(null, "El nombre es un campo obligatorio");
            return false;
        }
        
        if(!Character.isLetter(nombre.charAt(0))){
            JOptionPane.showMessageDialog(null, "El nombre debe empezar con una letra");
            return false;
        }
        
        for(int i = 0; i < nombre.length(); ++i){
            
            char caracter = nombre.charAt(i);
            
            if(Character.isDigit(caracter)){
               JOptionPane.showMessageDialog(null, "El nombre de la asignatura no debe contener numeros");
               return false;
            }
        }
        
        for(int i = 0; i < nombre.length(); ++i){
            
            char caracter = nombre.charAt(i);
            
            if(!Character.isSpaceChar(caracter)){
                if(!Character.isLetter(caracter))
                    if(!Character.isUpperCase(caracter)){
                        JOptionPane.showMessageDialog(null, "El nombre de la asignatura solo debe contener letras MAYUSCULAS");
                        return false;
                    }
            }
        }
        
        for(int i = 0; i < nombre.length(); ++i){
            
            char caracter = nombre.charAt(i);
            
            if(Character.isLetter(caracter)){
                if(!Character.isUpperCase(caracter)){
                    JOptionPane.showMessageDialog(null, "El nombre de la asignatura debe estar escrito en MAYUSCULAS");
                    return false;
                }
            }
        }
        
        
        return true;
    }
}