package connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connect {
    public Connection conexion(){
        //Ruta donde está la bd creada

        String url = "jdbc:sqlite:E:\\HP\\ingeneria_de_sistemas\\Sistemas_Operativos\\RoundSimulador\\src\\db\\procesos.db";

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