/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sistema.automatizado;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Irene
 */
public class VentanaAsignatura extends javax.swing.JFrame {

    private Asignatura asignatura;
    
    public static Usuario usuario;
    public int auxCodDep;
    
    /**
     * Creates new form VentanaAsignatura
     */
    
    public Ventana padre;
    
    public VentanaAsignatura(Ventana padre) {
        initComponents();
        this.padre = padre;
        Image icono = Toolkit.getDefaultToolkit().getImage("logo.png");
        this.setIconImage(icono);
        setTitle("Lista  Asignatura");
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(255,255,255));
        
        //Se instancia la clase encargada de manipular la "Asignatura"
        //quedando enlazada directamente con la JTable de este formulario
        asignatura = new Asignatura(this.tblAsignatura);
        
        //Activar "Escuchador de teclas"
        escucharTeclas();
        
        //Activar "Escuchador" del mouse
        escucharMouse();
        
        //Evitar selección de múltiples registros
        tblAsignatura.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }

    private VentanaAsignatura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void limpiarTabla(JTable tabla){
         
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0; filas > i ; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        
    }

    
    public void cargar(){

        limpiarTabla(tblAsignatura);
        DefaultTableModel modelo = (DefaultTableModel)tblAsignatura.getModel();
        Carreras auxCarrera = padre.listaCarreras.get(0);
        
        for (int i = 0; i < padre.listaAsignaturas.size(); i++) {
            
            Asignatura aux = padre.listaAsignaturas.get(i);
            modelo.addRow(new Object[]{aux.getNivel(),aux.getCodigo(),aux.getUc(),aux.getHoras(),
                                aux.getNombre(),aux.getDepartamento(),auxCarrera.getNombre()});
            
        }

    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsignatura = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtUC = new javax.swing.JTextField();
        lblUC = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnLimpiarCampos = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtDepartamento = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        txtNivel = new javax.swing.JTextField();
        txtHoras = new javax.swing.JTextField();
        lblCodigo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblAsignatura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Carrera", "Nivel", "Código", "Nombre", "Departamento", "U.C.", "Horas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAsignatura);

        jPanel3.setBackground(new java.awt.Color(13, 80, 175));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 41));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LISTADO ASIGNATURAS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        lblCodigo.setText("Código:");

        lblUC.setText("U.C.:");

        lblNombre.setText("Nombre:");

        btnLimpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/limpiarcampos.png"))); // NOI18N
        btnLimpiarCampos.setToolTipText("Limpiar campos");
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAgregar.setToolTipText("Agregar al listado");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/refresh-32.png"))); // NOI18N
        btnModificar.setToolTipText("Refrescar listado");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/eliminarlemento.png"))); // NOI18N
        btnEliminar.setToolTipText("Eliminar elemento seleccionado");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblNombre1.setText("Departamento:");

        lblNivel.setText("Nivel:");

        lblCodigo1.setText("Horas:");

        jLabel2.setText("Carrera:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblUC)
                                    .addComponent(lblCodigo)
                                    .addComponent(lblNombre))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigo)
                                    .addComponent(txtUC)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNivel)
                                    .addComponent(lblCodigo1)
                                    .addComponent(lblNombre1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHoras)
                                    .addComponent(txtNivel)
                                    .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLimpiarCampos)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUC)
                            .addComponent(txtUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo1)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNivel)
                            .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre1)
                            .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiarCampos)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed

        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        //Se procede a ejecutar el método encargado de agregar un nuevo registro
        //tomando como parámetros l@s String de los campos de texto
        
        if(Validaciones.validarAsignatura(txtNombre.getText(), txtUC.getText(), txtHoras.getText(), txtCarrera.getText(), txtDepartamento.getText(), txtNivel.getText()))
            if(OperacionesBD.addAsignatura(txtCodigo.getText(), Integer.parseInt(txtUC.getText()),
                                        Integer.parseInt(txtHoras.getText()), txtNombre.getText(),txtCarrera.getText(),
                                        txtDepartamento.getText(), Integer.parseInt(txtNivel.getText()), usuario.getNombre(), usuario.getClave()))

                asignatura.agregar(txtCodigo.getText(), Integer.parseInt(txtUC.getText()), 
                                   Integer.parseInt(txtHoras.getText()), txtNombre.getText(), Integer.parseInt(txtNivel.getText()),
                                   txtDepartamento.getText(), txtCarrera.getText());
        limpiarCampos();
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        //Se verifica que exista una fila seleccionada para poder modificarla
        //se puede selecionar con el mouse o con las flehas del teclado
        if(Validaciones.validarAsignatura(txtNombre.getText(), txtUC.getText(), txtHoras.getText(), txtCarrera.getText(), txtDepartamento.getText(), txtNivel.getText()))
            if(tblAsignatura.getSelectedRow()<0)
                JOptionPane.showMessageDialog(this, "Debe seleccionar la fila que desea modificar");
            else{

                txtCodigo.setText(tblAsignatura.getModel().getValueAt(tblAsignatura.getSelectedRow(), 1).toString());

                if(OperacionesBD.setAsignatura(txtCodigo.getText(), Integer.parseInt(txtUC.getText()),
                                               Integer.parseInt(txtHoras.getText()), txtNombre.getText(),txtCarrera.getText(),
                                               txtDepartamento.getText(), Integer.parseInt(txtNivel.getText()), usuario.getNombre(), usuario.getClave()))

                    if(txtDepartamento.getText().equals(""))
                        asignatura.modificar(txtCodigo.getText(), Integer.parseInt(txtUC.getText()), 
                                         Integer.parseInt(txtHoras.getText()), txtNombre.getText(), tblAsignatura.getSelectedRow(), 
                                         Integer.parseInt(txtNivel.getText()),"", 
                                         padre.listaCarreras.get(0).getNombre());
                    else
                        asignatura.modificar(txtCodigo.getText(), Integer.parseInt(txtUC.getText()), 
                                         Integer.parseInt(txtHoras.getText()), txtNombre.getText(), tblAsignatura.getSelectedRow(), 
                                         Integer.parseInt(txtNivel.getText()),padre.listaDepartamentos.get(Integer.parseInt(txtDepartamento.getText())).getNombre(), 
                                         padre.listaCarreras.get(0).getNombre());

            }//aqui esta el erro al convertir el departamento vacio ""
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        //Se verifica que exista una fila seleccionada para poder eliminarla
        //se puede selecionar con el mouse o con las flehas del teclado
        if(!Validaciones.verificarSoloNumeros(txtCodigo.getText()))
            JOptionPane.showMessageDialog(this, "El código de la carrera debe ser un valor entero");
        else
            if(tblAsignatura.getSelectedRow()>=0){
                txtCodigo.setText(tblAsignatura.getModel().getValueAt(tblAsignatura.getSelectedRow(), 1).toString());
                int opcion = JOptionPane.showConfirmDialog(null, "¿Realmente desea eliminar este registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                //Si se confirma la eliminación del registro se procede a ejecutar la operación
                if(opcion==0){

                    if(OperacionesBD.deleteAsignatura(txtCodigo.getText(), 
                                                        usuario.getNombre(), 
                                                        usuario.getClave())){

                        asignatura.eliminar(tblAsignatura.getSelectedRow());
                        limpiarCampos();
                    }
                }
            }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    
    //Como su nombre lo indica con este método se limpian los campos de texto.
    public void limpiarCampos(){
        
        txtCodigo.setText("");
        txtUC.setText("");
        txtDepartamento.setText("");
        txtNombre.setText("");
        txtNivel.setText("");
        txtHoras.setText("");
        txtCarrera.setText("");
        
    }
    
    private void escucharTeclas(){
        
        tblAsignatura.addKeyListener( new KeyAdapter(){
            @Override
            public void keyReleased( KeyEvent e ){ 
                if( tblAsignatura.getSelectedRowCount() > 0 ){ 
                    if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN){
                        
                        if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),0)!=null)
                            txtNivel.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),0).toString());
                        else
                            txtNivel.setText("");

                        if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),1)!=null)
                            txtCodigo.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),1).toString());
                        else
                            txtCodigo.setText("");

                        if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),2)!=null)
                            txtUC.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),2).toString());
                        else
                            txtUC.setText("");

                        if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),3)!=null)
                            txtHoras.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),3).toString());
                        else
                            txtHoras.setText("");

                        if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),4)!=null)
                            txtNombre.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),4).toString());
                        else
                            txtNombre.setText("");

                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),5)!=null)
                        
                        for (int i = 0; i < padre.listaDepartamentos.size() ; i++) {
                                
                            if(padre.listaAsignaturas.get(tblAsignatura.getSelectedRow()).getDepartamento().equals(padre.listaDepartamentos.get(i).getNombre())){
                                txtDepartamento.setText(""+padre.listaDepartamentos.get(i).getCod_departamento());
                                auxCodDep = i;
                            }
                                
                        }
                            //txtDepartamento.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),5).toString());
                    else
                        txtDepartamento.setText("");   

                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),6)!=null)
                        txtCarrera.setText(padre.listaCarreras.get(0).getCod_carrera());
                            //txtCarrera.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),6).toString());
                    else
                        txtCarrera.setText("");   
                    }
                }
            }
        });
    
    }
    
    //Método "Escuchador" del mouse para actualizar los campos del registro seleccionado"
    
    private void escucharMouse(){
        tblAsignatura.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                
                if( tblAsignatura.getSelectedRowCount() > 0 ){
                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),0)!=null)
                        txtNivel.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),0).toString());
                    else
                        txtNivel.setText("");
                    
                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),1)!=null)
                        txtCodigo.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),1).toString());
                    else
                        txtCodigo.setText("");
                    
                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),2)!=null)
                        txtUC.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),2).toString());
                    else
                        txtUC.setText("");
                    
                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),3)!=null)
                        txtHoras.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),3).toString());
                    else
                        txtHoras.setText("");
                    
                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),4)!=null)
                        txtNombre.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),4).toString());
                    else
                        txtNombre.setText("");
                        
                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),5)!=null)
                        
                        for (int i = 0; i < padre.listaDepartamentos.size() ; i++) {
                                
                            if(padre.listaAsignaturas.get(tblAsignatura.getSelectedRow()).getDepartamento().equals(padre.listaDepartamentos.get(i).getNombre())){
                                txtDepartamento.setText(""+padre.listaDepartamentos.get(i).getCod_departamento());
                                auxCodDep = i;
                            }
                                
                        }
                            //txtDepartamento.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),5).toString());
                    else
                        txtDepartamento.setText("");    
                    
                    if(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),6)!=null)
                        txtCarrera.setText(padre.listaCarreras.get(0).getCod_carrera());
                        //txtCarrera.setText(asignatura.getModeloDeTabla().getValueAt(tblAsignatura.getSelectedRow(),6).toString());
                    else
                        txtCarrera.setText("");

                }   
            }
        });
        
    }
    
    
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
            java.util.logging.Logger.getLogger(VentanaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAsignatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAsignatura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigo1;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblUC;
    private javax.swing.JTable tblAsignatura;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUC;
    // End of variables declaration//GEN-END:variables
}
