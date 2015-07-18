/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.automatizado;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import static sistema.automatizado.VentanaOfertaAcademica.usuario;

/**
 *
 * @author Irene
 */
public class VentanaOfertaDetalle extends javax.swing.JFrame {

    /**
     * Creates new form VentanaOfertaDetalle
     */
   
    
    DefaultTableModel modelo = new DefaultTableModel();
    
  //  public ArrayList<Seccion> listaSeccion = new  ArrayList<Seccion>();
  //  public ArrayList<Asignatura> listaAsignaturas = new  ArrayList<Asignatura>();
   // public ArrayList<Docente> listaDocentes = new ArrayList<Docente> ();
    
    public static Oferta oferta;
    //public Ventana padre;
    //public static Usuario usuario;
    VentanaOfertaAcademica padre;
    
    public VentanaOfertaDetalle(VentanaOfertaAcademica padre) {
        initComponents();
        this.padre = padre;
        Image icono = Toolkit.getDefaultToolkit().getImage("logo.png");
        this.setIconImage(icono);
        setTitle("Detalle asignatura");
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(255,255,255));
        
        jTable1.setModel(modelo);

    }

    private VentanaOfertaDetalle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    /**
     * Limpia el modelo de la tabla
     * @param tabla 
     */
    
    public void limpiarTabla(JTable tabla){
         
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            
            int filas=tabla.getRowCount();
            for (int i = 0; filas > i ; i++) {
                modelo.removeRow(0);
            }
            
            jTable1.setModel(new DefaultTableModel());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        
    }
    
    /**
     * Genera las columnas de forma dinamica, dependiendo de la  cantidad de secciones ofertada
     */
     
    
    public void generarColumnas(){
    
            limpiarTabla(jTable1);
            
            
            if(oferta.getNroSecciones() != 0){
                int j = 0;
                String [] secciones = new String [14];
                modelo = (DefaultTableModel) jTable1.getModel();
                modelo.setNumRows(0);
                TableColumn columna;
                
                
                
                for (int i = 0 ; i < padre.listaSeccion.size(); i++) {
                    
                    if(oferta.getCodigo().equals(padre.listaSeccion.get(i).getCod_asignatura() )){
                      
                            secciones[j]="Seccion "+padre.listaSeccion.get(i).getNro();
                            modelo.addColumn(""+secciones[j]);
                            columna = jTable1.getColumn(""+secciones[j]);
                            j++;
                    
                    }
                }

                jTable1.setModel(modelo);

                cargar();
            }else{
                JOptionPane.showMessageDialog(rootPane,"No existe oferta para esta materia", "ADVERTENCIA", 0);
            }
    }
    
    /**
     * Carga los combo box 
     * @param oferta estructura de la cual se obtiene los nombres de las asignaturas
     *               y los numeros de las secciones
     */
    
    public void cargarjComboBox2(Oferta oferta){
       
        this.oferta = oferta;
        jLabel2.setText(""+oferta.getCodigo());
        jComboBox2.removeAllItems();
        jComboBox1.removeAllItems();
        
        for (int i = 0; i < padre.listaDocentes.size(); i++){
            jComboBox2.addItem(padre.listaDocentes.get(i).getNombre());
        }
        
        for (int i = 0; i < oferta.getNroSecciones(); i++) {
            jComboBox1.addItem(""+(i+1));
        }
        
        
        
        generarColumnas();
        
    }
    
     
     /**
      * Busca un profesor partiendo de una cedula
      * @param cedula del profesor a buscar
      * @return el nombre del profesor, en dado caso no exista null
      */
     public String buscarProfesor(int cedula){
         
         for (int i = 0; i < padre.listaDocentes.size(); i++) {
             if(cedula ==Integer.parseInt(padre.listaDocentes.get(i).getCi()))
                 return padre.listaDocentes.get(i).getNombre();
         }
         return null;
     }

     /**
      * Ordena el string auxProfesores en el orden correspondiente a sus secciones
      */
     
     public String [] ordernarPorSecciones( String [] auxProfesores){
         
        
        String auxNombre = ""; //variable auxiliar para guardar un nombre
        
        int [] A = new int[14]; //vector auxiliar para guardar todos los nros de secciones
        int aux; //variable auxiliar para guardar una seccion
         
        //Se rellena con numeros altos para que así no hayan posiciones que se rellenen con 0
        for (int i = 0; i < A.length; i++) {
             A[i] = 100;
        }
        
        //Se colocan los numeros de las secciones en orden secuencial 
        int posicion = 0;
        for (int i = 0; i < padre.listaSeccion.size()  ; i++)     
             if(oferta.getCodigo().equals(padre.listaSeccion.get(i).getCod_asignatura())){
                 
                if(padre.listaSeccion.get(i).getProfesor() == 0){
                     auxProfesores[posicion] = "Por Asignar";
                     A[posicion] = padre.listaSeccion.get(i).getNro();
                }else{
                    auxProfesores[posicion] = buscarProfesor(padre.listaSeccion.get(i).getProfesor())+" - "+padre.listaSeccion.get(i).getModalidad();
                    A[posicion] = padre.listaSeccion.get(i).getNro();
                }
                posicion++;   
             }

        
        //Se somete el vector a un ordenamiento, quedando los 100 en las ultimas posiciones
        for (int k = 0; k < A.length-1; k++) {
            for (int j = 0; j < A.length-k-1; j++) {
                if(A[j+1] < A[j]){
                    
                    aux = A[j];
                    auxNombre = auxProfesores[j];
                    
                    A[j] = A[j+1];
                    auxProfesores[j] = auxProfesores[j+1];
                    
                    A[j+1] = aux;
                    auxProfesores[j+1] = auxNombre;
                }//fin if
            }//fin for interno
        }//fin for externo
        
        return auxProfesores;
     }
     /**
      * Encargado de dar estructura al modelo del jtable1
      */
     public void cargar(){

         String [] auxProfesores = new String[14];
         modelo = (DefaultTableModel) jTable1.getModel();
         this.modelo.setNumRows(0);
         
         int posicion = 0;
         auxProfesores =  ordernarPorSecciones( auxProfesores);         
         
         
         modelo.addRow(new Object[]{(auxProfesores[0]==null)?"Por Asignar":auxProfesores[0],
                                    (auxProfesores[1]==null)?"Por Asignar":auxProfesores[1],
                                    (auxProfesores[2]==null)?"Por Asignar":auxProfesores[2],
                                    (auxProfesores[3]==null)?"Por Asignar":auxProfesores[3],
                                    (auxProfesores[4]==null)?"Por Asignar":auxProfesores[4],
                                    (auxProfesores[5]==null)?"Por Asignar":auxProfesores[5],
                                    (auxProfesores[6]==null)?"Por Asignar":auxProfesores[6],
                                    (auxProfesores[7]==null)?"Por Asignar":auxProfesores[7],
                                    (auxProfesores[8]==null)?"Por Asignar":auxProfesores[8],
                                    (auxProfesores[9]==null)?"Por Asignar":auxProfesores[9],
                                    (auxProfesores[10]==null)?"Por Asignar":auxProfesores[10],
                                    (auxProfesores[11]==null)?"Por Asignar":auxProfesores[11],
                                    (auxProfesores[12]==null)?"Por Asignar":auxProfesores[12],
                                    (auxProfesores[13]==null)?"Por Asignar":auxProfesores[13],
                                    });
                                    /**
                                     * Si no existe profesor asignado (null) se indica que aun esta por asignar
                                     * de lo contrario se muestra el profesor asignado
                                     */
         
        
     }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(13, 80, 175));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 41));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DETALLE ASIGNATURA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        jLabel2.setText("ASIGNATURA");

        jLabel3.setText("Código asignatura:");

        jLabel5.setText("Sección:");

        jButton1.setText("Agregar profesor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombre:");

        jLabel4.setText("Modalidad:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Presencial", "Semi-Presencial", "Virtual", "Tutorial" }));

        jButton2.setText("Cerrar Seccion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(299, 299, 299))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int cedula = Integer.parseInt(padre.listaDocentes.get(jComboBox2.getSelectedIndex()).getCi());
            int auxSeccion = jComboBox1.getSelectedIndex()+1;
            String auxModalidad = jComboBox3.getSelectedItem().toString();
            
            OperacionesBD.setSeccion(cedula,auxSeccion,oferta.getCodigo(),auxModalidad, padre.usuario.getNombre(), padre.usuario.getClave());
            padre.listaSeccion = OperacionesBD.getSeccion(padre.usuario.getNombre(), padre.usuario.getClave());
            
            //Se refresca la tabla
            //limpiarTabla(jTable1);
            
            cargar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Por favor revise la cédula introducida", "ADVERTENCIA", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        // TODO add your handling code here:
         //int row = this.jTable1.getSelectedRow();
        TableColumnModel tbc = jTable1.getColumnModel();

         int column = this.jTable1.getSelectedColumn();
         TableColumn columna = tbc.getColumn(column);
         int auxColumn = 0;
         System.out.println("Inicial"+column);
         for (int i = 0; i < padre.listaSeccion.size(); i++) {
            
             if(oferta.getCodigo().equals(padre.listaSeccion.get(i).getCod_asignatura())){
                 if(auxColumn == column){

                     /*System.out.println(""+ padre.listaSeccion.size());
                     System.out.println(" "+padre.listaSeccion.get(i).getCod_asignatura());
                     System.out.println(" "+padre.listaSeccion.get(i).getNro());
                     System.out.println(""+ padre.listaSeccion.get(i).getLapso());
*/
                     
                     tbc.removeColumn(columna);
                     
                     
                     OperacionesBD.deleteSeccion(padre.listaSeccion.get(i).getCod_asignatura(), 
                                                 padre.listaSeccion.get(i).getLapso(), 
                                                 padre.listaSeccion.get(i).getNro(), 
                                                 usuario.getNombre(), usuario.getClave()); 
                     
                     OperacionesBD.setOferta(oferta.getCodigo(),
                                            (oferta.getNroSecciones()-1),
                                            usuario.getNombre(), usuario.getClave());
                     
                     padre.listaSeccion = OperacionesBD.getSeccion(usuario.getNombre(), usuario.getClave());
                     //oferta = OperacionesBD.getOferta(usuario.getNombre(), usuario.getClave());
                     

                     generarColumnas();

                     jComboBox1.removeAllItems();
                     for (int j = 0; j < oferta.getNroSecciones(); j++) {
                        jComboBox1.addItem(""+(j+1));
                    }
                     
                 }
                 auxColumn++;
                 
                 
             }
             System.out.println(""+auxColumn);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaOfertaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaOfertaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaOfertaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaOfertaDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaOfertaDetalle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
