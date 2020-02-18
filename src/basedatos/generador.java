package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import miscosas.Utilidades;

/**
 * generador
 * 
 * genera 100 usuarios para la agenda
 */
public class generador {

    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://remotemysql.com:3306/F5DQRpnXfM";
        String usuario = "F5DQRpnXfM";
        String password = ""; // <--------- INSERTAR AQUÍ EL PASSWORD
        int cosa =0;
        String strTelefono;
        String strNombre;
        try {
            System.out.println("Conectando...");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conectado con éxito");
            System.out.println("Consulta: generar 100 contactos para la Agenda");
            // generar aquí los usuarios:
            Statement stmt = con.createStatement();
            long inicio = System.nanoTime();
            for (int i = 1; i <= 100; i++) {
                if (i < 10){
                    strNombre = "Contacto 00"+i;
                    strTelefono = "60900000"+i;
                } else if (i < 100){
                    strNombre = "Contacto 0"+i;
                    strTelefono = "6090000"+i;
                } else {
                    strNombre = "Contacto "+i;
                    strTelefono = "609000"+i;
                }
                cosa = stmt.executeUpdate("INSERT INTO agenda(cod, nombre, telefono) VALUES ("+i+",'"+strNombre+"','"+strTelefono+"')");
                if (i < 100){
                    System.out.print(".");
                } else {
                    System.out.println(".");
                }
            }
            long fin = System.nanoTime();
            if (cosa != 0){
                System.out.println("Operación realizada con éxito");
            } else {
                System.out.println("No hay nada que hacer");
            }
            con.close();

            System.out.println(Utilidades.medirTiempoEjecucion("crear 100 usuarios", inicio, fin));
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
            System.out.println("* CAUSA: " + e.getCause());
            e.getStackTrace();
        }
    }
}