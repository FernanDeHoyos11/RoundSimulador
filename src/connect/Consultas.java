/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

/**
 *
 * @author Isaac
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
    Connect objConexion = new Connect();


    public void Guardar(String Nombre) {
        try {
            // Creación de un objeto de la clase Connect.java
            Connection conn = objConexion.conexion();
            // Statement nos sirve para enviar las instrucciones a la bd
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Catalogo(id, nombre) VALUES ( null,'" + Nombre +"');");
            System.out.println("Catalogo agregado");
            conn.close();
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}