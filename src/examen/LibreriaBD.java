package examen;

import java.sql.Connection;
import java.sql.DriverManager;

public class LibreriaBD {

    /**
     * Método para conectar a la BBDD
     * ==================================================================================
     */
    public static Connection conectar() {
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://cursosporinternet.es/antonio"; // <----- INSERTAR AQUÍ LA URL
        String usuario = "antonio"; // <----- INSERTAR AQUÍ EL USUARIO
        String password = "123456"; // <----- INSERTAR AQUÍ EL PASSWORD
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e);
            e.printStackTrace();
        }
        return con;
    }

    /**
     * Método para cerrar la conexión a la base de datos
     * 
     * @param con Connection que hay que cerrar
     * 
     * ==================================================================================
     */
    public static void cerrarConexion(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexión: " + e);
            e.printStackTrace();
        }
    }
}