package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import miscosas.Utilidades;

/**
 * BDUtil
 * 
 * Utilidades para conectar a base de datos
 */
public class BDUtil {

    /**
     * MENÚ PRINCIPAL
     * 
     */
    public static void menuPrincipal(Scanner entradaDatos) {
        Utilidades.limpiarPantalla();
        System.out.println("============================================================");
        System.out.println("==                      JAVAGENDA BD                      ==");
        System.out.println("============================================================");
        System.out.println("==  1.- Añadir un contacto a la Base de Datos             ==");
        System.out.println("==  2.- Borrar un contacto de la Base de Datos            ==");
        System.out.println("==  3.- Editar un contacto de la Base de Datos            ==");
        System.out.println("==  4.- Consultar contactos en la Base de Datos           ==");
        System.out.println("============================================================");
        System.out.println("==  9.- Salir de JAVAGENDA BD                             ==");
        System.out.println("============================================================");
    }

    /**
     * conexion
     * 
     * @return Connection con la conexión establecida
     */
    public static Connection conexion() {
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://remotemysql.com:3306/F5DQRpnXfM";
        String usuario = "F5DQRpnXfM";
        String password = ""; // <--------- INSERTAR AQUÍ EL PASSWORD
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            mostrarError(e);
        }
        return con;
    }

    /**
     * Cerrar Conexión
     * 
     * @param con Connection que hay que cerrar
     */
    public static void cerrarConexion(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    // alta
    public static void alta(Scanner entradaDatos, Connection con, int codigo, String nombre, String telefono) {
        boolean error = false;
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO agenda(codigo,nombre, telefono) VALUES (" + codigo + ",'" + nombre + "','" + telefono + "')");
        } catch (Exception e) {
            error = true;
            mostrarError(e);
        }
        mostrarMensaje(entradaDatos, error);

    }

    // baja
    public static void baja() {

    }

    // modificacion
    public static void modificar() {

    }

    // consulta
    public static void consulta() {

    }

    /**
     * Método para aceptar sólo una tecla para continuar
     * 
     * @param entradaDatos Scanner para la entrada de datos
     */
    public static void pulsarTecla(Scanner entradaDatos, char teclaAPulsar) {
        char tecla;
        do {
            System.out.println("(pulsa " + teclaAPulsar + " y presiona Enter para volver al menú)");
            tecla = entradaDatos.next().toUpperCase().charAt(0);
        } while (tecla != teclaAPulsar);
    }

    public static void mostrarMensaje(Scanner entradaDatos, boolean error){
        if(!error){
            System.out.println("Contacto añadido a la agenda.");
        }else{
            System.out.println("Ha ocurrido un error y no se ha añadido el contacto a la agenda.");
        }
        pulsarTecla(entradaDatos, 'V');
    }

    /**
     * Mostrar Error
     * Muestra los errores de las excepciones
     * @param excepcion Exception a mostrar los errores
     */
    public static void mostrarError(Exception excepcion){
        System.out.println("* ERROR: " + excepcion.getMessage());
        System.out.println("* CAUSA: " + excepcion.getCause());
        excepcion.getStackTrace();
    }

}