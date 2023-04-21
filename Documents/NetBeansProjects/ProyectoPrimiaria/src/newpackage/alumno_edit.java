/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newpackage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * @author ElianLv
*/
public class alumno_edit extends javax.swing.JFrame {

    ConexionBD con = new ConexionBD();
    Connection cn = (Connection) con.conexion();
    
    String[] Titulos = {"ID", "NOMBRE", "CURP", "MATRICULA","ESTATUS", "GRADO/GRUPO"};
    ResultSet rs;
    String[][] M_datos;
    DefaultTableModel dtm_datos = new DefaultTableModel();
    TableRowSorter<TableModel> trs;
    
    public alumno_edit() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrartabla();
        updateCombo();
        cicloEscolar();
    }
    public java.awt.Image getIconImage() {
        java.awt.Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/logopeque.png"));
        return retValue;
    }
    
    // Metodo para Limpiar Los textField
    void limpiar(){
        txtNombre.setText("");
        txtCurp.setText("");
        txtMatricula.setText("");
        //txtEstatus.setText("");
        txtGradMov.setText("");
    }
    
    String grupo; // este contiene el grupo
    String grado; //  este contiene el grado
    // este metodo sirve para poder saber en que grupo estan los alumnos al momento de hacer las listas
    private void gradGrup(String val) {
        java.sql.PreparedStatement pst = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM alumno inner join grupo on alumno.grupo_idgrado=grupo.id_grado WHERE grupo.id_grado LIKE'" + val +"'";
        try {
            pst = (java.sql.PreparedStatement) cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                grupo = rs.getString("grupo.grupo");
                grado = rs.getString("grupo.grado");
            }
        } catch (Exception e) {
            
        }
    }
    
    String dato; // este contiene el nombre del director
    // este metodo sirve para llenar el combo box de los datos de la base de datos
    private void cicloEscolar() {
        java.sql.PreparedStatement pst = null;
        ResultSet rs = null;
        
        String sql = "select * from interface";
        try {
            pst = (java.sql.PreparedStatement) cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                dato = rs.getString("ciclo_escolar");
                System.out.print(dato);
            }
        } catch (SQLException e) {
            
        }
    }
    
    // este metodo sirve para llenar el combo box de los datos de la base de datos
    private void updateCombo() {
        Connection con1 = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String sql = "select * from grupo";
        try {
            pst = (PreparedStatement) cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                cboGrupos.addItem(rs.getString("id_grado"));
            }
        } catch (Exception e) {
            
        }
    }

    // Metodo ´para mostrar Alumnos
    void mostrartabla(){
        int contador = 0;  //creamos un contador para saber el numero de datos que obtendremos de la tabla datos de sql
        try { //para las consultas sql siempre vamos a ocupar un try catch por su ocurre un error
            java.sql.Statement st_cont = cn.createStatement(); //el statement nos ayuda a procesar una sentencia sql 
            ResultSet rs_cont = st_cont.executeQuery("SELECT COUNT(*) FROM alumno"); // asignamos los datos obtenidos de la consulta al result set
             if (rs_cont.next()) {
                contador = rs_cont.getInt(1);
            }
             
            java.sql.Statement st = cn.createStatement(); //ahora vamos a  hacer lo mismo solo que esta vez no obtendremos el numero de filas en la tabla
            rs = st.executeQuery("SELECT * FROM alumno"); //aora obtendremos los datos de la tabla para mostrarlos en el jtable
            
            int cont = 0; //el contador nos ayudara para movernos en las filas de la matriz mientras que los numeros fijos (0,1,2,3) nos moveran por las 4 columnas que seran el id, nombre, etc
            M_datos = new String[contador][6]; //definimos el tamaño de la matriz 
            while (rs.next()) { //el while nos ayudara a recorrer los datos obtenidos en la consulta anterior y asignarlos a la matriz  
                M_datos[cont][0] = rs.getString("id");    //agregamos los datos a la table
                M_datos[cont][1] = rs.getString("nombre");
                M_datos[cont][2] = rs.getString("curp");
                M_datos[cont][3] = rs.getString("matricula");
                M_datos[cont][4] = rs.getString("estatus");
                M_datos[cont][5] = rs.getString("grupo_idgrado");
                cont = cont + 1; //avanzamos una posicion del contador para que pase a la siguiente fila
            }

        } catch (SQLException ex) {
            Logger.getLogger(alumno_edit.class.getName()).log(Level.SEVERE, null, ex); //si llegara a ocurrir un error ya se  una mala consulta o mala conexion aqui nos lo mostraria
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCurp = new javax.swing.JTextField();
        txtMatricula = new javax.swing.JTextField();
        txtEstatus = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cboGrupos = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_datos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ContadorX = new javax.swing.JTextField();
        jt_buscador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtGradMov = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel1.setText("Dashbord Alumnos");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre: ");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Curp:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Estatus:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Matricula:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Grupo:");

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jtable_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtable_datos);

        jButton1.setBackground(new java.awt.Color(102, 255, 0));
        jButton1.setText("Guardar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setText("Actualizar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 0));
        jButton3.setText("Limpiar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Eliminar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 255, 204));
        jButton5.setText("Modificar");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        buscar.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel3.setText("Filtro:");

        ContadorX.setEditable(false);

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

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Num.Alumnos:");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/protocolos.png"))); // NOI18N
        jButton7.setText("Generar");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel4.setText("Constancias:");

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel10.setText("Listas:");

        jButton8.setBackground(new java.awt.Color(204, 204, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        jButton8.setText("Entrar");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel11.setText("Mover:");

        jButton9.setBackground(new java.awt.Color(51, 255, 102));
        jButton9.setText("Realizar");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/informacion.png"))); // NOI18N
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel12.setText("Buena Conducta:");

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel13.setText("Cartas De");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contrato.png"))); // NOI18N
        jButton11.setText("IR");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4)))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton5)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(buscar)
                                                .addComponent(cboGrupos, 0, 83, Short.MAX_VALUE)))
                                        .addGap(101, 101, 101)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(ContadorX, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(787, 787, 787)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(jButton7)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGradMov)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(jButton11))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton7))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ContadorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton8))
                        .addGap(52, 52, 52)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGradMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            ResultSet rs = st_cont.executeQuery("SELECT * FROM alumno WHERE matricula LIKE'" + txtMatricula.getText() + "%'");

            if (rs.last()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                JOptionPane.showMessageDialog(null, "Alumno Ya Registrado");
            } else {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO alumno(nombre,curp,matricula,estatus,grupo_idgrado) VALUES(?,?,?,?,?)");
                String opcion = cboGrupos.getSelectedItem().toString(); // esto es para obtener el valor de la opcion seleccionada y pasarlo a string
                pps.setString(1, txtNombre.getText());
                pps.setString(2, txtCurp.getText());
                pps.setString(3, txtMatricula.getText());
                pps.setString(4, txtEstatus.getText());
                pps.setString(5, opcion);
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Alumno Agregado");
                limpiar();
                mostrartabla();
            }

        } catch (SQLException ex) {
            Logger.getLogger(maestro_edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int fila = jtable_datos.getSelectedRow();
        if(fila>=0) {
            buscar.setText(jtable_datos.getValueAt(fila, 0).toString());
            txtNombre.setText(jtable_datos.getValueAt(fila, 1).toString());
            txtCurp.setText(jtable_datos.getValueAt(fila, 2).toString());
            txtMatricula.setText(jtable_datos.getValueAt(fila, 3).toString());
            txtEstatus.setText(jtable_datos.getValueAt(fila, 4).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PreparedStatement pps;
        String opcion = cboGrupos.getSelectedItem().toString();
        
        try {
            pps = (PreparedStatement) cn.prepareStatement("UPDATE alumno SET nombre='"+txtNombre.getText()+"',curp='"
                    +txtCurp.getText()+"',matricula='"+txtMatricula.getText()+"',estatus='"+txtEstatus.getText()+"',grupo_idgrado='"
                    +opcion+"' WHERE id='"+buscar.getText()+"';");
            pps.execute();
            JOptionPane.showMessageDialog(null, "Alumno Acutliazado");
            limpiar();
            mostrartabla();
        } catch (SQLException ex) {
            Logger.getLogger(alumno_edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int fila=jtable_datos.getSelectedRow();
        String valor = jtable_datos.getValueAt(fila, 0).toString();
        if(fila>=0){
            try {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("DELETE FROM alumno WHERE id='"+valor+"'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Alumno Eliminado"); 
                mostrartabla();
            } catch (SQLException ex) {
                Logger.getLogger(alumno_edit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_buscadorKeyReleased
        int valor = 0;
        int cont = 0;
        int conter = 0;
        String aux = "" + jt_buscador.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
            try {
                java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
                ResultSet rs = st_cont.executeQuery("SELECT COUNT(*) FROM alumno WHERE grupo_idgrado LIKE'" + jt_buscador.getText() + "%' or nombre like'" +jt_buscador.getText()+ "'");
                
                if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                    valor = rs.getInt(1);
                    conter = rs.getInt(1);
                    ContadorX.setText(conter+"");
                }
                
                    M_datos = new String[valor][6];
                    rs = st_cont.executeQuery("SELECT * FROM alumno WHERE grupo_idgrado LIKE'" + jt_buscador.getText() + "%' or nombre like'" +jt_buscador.getText()+ "'"); //aqui es donde buscaremos a a la persona en especifico o las personas
                    while (rs.next()) {
                        M_datos[cont][0] = rs.getString("id");    
                        M_datos[cont][1] = rs.getString("nombre");
                        M_datos[cont][2] = rs.getString("curp");
                        M_datos[cont][3] = rs.getString("matricula");
                        M_datos[cont][4] = rs.getString("estatus");
                        M_datos[cont][5] = rs.getString("grupo_idgrado");
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

    private void jt_buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_buscadorActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Home newframe = new Home();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Boton para generar Lista de Alumno
        String val;
        val = jt_buscador.getText();
        gradGrup(val);
        
        // -*-*-*-*-*-*-*-*-* DOCUMETO LISTA -*-*-*-*-*-*-*-*-*-
        Document documento = new Document();
        try{
            // Ruta de descarga para las listas
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Listas/"+grado+""+grupo+""+dato+""+".pdf"));
            
            //Logo de Primaria
            Image logo = Image.getInstance(ruta+"/img/logopeque.png");
            logo.scaleToFit(90,120);
            logo.setAbsolutePosition(55F, 750F);
            
            //Logo de la SEP
            Image sep = Image.getInstance(ruta+"/img/se.jpg");
            sep.scaleToFit(100,130);
            sep.setAbsolutePosition(480F, 770F);
            
            documento.open(); // aqui se abre todo lo que contendra el documento
            
            // Inicializaciones de texto Superior
            Paragraph paragrapTop = new Paragraph(); // Texto de arriva del principal
            
            // Aqui se inisializan las Fuestes y Tamaños de la misma
            //Fuentes para poder usar
            Font f = new Font();
            f.setFamily(Font.FontFamily.TIMES_ROMAN.name());
            f.setStyle(Font.BOLDITALIC);
            f.setSize(7);
            
            
            // Texto Superior
            documento.add(logo);
            documento.add(sep);
            paragrapTop.setFont(f); //para que le de estilo negrita
            paragrapTop.add("SECRETARIA DE EDUCACION\n");
            paragrapTop.add("SECRETARIA DE EDUCACION FEDERALIZADA\n");
            paragrapTop.add("DIRECCION DE EDUCACION PRIMARIA\n");
            paragrapTop.add("ESCUALA PRIMARIA 'ROSARIO CASTELLANOS FIGUEROA' C.C.T.:07DPR1164G\n");
            paragrapTop.add("Grado:__"+grado+"__.  "+ " Grupo:__"+grupo+"__. "+"  CICLO ESCOLAR: "+dato+"\n\n");
            paragrapTop.setAlignment(Element.ALIGN_CENTER);
            
            documento.add(paragrapTop);
            
            // Creacion de la tabla Principal
            PdfPTable tabla = new PdfPTable(17);
            tabla.setWidths(new int[]{1,5,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2});
            tabla.addCell(new Phrase("NP", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("Nombre de Alumno:", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            // Aqui empiezan las Columnas Vacias
            tabla.addCell(new Phrase("1", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("2", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("3", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("4", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("5", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("6", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("7", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("8", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("9", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("10", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("PG", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("PI", FontFactory.getFont(FontFactory.defaultEncoding, 6,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("DISC", FontFactory.getFont(FontFactory.defaultEncoding, 5,Element.ALIGN_CENTER)));
            tabla.addCell(new Phrase("UNIFORME", FontFactory.getFont(FontFactory.defaultEncoding, 5,Element.ALIGN_JUSTIFIED)));
            tabla.addCell(new Phrase("CALIFICACION", FontFactory.getFont(FontFactory.defaultEncoding, 5,Element.ALIGN_JUSTIFIED)));
            
            try{
                int numero = 1;
                String vacio = " ";
                String numeroX = "1";
                
                PreparedStatement pst = (PreparedStatement) cn.prepareStatement("SELECT * FROM alumno WHERE grupo_idgrado LIKE'" + jt_buscador.getText() + "%'");
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){ // aqui se verifican si se encontraron dotos con la consulta antes realizada
                    do{
                        tabla.addCell(new Phrase(numeroX, FontFactory.getFont(FontFactory.defaultEncoding, 5)));
                        numero = Integer.parseInt(numeroX) + 1;
                        tabla.addCell(new Phrase(rs.getString(2), FontFactory.getFont(FontFactory.defaultEncoding, 5))); // Aqui llamo el nombre de la tabla
                        // aqui empiezan las columnas vacias
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        tabla.addCell(new Phrase(vacio));
                        numeroX = numero+"";
                    }while(rs.next());
                    documento.add(tabla);
                }
            }catch(DocumentException | SQLException e){
            }
            
            documento.close(); // aqui se cierra el documento
            
            JOptionPane.showMessageDialog(null, "Lista Creada Con ¡Exito!");// Fin de Codigo para el documento
            
        }catch(DocumentException | HeadlessException | IOException e){
            
        }
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // Enlace para ir a la vista donde se generan las constancias
        alumno_constancias newframe = new alumno_constancias();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //Este apartado sera para poder mover los alumnos que se necesiten 
        PreparedStatement pps;
        String gradInicial = jt_buscador.getText();
        String gradFinal = txtGradMov.getText();
        
        try{
            pps = (PreparedStatement) cn.prepareStatement("UPDATE alumno SET grupo_idgrado ='"+gradFinal+"' WHERE grupo_idgrado='"+gradInicial+"';");
            pps.execute();
            JOptionPane.showMessageDialog(null, "Grupo Actualizado");
            limpiar();
            mostrartabla();
        }catch(SQLException ex){
            Logger.getLogger(alumno_edit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // Boton Info
        
        JOptionPane.showMessageDialog(null, "Para mover alumnos la casilla 'filtro' debe \n de estallar llena con un grupo \n Y la casilla mover debe de teneer el grado y grupo a donde se va a mover");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        carta_conducta newframe = new carta_conducta();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(alumno_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alumno_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alumno_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alumno_edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new alumno_edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ContadorX;
    private javax.swing.JTextField buscar;
    private javax.swing.JComboBox<String> cboGrupos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jt_buscador;
    private javax.swing.JTable jtable_datos;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtEstatus;
    private javax.swing.JTextField txtGradMov;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
