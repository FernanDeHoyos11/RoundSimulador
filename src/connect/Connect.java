package connect;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connect {
    //String barra = File.separator;
    //String ubicacion = System.getProperty("user.dir") + barra + "db" + barra;
    //File contenedor = new File(ubicacion);
    //File medicos[] = contenedor.listFiles();
    public Connection conexion(){
        //Ruta donde está la bd creada

        String url = "jdbc:sqlite:C:\\Users\\JoseAlejandroGonzale\\Documents\\GitHub\\RoundSimulador\\src\\db\\procesos.db";

        Connection conn = null;
        try{
            //Creamos la conexión
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}