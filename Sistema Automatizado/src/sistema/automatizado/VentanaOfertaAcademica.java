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
import javax.swing.table.TableColumn;
import static sistema.automatizado.Ventana.usuario;



/**
 *
 * @author Irene - Stalin :P
 */
public class VentanaOfertaAcademica extends javax.swing.JFrame {
    
    int nroSecciones = 0; //nuermo maximo de secciones en la tabla
    int nroProfesores = 0; //Número de profesores
    boolean condicion = false; //variable control
    DefaultTableModel modelo = new DefaultTableModel();
    String [] secciones = new String [20]; 
    int posicion = 0;
    int indiceFilaEditar = 0; //Ubicación de la fila que se desea editar
    ArrayList<Asignatura> asignaturas = new  ArrayList<Asignatura>();
    
    public Ventana padre;
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
        setExtendedState(JFrame.MAXIMIZED_BOTH);
             
        
        jTable1.setModel(modelo);
        modelo.addColumn("Asignatura");
        modelo.addColumn("Profesor");

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
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
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
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1393, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        jLabel2.setText("Asignatura");

        jLabel3.setText("Número de secciones:");

        jLabel4.setText("Número de profesores");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/refresh-32.png"))); // NOI18N
        jButton1.setText("REFRESCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Asignatura", "Profesor"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1393, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1282, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jButton3))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarInicio(){
        jComboBox1.removeAllItems(); //Materias
        jComboBox2.removeAllItems(); //Numero de profesores
    
    }
    
    public void limpiar(){
        
        jComboBox2.setVisible(false);//Ocultar combobox
        jLabel4.setVisible(false); //ocultar label
        jButton2.setVisible(false); //Ocultar boton agregar
        jButton3.setVisible(false);//Ocultar boton eliminar
        jButton4.setVisible(true); //Restaurar boton editar
        jButton5.setVisible(false);//Ocultar boton listo
        jTextField1.setText(""); //Limpiar label secciones
        jComboBox1.setSelectedIndex(0); //Indicar posicion 0 al combo asignaturas
        cargarJTable(); //Para que la tabla se ajuste dependiendo de cada cambio
    }
    
    public void cargar(String usuario, String clave){
        
         //Aqui se almacena toda la informacion de las asignaturas
        
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
                
                Asignatura objAsignatura = new Asignatura(rs.getInt("nivel"), rs.getInt("cod_asignatura"), rs.getInt("uc"), rs.getInt("horas_sem"), rs.getString(2), rs.getString(9), rs.getString(11));
                
                asignaturas.add(objAsignatura);
                
                
                
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
    
    }
    
    /**
     * Carga la lista de item en el jComboBox2
     * @param aux número de secciones indicadas por el usuario
     */
    
    public void cargarComboProfesores(int aux){
        jComboBox2.removeAllItems(); //Quitar la vieja lista de items
        for (int i = 0; i < aux; i++) {
            jComboBox2.addItem(""+(i+1)); //Cargar la nueva lista
        }   
        jLabel4.setVisible(true); //Mostrar su respectivo label
        jComboBox2.setVisible(true); //Mostrar su respectivo combobobx
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
              aux = Integer.parseInt (jTextField1.getText());
              if(aux>0){
                if(nroSecciones< aux){
                    nroSecciones = aux;
                    condicion = true;
                }else{
                    condicion = false;
                }
                jButton2.setVisible(true);

                cargarComboProfesores(aux);
            }else{
                JOptionPane.showMessageDialog(rootPane,"Verifique número de secciones", "ADVERTENCIA", 0);
            }
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
                System.out.println("holi");
                return i;   
            }
        }
        return -1;
    }
    
    
    /**
     * Captura el número de profesores indicado en el jComboBox2
     * y lo almacena en la estructura.
     */
    
    public void capturarNumeroprofesores(){
       
         //Variables auxiliares para rellenar el nuevo objeto
       String auxAsignatura = (String) jComboBox1.getSelectedItem();
       nroProfesores = Integer.parseInt((String) jComboBox2.getSelectedItem());
       int auxSecciones = Integer.parseInt(jTextField1.getText());
       int elemento = BuscarMateria(auxAsignatura);
       String auxCod = asignaturas.get(elemento).getCodigo()+"";
       System.out.println(""+elemento);
       if( validarMateria(auxAsignatura)==true ){
            //Nuevo objeto para insertar en la lista Oferta
           Oferta auxOferta = new Oferta(auxAsignatura,nroProfesores,auxSecciones);

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
        }else{
           JOptionPane.showMessageDialog(rootPane,"Esta materia ya fue registrada", "ADVERTENCIA", 0);
       }  
          
    }
    
    /**
     * Refleja en el jTable1 la estructura
     */
    public void cargarJTable() {
        Seccion [] auxCadenaSecciones = new Seccion[14];
        this.modelo = (DefaultTableModel) this.jTable1.getModel();
        this.modelo.setNumRows(0);
        for ( int i=0; i<this.padre.listaOferta.size(); i++ ){
            auxCadenaSecciones = padre.listaOferta.get(i).getSecciones();
            
            modelo.addRow(new Object[]{
                            this.padre.listaOferta.get(i).getAsignatura(),
                            this.padre.listaOferta.get(i).getProfesor()+"",
                            (auxCadenaSecciones[0].isIndicador())?auxCadenaSecciones[0].getProfesor():"No cuenta",
                            (auxCadenaSecciones[1].isIndicador())?auxCadenaSecciones[1].getProfesor():"No cuenta",
                            (auxCadenaSecciones[2].isIndicador())?auxCadenaSecciones[2].getProfesor():"No cuenta",
                            (auxCadenaSecciones[3].isIndicador())?auxCadenaSecciones[3].getProfesor():"No cuenta",
                            (auxCadenaSecciones[4].isIndicador())?auxCadenaSecciones[4].getProfesor():"No cuenta",
                            (auxCadenaSecciones[5].isIndicador())?auxCadenaSecciones[5].getProfesor():"No cuenta",
                            (auxCadenaSecciones[6].isIndicador())?auxCadenaSecciones[6].getProfesor():"No cuenta",
                            (auxCadenaSecciones[7].isIndicador())?auxCadenaSecciones[7].getProfesor():"No cuenta",
                            (auxCadenaSecciones[8].isIndicador())?auxCadenaSecciones[8].getProfesor():"No cuenta",
                            (auxCadenaSecciones[9].isIndicador())?auxCadenaSecciones[9].getProfesor():"No cuenta",
                            (auxCadenaSecciones[10].isIndicador())?auxCadenaSecciones[10].getProfesor():"No cuenta",
                            (auxCadenaSecciones[11].isIndicador())?auxCadenaSecciones[11].getProfesor():"No cuenta",
                            (auxCadenaSecciones[12].isIndicador())?auxCadenaSecciones[12].getProfesor():"No cuenta",
                            (auxCadenaSecciones[13].isIndicador())?auxCadenaSecciones[13].getProfesor():"No cuenta"
                            /**
                             * Los profesores se encuentran Por asignar hasta que jefatura los asigne
                             * El campo que se muestra como No cuenta en la estrucutra es un ""
                             */
            });
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
    
    /**
     * Genera la cantidad de columnas dependiendo de las secciones indicadas
     */
    
    public void generarColumnas(){
    
        if(condicion == true){
            TableColumn columna;

            for (int i = posicion ; i < nroSecciones; i++,posicion++) {

                secciones[i]="sección"+(i+1);
                modelo.addColumn(""+secciones[i]);
                columna = jTable1.getColumn(""+secciones[i]);
                columna.setPreferredWidth(320);
            }
            
            jTable1.setModel(modelo);
        }
        
        cargarJTable();
        
        limpiar();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        capturarNumeroSecciones();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        capturarNumeroprofesores();
        
        
        //Esta linea no sirve por los momentos porque la lsita siempre se recarga cuando se llama limpiar
        //dado que estoy cargando todo estaticamente
       // jComboBox1.removeItemAt(jComboBox1.getSelectedIndex());
        
        generarColumnas();
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
  
            jComboBox2.setVisible(true);
            jComboBox1.setSelectedItem(padre.listaOferta.get(jTable1.getSelectedRow()).getAsignatura());
            cargarComboProfesores(padre.listaOferta.get(jTable1.getSelectedRow()).getNroSecciones());
            
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
                int auxProfesor = Integer.parseInt((String) jComboBox2.getSelectedItem());
                String auxAsignatura = (String) jComboBox1.getSelectedItem();
                String auxCod = asignaturas.get(BuscarMateria(auxAsignatura)).getCodigo()+"";
                //Se crea nuevo objeto oferta 
                Oferta auxOferta = new Oferta(auxAsignatura,auxProfesor,auxSecciones);

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


                //Esta linea es la unica diferencia con le funcion capturarNumeroprofesores()
                //Se inserta el nuevo objeto en la lista con el fin de reemplazar el anterior
                padre.listaOferta.set(indiceFilaEditar, auxOferta);
                capturarNumeroSecciones();
                generarColumnas();
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
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
