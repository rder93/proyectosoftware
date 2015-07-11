/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.automatizado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author RICARDO
 */
public class OperacionesBD {
    
    public static ArrayList<Docente> getDocentes(String usuario, String clave){
        
        ArrayList<Docente> docentes = new  ArrayList<Docente>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * FROM profesores ORDER BY nombre";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                Docente objDocente = new Docente(rs.getString("nombre"), rs.getString("cedula"), rs.getString("dedicacion"), rs.getString("area_conocimiento"));
                
                docentes.add(objDocente);
                
            }
           
            return docentes;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    
    public static ArrayList<Asignatura> getAsignaturas(String usuario, String clave){
        
        ArrayList<Asignatura> asiganturas = new  ArrayList<Asignatura>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * "
                       + "FROM (asignaturas AS a LEFT OUTER JOIN departamentos AS d ON  a.departamento=d.cod_departamento) LEFT OUTER JOIN carreras AS c ON a.carrera=c.cod_carrera "
                       + "ORDER BY (nivel,cod_asignatura)";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
  
                Asignatura objAsignatura = new Asignatura(rs.getInt("nivel"), rs.getInt("cod_asignatura"), rs.getInt("uc"), rs.getInt("horas_sem"), rs.getString(2), rs.getString(9), rs.getString(11));
                
                asiganturas.add(objAsignatura);
                
            }
           
            return asiganturas;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    public static ArrayList<PlantaFisica> getAulas(String usuario, String clave){
        
        ArrayList<PlantaFisica> plantafisica = new  ArrayList<PlantaFisica>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * "
                       + "FROM (aulas AS a LEFT OUTER JOIN edificios AS e ON  a.edificio=e.id_edificio)"
                       + "ORDER BY (id_aula)";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
  
               PlantaFisica objPlantaFisica = new PlantaFisica(rs.getInt(3),rs.getString("nombre"));
                
                plantafisica.add(objPlantaFisica);
                
            }
           
            return plantafisica;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    
    
    
    public static boolean addAsignatura(int codigo, int uc, int hora, String nombre, String carrera, String departamento, int nivel, String usuario, String clave ){
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "INSERT "
                       + "INTO asignaturas values('"+codigo+"','"+nombre+"',"+uc+","+hora+",'"+carrera+"',"+departamento+","+nivel+");";
            
            return st.executeUpdate(sql)>0;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
        }
    }
    
    
    public static boolean setAsignatura(int codigo, int uc, int hora, String nombre, String carrera, String departamento, int nivel, String usuario, String clave ){
        
        
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "UPDATE asignaturas "
                       + " SET uc = "+  uc+", " 
                       + "horas_sem = "+hora+", " 
                       + "nombre = '"+nombre+"', " 
                       + "nivel = "+nivel+", " 
                       + "departamento = "+departamento+", " 
                       + "carrera = '"+carrera+"' " 
                       + "WHERE cod_asignatura = '"+codigo+"'";
  
            return st.executeUpdate(sql)>0;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
        }
    }
    
    public static boolean deleteAsignatura(int codigo, String usuario, String clave ){
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "DELETE "
                       + "FROM asignaturas "
                       + "WHERE cod_asignatura='"+codigo+"'";
            
            return st.executeUpdate(sql)>0;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
        }
    }
    
}
