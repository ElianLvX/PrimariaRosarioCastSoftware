/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newpackage;

import java.sql.*;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter; // Para poder escribir texto
import java.io.FileOutputStream;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.IOException;

/**
 *
 * @author ElianLv
 */
public class alumno_constancias extends javax.swing.JFrame {

    ConexionBD con = new ConexionBD();
    Connection cn = (Connection) con.conexion();

    String[] Titulos = {"ID", "NOMBRE", "GRADO", "GRUPO", "MATRICULA", "CURP"};
    ResultSet rs;
    String[][] M_datos;
    DefaultTableModel dtm_datos = new DefaultTableModel();
    TableRowSorter<TableModel> trs;

    public alumno_constancias() {
        initComponents();
        this.setLocationRelativeTo(null);
        updateCombo();
    }
    
    public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/logopeque.png"));
        return retValue;
    }
    
    void limpiar(){
        txtNombre.setText("");
        txtGrado.setText("");
        txtGrupo.setText("");
        txtMatricula.setText("");
        txtCurp.setText("");
        buscar.setText("");
        dia.setText("");
        mes.setText("");
        año.setText("");
    }
    
    String dato; // este contiene el nombre del director
    String dato2; // este contiene el Ciclo escolar actual
    
    // este metodo sirve para llenar el combo box de los datos de la base de datos
    private void updateCombo() {
        Connection con1 = null;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_datos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jt_buscador = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dia = new javax.swing.JTextField();
        mes = new javax.swing.JTextField();
        año = new javax.swing.JTextField();
        ContadorX = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel1.setText("Generador de Constancias");

        jtable_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtable_datos);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Grado: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dia:");

        txtGrado.setEditable(false);

        txtNombre.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Grupo: ");

        txtGrupo.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Matricula: ");

        txtMatricula.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Curp: ");

        txtCurp.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Filtro:");

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Nombre: ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Mes:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Año:");

        ContadorX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ContadorXKeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 51, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Subir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buscar.setEditable(false);

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Generar Constancia");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        limpiar.setBackground(new java.awt.Color(255, 204, 0));
        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel4))
                                            .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGrupo))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                            .addComponent(txtCurp))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(ContadorX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(limpiar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                        .addGap(91, 91, 91)
                                        .addComponent(jButton3)
                                        .addGap(0, 187, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(293, 293, 293)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(17, 17, 17)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContadorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(año, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscadorKeyReleased
        // Codigo para el filtro de alumnos

        int valor = 0;
        int cont = 0;
        int conter = 0;
        String aux = "" + jt_buscador.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        try {
            java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            ResultSet rs = st_cont.executeQuery("SELECT COUNT(*) FROM alumno WHERE grupo_idgrado LIKE'" + jt_buscador.getText() + "%'");

            if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                valor = rs.getInt(1);
                conter = rs.getInt(1);
                ContadorX.setText(conter + "");
            }

            M_datos = new String[valor][6];
            rs = st_cont.executeQuery("select alumno.id, alumno.nombre, alumno.matricula, alumno.curp, grupo.grado as Grado, grupo.grupo as Grupo from alumno inner join grupo on alumno.grupo_idgrado=grupo.id_grado where id_grado like'" + jt_buscador.getText() + "%'"); //aqui es donde buscaremos a a la persona en especifico o las personas
            while (rs.next()) {
                M_datos[cont][0] = rs.getString("id");
                M_datos[cont][1] = rs.getString("nombre");
                M_datos[cont][2] = rs.getString("Grado");
                M_datos[cont][3] = rs.getString("Grupo");
                M_datos[cont][4] = rs.getString("Matricula");
                M_datos[cont][5] = rs.getString("Curp");
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

    private void ContadorXKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContadorXKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ContadorXKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = jtable_datos.getSelectedRow();
        if (fila >= 0) {
            buscar.setText(jtable_datos.getValueAt(fila, 0).toString());
            txtNombre.setText(jtable_datos.getValueAt(fila, 1).toString());
            txtGrado.setText(jtable_datos.getValueAt(fila, 2).toString());
            txtGrupo.setText(jtable_datos.getValueAt(fila, 3).toString());
            txtMatricula.setText(jtable_datos.getValueAt(fila, 4).toString());
            txtCurp.setText(jtable_datos.getValueAt(fila, 5).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada o Campos Fecha Vacios");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Constancias/"+txtNombre.getText()+" "+txtGrado.getText()+""+txtGrupo.getText()+".pdf"));
            
            // Apartado para incluir logo "SEP"
            Image logo = Image.getInstance(ruta+"/img/se.jpg");
            logo.scaleToFit(130,160);
            logo.setAbsolutePosition(60F, 705F);
            
            // Apartado para mandar a llmar la imagen "Marca de Agua"
            Image header = Image.getInstance(ruta+"/img/logoa.jpg");
            header.scaleToFit(520, 520);
            header.setAbsolutePosition(70f, 130f);
            
            System.out.println("Estoi Aqui");
            // Apartir de aqui va el codigo para poder llenar el documento 
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
            
            String name = txtNombre.getText();
            String grado = txtGrado.getText();
            String grupo = txtGrupo.getText();
            String matricula = txtMatricula.getText();
            String curp = txtCurp.getText();
            
            // Texto Superior
            documento.add(logo);
            paragraphHello.setFont(f); //para que le de estilo negrita
            paragraphHello.add("\n");
            paragraphHello.add("SECRETARIA DE EDUCACION\n");
            paragraphHello.add("SUBSECRETARÍA DE EDUCACIÓN FEDERALIZADA\n");
            paragraphHello.add("DIRECCIÓN DE EDUCACIÓN PRIMARIA\n");
            paragraphHello.add("JEFATURA DE SECTOR N° 04\n");
            paragraphHello.add("SUPERVISIÓN ESCOLAR N° 131\n");
            paragraphHello.add("ESC. PRIM. ROSARIO CASTELLANOS FIGUEROA\n");
            paragraphHello.add("CLAVE: 07DPR1164G\n\n\n\n");
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
                    + " 'ROSARIO CASTELLANOS FIGUEROA' TURNO MATUTINO, UBICADA EN AV. "
                    + " ROSA DEL ORIENTE Y AV.ROSA DEL NORTE DE LA COLONIA INFONAVIT EL"
                    + " ROSARIO EN CIUDAD DE TUXTLA GUTIERREZ, CHIAPAS; MEXICO, EXPIDE:\n\n\n\n");
            paragraphLorem.setAlignment(Element.ALIGN_JUSTIFIED);

            documento.add(paragraphLorem);
            
            // Texto de "CONSTANCIADE ESTUDIO"
            Paragraph Consta = new Paragraph();
            Consta.setFont(f2);
            Consta.add("CONSTANCIA DE ESTUDIO \n\n\n\n");
            Consta.setAlignment(Element.ALIGN_CENTER);
            
            documento.add(Consta);
            
            // Texto de Datos del Alumno ---- -->>
                Paragraph Pagare1 = new Paragraph();
                Font font1 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

                //Chunk texto1 = new Chunk(name, font1);
                //Chunk texto3 = new Chunk("Tu texto 2", new Font(FontFamily.TIMES_ROMAN, 10, Font.ITALIC));
                Chunk texto1 = new Chunk("Al ALUMNO: ");
                Chunk texto2 = new Chunk(name + ".", new Font(FontFamily.HELVETICA, 15, Font.BOLD));
                Chunk texto3 = new Chunk("\nSE ENCUENTRA INSCRITO EN EL ");
                Chunk texto4 = new Chunk(grado, font1);
                Chunk texto5 = new Chunk("°. GRADO GRUPO: '");
                Chunk texto6 = new Chunk(grupo, font1);
                Chunk texto7 = new Chunk("' CON NUMERO DE ");
                Chunk texto8 = new Chunk("MATRICULA: ");
                Chunk texto9 = new Chunk(matricula, font1);
                Chunk texto10 = new Chunk(" CURP: ");
                Chunk texto11 = new Chunk(curp+",", font1);
                Chunk texto12 = new Chunk("  SEGUN DOCUMENTOS QUE OBRAN EN EL ARCHIVO DE ESTE PLANTEL EDUCATIVO,");
                Chunk texto13 = new Chunk(" EN EL PRESENTE CICLO ESCOLAR  ");
                Chunk texto14 = new Chunk(dato2+".  ", font1);

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
                Pagare1.setAlignment(Element.ALIGN_JUSTIFIED);

                documento.add(Pagare1);
           
            // Texto de Datos de bloque final -------->
                Paragraph PagareF = new Paragraph();
                Font font2 = new Font(FontFamily.HELVETICA, 12, Font.BOLD);// Estilos para las variables del alumno

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
            
            documento.close();

            JOptionPane.showMessageDialog(null, "Documento Creado Con ¡Exito!");// Fin de Codigo para el documento
        } catch (DocumentException | HeadlessException | IOException e) {
            System.out.println("eror:" + e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jt_buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_buscadorActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Home newframe = new Home();
        newframe.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(alumno_constancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alumno_constancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alumno_constancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alumno_constancias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new alumno_constancias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ContadorX;
    private javax.swing.JTextField año;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField dia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jt_buscador;
    private javax.swing.JTable jtable_datos;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField mes;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
