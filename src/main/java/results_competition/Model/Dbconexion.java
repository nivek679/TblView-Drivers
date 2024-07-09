package results_competition.Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconexion {
    private String usuario = "postgres";
    private String contraseña = "kshb";
    private String bd = "pruebabasedatos";
    private String ip= "localhost";
    private String puerto = "5432";

    private Connection conectar = null;

    private String cadenaC = "jdbc:postgresql://" + ip + ":" + puerto + "/" + bd;

    public Connection establecerConexion(){
        try {
            //referencia de la ruta del driver a utilizar.
            Class.forName("org.postgresql.Driver");
            //A la variable conectar se le guarda el driver que se hizo referencia y se realiza la conexion.
            conectar = DriverManager.getConnection(cadenaC, usuario, contraseña);

            System.out.println("si sirve. ");
            

            
        } catch (Exception e) {
            System.out.println("no sirve. ");
        }

        return conectar;
    }


    public static void main(String[] args) {
        Dbconexion oDbconexion = new Dbconexion();
        oDbconexion.establecerConexion();
    }
    
}
