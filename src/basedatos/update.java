package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import miscosas.Utilidades;

/**
 * update
 * 
 * Editar/Actualizar un registro en la tabla
 */
public class update {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://"; // <----- INSERTAR AQUÍ LA URL
		String usuario = ""; // <----- INSERTAR AQUÍ EL PASSWORD
		String password = ""; // <----- INSERTAR AQUÍ EL PASSWORD
        try {
            // 1.- registrar el Driver JDBC
            System.out.println("Conectando...");
            Class.forName(driver);
            // 2.- crear la conexión
            long inicioConexion = System.nanoTime();
            Connection con = DriverManager.getConnection(url, usuario, password);
            long finalConexion = System.nanoTime();
            System.out.println("Conectado con éxito");
            // 3.- crear objeto STATEMENT para hacer la consulta
            System.out.println("Consulta: actualizar/modificar datos en la tabla");
            Statement stmt = con.createStatement();
            long inicioConsulta = System.nanoTime();
            // 4.- ejecutar la consulta
            int cosa = stmt.executeUpdate("UPDATE agenda SET telefono='636636636' WHERE codigo=1");
            long finalConsulta = System.nanoTime();
            if (cosa != 0){
                System.out.println("Consulta: realizada. "+ cosa +" registro/s afectado/s");
            } else{
                System.out.println("Consulta: no ha habido nada que hacer");
            }
            // 5.- Cerrar la conexion
            con.close();
            System.out.println(Utilidades.medirTiempoEjecucion("conexión", inicioConexion, finalConexion));
            System.out.println(Utilidades.medirTiempoEjecucion("consulta", inicioConsulta, finalConsulta));
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
            System.out.println("* CAUSA: " + e.getCause());
            e.getStackTrace();
        }
    }
}