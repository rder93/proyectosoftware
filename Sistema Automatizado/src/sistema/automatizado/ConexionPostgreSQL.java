
package sistema.automatizado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase que permite la conexión a la base de datos, en la cual están alojados los datos de los usuarios registrados en el sistema.
 * @author Stalin
 */
public class ConexionPostgreSQL {
    
    private String hostname;
    private String baseDeDatos;
    private String url;
    private String usuario;
    private String clave;
    private String puerto;
    
    /**
     * Constructor de la conexion a la base de datos a partir de los parametros dados
     * @param usuario
     * @param clave
     */
    public ConexionPostgreSQL(String usuario, String clave){
        this.hostname = "organiza2.sytes.net";
        this.baseDeDatos = "atlantico";
        this.puerto = "5432";
        this.url = "jdbc:postgresql://"+hostname+":"+puerto+"/"+baseDeDatos;
        this.usuario = usuario;
        this.clave = clave;
    }
    
    /**
     * Establece la conexion a la base de datos y devuelve el enlace a esta.
     * @return link;
     */
    public Connection conectar(){
        Connection link = null;
       
        try {
            Class.forName("org.postgresql.Driver");
            link = DriverManager.getConnection(url, usuario, clave);
            if (link != null) {
                //System.out.println("Conexión a la bd " + url + "....ok!!");
                //link.close();
            }
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null,"Driver JDBC no encontrado");
            //cnfe.printStackTrace();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,"Error al conectarse a la BD");
            //sqle.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error general");
            //e.printStackTrace();
        }
        
        return link;
    }
    
}
