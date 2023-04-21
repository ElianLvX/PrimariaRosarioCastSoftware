/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.sql.*;

public class ConexionBD {
    Connection cn;
    Statement st;
    // 192.168.1.232
    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/primariarosario","root","");
            System.out.println("Conexion Exitosa");
        } catch(ClassNotFoundException | SQLException e) {
            System.out.print(e.getMessage());
        }
        return cn;
    }
    Statement createStatement() {
        throw new UnsupportedOperationException("No Soportado");
    }
}
