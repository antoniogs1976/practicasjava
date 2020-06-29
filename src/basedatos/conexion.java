package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * conexion
 */
public class conexion {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://"; // <----- INSERTAR AQUÍ LA URL
		String usuario = ""; // <----- INSERTAR AQUÍ EL PASSWORD
		String password = ""; // <----- INSERTAR AQUÍ EL PASSWORD
        try {
            System.out.println("Conectando...");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conectado con éxito");
            con.close();
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
            System.out.println("* CAUSA: " + e.getCause());
            e.getStackTrace();
        }
    }
}