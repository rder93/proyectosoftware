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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Irene
 */
public class VentanaSabana extends javax.swing.JFrame {

    /**
     * Creates new form VentanaDistribucion
     */
    
    public Ventana padre;
    public static Usuario usuario;
    
    ArrayList<Asignatura> asignaturas = new  ArrayList<Asignatura>();
    ArrayList<String> dias = new  ArrayList<String>();
    DefaultTableModel modelo = new DefaultTableModel();
    int posicionDia = 0; //Posicion del dia selccionado
    
    public VentanaConfirmacionDatos ventanaConfirmacionDatos = new VentanaConfirmacionDatos(this);
    
    public VentanaSabana(Ventana padre) {
        initComponents();
        this.padre = padre;
        Image icono = Toolkit.getDefaultToolkit().getImage("logo.png");
        this.setIconImage(icono);
        this.setTitle("Crear Sabana");
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new java.awt.Color(255,255,255));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        jButton5.setOpaque(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);
        
        jButton6.setOpaque(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);
        
        cargarDias();
       
        jLabel2.setText(dias.get(posicionDia));
        
        
    }

    private VentanaSabana() {
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

        jMenuItem3 = new javax.swing.JMenuItem();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/left.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MIERCOLES");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/right.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(13, 80, 175));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 41));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CREAR SABANA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"7:00 a 7:50", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"7:50 a 8:40", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"8:45 a 9:35", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"9:35 a 10:25", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"10:30 a 11:20", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"11:20 a 12:10  ", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"1:10 a 2:00", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"2:00 a 2:50", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"2:55 a 3:45", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"3:45 a 4:35", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"4:40 a 5:30", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"5:30 a 6:20", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"6:20 a 7:10", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"7:15 a 8:05", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"8:05 a 8:55", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"8:55 a 9:45", null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Hora", "Aula 1", "Aula 2", "Aula 3", "Aula 4", "Aula 5", "Aula 6", "Aula 9", "Aula 10", "Aula 11", "Aula 12", "Aula 13", "Aula 14", "Aula 15"
            }
        ));
        jTable1.setCellSelectionEnabled(true);
        jTable1.setRowHeight(50);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        jLabel1.setText("Asignaturas:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nivel", "Código", "UC", "Horas"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Ver Detalles");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("NOMBRE USUARIO ");

        jLabel5.setText("CARRERA");

        jLabel6.setText("LAPSO ACADEMICO");

        jButton2.setText("Agregar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });

        jLabel7.setText("Nro. secciones:");

        jButton3.setText("Limpiar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });

        jMenu4.setText("Archivo");

        jMenuItem1.setText("Limpiar este día");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem4.setText("Limpiar sabana");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("Asignaturas");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Aulas/Lab");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addGap(5, 5, 5)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Carga el combobox con las secciones que se han creado para esa materia
     */
    public void cargarjComboBox2(int tamano){
        jComboBox2.removeAllItems();
        for (int i = 0; i < tamano; i++) {
            jComboBox2.addItem(i+1);
        }
    }
    /**
     *  Limpiar los combo box y la tabla
     */
    public void limpiar(){
        
        jComboBox1.removeAllItems(); //Materias
        jComboBox2.removeAllItems(); //secciones
        this.modelo.setNumRows(0);
        
    }
    
    public int buscarDia(String dia){
    
        switch (dia) {
            
            case "Lunes":
                    return 0;
            case "Martes":  
                    return 1;
            case "Miercoles":  
                    return 2;
            case "Jueves":  
                    return 3;
            case "Viernes":  
                    return 4;
            case "Sabado":  
                   return 5;
            case "Domingo":  
                    return 6;
            default: return -1;
        }
    
    }
    
    
    /**
     * Retorna el nivel de una materia partiendo de un codigo
     */
    
    public int buscarSemestre(String codigo){
    
        for (int i = 0; i < padre.listaAsignaturas.size(); i++) {
            if( (padre.listaAsignaturas.get(i).getCodigo()).equals(codigo)){
                return (padre.listaAsignaturas.get(i).getNivel()+1);
                //Se le suma +1 al nivel para obtener el semestre
            }
        }
        
        return -1; //error
    }
    
    /**
     * Retorna el nombre de una materia partiendo de un codigo
     */
    
    public String buscarNombre(String codigo){
    
        for (int i = 0; i < padre.listaAsignaturas.size(); i++) {
            if( (padre.listaAsignaturas.get(i).getCodigo()).equals(codigo)){
                return (padre.listaAsignaturas.get(i).getNombre());
            }
        }
        
        return ""; //error
    }
    
    public String buscarProfesor(String codigo, int seccion){
        
        for (int i = 0; i < padre.listaSeccion.size(); i++) {
            /**Se busca la seccion que estamos buscando por codigo y seccion
             * Para asi obtener el codigo del profesor
             * De  no tener profesor se coloca por asignar
             */
            if( padre.listaSeccion.get(i).getCod_asignatura().equals(codigo) 
                && padre.listaSeccion.get(i).getNro() == seccion){
                
                if(padre.listaSeccion.get(i).getProfesor() == 0){
                    return "Por asignar";//No tiene profesor asginado
                
                }else{//Si tiene profesor asignado
                    for (int j = 0; j < padre.listaDocente.size(); j++) {
                        if( Integer.parseInt(padre.listaDocente.get(j).getCi()) == padre.listaSeccion.get(i).getProfesor() ){
                            return padre.listaDocente.get(j).getNombre();
                        }
                    }
                }
            }    
        }
        return "";
    }
    
 
    
    public void cargarSabana(){

        
        for (int l = 0; l < 16; l++) {
            for (int m = 1; m < 14; m++) {
                this.jTable1.setValueAt("", l, m); 
            }
        }
        
        for (int i = 0; i < padre.listaSabana.size(); i++) {
            if( buscarDia(padre.listaSabana.get(i).getDia()) == posicionDia ){
                
                int rows[] = {(padre.listaSabana.get(i).getHoraInicial()-1),(padre.listaSabana.get(i).getHoraFinal()-1)};
                int columns = 0;
                if(padre.listaSabana.get(i).getAula()>6){
                   columns  = padre.listaSabana.get(i).getAula()-2;
                }else{
                   columns = padre.listaSabana.get(i).getAula();
                }
                
                
                if (rows.length != 0){
                    for ( int k=rows[0]; k<=rows[rows.length-1]; k++ ){
                             
                            this.jTable1.setValueAt(
                                        /*Nombre de la asignatura*/
                                        buscarNombre(padre.listaSabana.get(i).getAsignatura())+" "+
                                        /*Semestre de la asignatura*/
                                        buscarSemestre(padre.listaSabana.get(i).getAsignatura())+"-"+
                                        /*Sección de la asignatura*/
                                        padre.listaSabana.get(i).getId_seccion()+" "+
                                        /*Nombre del profesor asginado o en su defecto "Por asignar"*/
                                        buscarProfesor(padre.listaSabana.get(i).getAsignatura(), padre.listaSabana.get(i).getId_seccion()),
                                        /**Coordenadas en la tabla 
                                         * Donde la hora inicial es la fila inicial
                                         *       el dia es la columna inicial
                                         */
                                        k,columns);

                        
                    }

                } 
            
            }
        }
    }
    
    /**
     * Agrega los item asignatura al combo
     */
    public void cargar(){
        
        for (int i = 0; i < padre.listaAsignaturas.size() ; i++) {
            
            jComboBox1.addItem(padre.listaAsignaturas.get(i).getNombre());
        }
        cargarSabana();
    }
    
    
    public void cargarInfo(String usuario, String clave){
        
        jLabel3.setText(usuario);
        
        try {
            ConexionPostgreSQL conexion = new ConexionPostgreSQL(usuario, clave);
            Connection cn = conexion.conectar();
            Connection cn2 = conexion.conectar();
            Statement st = cn.createStatement();
            Statement st2 = cn2.createStatement();
            
            String sql = "SELECT * FROM carreras";
            String sql2 = "SELECT * FROM sabana";
            
            ResultSet rs = st.executeQuery(sql);
            ResultSet rs2 = st2.executeQuery(sql2);
            
            rs.next();
            jLabel5.setText(rs.getString("nombre"));
            rs2.next();
            jLabel6.setText(rs2.getString("lapso"));
                
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 

    }
    
    /**
     * Cargar por defecto dias de la semana
     */
    
    private void cargarDias(){
    
        dias.add("Lunes");
        dias.add("Martes");
        dias.add("Miercoles");
        dias.add("Jueves");
        dias.add("Viernes");
        dias.add("Sabado");
        dias.add("Domingo");
 
    }
    /**
     * Realiza movimiento envolvente de los dias en la lista
     */
    
    public void movimientoDia(boolean sentido){
    
        if(sentido){

            if((--posicionDia)<0){
                posicionDia+=7;
            }      
        }else{

            if((++posicionDia)>6){
                posicionDia-=7;
            }
        }
        
   }
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        /*Sentido: Izquierda*/
        movimientoDia(true);
        jLabel2.setText(dias.get(posicionDia));
        cargarSabana();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        /*Sentido: Derecha*/
        movimientoDia(false);
        jLabel2.setText(dias.get(posicionDia));
        cargarSabana();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    
      
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean condicion = false; //Variable de control
        for (int i = 0; i < padre.listaOferta.size(); i++) {
            if(padre.listaAsignaturas.get(jComboBox1.getSelectedIndex()).getCodigo().equals(padre.listaOferta.get(i).getCodigo())){
                cargarjComboBox2( padre.listaOferta.get(i).getNroSecciones());
                
                this.modelo = (DefaultTableModel) this.jTable2.getModel();
                    this.modelo.setNumRows(0);
                    modelo.addRow(new Object[]{
                        padre.listaAsignaturas.get(jComboBox1.getSelectedIndex()).getNivel()+"",
                        padre.listaAsignaturas.get(jComboBox1.getSelectedIndex()).getCodigo()+"",
                        padre.listaAsignaturas.get(jComboBox1.getSelectedIndex()).getUc()+"",
                        padre.listaAsignaturas.get(jComboBox1.getSelectedIndex()).getHoras()+""
                    });
                    condicion = true; //Si existe en oferta
            }
        }
        
        if(condicion == false ){   //Si no existe en oferta 
            
            JOptionPane.showMessageDialog(rootPane,"No existe oferta para esta asignatura", "ADVERTENCIA", 0);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        
        padre.listaAsignaturas = OperacionesBD.getAsignaturas(usuario.getNombre(), usuario.getClave());
        padre.listaCarreras = OperacionesBD.getCarreras(usuario.getNombre(), usuario.getClave());
        padre.listaDepartamentos = OperacionesBD.getDepartamentos(usuario.getNombre(), usuario.getClave());
        
        if(padre.listaAsignaturas!=null){
            padre.ventanaAsignaturas.usuario = new Usuario();
            padre.ventanaAsignaturas.usuario.setNombre(usuario.getNombre());
            padre.ventanaAsignaturas.usuario.setClave(usuario.getClave());
            padre.ventanaAsignaturas.cargar();
            padre.ventanaAsignaturas.setVisible(true);
        }
        
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        
        padre.listaPlantaFisica = OperacionesBD.getAulas(usuario.getNombre(), usuario.getClave());
        
        if (padre.listaPlantaFisica!=null) {
            
            padre.ventanaplantafisica.cargar();
            padre.ventanaplantafisica.setVisible(true);
            
        }
        
        
    }//GEN-LAST:event_jMenu2MouseClicked

    
    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased

        
        try {
            int rows[] = this.jTable1.getSelectedRows();
            int columns[] = this.jTable1.getSelectedColumns();
            int[] auxAula = new int[100];
            
            int auxHoraInicial = rows[0] + 1;
            int auxHoraFinal = rows[rows.length-1] + 1;
            
            if( auxHoraInicial != auxHoraFinal ){
                
                for (int i = 0; i < columns.length; i++) {
                    
                    auxAula[i] = Integer.parseInt(this.jTable1.getColumnName(columns[i]).replaceFirst("Aula ","")); 
                    System.out.println(""+auxAula[i]);
                    String auxDia = dias.get(posicionDia);
                    String auxAsignatura = (String) this.jTable2.getValueAt(0, 1);
                    String auxLapso = jLabel6.getText();

                    int  auxId_seccion = jComboBox2.getSelectedIndex()+1;
                    
                    int auxModulo = 2;
                    padre.listaSabana.add(new Sabana (auxAsignatura, auxLapso, auxId_seccion, 
                                                                auxAula[i], auxModulo, auxDia, 
                                                                auxHoraInicial, auxHoraFinal));
                    /**OperacionesBD.addSabana(usuario.getNombre(), usuario.getClave(),
                                                    auxAsignatura, auxLapso, auxId_seccion, 
                                                    auxAula[i], auxModulo, auxDia, 
                                                    auxHoraInicial, auxHoraFinal);*/
                   cargarSabana();        
                } 
            }else{
                JOptionPane.showMessageDialog(rootPane,"Seleccione más de un bloque", "ADVERTENCIA", 0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane,"Verifique su seleccion", "ADVERTENCIA", 0);
        }        
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        int rows[] = this.jTable1.getSelectedRows();
        int columns[] = this.jTable1.getSelectedColumns();
        
        if ( (rows.length != 0) && (columns.length != 0) ){
            for ( int i=rows[0]; i<=rows[rows.length-1]; i++ ){
                for ( int j=columns[0]; j<=columns[columns.length-1]; j++ ){
                    this.jTable1.setValueAt("", i, j);
                }
            }
        }
    }//GEN-LAST:event_jButton3MouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        for (int i = 0; i < 16; i++) {
            for (int j = 1; j < 14; j++) {
                this.jTable1.setValueAt("", i, j);
               
            }
        }
       
        
      /*  for (int i = 0; i < padre.listaSabana.size(); i++) {
            if( padre.listaSabana.get(i).getDia().equals(dias.get(posicionDia)) ){
                padre.listaSabana.remove(i);
            }
        }*/
        //Hay que limpiar los objetos de la lista Sabana que sean de este dia 
 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //hay que limpiar toda la lista  sabana y volver a cargar la tabla
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(VentanaSabana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaSabana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaSabana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaSabana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaSabana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
