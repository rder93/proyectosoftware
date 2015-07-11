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
public class Validaciones {
    
    public static boolean autenticarUsuario(String usuario, String clave){
        
        ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario,clave);
        
        if(conexion.conectar()!=null)
            return true;
        else
            return false;
    }
    
}
