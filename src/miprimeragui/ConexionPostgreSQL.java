/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miprimeragui;

/**
 *
 * @author ALEX DAVID RUIDIAZ C
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionPostgreSQL {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/Tareas"; 
        String usuario = "postgres";
        String contraseña = "0000";

        try {
            // Cargar el controlador JDBC de PostgreSQL
            Class.forName("org.postgresql.Driver");

            try ( // Establecer la conexión
                    Connection conexion = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {
                JOptionPane.showMessageDialog(null, "conexion existosa a la base de datos");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("No se pudo cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
    }
}
