package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

import miscosas.Utilidades;

/**
 * generador
 * 
 * genera 100 usuarios para la agenda
 */
public class generador {

    public static void main(String[] args) {
        Random alea = new Random();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://remotemysql.com:3306/F5DQRpnXfM";
        String usuario = "F5DQRpnXfM";
        String password = "LzbcX6JCLx"; // <--------- INSERTAR AQUÍ EL PASSWORD
        final String letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int cosa = 0;
        int contador = 1;
        int codigo = 1;
        String strTelefono;
        String strNombre;
        Utilidades.limpiarPantalla();
        try {
            System.out.println("Conectando...");
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conectado con éxito");
            System.out.println("Consulta: generar 100 contactos para la Agenda");
            System.out.println("# = código de contacto ya existe.");
            System.out.println(". = código nuevo, creando contacto.");
            System.out.println("--------------------------------------------------------------------------------");
            // generar aquí los usuarios:
            Statement stmt = con.createStatement();
            long inicio = System.nanoTime();
            while (contador <= 100){
                if(!BDUtil.existeCodigo(con, codigo)){
                    strNombre = "";
                    strTelefono = "";
                    // Generar un nombre de 10 letras aleatorio
                    for (int j = 1; j <= 10; j++) {
                        strNombre += letras.charAt(alea.nextInt(letras.length()));
                    }
                    // Generar un número de teléfono de 9 cifras aleatorio
                    for (int k = 1; k <= 9; k++) {
                        strTelefono += alea.nextInt(9);
                    }
                    String consulta = String.format("INSERT INTO agenda(codigo, nombre, telefono) VALUES (%d, '%s', '%s');", codigo, strNombre, strTelefono);
                    cosa = stmt.executeUpdate(consulta);
                    if (contador < 100) {
                        System.out.print(".");
                    } else {
                        System.out.println(".");
                    }
                    contador++;
                } else{
                    System.out.print("#");
                }
                codigo++;
            }
            long fin = System.nanoTime();
            if (cosa != 0) {
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