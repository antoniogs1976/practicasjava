package examen;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBBDD {
    public static void main(String[] args) {
        // registrar el driver jdbc
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://"; // <----- INSERTAR AQUÍ LA URL
		String usuario = ""; // <----- INSERTAR AQUÍ EL USUARIO
		String password = ""; // <----- INSERTAR AQUÍ EL PASSWORD
        Connection conexion = null;
        
        miscosas.MisClases.limpiarPantalla();
        try {
            Class.forName(driver);
            // Obtener conexión
            conexion = DriverManager.getConnection(url, usuario, password);
            if (conexion != null){
                System.out.println("conectado");
            }
            conexion.close();
            System.out.println("conexion cerrada");
        } catch (Exception e) {
            System.err.println("Error al cargar el driver: " + e);
            e.printStackTrace();
        } 
    }
}