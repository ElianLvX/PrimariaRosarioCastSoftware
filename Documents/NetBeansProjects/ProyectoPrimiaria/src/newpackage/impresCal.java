/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newpackage;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Toolkit;
import java.sql.PreparedStatement;

/**
 * @author ElianLv
 */
public class impresCal extends javax.swing.JFrame {

    ConexionBD con = new ConexionBD();
    Connection cn = (Connection) con.conexion();
    
    
    String[] Titulos = {"ID", "NOMBRE", "CURP","MATRICULA","GRADO","GRUPO"}; // Para consultar los alumnos del grado seleccionaod
    String[] Titulos3 = {"ID","Alumno","LenguaMaterna","Matematicas","LenguaExtrangera","ConocimientoDelMedio","Artes","EducacionFisica","Promedio"}; // columnas para matcal_12
    String[] Titulos4 = {"ID","Alumno","Español","Matematicas"," SegundaLengua","CienciasNaturales","EntidadDonVivo","FormCivica","Artes","EducacionFisica","Promedio"}; // columnas para matcal_12
    String[] Titulos5 = {"ID","Alumno","Español","Matematicas"," SegundaLengua","CienciasNaturales","Geografia","Historia","FormCivica","Artes","EducacionFisica","Promedio"}; // columnas para matcal_456
    ResultSet rs;
    String[][] M_datos; // Primer arreglo de tablas de alumno
    String[][] M_datos3; // Para arreglo de tablas de Calificaciones matcal_12
    String[][] M_datos4; // Para arreglo de tablas de Calificaciones matcal_3
    String[][] M_datos5; // Para arreglo de tablas de Calificaciones matcal_456
    
    DefaultTableModel dtm_datos = new DefaultTableModel(); // este es para el buscador de alumnos
    DefaultTableModel dtm_datos3 = new DefaultTableModel(); // este es para promedios de tabla matcal_12
    DefaultTableModel dtm_datos4 = new DefaultTableModel(); // este es para promedios de tabla matcal_3
    DefaultTableModel dtm_datos5 = new DefaultTableModel(); // este es para promedios de tabla matcal_456
    TableRowSorter<TableModel> trs;
    
    public impresCal() {
        initComponents();
        this.setLocationRelativeTo(null);
        String periodoS = comboP.getSelectedItem().toString();
        updateCombo();
    }
    
