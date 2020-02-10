package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import miscosas.Utilidades;

/**
 * insert
 * 
 * Insetar un registro en la tabla
 */
public class insert {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://remotemysql.com:3306/F5DQRpnXfM";
        String usuario = "F5DQRpnXfM";
        String password = ""; // <---- INSERTAR AQUÍ EL PASSWORD
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
            System.out.println("Consulta: insetar datos en la tabla");
            Statement stmt = con.createStatement();
            long inicioConsulta = System.nanoTime();
            // 4.- ejecutar la consulta
            stmt.executeUpdate("INSERT INTO agenda(nombre, telefono) VALUES ('5','Francisco','555325252')");
            long finalConsulta = System.nanoTime();
            System.out.println("Consulta: realizada");
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