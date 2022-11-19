package connect;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connect {
    public Connection conexion(){
        //Ruta donde está la bd creada
        String barra = File.separator;
        String ubicacion = System.getProperty("user.dir") + barra + "src" + barra + "db"  + barra + "procesos.db";
        String url = "jdbc:sqlite:"+ ubicacion;
        System.out.println(ubicacion);
        Connection conn = null;
        try{
            //Creamos la conexión
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida");

        }catch(SQLException e){
            System.out.println(e.getMessage() + "Conexion no establecida");
        }
        return conn;
    }
}