    public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/logopeque.png"));
        return retValue;
    }
    
    void limpiar(){
        buscar.setText("");
        txtNombre.setText("");
        txtMatricula.setText("");
        txtGrado.setText("");
        txtGrupo.setText("");
        txtCurp.setText("");
        dia.setText("");
        mes.setText("");
        año.setText("");
        buscador3.setText("");
    }
    
    String dato; // este contiene el nombre del director
    String dato2; // este contiene el Ciclo escolar actual
    
    // este metodo sirve para llenar el combo box de los datos de la base de datos
    private void updateCombo() {
        java.sql.Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        
        String sql = "select * from interface";
        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                dato = rs.getString("nombredirec");
                dato2 = rs.getString("ciclo_escolar");
                System.out.print(dato);
            }
        } catch (Exception e) {
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        buscar = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtCurp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        mes = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        año = new javax.swing.JTextField();
        buscador1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        contadorX = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_datos = new javax.swing.JTable();
        contadorX2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtable_datos2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtable_datos3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        buscador3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        comboP = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Grado: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Nombre: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        buscar.setEditable(false);
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 80, -1));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 270, -1));

        txtGrado.setEditable(false);
        txtGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGradoActionPerformed(evt);
            }
        });
        jPanel1.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Grupo: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        txtGrupo.setEditable(false);
        jPanel1.add(txtGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Matricula: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Curp: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        txtMatricula.setEditable(false);
        jPanel1.add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 180, -1));

        txtCurp.setEditable(false);
        jPanel1.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 180, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        jPanel1.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 112, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Mes:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));
        jPanel1.add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 171, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Año:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, -1));
        jPanel1.add(año, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 253, -1));

        buscador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscador1ActionPerformed(evt);
            }
        });
        buscador1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscador1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscador1KeyTyped(evt);
            }
        });
        jPanel1.add(buscador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 305, 70, -1));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel2.setText("Generador de Boletas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(617, 6, -1, -1));

        jLabel7.setText("Filtro de Alumnos:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 275, -1, 20));

        jLabel12.setText("Num Alumnos:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 333, -1, -1));

        contadorX.setEditable(false);
        contadorX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contadorXActionPerformed(evt);
            }
        });
        contadorX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contadorXKeyReleased(evt);
            }
        });
        jPanel1.add(contadorX, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 363, 70, -1));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Modificar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 363, -1, -1));

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAlumno);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 407, 540, 300));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seccion Calificaciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtable_datos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jtable_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtable_datos);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 750, 100));

        contadorX2.setEditable(false);
        contadorX2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contadorX2ActionPerformed(evt);
            }
        });
        contadorX2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contadorX2KeyReleased(evt);
            }
        });
        jPanel2.add(contadorX2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 70, -1));

        jtable_datos2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jtable_datos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtable_datos2);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 750, 100));

        jtable_datos3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jtable_datos3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jtable_datos3);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 750, 110));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("4to, 5to y 6to Grado");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel15.setText("1er y 2do Grado");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel16.setText("3er Grado");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 790, 450));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Alumno:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, -1, -1));

        buscador3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscador3ActionPerformed(evt);
            }
        });
        buscador3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscador3KeyReleased(evt);
            }
        });
        jPanel1.add(buscador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 360, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 36, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Periodo:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 275, -1, -1));

        comboP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        jPanel1.add(comboP, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 301, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generadores de Pdf's", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setText("Generar PDF");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 40, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setText("Generar PDF");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 80, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Generar PDF");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 120, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel17.setText("1er y 2do Grado: ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 47, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("3er Grado:");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 87, 89, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("4to,5to y 6to:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 127, 89, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 233, 160));

        jButton6.setBackground(new java.awt.Color(255, 204, 0));
        jButton6.setText("LIMPIAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(758, 80, -1, -1));

        jScrollPane5.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1367, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGradoActionPerformed

    private void buscador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscador1ActionPerformed

    private void buscador1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscador1KeyReleased
        /* Codigo para mostrar alumnos y materias */

        int valor = 0;
        int cont = 0;
        int conter = 0;
        String aux = "" + buscador1.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        try {
            java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            ResultSet rs = st_cont.executeQuery("SELECT COUNT(*) FROM alumno WHERE grupo_idgrado LIKE'" + buscador1.getText() + "%'");

            if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                valor = rs.getInt(1);
                conter = rs.getInt(1);
                contadorX.setText(conter+"");
            }

            M_datos = new String[valor][6];
            rs = st_cont.executeQuery("SELECT * FROM alumno inner join grupo on alumno.grupo_idgrado=grupo.id_grado WHERE grupo_idgrado LIKE'" + buscador1.getText() + "%'"); //aqui es donde buscaremos a a la persona en especifico o las personas
            while (rs.next()) {
                M_datos[cont][0] = rs.getString("alumno.id");
                M_datos[cont][1] = rs.getString("alumno.nombre");
                M_datos[cont][2] = rs.getString("alumno.curp");
                M_datos[cont][3] = rs.getString("alumno.matricula");
                M_datos[cont][4] = rs.getString("grupo.grado");
                M_datos[cont][5] = rs.getString("grupo.grupo"); 
                cont = cont + 1;
            }
            dtm_datos = new DefaultTableModel(M_datos, Titulos) {
                public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla,
                    return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
                }
            };
            tablaAlumno.setModel(dtm_datos);
            trs = new TableRowSorter<>(dtm_datos);
            tablaAlumno.setRowSorter(trs);

        } catch (Exception e) {

        }
    }//GEN-LAST:event_buscador1KeyReleased

    private void buscador1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscador1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_buscador1KeyTyped

    private void contadorXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contadorXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contadorXActionPerformed

    private void contadorXKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contadorXKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_contadorXKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = tablaAlumno.getSelectedRow();
        if(fila>=0) {
            buscar.setText(tablaAlumno.getValueAt(fila, 0).toString());
            buscador3.setText(tablaAlumno.getValueAt(fila, 1).toString());
            txtNombre.setText(tablaAlumno.getValueAt(fila, 1).toString());
            txtCurp.setText(tablaAlumno.getValueAt(fila, 2).toString());
            txtMatricula.setText(tablaAlumno.getValueAt(fila, 3).toString());
            txtGrado.setText(tablaAlumno.getValueAt(fila, 4).toString());
            txtGrupo.setText(tablaAlumno.getValueAt(fila, 5).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscador3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscador3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscador3ActionPerformed

    private void buscador3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscador3KeyReleased
       
        if(buscador3.getText() == ""){
            JOptionPane.showMessageDialog(null, "Caja De Texto Basica");
        }
         // Codigo para filtrar las materias de matcal 1 (Escogiendo periodo)

        String opcionP = comboP.getSelectedItem().toString(); // aqui pido el perido que nesesita ver
        //*-*-*-*-*-*-*-*-*-*-*-*-* TABLA MATCAL_12 -*-*-*-*-*-*-*-*-*-*
        int valor = 0;
        int cont = 0;
        int conter = 0;
        String aux = "" + buscador3.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        try {
            java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            ResultSet rs = st_cont.executeQuery("select COUNT(*) from matcal_12 inner join alumno on matcal_12.alumno_id=alumno.id where alumno.nombre like'" + buscador3.getText() + "%'and matcal_12.periodo like'" +opcionP+"'");

            if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                valor = rs.getInt(1);
                conter = rs.getInt(1);
                contadorX2.setText(conter+"");
            }

            M_datos3 = new String[valor][9];
            rs = st_cont.executeQuery("select * from matcal_12 inner join alumno on matcal_12.alumno_id=alumno.id where alumno.nombre like'" + buscador3.getText() + "%'and matcal_12.periodo like'" +opcionP+"'");
            while (rs.next()) {
                M_datos3[cont][0] = rs.getString("matcal_12.id");
                M_datos3[cont][1] = rs.getString("alumno.nombre");
                M_datos3[cont][2] = rs.getString("matcal_12.lengua_materna");
                M_datos3[cont][3] = rs.getString("matcal_12.matematicas");
                M_datos3[cont][4] = rs.getString("matcal_12.lengua_extrangera");
                M_datos3[cont][5] = rs.getString("matcal_12.conocimiento_medio");
                M_datos3[cont][6] = rs.getString("matcal_12.artes");
                M_datos3[cont][7] = rs.getString("matcal_12.educacion_fisica");
                M_datos3[cont][8] = rs.getString("matcal_12.promedio");
                cont = cont + 1;
            }
            dtm_datos3 = new DefaultTableModel(M_datos3, Titulos3) {
                @Override
                public boolean isCellEditable(int row, int column) {// este metodo es muy util si no quieren que editen su tabla,
                    return false;  // si quieren modificar los campos al dar clic entonces borren este metodo
                }
            };
            jtable_datos.setModel(dtm_datos3);
            trs = new TableRowSorter<>(dtm_datos3);
            jtable_datos.setRowSorter(trs);

        } catch (SQLException e) {
        }
        
        
        //*-*-*-*-*-*-*-*-*-*-*-*-* TABLA MATCAL_3  -*-*-*-*-*-*-*-*-*-*
        
        int valorB = 0;
        int contB = 0;
        int conterB = 0;
        String auxB = "" + buscador3.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        try {
            java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            ResultSet rs = st_cont.executeQuery("select COUNT(*) from matcal_3 inner join alumno on matcal_3.alumno_id=alumno.id where alumno.nombre like'" + buscador3.getText() + "%'and matcal_3.periodo like'" +opcionP+"'");

            if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                valorB = rs.getInt(1); 
                conterB = rs.getInt(1);
                contadorX2.setText(conterB+"");
            }

            M_datos4 = new String[valorB][11];
            rs = st_cont.executeQuery("select * from matcal_3 inner join alumno on matcal_3.alumno_id=alumno.id where alumno.nombre like'" + buscador3.getText() + "%'and matcal_3.periodo like'" +opcionP+"'");
            while (rs.next()) {
                M_datos4[contB][0] = rs.getString("matcal_3.id");
                M_datos4[contB][1] = rs.getString("alumno.nombre");
                M_datos4[contB][2] = rs.getString("matcal_3.español");
                M_datos4[contB][3] = rs.getString("matcal_3.matematicas");
                M_datos4[contB][4] = rs.getString("matcal_3.segunda_lengua");
                M_datos4[contB][5] = rs.getString("matcal_3.ciencias_naturales");
                M_datos4[contB][6] = rs.getString("matcal_3.entidad_donde_vivo");
                M_datos4[contB][7] = rs.getString("matcal_3.form_civica_etica");
                M_datos4[contB][8] = rs.getString("matcal_3.artes");
                M_datos4[contB][9] = rs.getString("matcal_3.educacion_fisica");
                M_datos4[contB][10] = rs.getString("matcal_3.promedio");
                contB = contB + 1;
            }
            dtm_datos4 = new DefaultTableModel(M_datos4, Titulos4) {
                @Override
                public boolean isCellEditable(int row, int column) {// este metodo es muy util si no quieren que editen su tabla,
                    return false;  // si quieren modificar los campos al dar clic entonces borren este metodo
                }
            };
            jtable_datos2.setModel(dtm_datos4);
            trs = new TableRowSorter<>(dtm_datos4);
            jtable_datos2.setRowSorter(trs);

        } catch (SQLException e) {
        }
        
        //*-*-*-*-*-*-*-*-*-*-*-*-* TABLA MATCAL_456  -*-*-*-*-*-*-*-*-*-*
        
        // int periodoB = 1;
        int valorC = 0;
        int contC = 0;
        int conterC = 0;
        String auxC = "" + buscador3.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        try {
            java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            ResultSet rs = st_cont.executeQuery("select COUNT(*) from matcal_456 inner join alumno on matcal_456.alumno_id=alumno.id where alumno.nombre like'" + buscador3.getText() + "%'and matcal_456.periodo like'" +opcionP+"'");

            if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                valorC = rs.getInt(1);
                conterC = rs.getInt(1);
                contadorX2.setText(conterC+"");
            }
            

            M_datos5 = new String[valorC][12];
            rs = st_cont.executeQuery("select * from matcal_456 inner join alumno on matcal_456.alumno_id=alumno.id where alumno.nombre like'" + buscador3.getText() + "%'and matcal_456.periodo like'" +opcionP+"'");
            while (rs.next()) {
                M_datos5[cont][0] = rs.getString("matcal_456.id");
                M_datos5[cont][1] = rs.getString("alumno.nombre");
                M_datos5[cont][2] = rs.getString("matcal_456.español");
                M_datos5[cont][3] = rs.getString("matcal_456.matematicas");
                M_datos5[cont][4] = rs.getString("matcal_456.segunda_lengua");
                M_datos5[cont][5] = rs.getString("matcal_456.ciencias_naturales");
                M_datos5[cont][6] = rs.getString("matcal_456.geografia");
                M_datos5[cont][7] = rs.getString("matcal_456.historia");
                M_datos5[cont][8] = rs.getString("matcal_456.form_civica_etica");
                M_datos5[cont][9] = rs.getString("matcal_456.artes");
                M_datos5[cont][10] = rs.getString("matcal_456.eduacion_fisica");
                M_datos5[cont][11] = rs.getString("matcal_456.promedio");
                contC = contC + 1;
            }
            
            dtm_datos5 = new DefaultTableModel(M_datos5, Titulos5) {
                @Override
                public boolean isCellEditable(int row, int column) {// este metodo es muy util si no quieren que editen su tabla,
                    return false;  // si quieren modificar los campos al dar clic entonces borren este metodo
                }
            };
            jtable_datos3.setModel(dtm_datos5);
            trs = new TableRowSorter<>(dtm_datos5);
            jtable_datos3.setRowSorter(trs);

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        

    }//GEN-LAST:event_buscador3KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Home newframe = new Home();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void contadorX2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contadorX2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contadorX2ActionPerformed

    private void contadorX2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contadorX2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_contadorX2KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Aqui se generan la boleta de los grados 1ro y segundo grado;
        int fila = jtable_datos.getSelectedRow();
        if(fila>=0 && dia.getText().length() >= 1 && mes.getText().length() >= 1 && año.getText().length() >= 1) {
            String id_cal = jtable_datos.getValueAt(fila, 0).toString();
            String nom = jtable_datos.getValueAt(fila, 1).toString();
            String LenguaMat = jtable_datos.getValueAt(fila, 2).toString();
            String matematicas = jtable_datos.getValueAt(fila, 3).toString();
            String segundaLengua = jtable_datos.getValueAt(fila, 4).toString();
            String conocimientoMedio = jtable_datos.getValueAt(fila, 5).toString();
            String artes = jtable_datos.getValueAt(fila, 6).toString();
            String educacionFisica = jtable_datos.getValueAt(fila, 7).toString();
            String promedio = jtable_datos.getValueAt(fila, 8).toString();
            // -*-*-*-*-*-*-*-*-*-*- GENERACION DE BOLETA PARA MATCAL_12 -*-*-*-*-*-*-*-*-*-*-*-*-*-
            Document documento = new Document();
            try{
                String opcionP = comboP.getSelectedItem().toString(); // aqui pido el perido que nesesita ver
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Boletas/1er_2do_grado/"+txtGrado.getText()+""+ txtGrupo.getText()+" "+txtNombre.getText()+" "+opcionP+".pdf"));

                // Apartado para incluir logo "SEP"
                Image logo = Image.getInstance(ruta+"/img/se.jpg");
                logo.scaleToFit(130,160);
                logo.setAbsolutePosition(60F, 705F);

                // Apartado para mandar a llmar la imagen "Marca de Agua"
                Image header = Image.getInstance(ruta+"/img/logoa.jpg");
                header.scaleToFit(520, 520);
                header.setAbsolutePosition(70f, 130f);

                documento.open();

                // Inicializaciones de texto
                Paragraph paragraphHello = new Paragraph(); // Texto de arriva del principal
                Paragraph textoInit = new Paragraph(); // Texto de A quien corresponda

                //Fuentes para poder usar
                Font f = new Font();
                f.setFamily(FontFamily.TIMES_ROMAN.name());
                f.setStyle(Font.BOLD);
                f.setSize(11);

                // Estilo de texto "CONSTANCIA DE ESTUDIO"
                Font f2 = new Font();
                f2.setFamily(FontFamily.COURIER.name());
                f2.setStyle(Font.BOLD);
                f2.setSize(20);  

                //Fuentes para poder usar
                Font f3 = new Font();
                f3.setFamily(FontFamily.TIMES_ROMAN.name());
                f3.setStyle(Font.BOLD);
                f3.setSize(13);

                // Datos Del Alumno para poner estilos
                String name = txtNombre.getText();
                String grado = txtGrado.getText();
                String grupo = txtGrupo.getText();
                String matricula = txtMatricula.getText();
                String curp = txtCurp.getText();



                // Texto Superior
                documento.add(logo);
                paragraphHello.setFont(f); //para que le de estilo negrita
                paragraphHello.add("SECRETARIA DE EDUCACION\n");
                paragraphHello.add("SUBSECRETARÍA DE EDUCACIÓN FEDERALIZADA\n");
                paragraphHello.add("DIRECCIÓN DE EDUCACIÓN PRIMARIA\n");
                paragraphHello.add("JEFATURA DE SECTOR N° 04\n");
                paragraphHello.add("SUPERVISIÓN ESCOLAR N° 131\n");
                paragraphHello.add("ESC. PRIM. ROSARIO CASTELLANOS FIGUEROA\n");
                paragraphHello.add("CLAVE: 07DPR1164G\n\n\n");
                paragraphHello.setAlignment(Element.ALIGN_RIGHT);

                // Texto Inicial
                textoInit.setFont(f3);
                textoInit.add("A QUIEN CORRESPONDA:\n\n");
                textoInit.setAlignment(Element.ALIGN_LEFT);

                // Aqui se inserta el texto a los documentos
                documento.add(header);
                documento.add(paragraphHello);
                documento.add(textoInit);

                // Texto Principal
                Paragraph paragraphLorem = new Paragraph();
                paragraphLorem.add("EL QUE SUSCRIBE C. DIRECTOR DE LA ESCUELA PRIMARIA URBANA"
                        + " 'ROSARIO CASTELLANOS FIGUEROA' TURNO MATUTINO, UBICADA EN AV."
                        + " ROSA DEL ORIENTE Y AV. ROSA DEL NORTE DE LA COLONIA INFONAVIT EL"
                        + " ROSARIO EN CIUDAD DE TUXTLA GUTIERREZ, CHIAPAS; MEXICO, EXPIDE:\n\n\n\n");
                paragraphLorem.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(paragraphLorem);

                // Texto de "CONSTANCIADE ESTUDIO"
                Paragraph Consta = new Paragraph();
                Consta.setFont(f2);
                Consta.add("CONSTANCIA DE ESTUDIO \n\n\n\n");
                Consta.setAlignment(Element.ALIGN_CENTER);

                documento.add(Consta);

                // Texto de Datos del Alumno
                Paragraph Pagare1 = new Paragraph();
                Font font1 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

                //Chunk texto1 = new Chunk(name, font1);
                //Chunk texto3 = new Chunk("Tu texto 2", new Font(FontFamily.TIMES_ROMAN, 10, Font.ITALIC));
                Chunk texto1 = new Chunk("Al ALUMNO: ");
                Chunk texto2 = new Chunk(name + ".", new Font(FontFamily.HELVETICA, 15, Font.BOLD));
                Chunk texto3 = new Chunk("\nES ALUMNO REGULAR EN EL ");
                Chunk texto4 = new Chunk(grado, font1);
                Chunk texto5 = new Chunk("°. GRADO GRUPO: '");
                Chunk texto6 = new Chunk(grupo, font1);
                Chunk texto7 = new Chunk("' CON NUMERO DE ");
                Chunk texto8 = new Chunk("MATRICULA ");
                Chunk texto9 = new Chunk(matricula, font1);
                Chunk texto10 = new Chunk(" CURP: ");
                Chunk texto11 = new Chunk(curp+",", font1);
                Chunk texto12 = new Chunk("  SEGÚN DOCUMENTOS QUE OBRAN EN EL ARCHIVO DE ESTE PLANTEL EDUCATIVO,");
                Chunk texto13 = new Chunk(" EN EL PRESENTE CICLO ESCOLAR  ");
                Chunk texto14 = new Chunk(dato2+",  ", font1);
                Chunk texto15 = new Chunk("OBTENIENDO LAS SIGUIENTES CALIFICACIONES EN EL SIGUIENTE TRIMESTRE. \n\n\n");

                Pagare1.add(texto1);
                Pagare1.add(texto2);
                Pagare1.add(texto3);
                Pagare1.add(texto4);
                Pagare1.add(texto5);
                Pagare1.add(texto6);
                Pagare1.add(texto7);
                Pagare1.add(texto8);
                Pagare1.add(texto9);
                Pagare1.add(texto10);
                Pagare1.add(texto11);
                Pagare1.add(texto12);
                Pagare1.add(texto13);
                Pagare1.add(texto14);
                Pagare1.add(texto15);
                Pagare1.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(Pagare1);

                // -*-*-*-*-*-*-*-*-*-*-**-*-* AQUI SE IMPRIME LA TABLA DE CALIFICACIONES -*-*-*-*-*-*-*-*-*-*---*-*
                

                PdfPTable tabla = new PdfPTable(7);
                tabla.setWidths(new int[]{7,7,7,8,7,7,7});
                tabla.addCell(new Phrase(" PERIODO", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("     ESP", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("     MAT", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("  CON.MED", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("  ARTES", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("  EDU.FIS", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("    PROM", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                
                
                tabla.addCell(new Phrase("\n       "+opcionP+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+LenguaMat+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+matematicas+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n            "+conocimientoMedio+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+artes+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+educacionFisica+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+promedio+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                
                documento.add(tabla);
                
                // Texto de Datos de bloque final
                Paragraph PagareF = new Paragraph();
                Font font2 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

                Chunk textoF1 = new Chunk("\n\nAPETICION DE LA PARTE INTERESADA Y PARA LOS USOS LEGALES QUE ");
                Chunk textoF2 = new Chunk("HAYA LUGAR, SE EXTIENDE LA PRESENTE EN LA CIUDAD DE TUXTLA ");
                Chunk textoF3 = new Chunk("GUTIERREZ, CHIAPAS. A LOS ");
                Chunk textoF4 = new Chunk(dia.getText(), font2);
                Chunk textoF5 = new Chunk(" DIAS DEL MES DE ");
                Chunk textoF6 = new Chunk(mes.getText(), font2);
                Chunk textoF7 = new Chunk(" DEL AÑO ");
                Chunk textoF8 = new Chunk(año.getText(),font2);
                Chunk textoF9 = new Chunk("\n\n\n                                                                    ATENTAMENTE\n",font2);
                Chunk textoF10 = new Chunk("                                                        DIRECTOR DE LA ESCUELA ",font2);
                Chunk textoF11 = new Chunk("\n\n\n\n\n                                                       "+dato+".",font2);

                PagareF.add(textoF1);
                PagareF.add(textoF2);
                PagareF.add(textoF3);
                PagareF.add(textoF4);
                PagareF.add(textoF5);
                PagareF.add(textoF6);
                PagareF.add(textoF7);
                PagareF.add(textoF8);
                PagareF.add(textoF9);
                PagareF.add(textoF10);
                PagareF.add(textoF11);
                PagareF.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(PagareF);
                
                
                JOptionPane.showMessageDialog(null, "Documento Creado con ¡Exito!");
                
                documento.close();
                
            }catch(Exception e){
                System.out.println("Error: "+ e);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada o Rellena los capos de Dia, Mes o Año");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Boton para generar boleta de Matcal_3
        int fila = jtable_datos2.getSelectedRow();
        if(fila>=0 && dia.getText().length() >= 1 && mes.getText().length() >= 1 && año.getText().length() >= 1) {
            String id_cal = jtable_datos2.getValueAt(fila, 0).toString();
            String nom = jtable_datos2.getValueAt(fila, 1).toString();
            String LenguaMat = jtable_datos2.getValueAt(fila, 2).toString();
            String matematicas = jtable_datos2.getValueAt(fila, 3).toString();
            String segundaLengua = jtable_datos2.getValueAt(fila, 4).toString();
            String cienciasnaturales = jtable_datos2.getValueAt(fila, 5).toString();
            String entidad = jtable_datos2.getValueAt(fila, 6).toString();
            String formacionCivica = jtable_datos2.getValueAt(fila, 7).toString();
            String artes = jtable_datos2.getValueAt(fila, 8).toString();
            String educacionFisica = jtable_datos2.getValueAt(fila, 9).toString();
            String promedio = jtable_datos2.getValueAt(fila, 10).toString();  
            
            
            // -*-*-*-*-*-*-*-*-*-*- GENERACION DE BOLETA PARA MATCAL_12 -*-*-*-*-*-*-*-*-*-*-*-*-*-
            Document documento = new Document();
            try{
                String opcionP = comboP.getSelectedItem().toString(); // aqui pido el perido que nesesita ver
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Boletas/3er_Grado/"+txtGrado.getText()+""+ txtGrupo.getText()+" "+txtNombre.getText()+" "+opcionP+".pdf"));

                // Apartado para incluir logo "SEP"
                Image logo = Image.getInstance(ruta+"/img/se.jpg");
                logo.scaleToFit(130,160);
                logo.setAbsolutePosition(60F, 705F);

                // Apartado para mandar a llmar la imagen "Marca de Agua"
                Image header = Image.getInstance(ruta+"/img/logoa.jpg");
                header.scaleToFit(520, 520);
                header.setAbsolutePosition(70f, 130f);

                documento.open();

                // Inicializaciones de texto
                Paragraph paragraphHello = new Paragraph(); // Texto de arriva del principal
                Paragraph textoInit = new Paragraph(); // Texto de A quien corresponda

                //Fuentes para poder usar
                Font f = new Font();
                f.setFamily(FontFamily.TIMES_ROMAN.name());
                f.setStyle(Font.BOLD);
                f.setSize(11);

                // Estilo de texto "CONSTANCIA DE ESTUDIO"
                Font f2 = new Font();
                f2.setFamily(FontFamily.COURIER.name());
                f2.setStyle(Font.BOLD);
                f2.setSize(20);  

                //Fuentes para poder usar
                Font f3 = new Font();
                f3.setFamily(FontFamily.TIMES_ROMAN.name());
                f3.setStyle(Font.BOLD);
                f3.setSize(13);

                // Datos Del Alumno para poner estilos
                String name = txtNombre.getText();
                String grado = txtGrado.getText();
                String grupo = txtGrupo.getText();
                String matricula = txtMatricula.getText();
                String curp = txtCurp.getText();



                // Texto Superior
                documento.add(logo);
                paragraphHello.setFont(f); //para que le de estilo negrita
                paragraphHello.add("SECRETARIA DE EDUCACION\n");
                paragraphHello.add("SUBSECRETARÍA DE EDUCACIÓN FEDERALIZADA\n");
                paragraphHello.add("DIRECCIÓN DE EDUCACIÓN PRIMARIA\n");
                paragraphHello.add("JEFATURA DE SECTOR N° 04\n");
                paragraphHello.add("SUPERVISIÓN ESCOLAR N° 131\n");
                paragraphHello.add("ESC. PRIM. ROSARIO CASTELLANOS FIGUEROA\n");
                paragraphHello.add("CLAVE: 07DPR1164G\n\n\n");
                paragraphHello.setAlignment(Element.ALIGN_RIGHT);

                // Texto Inicial
                textoInit.setFont(f3);
                textoInit.add("A QUIEN CORRESPONDA:\n\n");
                textoInit.setAlignment(Element.ALIGN_LEFT);

                // Aqui se inserta el texto a los documentos
                documento.add(header);
                documento.add(paragraphHello);
                documento.add(textoInit);

                // Texto Principal
                Paragraph paragraphLorem = new Paragraph();
                paragraphLorem.add("EL QUE SUSCRIBE C. DIRECTOR DE LA ESCUELA PRIMARIA URBANA"
                        + " 'ROSARIO CASTELLANOS FIGUEROA' TURNO MATUTINO, UBICADA EN AV."
                        + " ROSA DEL ORIENTE Y AV. ROSA DEL NORTE DE LA COLONIA INFONAVIT EL"
                        + " ROSARIO EN CIUDAD DE TUXTLA GUTIERREZ, CHIAPAS; MEXICO, EXPIDE:\n\n\n\n");
                paragraphLorem.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(paragraphLorem);

                // Texto de "CONSTANCIADE ESTUDIO"
                Paragraph Consta = new Paragraph();
                Consta.setFont(f2);
                Consta.add("CONSTANCIA DE ESTUDIO \n\n\n\n");
                Consta.setAlignment(Element.ALIGN_CENTER);

                documento.add(Consta);

                // Texto de Datos del Alumno
                Paragraph Pagare1 = new Paragraph();
                Font font1 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

                //Chunk texto1 = new Chunk(name, font1);
                //Chunk texto3 = new Chunk("Tu texto 2", new Font(FontFamily.TIMES_ROMAN, 10, Font.ITALIC));
                Chunk texto1 = new Chunk("Al ALUMNO: ");
                Chunk texto2 = new Chunk(name + ".", new Font(FontFamily.HELVETICA, 15, Font.BOLD));
                Chunk texto3 = new Chunk("\nES ALUMNO REGULAR EN EL ");
                Chunk texto4 = new Chunk(grado, font1);
                Chunk texto5 = new Chunk("°. GRADO GRUPO: '");
                Chunk texto6 = new Chunk(grupo, font1);
                Chunk texto7 = new Chunk("' CON NUMERO DE ");
                Chunk texto8 = new Chunk("MATRICULA ");
                Chunk texto9 = new Chunk(matricula, font1);
                Chunk texto10 = new Chunk(" CURP: ");
                Chunk texto11 = new Chunk(curp+",", font1);
                Chunk texto12 = new Chunk("  SEGUN DOCUMENTOS QUE OBRAN EN EL ARCHIVO DE ESTE PLANTEL EDUCATIVO,");
                Chunk texto13 = new Chunk(" EN EL PRESENTE CICLO ESCOLAR  ");
                Chunk texto14 = new Chunk(dato2+",  ", font1);
                Chunk texto15 = new Chunk("OBTENIENDO LAS SIGUIENTES CALIFICACIONES EN EL SIGUIENTE TRIMESTRE. \n\n\n");

                Pagare1.add(texto1);
                Pagare1.add(texto2);
                Pagare1.add(texto3);
                Pagare1.add(texto4);
                Pagare1.add(texto5);
                Pagare1.add(texto6);
                Pagare1.add(texto7);
                Pagare1.add(texto8);
                Pagare1.add(texto9);
                Pagare1.add(texto10);
                Pagare1.add(texto11);
                Pagare1.add(texto12);
                Pagare1.add(texto13);
                Pagare1.add(texto14);
                Pagare1.add(texto15);
                Pagare1.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(Pagare1);

                // -*-*-*-*-*-*-*-*-*-*-**-*-* AQUI SE IMPRIME LA TABLA DE CALIFICACIONES -*-*-*-*-*-*-*-*-*-*---*-*

                PdfPTable tabla = new PdfPTable(9);
                tabla.setWidths(new int[]{10,7,7,9,7,7,8,9,7});
                tabla.addCell(new Phrase("PERIODO", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("   ESP", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("   MAT", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("CIE.NAT", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("EN.VI", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("F.CIV", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase(" ARTES", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("EDU.FIS", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("PROM", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER))); 
                
                
                tabla.addCell(new Phrase("\n      "+opcionP+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n     "+LenguaMat+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n     "+matematicas+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n        "+cienciasnaturales+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+entidad+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+formacionCivica+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+artes+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n       "+educacionFisica+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n    "+promedio+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                
                documento.add(tabla);
                
                // Texto de Datos del Alumno
                Paragraph PagareF = new Paragraph();
                Font font2 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

                //Chunk texto1 = new Chunk(name, font1);
                //Chunk texto3 = new Chunk("Tu texto 2", new Font(FontFamily.TIMES_ROMAN, 10, Font.ITALIC));
                Chunk textoF1 = new Chunk("\n\nA PETICION DE LA PARTE INTERESADA Y PARA LOS USOS LEGALES QUE ");
                Chunk textoF2 = new Chunk("HAYA LUGAR, SE EXTIENDE LA PRESENTE EN LA CIUDAD DE TUXTLA ");
                Chunk textoF3 = new Chunk("GUTIERREZ, CHIAPAS. A LOS ");
                Chunk textoF4 = new Chunk(dia.getText(), font2);
                Chunk textoF5 = new Chunk(" DIAS DEL MES DE ");
                Chunk textoF6 = new Chunk(mes.getText(), font2);
                Chunk textoF7 = new Chunk(" DEL AÑO ");
                Chunk textoF8 = new Chunk(año.getText(),font2);
                Chunk textoF9 = new Chunk("\n\n\n                                                                    ATENTAMENTE\n",font2);
                Chunk textoF10 = new Chunk("                                                        DIRECTOR DE LA ESCUELA ",font2);
                Chunk textoF11 = new Chunk("\n\n\n\n\n                                                       "+dato+".",font2);

                PagareF.add(textoF1);
                PagareF.add(textoF2);
                PagareF.add(textoF3);
                PagareF.add(textoF4);
                PagareF.add(textoF5);
                PagareF.add(textoF6);
                PagareF.add(textoF7);
                PagareF.add(textoF8);
                PagareF.add(textoF9);
                PagareF.add(textoF10);
                PagareF.add(textoF11);
                PagareF.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(PagareF);
                
                
                JOptionPane.showMessageDialog(null, "Documento Creado con ¡Exito!");
                documento.close();
            }catch(Exception e){
                System.out.println("Error: "+ e);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada o Rellena los capos de Dia, Mes o Año");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Boton para generar Boletas Matcal_456
        
        int fila = jtable_datos3.getSelectedRow();
        if(fila>=0 && dia.getText().length() >= 1 && mes.getText().length() >= 1 && año.getText().length() >= 1) {
            String id_cal = jtable_datos3.getValueAt(fila, 0).toString();
            String nom = jtable_datos3.getValueAt(fila, 1).toString();
            String LenguaMat = jtable_datos3.getValueAt(fila, 2).toString();
            String matematicas = jtable_datos3.getValueAt(fila, 3).toString();
            String segundaLengua = jtable_datos3.getValueAt(fila, 4).toString();
            String cienciasnaturales = jtable_datos3.getValueAt(fila, 5).toString();
            String geografia = jtable_datos3.getValueAt(fila, 6).toString();
            String historia = jtable_datos3.getValueAt(fila, 7).toString();
            String formacionCivica = jtable_datos3.getValueAt(fila, 8).toString();
            String artes = jtable_datos3.getValueAt(fila, 9).toString();
            String educacionFisica = jtable_datos3.getValueAt(fila, 10).toString();
            String promedio = jtable_datos3.getValueAt(fila, 11).toString();  
            
            
            // -*-*-*-*-*-*-*-*-*-*- GENERACION DE BOLETA PARA MATCAL_12 -*-*-*-*-*-*-*-*-*-*-*-*-*-
            Document documento = new Document();
            try{
                String opcionP = comboP.getSelectedItem().toString(); // aqui pido el perido que nesesita ver
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Boletas/4to_5to_6to_grado/"+txtGrado.getText()+""+ txtGrupo.getText()+" "+txtNombre.getText()+" "+opcionP+".pdf"));

                // Apartado para incluir logo "SEP"
                Image logo = Image.getInstance(ruta+"/img/se.jpg");
                logo.scaleToFit(130,160);
                logo.setAbsolutePosition(60F, 705F);

                // Apartado para mandar a llmar la imagen "Marca de Agua"
                Image header = Image.getInstance(ruta+"/img/logoa.jpg");
                header.scaleToFit(520, 520);
                header.setAbsolutePosition(70f, 130f);

                documento.open();

                // Inicializaciones de texto
                Paragraph paragraphHello = new Paragraph(); // Texto de arriva del principal
                Paragraph textoInit = new Paragraph(); // Texto de A quien corresponda

                //Fuentes para poder usar
                Font f = new Font();
                f.setFamily(FontFamily.TIMES_ROMAN.name());
                f.setStyle(Font.BOLD);
                f.setSize(11);

                // Estilo de texto "CONSTANCIA DE ESTUDIO"
                Font f2 = new Font();
                f2.setFamily(FontFamily.COURIER.name());
                f2.setStyle(Font.BOLD);
                f2.setSize(20);  

                //Fuentes para poder usar
                Font f3 = new Font();
                f3.setFamily(FontFamily.TIMES_ROMAN.name());
                f3.setStyle(Font.BOLD);
                f3.setSize(13);

                // Datos Del Alumno para poner estilos
                String name = txtNombre.getText();
                String grado = txtGrado.getText();
                String grupo = txtGrupo.getText();
                String matricula = txtMatricula.getText();
                String curp = txtCurp.getText();



                // Texto Superior
                documento.add(logo);
                paragraphHello.setFont(f); //para que le de estilo negrita
                paragraphHello.add("SECRETARIA DE EDUCACION\n");
                paragraphHello.add("SUBSECRETARÍA DE EDUCACIÓN FEDERALIZADA\n");
                paragraphHello.add("DIRECCIÓN DE EDUCACIÓN PRIMARIA\n");
                paragraphHello.add("JEFATURA DE SECTOR N° 04\n");
                paragraphHello.add("SUPERVISIÓN ESCOLAR N° 131\n");
                paragraphHello.add("ESC. PRIM. ROSARIO CASTELLANOS FIGUEROA\n");
                paragraphHello.add("CLAVE: 07DPR1164G\n\n\n");
                paragraphHello.setAlignment(Element.ALIGN_RIGHT);

                // Texto Inicial
                textoInit.setFont(f3);
                textoInit.add("A QUIEN CORRESPONDA:\n\n");
                textoInit.setAlignment(Element.ALIGN_LEFT);

                // Aqui se inserta el texto a los documentos
                documento.add(header);
                documento.add(paragraphHello);
                documento.add(textoInit);

                // Texto Principal
                Paragraph paragraphLorem = new Paragraph();
                paragraphLorem.add("EL QUE SUSCRIBE C. DIRECTOR DE LA ESCUELA PRIMARIA URBANA"
                        + " 'ROSARIO CASTELLANOS FIGUEROA' TURNO MATUTINO, UBICADA EN AV."
                        + " ROSA DEL ORIENTE Y AV. ROSA DEL NORTE DE LA COLONIA INFONAVIT EL"
                        + " ROSARIO EN CIUDAD DE TUXTLA GUTIERREZ, CHIAPAS; MEXICO, EXPIDE:\n\n\n\n");
                paragraphLorem.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(paragraphLorem);

                // Texto de "CONSTANCIADE ESTUDIO"
                Paragraph Consta = new Paragraph();
                Consta.setFont(f2);
                Consta.add("CONSTANCIA DE ESTUDIO \n\n\n\n");
                Consta.setAlignment(Element.ALIGN_CENTER);

                documento.add(Consta);

                // Texto de Datos del Alumno
                Paragraph Pagare1 = new Paragraph();
                Font font1 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

                //Chunk texto1 = new Chunk(name, font1);
                //Chunk texto3 = new Chunk("Tu texto 2", new Font(FontFamily.TIMES_ROMAN, 10, Font.ITALIC));
                Chunk texto1 = new Chunk("Al ALUMNO: ");
                Chunk texto2 = new Chunk(name + ".", new Font(FontFamily.HELVETICA, 15, Font.BOLD));
                Chunk texto3 = new Chunk("\nES ALUMNO REGULAR EN EL ");
                Chunk texto4 = new Chunk(grado, font1);
                Chunk texto5 = new Chunk("°. GRADO GRUPO: '");
                Chunk texto6 = new Chunk(grupo, font1);
                Chunk texto7 = new Chunk("' CON NUMERO DE ");
                Chunk texto8 = new Chunk("MATRICULA ");
                Chunk texto9 = new Chunk(matricula, font1);
                Chunk texto10 = new Chunk(" CURP: ");
                Chunk texto11 = new Chunk(curp+",", font1);
                Chunk texto12 = new Chunk("  SEGUN DOCUMENTOS QUE OBRAN EN EL ARCHIVO DE ESTE PLANTEL EDUCATIVO,");
                Chunk texto13 = new Chunk(" EN EL PRESENTE CICLO ESCOLAR  ");
                Chunk texto14 = new Chunk(dato2+",  ", font1);
                Chunk texto15 = new Chunk("OBTENIENDO LAS SIGUIENTES CALIFICACIONES EN EL SIGUIENTE TRIMESTRE. \n\n\n");

                Pagare1.add(texto1);
                Pagare1.add(texto2);
                Pagare1.add(texto3);
                Pagare1.add(texto4);
                Pagare1.add(texto5);
                Pagare1.add(texto6);
                Pagare1.add(texto7);
                Pagare1.add(texto8);
                Pagare1.add(texto9);
                Pagare1.add(texto10);
                Pagare1.add(texto11);
                Pagare1.add(texto12);
                Pagare1.add(texto13);
                Pagare1.add(texto14);
                Pagare1.add(texto15);
                Pagare1.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(Pagare1);

                // -*-*-*-*-*-*-*-*-*-*-**-*-* AQUI SE IMPRIME LA TABLA DE CALIFICACIONES -*-*-*-*-*-*-*-*-*-*---*-*

                PdfPTable tabla = new PdfPTable(10);
                tabla.setWidths(new int[]{11,7,7,9,7,7,7,7,9,7});
                tabla.addCell(new Phrase("PERIODO", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase(" ESP", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase(" MAT", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("CIE.NAT", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase(" GEO", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase(" HIST", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("F.CIV", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("ART", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("EDU.FIS", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("PROM", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER))); 
                
                
                tabla.addCell(new Phrase("\n       "+opcionP+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n    "+LenguaMat+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n     "+matematicas+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+cienciasnaturales+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n     "+geografia+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n     "+historia+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n     "+formacionCivica+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n     "+artes+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n      "+educacionFisica+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                tabla.addCell(new Phrase("\n           "+promedio+"\n", FontFactory.getFont(FontFactory.defaultEncoding, 11,Element.ALIGN_CENTER)));
                
                documento.add(tabla);
                
                // Texto de Datos del Alumno
                Paragraph PagareF = new Paragraph();
                Font font2 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

                //Chunk texto1 = new Chunk(name, font1);
                //Chunk texto3 = new Chunk("Tu texto 2", new Font(FontFamily.TIMES_ROMAN, 10, Font.ITALIC));
                Chunk textoF1 = new Chunk("\n\nAPETICION DE LA PARTE INTERESADA Y PARA LOS USOS LEGALES QUE ");
                Chunk textoF2 = new Chunk("HAYA LUGAR, SE EXTIENDE LA PRESENTE EN LA CIUDAD DE TUXTLA ");
                Chunk textoF3 = new Chunk("GUTIERREZ, CHIAPAS. A LOS ");
                Chunk textoF4 = new Chunk(dia.getText(), font2);
                Chunk textoF5 = new Chunk(" DIAS DEL MES DE ");
                Chunk textoF6 = new Chunk(mes.getText(), font2);
                Chunk textoF7 = new Chunk(" DEL AÑO ");
                Chunk textoF8 = new Chunk(año.getText(),font2);
                Chunk textoF9 = new Chunk("\n\n\n                                                                    ATENTAMENTE\n",font2);
                Chunk textoF10 = new Chunk("                                                        DIRECTOR DE LA ESCUELA ",font2);
                Chunk textoF11 = new Chunk("\n\n\n\n\n                                                       "+dato+".",font2);

                PagareF.add(textoF1);
                PagareF.add(textoF2);
                PagareF.add(textoF3);
                PagareF.add(textoF4);
                PagareF.add(textoF5);
                PagareF.add(textoF6);
                PagareF.add(textoF7);
                PagareF.add(textoF8);
                PagareF.add(textoF9);
                PagareF.add(textoF10);
                PagareF.add(textoF11);
                PagareF.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(PagareF);
                
                
                JOptionPane.showMessageDialog(null, "Documento Creado con ¡Exito!");
                documento.close();
            }catch(Exception e){
                System.out.println("Error: "+ e);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada o Rellena los capos de Dia, Mes o Año");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /*
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
            java.util.logging.Logger.getLogger(impresCal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(impresCal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(impresCal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(impresCal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new impresCal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField año;
    private javax.swing.JTextField buscador1;
    private javax.swing.JTextField buscador3;
    private javax.swing.JTextField buscar;
    private javax.swing.JComboBox<String> comboP;
    private javax.swing.JTextField contadorX;
    private javax.swing.JTextField contadorX2;
    private javax.swing.JTextField dia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jtable_datos;
    private javax.swing.JTable jtable_datos2;
    private javax.swing.JTable jtable_datos3;
    private javax.swing.JTextField mes;
    private javax.swing.JTable tablaAlumno;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private static class Opcion {

        public Opcion() {
        }
    }
}
