package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * BDUtil
 * 
 * Utilidades para conectar a base de datos
 */
public class BDUtil {

    /**
     * Método para crear una conexión a una base de datos
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
     * Método para cerrar la conexión a la base de datos
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

    /**
     * Método para dar de alta un contacto en la agenda
     * 
     * @param con       Connection sobre la que realizar la consulta
     * @param contacto  Contacto con los datos del contacto
     */
    public static void alta(Connection con, Contacto contacto) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO agenda(cod,nombre, telefono) VALUES (" + contacto.getCodigo() + ",'"
                    + contacto.getNombre() + "','" + contacto.getTelefono() + "')");
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    /**
     * Método para dar de baja (ELIMINAR) un contacto de la agenda
     * 
     * @param con       Connection sobre la que realizar la consulta
     * @param codigo    integer con el código (cod) del contacto a dar de baja
     */
    public static void baja(Connection con, int codigo) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM agenda WHERE cod ="+codigo+";");
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    /**
     * Método para modificar un contacto de la agenda
     * @param con       Connection sobre la que realizar la consulta
     * @param contacto  Contacto con los datos del contacto
     */
    public static void modificar(Connection con, Contacto contacto) {
        int codigo = contacto.getCodigo();
        String nombre = contacto.getNombre();
        String telefono = contacto.getTelefono();
        String consulta;
        consulta = String.format("UPDATE agenda SET cod=%d, nombre='%s', telefono='%s' WHERE cod=%d;", codigo, nombre, telefono, codigo);
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(consulta);
        } catch (Exception e) {
            mostrarError(e);
        }
    }

    /**
     * Método para mostrar los contactos de la agenda
     * 
     * @param con   Connection sobre la que realizar la consulta
     * @return      ArrayList<Contacto> con la lista de contactos
     */
    public static ArrayList<Contacto> consulta(Connection con) {
        ArrayList<Contacto> listado = new ArrayList<>();
        try {
            Contacto dummy = null;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agenda;");
            while (rs.next()) {
                dummy = new Contacto(rs.getInt(1), rs.getString(2), rs.getString(3));
                listado.add(dummy);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return listado;
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

    
    //public static void mostrarMensaje(Scanner entradaDatos, boolean error) {
    //    if (!error) {
    //        System.out.println("Contacto añadido a la agenda.");
    //    } else {
    //        System.out.println("Ha ocurrido un error y no se ha añadido el contacto a la agenda.");
    //    }
    //    pulsarTecla(entradaDatos, 'V');
    //}

    /**
     * Método para mostrar los errores de las excepciones
     * 
     * @param excepcion Exception a mostrar los errores
     */
    public static void mostrarError(Exception excepcion) {
        System.out.println("* ERROR: " + excepcion.getMessage());
        System.out.println("* CAUSA: " + excepcion.getCause());
        excepcion.getStackTrace();
    }

    /**
     * Método que devuelve el número de filas en una tabla
     * 
     * @param con   Connection sobre la que realizar la consulta
     * @return      entero con el número de filas/registros
     */
    public static int contarRegistros(Connection con) {
        int count = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS rowcount FROM agenda;");
            rs.next();
            count = rs.getInt("rowcount");
            rs.close();
        } catch (Exception e) {
            mostrarError(e);
        }
        return count;
    }

    /**
     * Método para hacer consultas sobre el campo NOMBRE de la agenda
     * 
     * @param con           Connection sobre la que realizar la consulta
     * @param cadenaABuscar String con la parte del nombre que se quiere buscar
     * @return              ArrayList<Contacto> con las coincidencias
     */
    public static ArrayList<Contacto> consultaNombre(Connection con, String cadenaABuscar) {
        ArrayList<Contacto> listado = new ArrayList<>();
        String modificado = "%" + cadenaABuscar + "%";
        try {
            Contacto dummy = null;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agenda WHERE nombre LIKE '" + modificado + "';");
            while (rs.next()) {
                dummy = new Contacto(rs.getInt(1), rs.getString(2), rs.getString(3));
                listado.add(dummy);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return listado;
    }

    /**
     * Método para hacer consultas sobre el campo COD de la agenda
     * 
     * @param con       Connection sobre la que realizar la consulta
     * @param codigo    integer código que se quiere buscar
     * @return          String con los datos de ese código
     */
    public static String consultaCodigo(Connection con, int codigo) {
        String datosContacto = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agenda WHERE cod =" + codigo + ";");
            while (rs.next()) {
                datosContacto = rs.getInt(1) + "\t - " + rs.getString(2) + "\t - " + rs.getString(3);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return datosContacto;
    }

}