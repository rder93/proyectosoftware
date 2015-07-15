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
    
    public static ArrayList<Seccion> getSeccion(String usuario, String clave){
        
        ArrayList<Seccion> secciones = new  ArrayList<Seccion>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * FROM secciones";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                Seccion objSeccion = new Seccion(rs.getInt("profesor"), rs.getString("lapso"), 
                                                rs.getString("modalidad"), rs.getString("status"), 
                                                rs.getBoolean("publicado"), rs.getString("cod_asignatura"), 
                                                rs.getInt("n_seccion"));
                
                secciones.add(objSeccion);
                
            }
           
            return secciones;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    
    public static ArrayList<Oferta> getOferta(String usuario, String clave){
        
        ArrayList<Oferta> oferta = new  ArrayList<Oferta>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * FROM oferta_academica";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                Oferta objOferta = new Oferta(rs.getString("cod_asignatura"),"2015-01", rs.getInt("cant_secciones"));
                
                oferta.add(objOferta);
                
            }
           
            return oferta;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    
    public static ArrayList<Asignatura> getAsignaturas(String usuario, String clave){
        
        ArrayList<Asignatura> asignaturas = new  ArrayList<Asignatura>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * "
                       + "FROM (asignaturas AS a LEFT OUTER JOIN departamentos AS d ON  a.departamento=d.cod_departamento) LEFT OUTER JOIN carreras AS c ON a.carrera=c.cod_carrera "
                       + "ORDER BY (nivel,cod_asignatura)";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
  
                Asignatura objAsignatura = new Asignatura(rs.getInt("nivel"), rs.getString("cod_asignatura"), rs.getInt("uc"), rs.getInt("horas_sem"), rs.getString(2), rs.getString(9), rs.getString(11));
                
                asignaturas.add(objAsignatura);
                
            }
           
            return asignaturas;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    public static ArrayList<Carreras> getCarreras(String usuario, String clave){
        
        ArrayList<Carreras> carreras = new  ArrayList<Carreras>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * FROM carreras" ;
            ResultSet rs = st.executeQuery(sql);
            
            rs.next();
                
            Carreras objCarrera = new Carreras(rs.getString("cod_carrera"), rs.getString("nombre"));
                
            carreras.add(objCarrera);
                
            
           
            return carreras;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    public static ArrayList<Departamentos> getDepartamentos(String usuario, String clave){
        
        ArrayList<Departamentos> departamentos = new  ArrayList<Departamentos>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * FROM departamentos" ;
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                Departamentos objDepartamentos = new Departamentos(rs.getInt("cod_departamento"), rs.getString("nombre"));

                departamentos.add(objDepartamentos);
            
            }
            
            return departamentos;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    public static ArrayList<Sabana> getSabana(String usuario, String clave){
        
        ArrayList<Sabana> sabana = new  ArrayList<Sabana>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * FROM sabana" ;
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                
                Sabana objSabana = new Sabana(rs.getString("cod_asignatura"),rs.getString("lapso"),
                                             rs.getInt("n_seccion"), rs.getInt("id_aula"), rs.getInt("id_edificio"),
                                             rs.getString("dia"), rs.getInt("hr_inicio"), rs.getInt("hr_final"));

                sabana.add(objSabana);
            
            }
            
            return sabana;
            
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
                
  
               PlantaFisica objPlantaFisica = new PlantaFisica(rs.getInt(3),rs.getString("nombre"), rs.getString("id_aula"));
                
                plantafisica.add(objPlantaFisica);
                
            }
           
            return plantafisica;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    public static ArrayList<Areas> getAreas(String usuario, String clave){
        
        ArrayList<Areas> areas = new  ArrayList<Areas>();
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * FROM areas";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
  
               Areas objAreas = new Areas(rs.getInt("cod_area"),rs.getString("nombre"),rs.getInt("cod_departamento"));
                
                areas.add(objAreas);
                
            }
           
            return areas;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return null;
    }
    
    public static void addOferta(String codigo, int nSecciones, String usuario, String clave){
        
        try {
                ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
                Connection cn = conexion.conectar();
                Statement st = cn.createStatement();
                String sql = "INSERT "
                           + "INTO oferta_academica values('"+codigo+"','2015-01',"+nSecciones+")";

                st.executeUpdate(sql);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }
    }
    
    public static void addProfesor(int cedula, String nombre, int area_conocimiento, int dedicacion, String usuario, String clave ){
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "INSERT "
                       + "INTO profesores values("+cedula+",'"+nombre+"',"+area_conocimiento+","+dedicacion+");";
            
            st.executeUpdate(sql);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
 
        }
    }
    
    
    public static boolean addAsignatura(String codigo, int uc, int hora, String nombre, String carrera, String departamento, int nivel, String usuario, String clave ){
        
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
    
    public static boolean addAula(String modulo, String numero, String id_aula, String usuario, String clave ){

       
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "INSERT INTO aulas "
                       + "VALUES ("+id_aula+",'"+numero+"'," +modulo+")";
  
            st.executeUpdate(sql);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;  
        }
        
    }
    
    
    public static void setOferta(String codigo, int nSecciones, String usuario, String clave ){

        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "UPDATE oferta_academica "
                       + "SET lapso = '2015-01',"
                       + "cant_secciones = "+nSecciones+" "
                       + "WHERE cod_asignatura = '"+codigo+"'";
  
            st.executeUpdate(sql);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
        }
    }
    
    public static void setSeccion(int cedula, int nroSeccion, String cod_asignatura, String usuario, String clave ){

        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "UPDATE secciones "
                        + "SET profesor = "+cedula+" "
                        + "WHERE cod_asignatura = '"+cod_asignatura+"' AND "
                        + "n_seccion = "+nroSeccion+" ";
  
            st.executeUpdate(sql);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        
        }
    }

    
    public static boolean setAsignatura(String codigo, int uc, int hora, String nombre, String carrera, String departamento, int nivel, String usuario, String clave ){
        
        if(departamento.isEmpty())
            departamento="NULL";
        
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
    
    public static boolean setAula(String modulo, String numero, String id_aula, String usuario, String clave ){

       
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "UPDATE aulas "
                       + "SET nombre = '"+numero+"',"
                       + "edificio = "+modulo+" "
                       + "WHERE id_aula = '"+id_aula+"'";
  
            st.executeUpdate(sql);
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
    
    public static boolean deleteAula(String id_aula, String modulo, String usuario, String clave ){
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "DELETE "
                       + "FROM aulas "
                       + "WHERE id_aula = '"+id_aula+"' AND edificio="+modulo;
            
            
            
            return st.executeUpdate(sql)>0;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
        }
    }
    
    
    public static boolean deleteOferta(String codigo, int nSecciones, String usuario, String clave ){
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Connection cn2 = conexion.conectar();
            Statement st = cn.createStatement();
            Statement st2 = cn2.createStatement();
            String sql = "DELETE "
                       + "FROM oferta_academica "
                       + "WHERE cod_asignatura = '"+codigo+"'";
            String sql2 = "DELETE FROM secciones WHERE cod_asignatura='"+codigo+"'";
            
            st2.executeUpdate(sql2);
            return st.executeUpdate(sql)>0;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
        }
    }
    
    
    public static boolean deleteAsignatura(String codigo, String usuario, String clave ){
        
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
