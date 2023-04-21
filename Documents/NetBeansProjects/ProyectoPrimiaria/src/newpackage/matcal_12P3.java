/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newpackage;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ElianLv
 */
public class matcal_12P3 extends javax.swing.JFrame {

   
    ConexionBD con = new ConexionBD();
    Connection cn = (Connection) con.conexion();
    
    String[] Titulos = {"ID", "NOMBRE"}; // Para consultar los alumnos del grado seleccionaod
    String[] Titulos3 = {"ID","Alumno","LenguaMaterna","Matematicas","LenguaExtrangera","ConocimientoDelMedio","Artes","EducacionFisica","Promedio"}; // Para llenar las columnas de tabla calificaciones
    ResultSet rs;
    String[][] M_datos; // Primer arreglo de tablas de alumno
    String[][] M_datos2; // Para arreglo de tablas de Materias
    String[][] M_datos3; // Para arreglo de tablas de Calificaciones
    DefaultTableModel dtm_datos = new DefaultTableModel();
    DefaultTableModel dtm_datos2 = new DefaultTableModel();
    DefaultTableModel dtm_datos3 = new DefaultTableModel();
    TableRowSorter<TableModel> trs;
    
    public matcal_12P3() {
        initComponents(); 
        this.setLocationRelativeTo(null);
        txtLenMaterna.setText("0");
        txtMatematicas.setText("0");
        txtIngles.setText("0");
        txtConMedio.setText("0");
        txtArtes.setText("0");
        txtEduFisica.setText("0");
    }
    
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("img/logopeque.png"));
        return retValue;
    }
    
        // Metodo para Limpiar Los textField
    void limpiar(){
        txtAlumno.setText("");
        txtLenMaterna.setText("0");
        txtMatematicas.setText("0");
        txtIngles.setText("0");
        txtConMedio.setText("0");
        txtArtes.setText("0");
        txtEduFisica.setText("0");
        buscador3.setText("");
        buscar.setText("");
        id_alumnocal.setText("");
        txtPromedio.setText("");
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLenMaterna = new javax.swing.JTextField();
        buscador1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_datos = new javax.swing.JTable();
        contadorX = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        buscador3 = new javax.swing.JTextField();
        contadorX2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMatematicas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIngles = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtConMedio = new javax.swing.JTextField();
        txtArtes = new javax.swing.JTextField();
        txtEduFisica = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        id_alumnocal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtPromedio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel1.setText("Calificaciones Parciales Perido 3");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Lengua Materna:");

        txtLenMaterna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLenMaterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLenMaternaActionPerformed(evt);
            }
        });

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

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAlumno);

        jtable_datos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jtable_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtable_datos);

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Alumno:");

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Modificar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        limpiar.setBackground(new java.awt.Color(255, 255, 0));
        limpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        limpiar.setText("limpiar");
        limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Alumno:");

        txtAlumno.setEditable(false);

        guardar.setBackground(new java.awt.Color(51, 204, 0));
        guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        guardar.setText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        buscar.setEditable(false);

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

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Modificar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(255, 0, 0));
        eliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        actualizar.setBackground(new java.awt.Color(102, 255, 204));
        actualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Matematicas:");

        txtMatematicas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatematicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatematicasActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ingles:");

        txtIngles.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Artes:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Con.Del Medio:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Edu.Fisica:");

        txtConMedio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtArtes.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtEduFisica.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Solo agregar Calificaciones para Primero Y Segundo Grado");

        id_alumnocal.setEditable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/informacion.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtPromedio.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Promedio:");

        jLabel12.setText("Num Alumnos:");

        jLabel13.setText("Grado/Grupo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(257, 257, 257)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id_alumnocal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(476, 476, 476))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(contadorX, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(79, 79, 79)
                                            .addComponent(jButton1)
                                            .addGap(221, 221, 221)
                                            .addComponent(contadorX2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton4))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtAlumno)
                                                    .addGap(55, 55, 55))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(177, 177, 177)
                                                            .addComponent(jLabel7))
                                                        .addComponent(jLabel12)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(100, 100, 100)
                                                            .addComponent(buscador1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(guardar)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(252, 252, 252)
                                                    .addComponent(jLabel5)))))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addComponent(actualizar))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtMatematicas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtLenMaterna, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(27, 27, 27)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtIngles, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtConMedio, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtArtes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEduFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(buscador3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(limpiar)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guardar)
                            .addComponent(eliminar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtConMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(id_alumnocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtLenMaterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3)
                                    .addComponent(txtMatematicas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtArtes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIngles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(txtEduFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscador3)
                            .addComponent(jLabel6)
                            .addComponent(buscador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 32, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(contadorX2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(actualizar)
                    .addComponent(txtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contadorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1329, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contadorXKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contadorXKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_contadorXKeyReleased

    private void contadorXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contadorXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contadorXActionPerformed

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

            M_datos = new String[valor][2];
            rs = st_cont.executeQuery("SELECT * FROM alumno WHERE grupo_idgrado LIKE'" + buscador1.getText() + "%'"); //aqui es donde buscaremos a a la persona en especifico o las personas
            while (rs.next()) {
                M_datos[cont][0] = rs.getString("id");
                M_datos[cont][1] = rs.getString("nombre");
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

    private void buscador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscador1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int fila = tablaAlumno.getSelectedRow();
        if(fila>=0) {
            buscar.setText(tablaAlumno.getValueAt(fila, 0).toString());
            txtAlumno.setText(tablaAlumno.getValueAt(fila, 1).toString());
            buscador3.setText(tablaAlumno.getValueAt(fila, 1).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try {
            // Valores Estaticos
            int periodo = 3; // El periodo es esta vista es estatico es 1
            
            // Aqui se obtiene el ID alumno y se convierte a Integer
            int valor1Alumno = Integer.parseInt(buscar.getText()); // aqui obtenemos el ID del Alumno
      
            
            // -*-*-*-*-*-*- PARSEO DE CALIFICACIONES A FLOAT -*-*-*-*-*-*-*-*-*
            float valorCaliLenguaMaterna = Float.valueOf(txtLenMaterna.getText());
            float valorCaliMatematicas = Float.valueOf(txtMatematicas.getText());
            float valorCaliIngles = Float.valueOf(txtIngles.getText());
            float valorCaliConMedio = Float.valueOf(txtConMedio.getText());
            float valorCaliArtes = Float.valueOf(txtArtes.getText());
            float valorCaliEduFisica = Float.valueOf(txtEduFisica.getText());
            
            float promedio = 0; // aqui se almacena el promedio obtenido
            
            String conver = "";
            // -*-*-*-*-*-* CALCULAR PROMEDIO PERIODO 1 -*-*-*-*-*-*-*-*-*-*

            // Caso 1 si materia Lengua Materna no se Coloco
            if(valorCaliLenguaMaterna == 0){
                promedio = (valorCaliMatematicas+valorCaliIngles+valorCaliConMedio+valorCaliArtes+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 2 si materia Matematicas no se Coloco
            if(valorCaliMatematicas == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliIngles+valorCaliConMedio+valorCaliArtes+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 3 si materia Ingles no se Coloco
            if(valorCaliIngles == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliConMedio+valorCaliArtes+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 4 si materia ConMedio no se Coloco
            if(valorCaliConMedio == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliIngles+valorCaliArtes+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 5 si materia Artes no se coloco
            if(valorCaliArtes == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliIngles+valorCaliConMedio+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 6 si materia Educacuoion Fisica no se coloco
            if(valorCaliEduFisica == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliIngles+valorCaliConMedio+valorCaliArtes)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            if(valorCaliLenguaMaterna >= 1 && valorCaliMatematicas >= 1 && valorCaliIngles >= 1 && valorCaliConMedio >= 1 && valorCaliArtes >= 1 && valorCaliEduFisica >= 1){
                // Si se llenaron todos los inputs se sacara la calificacion de manera nornal
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliIngles+valorCaliConMedio+valorCaliArtes+valorCaliEduFisica)/6;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            
            
            PreparedStatement pps = (PreparedStatement) cn.prepareStatement("INSERT INTO matcal_12(lengua_materna,matematicas,lengua_extrangera,conocimiento_medio,artes,educacion_fisica,promedio,periodo,alumno_id) VALUES(" +valorCaliLenguaMaterna+ "," +valorCaliMatematicas+ "," +valorCaliIngles+","+valorCaliConMedio+","+valorCaliArtes+","+valorCaliEduFisica+","+promedio+","+periodo+","+valor1Alumno+")");
            pps.executeUpdate();
            limpiar();
            JOptionPane.showMessageDialog(null, "Calificaciones Agregadas");
            limpiar();

        } catch (SQLException ex) {
            Logger.getLogger(matcal_12.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void buscador3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscador3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscador3ActionPerformed

    private void buscador3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscador3KeyReleased
        // Codigo para filtrar las materias
        
        int periodo = 3;
        int valor = 0;
        int cont = 0;
        int conter = 0;
        String aux = "" + buscador3.getText();//aqui obtenemos cada letra que ingresemos en el textfield en tiempo real
        try {
            java.sql.Statement st_cont = cn.createStatement(); //hacemos lo mismo que con el metodo mostrar, buscamos el numero de filas dela tabla
            ResultSet rs = st_cont.executeQuery("select COUNT(*) from matcal_12 inner join alumno on matcal_12.alumno_id=alumno.id where alumno.nombre like'" + buscador3.getText() + "%'or alumno.grupo_idgrado like'" + buscador3.getText() + "%'and matcal_12.periodo like'" +periodo+"'");

            if (rs.next()) {// like nos ayudara a buscar nombres que tengan similitudes con lo que estamos escribiendo en el texfield
                valor = rs.getInt(1);
                conter = rs.getInt(1);
                contadorX2.setText(conter+"");
            }

            M_datos3 = new String[valor][9];
            rs = st_cont.executeQuery("select * from matcal_12 inner join alumno on matcal_12.alumno_id=alumno.id where alumno.nombre like'" + buscador3.getText() + "%'or alumno.grupo_idgrado like'" + buscador3.getText() + "%'and matcal_12.periodo like'" +periodo+"'");
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
                public boolean isCellEditable(int row, int column) {// este metodo es muy util si no quieren que editen su tabla,
                    return false;  // si quieren modificar los campos al dar clic entonces borren este metodo
                }
            };
            jtable_datos.setModel(dtm_datos3);
            trs = new TableRowSorter<>(dtm_datos3);
            jtable_datos.setRowSorter(trs);

        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_buscador3KeyReleased

    private void contadorX2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contadorX2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contadorX2ActionPerformed

    private void contadorX2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contadorX2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_contadorX2KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int fila = jtable_datos.getSelectedRow();
        if(fila>=0) {
            id_alumnocal.setText(jtable_datos.getValueAt(fila, 0).toString());
            txtLenMaterna.setText(jtable_datos.getValueAt(fila, 2).toString());
            txtMatematicas.setText(jtable_datos.getValueAt(fila, 3).toString());
            txtIngles.setText(jtable_datos.getValueAt(fila, 4).toString());
            txtConMedio.setText(jtable_datos.getValueAt(fila, 5).toString());
            txtArtes.setText(jtable_datos.getValueAt(fila, 6).toString());
            txtEduFisica.setText(jtable_datos.getValueAt(fila, 7).toString());
            txtPromedio.setText(jtable_datos.getValueAt(fila, 8).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fila No seleccionada");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int fila=jtable_datos.getSelectedRow();
        String valor = jtable_datos.getValueAt(fila, 0).toString();
        if(fila>=0){
            try {
                PreparedStatement pps = (PreparedStatement) cn.prepareStatement("DELETE FROM matcal_12 WHERE id='"+valor+"'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Eliminado"); 
                mostrartabla();
            } catch (SQLException ex) {
                Logger.getLogger(alumno_edit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        
        // -*-*-*-*-*-*- PARSEO DE CALIFICACIONES A FLOAT -*-*-*-*-*-*-*-*-*
        float valorCaliLenguaMaterna = Float.valueOf(txtLenMaterna.getText());
        float valorCaliMatematicas = Float.valueOf(txtMatematicas.getText());
        float valorCaliIngles = Float.valueOf(txtIngles.getText());
        float valorCaliConMedio = Float.valueOf(txtConMedio.getText());
        float valorCaliArtes = Float.valueOf(txtArtes.getText());
        float valorCaliEduFisica = Float.valueOf(txtEduFisica.getText());
        
        float promedio = 0; // aqui se almacena el promedio obtenido
        
        String conver = "";
        // -*-*-*-*-*-* CALCULAR PROMEDIO PERIODO 1 -*-*-*-*-*-*-*-*-*-*
            
            // Caso 1 si materia Lengua Materna no se Coloco
            if(valorCaliLenguaMaterna == 0){
                promedio = (valorCaliMatematicas+valorCaliIngles+valorCaliConMedio+valorCaliArtes+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 2 si materia Matematicas no se Coloco
            if(valorCaliMatematicas == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliIngles+valorCaliConMedio+valorCaliArtes+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 3 si materia Ingles no se Coloco
            if(valorCaliIngles == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliConMedio+valorCaliArtes+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 4 si materia ConMedio no se Coloco
            if(valorCaliConMedio == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliIngles+valorCaliArtes+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 5 si materia Artes no se coloco
            if(valorCaliArtes == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliIngles+valorCaliConMedio+valorCaliEduFisica)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            // Caso 6 si materia Educacuoion Fisica no se coloco
            if(valorCaliEduFisica == 0){
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliIngles+valorCaliConMedio+valorCaliArtes)/5;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
            if(valorCaliLenguaMaterna >= 1 && valorCaliMatematicas >= 1 && valorCaliIngles >= 1 && valorCaliConMedio >= 1 && valorCaliArtes >= 1 && valorCaliEduFisica >= 1){
                // Si se llenaron todos los inputs se sacara la calificacion de manera nornal
                promedio = (valorCaliLenguaMaterna+valorCaliMatematicas+valorCaliIngles+valorCaliConMedio+valorCaliArtes+valorCaliEduFisica)/6;
                conver = String.valueOf(promedio);
                conver = conver.substring(0,3);
                System.out.println("Valor Sin: " + conver);
                promedio = Float.parseFloat(conver);
                JOptionPane.showMessageDialog(null, "Promedio Alcanzado: "+promedio);
            }
        
        
        PreparedStatement pps;
        try {
            pps = (PreparedStatement) cn.prepareStatement("UPDATE matcal_12 SET lengua_materna='"+txtLenMaterna.getText()+"',matematicas='"
                    +txtMatematicas.getText()+"',lengua_extrangera='"+txtIngles.getText()+"',conocimiento_medio='"+txtConMedio.getText()+"',artes='"
                    +txtArtes.getText()+"',educacion_fisica='"+txtEduFisica.getText()+"',promedio='"+promedio+"' WHERE id='"+id_alumnocal.getText()+"';");
            pps.execute();
            JOptionPane.showMessageDialog(null, "Calificacion Actualizada");
            limpiar();
            mostrartabla();
        } catch (SQLException ex) {
            Logger.getLogger(alumno_edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Home newframe = new Home();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtMatematicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatematicasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatematicasActionPerformed

    private void txtLenMaternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLenMaternaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLenMaternaActionPerformed

    private void buscador1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscador1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_buscador1KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(null, "En este apartado Inserta Calificaciones de: \n 1er Grado y 2do Grado \n --> Si Quieres asignar calificaciones de los otros grados \n vuelve al menu de Calificaciones <-- \n\n De lo contrario el software no funcionara");
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
            java.util.logging.Logger.getLogger(matcal_12.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(matcal_12.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(matcal_12.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(matcal_12.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new matcal_12P3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JTextField buscador1;
    private javax.swing.JTextField buscador3;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField contadorX;
    private javax.swing.JTextField contadorX2;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField id_alumnocal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtable_datos;
    private javax.swing.JButton limpiar;
    private javax.swing.JTable tablaAlumno;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtArtes;
    private javax.swing.JTextField txtConMedio;
    private javax.swing.JTextField txtEduFisica;
    private javax.swing.JTextField txtIngles;
    private javax.swing.JTextField txtLenMaterna;
    private javax.swing.JTextField txtMatematicas;
    private javax.swing.JTextField txtPromedio;
    // End of variables declaration//GEN-END:variables
}
