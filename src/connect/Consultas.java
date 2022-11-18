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

    public void GuardarCatalogo(String Nombre) {
        try {
            // Creación de un objeto de la clase Connect.java
            Connection conn = objConexion.conexion();
            // Statement nos sirve para enviar las instrucciones a la bd
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO catalogo(id, nombrecatalogo) VALUES ( null,'" + Nombre + "');");
            System.out.println("Catalogo agregado");
            conn.close();
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println(e.getMessage() + "error guardar catalogo");
        }
    }

    public void GuardarProcesos(long pid, String nombre, String usuario, String descripcion, int prioridad, int idcatalogo) {
        try {
            Connection conn = objConexion.conexion();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO procesos(id,pid,nombre,usuario,descripcion,prioridad,idcatalogo) VALUES "
                    + "(null," + pid + ",'" + nombre + "','" + usuario + "','" + descripcion + "'," + prioridad + "," + idcatalogo + ");");
            System.out.println("Proceso agregado");
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "error guardar");
        }
    }

    public int Consecutivo() {
        int consecutivo = 0;
        try {
            Connection conn = objConexion.conexion();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM catalogo WHERE id = (SELECT MAX(id) FROM catalogo);");
            ResultSet result = ps.executeQuery();
            consecutivo = Integer.parseInt(result.getString(1));
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage() + "error seleccion catalogo");
        }
        return consecutivo;
    }
}
