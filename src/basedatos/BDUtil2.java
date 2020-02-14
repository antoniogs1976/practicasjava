package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * BDUtil2
 * 
 * Métodos y utilidades varias para la conexión y gestión de la base de datos de
 * contactos
 */
public class BDUtil2 {

    // ------------------------------------------------------------------------
    // MÉTODOS PARA CONEXION A BBDD -------------------------------------------
    // ------------------------------------------------------------------------

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

    // ------------------------------------------------------------------------
    // MÉTODOS DE GESTIÓN DE LA BBDD ------------------------------------------
    // ------------------------------------------------------------------------

    /**
     * Método para dar de alta un contacto en la agenda
     * 
     * @param con      Connection sobre la que realizar la consulta
     * @param contacto Contacto con los datos del contacto
     * @return devuelve TRUE si ha salido bien, FALSE si hay algún error
     */
    public static boolean alta(Connection con, Contacto contacto) {
        boolean retorno;
        String consulta = String.format("INSERT INTO agenda (cod, nombre, telefono) VALUES (%d, %s, %s);",
                contacto.getCodigo(), contacto.getNombre(), contacto.getTelefono());
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(consulta);
            retorno = true;
        } catch (Exception e) {
            mostrarError(e);
            retorno = false;
        }
        return retorno;

    }

    /**
     * Método para dar de baja (ELIMINAR) un contacto de la agenda
     * 
     * @param con    Connection sobre la que realizar la consulta
     * @param codigo integer con el código (cod) del contacto a dar de baja
     * @return devuelve TRUE si ha salido bien, FALSE si hay algún error
     */
    public static boolean baja(Connection con, int codigo) {
        boolean retorno;
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM agenda WHERE cod =" + codigo + ";");
            retorno = true;
        } catch (Exception e) {
            mostrarError(e);
            retorno = false;
        }
        return retorno;
    }

    /**
     * Método para modificar un contacto de la agenda
     * 
     * @param con      Connection sobre la que realizar la consulta
     * @param contacto Contacto con los datos del contacto
     * @return devuelve TRUE si ha salido bien, FALSE si hay algún error
     */
    public static boolean modificar(Connection con, Contacto contacto) {
        boolean retorno;
        String consulta = String.format("UPDATE agenda SET cod=%d, nombre='%s', telefono='%s' WHERE cod=%d;",
                contacto.getCodigo(), contacto.getNombre(), contacto.getTelefono(), contacto.getCodigo());
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(consulta);
            retorno = true;
        } catch (Exception e) {
            mostrarError(e);
            retorno = false;
        }
        return retorno;
    }

    /**
     * Método para mostrar los contactos de la agenda
     * 
     * @param con Connection sobre la que realizar la consulta
     * @return ArrayList<Contacto> con la lista de contactos
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

    // ------------------------------------------------------------------------
    // OTROS MÉTODOS ----------------------------------------------------------
    // ------------------------------------------------------------------------

    /**
     * Método para mostrar los errores de las excepciones
     * 
     * @param excepcion Exception a mostrar los errores
     */
    public static void mostrarError(Exception e) {
        System.out.println("* ERROR: " + e.getMessage());
        System.out.println("* CAUSA: " + e.getCause());
        e.getStackTrace();
    }

    /**
     * Método que devuelve el número de filas en una tabla
     * 
     * @param con Connection sobre la que realizar la consulta
     * @return entero con el número de filas/registros
     */
    public static int numeroRegistros(Connection con) {
        int numRegistros = 0;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS rowcount FROM agenda;");
            rs.next();
            numRegistros = rs.getInt("rowcount");
            rs.close();
        } catch (Exception e) {
            mostrarError(e);
        }
        return numRegistros;
    }

    /**
     * Método para ajustar el campo código (COD) de la base de datos. Cada vez que
     * se elimina algún contacto, el campo código (que sería autonumérico), debería
     * actualizarse, pero no hemos usado esa opción en la BBDD y lo vamos a realizar
     * a mano.
     * 
     * Necesitamos:
     * 1.- conexión sobre la que realizar la consulta.
     * 2.- lista de contactos con el código original
     * 
     * Devuelve (o debería devolver...):
     * 1.- lista de contactos con el código cambiado
     */
    public static void cambiarCodigoContactos(Connection con){
        ArrayList<Contacto> listado = new ArrayList<>();
        try {
            int contador = 1;
            Contacto dummy = null;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agenda;");
            while (rs.next()) {
                dummy = new Contacto(contador, rs.getString(2), rs.getString(3)); // aquí cambiamos el código ya
                listado.add(dummy);
                contador++;
            }            
            // Recorrer el ArrayList e ir devolviendo los resultados a la BBDD
            
        } catch (Exception e) {
            mostrarError(e);
        }

        // return retorno;
    }

}