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
import models.CatalogoModel;
import models.ProcesosModel;

public class Consultas {

    Connect objConexion = new Connect();

    public void GuardarCatalogo(String Nombre) {
        try {
            // Creación de un objeto de la clase Connect.java
            Connection conn = objConexion.conexion();
            // Statement nos sirve para enviar las instrucciones a la bd
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Catalogo(id, nombre) VALUES ( null,'" + Nombre + "');");
            System.out.println("Catalogo agregado");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error al guardar catalogo");
        }
    }

    public void GuardarProcesos(long pid, String nombre, String usuario, String descripcion, int prioridad, int idcatalogo) {
        try {
            Connection conn = objConexion.conexion();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Procesos(id,pid,nombre,usuario,descripcion,prioridad,idcatalogo) VALUES "
                    + "(null," + pid + ",'" + nombre + "','" + usuario + "','" + descripcion + "'," + prioridad + "," + idcatalogo + ");");
            System.out.println("Proceso agregado");
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage()+ "Error al guardar procesos");
        }
    }

    public String Consecutivo() {
        String consecutivo = "";
        try {
            Connection conn = objConexion.conexion();
            PreparedStatement ps = conn.prepareStatement(" SELECT * FROM 'Catalogo' WHERE id = (SELECT MAX(id) FROM 'Catalogo'); ");
            ResultSet result = ps.executeQuery();
            consecutivo = result.getString(1);
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return consecutivo;
    }

    public int ObtenerConsecutivo(String nombre) {
        int consecutivo = 0;
        try {
            Connection conn = objConexion.conexion();
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM Catalogo WHERE nombre = '" + nombre + "';");
            ResultSet result = ps.executeQuery();
            consecutivo = result.getInt(1);
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return consecutivo;
    }

    public CatalogoModel[] consultaCargar(String sql) {
        String Consulta = sql;
        CatalogoModel Array[] = null;
        try {
            Connection conn = objConexion.conexion();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(Consulta);
            int numColumna = contarRegistrosC();
            Array = new CatalogoModel[numColumna];

            int aux = 0;
            while (result.next()) {
                if (aux < numColumna) {
                    Array[aux] = new CatalogoModel(result.getInt("id"), result.getString("nombre"));
                }
                aux++;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Array;
    }
    public int contarRegistrosC(){
        int count = 0;
        try {
            Connection conn = objConexion.conexion();
            PreparedStatement ps = conn.prepareStatement("SELECT count(id) from Catalogo;");
            ResultSet result = ps.executeQuery();
            count = result.getInt(1);
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return count;
    }
    
    public int contarRegistros(int id){
        int count = 0;
        try {
            Connection conn = objConexion.conexion();
            PreparedStatement ps = conn.prepareStatement("SELECT count(id) from Procesos WHERE Procesos.idcatalogo = "+id+";); ");
            ResultSet result = ps.executeQuery();
            count = result.getInt(1);
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return count;
    }

    public CatalogoModel[] consultarProcesos( int id, String nombreCatalogo) {
        CatalogoModel Array[] = null;
        try {
            Connection conn = objConexion.conexion();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT *  from Procesos WHERE Procesos.idcatalogo = "+id+";");
            int numColumna = contarRegistros(id);
            Array = new CatalogoModel[numColumna];
            
            int aux = 0;
            while (result.next()) {
                ProcesosModel procesosModel = new ProcesosModel(result.getInt(2), result.getString(3),result.getString(4),result.getString(5),result.getInt(6));
                if (aux < numColumna) {
                    Array[aux] = new CatalogoModel(id,nombreCatalogo,procesosModel);
                }
                aux++;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Array;
    }
}
