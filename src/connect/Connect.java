package connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connect {
    
    public Connection conexion(){
        //Ruta donde está la bd creada
        String url = "jdbc:mysql://db4free.net:3306/simulador";

        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos la conexión
            conn = DriverManager.getConnection(url,"cuasingenieros", "Sonicboom4071!");
            System.out.println("Conexión establecida");

        }catch(ClassNotFoundException|SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}