/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newpackage;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ElianLv Siempre Real
 * Cuando empece a elborar el proyecto pense que nunca lo lograria
 * en estos momento solo me falta la carta de buena conducta para concluir 
 * -*-*-*-*--*-*-LO IMPOSIBLE SIEMPRE ESTA SUCEDIENDO-*-*-*-*-*-*-*-*-*-*-*-*-*-*
 */
public class carta_conducta extends javax.swing.JFrame {

    ConexionBD con = new ConexionBD();
    Connection cn = (Connection) con.conexion();
    
    String[] Titulos = {"ID", "NOMBRE", "CURP", "MATRICULA","ESTATUS", "GRADO","GRUPO"};
    ResultSet rs;
    String[][] M_datos;
    DefaultTableModel dtm_datos = new DefaultTableModel();
    TableRowSorter<TableModel> trs;
    
    public carta_conducta() {
        initComponents();
        this.setLocationRelativeTo(null);
        updateCombo();
    }
    
    public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/logopeque.png"));
        return retValue;
    }

    String direc; // este contiene el nombre del director
    String ciclo; // este contiene el Ciclo escolar actual
    
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
                direc = rs.getString("nombredirec");
                ciclo = rs.getString("ciclo_escolar");
            }
        } catch (Exception e) {
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jt_buscador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ContadorX = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_datos = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        dia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mes = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        año = new javax.swing.JTextField();
        comboP = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel1.setText("Cartas de Buena Conducta");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Generador PDF'S");

        jt_buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_buscadorActionPerformed(evt);
            }
        });
        jt_buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jt_buscadorKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel3.setText("Filtro:");

        ContadorX.setEditable(false);

        jtable_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtable_datos);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        jButton1.setText("Generar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Conducta:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Mes:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Año:");

        comboP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALA", "REGULAR", "BUENA" }));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dia:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(274, 274, 274)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dia, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(año))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(238, 238, 238))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(302, 302, 302)
                                        .addComponent(jButton1)
                                        .addGap(71, 71, 71)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ContadorX, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(204, 204, 204))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jt_buscador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(ContadorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_buscadorActionPerformed

    private void jt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscadorKeyReleased
        int valor = 0;
        int cont = 0;
        int conter = 0;
        int grad = 6;
        String aux = "" + jt_buscador.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        try {
            java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            ResultSet rs = st_cont.executeQuery("select COUNT(*) from alumno inner join grupo on alumno.grupo_idgrado=grupo.id_grado where grupo.id_grado like'" + jt_buscador.getText() + "%' and grupo.grado like'" +grad+"'");

            if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                valor = rs.getInt(1);
                conter = rs.getInt(1);
                ContadorX.setText(conter+"");
            }
            

            M_datos = new String[valor][7];
            rs = st_cont.executeQuery("select * from alumno inner join grupo on alumno.grupo_idgrado=grupo.id_grado where grupo.id_grado like'" + jt_buscador.getText() + "%' and grupo.grado like'" +grad+"'"); //aqui es donde buscaremos a a la persona en especifico o las personas
            while (rs.next()) {
                M_datos[cont][0] = rs.getString("id");
                M_datos[cont][1] = rs.getString("nombre");
                M_datos[cont][2] = rs.getString("curp");
                M_datos[cont][3] = rs.getString("matricula");
                M_datos[cont][4] = rs.getString("estatus");
                M_datos[cont][5] = rs.getString("grupo.grado");
                M_datos[cont][6] = rs.getString("grupo.grupo");
                cont = cont + 1;
            }
            dtm_datos = new DefaultTableModel(M_datos, Titulos) {
                public boolean isCellEditable(int row, int column) {//este metodo es muy util si no quieren que editen su tabla,
                    return false;  //si quieren modificar los campos al dar clic entonces borren este metodo
                }
            };
            jtable_datos.setModel(dtm_datos);
            trs = new TableRowSorter<>(dtm_datos);
            jtable_datos.setRowSorter(trs);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jt_buscadorKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        alumno_edit newframe = new alumno_edit();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Aqui se Geran las cartas de Buena Conducta
        
        int fila = jtable_datos.getSelectedRow();
        if (fila >= 0 && dia.getText().length() >= 1 && mes.getText().length() >= 1 && año.getText().length() >= 1) {
            String nombreA = jtable_datos.getValueAt(fila, 1).toString();
            String curp = jtable_datos.getValueAt(fila, 2).toString();
            String matricula = jtable_datos.getValueAt(fila, 3).toString();
            String status = jtable_datos.getValueAt(fila, 4).toString();
            String grad = jtable_datos.getValueAt(fila, 5).toString();
            String grup = jtable_datos.getValueAt(fila, 6).toString();
            
            // -*-*-*-*-*-*-*-*-*-*- GENERACION DE BOLETA PARA MATCAL_12 -*-*-*-*-*-*-*-*-*-*-*-*-*-
            Document documento = new Document();
            try{
                String opcionP = comboP.getSelectedItem().toString(); // aqui pido el perido que nesesita ver
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/CartaConduc/"+grad+""+ grup+" "+nombreA+".pdf"));

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
                    f.setFamily(Font.FontFamily.TIMES_ROMAN.name());
                    f.setStyle(Font.BOLD);
                    f.setSize(11);

                    // Estilo de texto "CONSTANCIA DE ESTUDIO"
                    Font f2 = new Font();
                    f2.setFamily(Font.FontFamily.COURIER.name());
                    f2.setStyle(Font.BOLD);
                    f2.setSize(20);  

                    //Fuentes para poder usar
                    Font f3 = new Font();
                    f3.setFamily(Font.FontFamily.TIMES_ROMAN.name());
                    f3.setStyle(Font.BOLD);
                    f3.setSize(13);
                    
                    // Texto Superior
                    documento.add(logo);
                    paragraphHello.setFont(f); //para que le de estilo negrita
                    paragraphHello.add("SECRETARIA DE EDUCACION\n");
                    paragraphHello.add("SUBSECRETARÍA DE EDUCACIÓN FEDERALIZADA\n");
                    paragraphHello.add("DIRECCIÓN DE EDUCACIÓN PRIMARIA\n");
                    paragraphHello.add("JEFATURA DE SECTOR N° 04\n");
                    paragraphHello.add("SUPERVISIÓN ESCOLAR N° 131\n");
                    paragraphHello.add("ESC. PRIM. ROSARIO CASTELLANOS FIGUEROA\n");
                    paragraphHello.add("CLAVE: 07DPR1164G\n\n\n\n\n");
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
                    Consta.add("HACE CONSTAR \n\n\n\n");
                    Consta.setAlignment(Element.ALIGN_CENTER);

                    documento.add(Consta);
                    
                    // Texto de Datos del Alumno
                    Paragraph Pagare1 = new Paragraph();
                    Font font1 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

                    Chunk texto1 = new Chunk("Al ALUMNO: ");
                    Chunk texto2 = new Chunk(nombreA + ".", new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD));
                    Chunk texto3 = new Chunk("\nCURSO DE MANERA SATISFACTORIA EL ");
                    Chunk texto4 = new Chunk(grad, font1);
                    Chunk texto5 = new Chunk("°. GRADO GRUPO: '");
                    Chunk texto6 = new Chunk(grup, font1);
                    Chunk texto7 = new Chunk("' CON NUMERO DE ");
                    Chunk texto8 = new Chunk("MATRICULA: ");
                    Chunk texto9 = new Chunk(matricula, font1);
                    Chunk texto10 = new Chunk(" SEGUN DOCUMENTOS QUE OBRAN EN EL ARCHIVO DE ESTE PLANTEL EDUCATIVO Y ");
                    Chunk texto11 = new Chunk(" HA OBSERVADO "+opcionP+" CONDUCTA ",font1);
                    Chunk texto12 = new Chunk("EN EL PRESENTE CICLO ESCOLAR ");
                    Chunk texto13 = new Chunk(ciclo+". \n\n", font1);
                    

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
                    
                    Pagare1.setAlignment(Element.ALIGN_JUSTIFIED);

                    documento.add(Pagare1);
                    
                    // Texto de Datos de bloque final
                    Paragraph PagareF = new Paragraph();
                    Font font2 = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

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
                    Chunk textoF11 = new Chunk("\n\n\n\n\n                                                       "+direc+".",font2);

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
                
                    JOptionPane.showMessageDialog(null, "Carta Conducta Creada Con Exito");
                    
                documento.close();
                
            }catch(DocumentException | HeadlessException | IOException e){
                System.out.println("Erro: " + e);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada o Campos Fecha Vacios");
        }
        
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
            java.util.logging.Logger.getLogger(carta_conducta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(carta_conducta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(carta_conducta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(carta_conducta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new carta_conducta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ContadorX;
    private javax.swing.JTextField año;
    private javax.swing.JComboBox<String> comboP;
    private javax.swing.JTextField dia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jt_buscador;
    private javax.swing.JTable jtable_datos;
    private javax.swing.JTextField mes;
    // End of variables declaration//GEN-END:variables
}
