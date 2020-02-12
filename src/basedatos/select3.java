package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import miscosas.Utilidades;

/**
 * select
 * 
 * Realiza una consulta a la BD LOCAL
 */
public class select3 {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        //String url = "jdbc:mysql://localhost:3306/practicas?serverTimezone=UTC";
        // la linea anterior es por si da fallo de timezone. Para corregirlo de forma global
        // añadir la opción default-time-zone=+00:00 en my.ini/my.cnf
        String url = "jdbc:mysql://localhost:3306/practicas";
        String usuario = "root";
        String password = "123456"; // <---- INSERTAR AQUÍ EL PASSWORD
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
            System.out.println("Consulta: Seleccionar todo de la tabla");
            long inicioConsulta = System.nanoTime();
            Statement stmt = con.createStatement();
            // 4.- ejecutar la consulta
            ResultSet rs = stmt.executeQuery("select * from agenda");
            // 5.- recuperar los resultados (mostrarlos)
            long finalConsulta = System.nanoTime();
            long inicioImprimir = System.nanoTime();
            while (rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) +"\t" + rs.getString(3));
            }
            // 6.- cerrar la conexión
            long finalImprimir = System.nanoTime();
            con.close();
            System.out.println(Utilidades.medirTiempoEjecucion("conexión", inicioConexion, finalConexion));
            System.out.println(Utilidades.medirTiempoEjecucion("consulta", inicioConsulta, finalConsulta));
            System.out.println(Utilidades.medirTiempoEjecucion("imprimir", inicioImprimir, finalImprimir));
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
            System.out.println("* CAUSA: " + e.getCause());
            e.getStackTrace();
        }
    }
}