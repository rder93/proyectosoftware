package sistema.automatizado;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sistema.automatizado.Ventana.usuario;



/**
 *
 * @author Irene - Stalin :P
 */
public class VentanaOfertaAcademica extends javax.swing.JFrame {
    
    boolean condicion = false; //variable control
    DefaultTableModel modelo = new DefaultTableModel();
    String [] secciones = new String [20];
    String auxAsignatura = "";
    String auxCod = "";
    int posicion = 0;
    int indiceFilaEditar = 0; //Ubicación de la fila que se desea editar
    ArrayList<Asignatura> asignaturas = new  ArrayList<Asignatura>();
    
    public VentanaOfertaDetalle ventanaDetalle = new VentanaOfertaDetalle(this);
    
    public Ventana padre;
    public static Usuario usuario;
    /**
     * Creates new form VentanaCargaData
     */
    
    public VentanaOfertaAcademica(Ventana padre) {
        initComponents();
       // this.setResizable(false);
        this.padre = padre;
        Image icono = Toolkit.getDefaultToolkit().getImage("logo.png");
        this.setIconImage(icono);
        setTitle("Oferta academica");
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(255,255,255));
        
        jComboBox1.removeAllItems(); //Materias
        
        jTable1.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Asignatura");
        modelo.addColumn("Nro. Secciones");
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        
        
    }

    private VentanaOfertaAcademica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 =  new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(13, 80, 175));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 41));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OFERTA ACADEMICA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jLabel2.setText("Asignatura");

        jLabel3.setText("Número de secciones:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Asignatura", "Nro. Secciones"
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminarlemento.png"))); // NOI18N
        jButton3.setText("ELIMINAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/lapiz.png"))); // NOI18N
        jButton4.setText("EDITAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/check.png"))); // NOI18N
        jButton5.setText("ACEPTAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("ASIGNAR PROFESOR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Docentes");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Asignaturas");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3))))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void limpiar(){
        
        jButton3.setVisible(false);//Ocultar boton eliminar
        jButton4.setVisible(true); //Restaurar boton editar
        jButton5.setVisible(false);//Ocultar boton listo
        jTextField1.setText(""); //Limpiar label secciones
        jComboBox1.setSelectedIndex(0); //Indicar posicion 0 al combo asignaturas
        cargarJTable(); //Para que la tabla se ajuste dependiendo de cada cambio
    }
    
    public void cargar(String usuario, String clave){
        
         //Aqui se almacena toda la informacion de las asignaturas
        asignaturas.clear();
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            String sql = "SELECT * "
                       + "FROM (asignaturas AS a LEFT OUTER JOIN departamentos AS d ON  a.departamento=d.cod_departamento) LEFT OUTER JOIN carreras AS c ON a.carrera=c.cod_carrera "
                       + "ORDER BY (nivel,cod_asignatura)";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                jComboBox1.addItem(rs.getString(2));
                
                Asignatura objAsignatura = new Asignatura(rs.getInt("nivel"), 
                                                          rs.getString("cod_asignatura"), 
                                                          rs.getInt("uc"), 
                                                          rs.getInt("horas_sem"), 
                                                          rs.getString(2), 
                                                          rs.getString(9), 
                                                          rs.getString(11));
                
                asignaturas.add(objAsignatura);
                
                
                
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    
    }    
    /**
     * Captura el número de secciones indicadas en el jTextField1
     */
    public void capturarNumeroSecciones(){
      
      int condicionVacio = 1;
      int aux = 0;
      if("".equals(jTextField1.getText())) condicionVacio = 0; // Si está vacío
      
      if(condicionVacio == 0){
          JOptionPane.showMessageDialog(rootPane,"Campo vacío", "ADVERTENCIA", 0);
      }else{
          try {
              //Se toma el número de secciones indicado
              aux = Integer.parseInt (jTextField1.getText());
              if(aux<0 || aux==0)
                JOptionPane.showMessageDialog(rootPane,"Verifique número de secciones", "ADVERTENCIA", 0);

          } catch (Exception e) {
              JOptionPane.showMessageDialog(rootPane,"Error en el ingreso de secciones", "ADVERTENCIA", 0);
          }
      }//fin else
    
    }
    
    /**
     * Valida las materias que ya han sido registradas
     */
    public boolean validarMateria(String auxMateria){
    
        for (int i = 0; i < padre.listaOferta.size(); i++) {
            
            if( padre.listaOferta.get(i).getAsignatura().equals(auxMateria) ){
                return false; //Ya fue registrada
            }   
        }
        return true; //No ha sido registrada
    }
    
    public int BuscarMateria(String auxMateria){
        for (int i = 0; i < asignaturas.size(); i++) {
            if( asignaturas.get(i).getNombre().equals(auxMateria) ){
                return i;   
            }
        }
        return -1;
    }
    
    
       
    /**
     * Refleja en el jTable1 la estructura
     */
    public void cargarJTable() {
        Seccion [] auxCadenaSecciones = new Seccion[14];
        this.modelo = (DefaultTableModel) jTable1.getModel();
        this.modelo.setNumRows(0);

        
        for (int i = 0; i < padre.listaOferta.size(); i++) {
                
            for (int j = 0; j < asignaturas.size(); j++) {
                
                if(padre.listaOferta.get(i).getAsignatura().equals(asignaturas.get(j).getCodigo())){
                    
                    Oferta aux = padre.listaOferta.get(i);
                    this.modelo.addRow(new Object[]{aux.getAsignatura(),asignaturas.get(j).getNombre(),aux.getNroSecciones()});
                   
                }
            }
            
        }
        
    }
    
    /**
     * Elimina la fila seleccionada con el mouse luego de hacer click en el boton jButton3
     */
    
    public void eliminarSeleccion(){
        
        //Item seleccionado
        int indiceFila = jTable1.getSelectedRow();
        //Se borra en el jtable
        this.modelo = (DefaultTableModel)jTable1.getModel();
        this.modelo.removeRow(indiceFila);
        //Se borra en la lista de objetos
        this.padre.listaOferta.remove(indiceFila);
    }
         
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        capturarNumeroSecciones();
        auxAsignatura = (String) jComboBox1.getSelectedItem();
        auxCod = asignaturas.get(BuscarMateria(auxAsignatura)).getCodigo()+"";
        
        OperacionesBD.addOferta(auxCod,Integer.parseInt(jTextField1.getText()),usuario.getNombre(),usuario.getClave());
       
       
       int auxSecciones = Integer.parseInt(jTextField1.getText());
       int elemento = BuscarMateria(auxAsignatura);
       
       if( validarMateria(auxAsignatura)==true ){
           
            //Nuevo objeto para insertar en la lista Oferta
           Oferta auxOferta = new Oferta(auxAsignatura,auxCod,auxSecciones);

            //Variable auxiliar para crear cadena de secciones
            //Se considera que existe un maximo de 14 secciones por x materia
            Seccion [] auxCadenaSecciones = new Seccion[14]; 

            for (int i = 0; i < 14; i++) {

                if(i< auxSecciones ){
                        
                        //True= de ser parte de las secciones que escogio
                        auxCadenaSecciones[i]=new Seccion(true,"Por asignar",auxCod);
                }else{
                        //False = de no ser parte de las secciones que escogio
                        auxCadenaSecciones[i]=new Seccion(false,"","");
                }
                /**
                 * Ejemplo: Si escoge 4
                 * Los primeros 4 son true
                 * Los siguientes 10 son false
                 **/
            }

            //Modificar el array secciones
            auxOferta.setSecciones(auxCadenaSecciones);

            //Insertar nuevo nodo objeto oferta
            padre.listaOferta.add(auxOferta);
            
            //AQUI SE DEBE CREAR EL OBJETO ASIGNATURA <---------------------
            
            limpiar();
        }else{
           JOptionPane.showMessageDialog(rootPane,"Esta materia ya fue registrada", "ADVERTENCIA", 0);
       }  

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(padre.listaOferta.size() ==0 || jTable1.getSelectedRow()==-1 ){
             JOptionPane.showMessageDialog(rootPane,"No se puede realizar esta acción", "ADVERTENCIA", 0);
        }else{
            eliminarSeleccion();
            limpiar();
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRow()==-1 ){
        
            JOptionPane.showMessageDialog(rootPane,"No se puede realizar esta acción", "ADVERTENCIA", 0);
        }else{
            indiceFilaEditar = jTable1.getSelectedRow();
            jTextField1.setVisible(true);
            jTextField1.setText(""+padre.listaOferta.get(jTable1.getSelectedRow()).getNroSecciones());
  
            jComboBox1.setSelectedItem(padre.listaOferta.get(jTable1.getSelectedRow()).getAsignatura());
            
            jButton4.setVisible(false);
            jButton5.setVisible(true);
            jButton3.setVisible(true);
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         try {
            
            //JOptionPane.showMessageDialog(rootPane,"No se puede realizar esta acción", "ADVERTENCIA", 0);
            
            if("".equals(jTextField1.getText())){
                JOptionPane.showMessageDialog(rootPane,"Ingresar secciones", "ADVERTENCIA", 0);
            }else{
                //Auxiliares para crear nuevo objeto Oferta
                int auxSecciones = Integer.parseInt(jTextField1.getText());
                auxAsignatura = (String) jComboBox1.getSelectedItem();
                auxCod = asignaturas.get(BuscarMateria(auxAsignatura)).getCodigo()+"";
                //Se crea nuevo objeto oferta 
                Oferta auxOferta = new Oferta(auxAsignatura,auxCod,auxSecciones);

                //Variable auxiliar para crear cadena de secciones
                //Se considera que existe un maximo de 14 secciones por x materia
                Seccion [] auxCadenaSecciones = new Seccion[14]; 

                for (int i = 0; i < 14; i++) {

                if(i< auxSecciones ){
                    
                    //True= de ser parte de las secciones que escogio
                    auxCadenaSecciones[i]=new Seccion(true,"Por asignar",auxCod);
                }else{

                    //False = de no ser parte de las secciones que escogio
                    auxCadenaSecciones[i]=new Seccion(false,"","");
                }
                /**
                 * Ejemplo: Si escoge 4
                 * Los primeros 4 son true
                 * Los siguientes 10 son false
                 **/
                }

                 //AQUI SE DEBE MODIFICAR EL OBJETO ASIGNATURA <---------------------
                
                //Modificar el array secciones
                auxOferta.setSecciones(auxCadenaSecciones);
                
                //Se inserta el nuevo objeto en la lista con el fin de reemplazar el anterior
                padre.listaOferta.set(indiceFilaEditar, auxOferta);
                capturarNumeroSecciones();
                OperacionesBD.setOferta(auxCod, auxSecciones, usuario.getNombre(), usuario.getClave());
                
            }
            
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Verifique campo secciones", "ADVERTENCIA", 0);
            //limpiar();
        }
       
    }//GEN-LAST:event_jButton5ActionPerformed

    
    //ESTOS DOS EVENTOS HAY QUE MODIFICARLOS
    
    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        padre.listaAsignaturas = OperacionesBD.getAsignaturas(usuario.getNombre(), usuario.getClave());
        
        if(padre.listaAsignaturas!=null){
            padre.ventanaAsignaturas.cargar();
            padre.ventanaAsignaturas.setVisible(true);
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        padre.listaDocente = OperacionesBD.getDocentes(usuario.getNombre(), usuario.getClave());
        
        if(padre.listaDocente!=null){
            padre.ventanadocente.cargar();
            padre.ventanadocente.setVisible(true);
        }
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ventanaDetalle.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(VentanaOfertaAcademica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaOfertaAcademica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaOfertaAcademica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaOfertaAcademica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaOfertaAcademica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
