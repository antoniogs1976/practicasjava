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

    // -------------------------------------------------------------------------
    // MÉTODOS PARA LA CONEXION A LA BBDD -------------------------------------
    // -------------------------------------------------------------------------

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
        String password = "LzbcX6JCLx"; // <--------- INSERTAR AQUÍ EL PASSWORD
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

    // -------------------------------------------------------------------------
    // MÉTODOS PARA LA GESTIÓN DE LA BBDD -------------------------------------
    // -------------------------------------------------------------------------

    /**
     * Método para dar de alta un contacto en la agenda
     * 
     * @param con      Connection sobre la que realizar la consulta
     * @param contacto Contacto con los datos del contacto
     */
    public static boolean alta(Connection con, Contacto contacto) {
        boolean resultado = false;
        String consulta = String.format("INSERT INTO agenda (codigo, nombre, telefono) VALUES (%d, '%s', '%s');",
                contacto.getCodigo(), contacto.getNombre(), contacto.getTelefono());
        try {
            Statement stmt = con.createStatement();
            if (stmt.executeUpdate(consulta) != 0){
                resultado = true;
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return resultado;
    }

    /**
     * Método para dar de baja (ELIMINAR) un contacto de la agenda
     * 
     * @param con    Connection sobre la que realizar la consulta
     * @param codigo integer con el código (cod) del contacto a dar de baja
     */
    public static boolean baja(Connection con, int codigo) {
        boolean resultado = false;
        String consulta = String.format("DELETE FROM agenda WHERE codigo = %d;", codigo);
        try {
            Statement stmt = con.createStatement();
            if (stmt.executeUpdate(consulta) != 0){
                resultado = true;
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return resultado;
    }

    /**
     * Método para modificar un contacto de la agenda
     * 
     * @param con      Connection sobre la que realizar la consulta
     * @param contacto Contacto con los datos del contacto
     */
    public static boolean modificar(Connection con, Contacto contacto) {
        boolean resultado = false;
        int codigo = contacto.getCodigo();
        String nombre = contacto.getNombre();
        String telefono = contacto.getTelefono();
        String consulta;
        consulta = String.format("UPDATE agenda SET codigo=%d, nombre='%s', telefono='%s' WHERE codigo=%d;", codigo, nombre,
                telefono, codigo);
        try {
            Statement stmt = con.createStatement();
            if (stmt.executeUpdate(consulta) != 0){
                resultado = true;
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return resultado;
    }

    /**
     * Método para mostrar los contactos de la agenda
     * 
     * @param con Connection sobre la que realizar la consulta
     * @return ArrayList<Contacto> con la lista de contactos
     */
    public static ArrayList<Contacto> consulta(Connection con) {
        ArrayList<Contacto> listado = new ArrayList<>();
        Contacto dummy = null;
        try {
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
     * Método que devuelve el número de filas en una tabla
     * 
     * @param con Connection sobre la que realizar la consulta
     * @return entero con el número de filas/registros
     */
    public static int contarRegistros(Connection con) {
        int numRegistros = 1;
        String consulta = String.format("SELECT MAX(codigo) AS rowcount FROM agenda;");
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()) {
                numRegistros = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            mostrarError(e);
        }
        return numRegistros;
    }

    /**
     * Método para hacer consultas sobre el campo NOMBRE de la agenda
     * 
     * @param con           <code>java.sql.Connection</code> sobre la que realizar
     *                      la consulta.
     * @param cadenaABuscar String con la parte del nombre que se quiere buscar.
     * @return ArrayList<Contacto> con las coincidencias
     */
    public static ArrayList<Contacto> consultaNombre(Connection con, String cadenaABuscar) {
        ArrayList<Contacto> listado = new ArrayList<>();
        String str = "%" + cadenaABuscar + "%";
        String consulta = String.format("SELECT * FROM agenda WHERE nombre LIKE '%s';", str);
        Contacto dummy = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
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
     * Método para realizar búsquedas en la base de datos. Busca en los dos campos
     * de la agenda (nombre y teléfono).
     * 
     * @param con           <code>java.sql.Connection</code> sobre la que hacer la
     *                      consulta.
     * @param cadenaABuscar <code>String</code> con la cadena a buscar.
     * @return <code>Arraylist<Contacto></code> con las coincidencias de la búsqueda
     */
    public static ArrayList<Contacto> buscarContacto(Connection con, String cadenaABuscar) {
        ArrayList<Contacto> listado = new ArrayList<>();
        String str = "%" + cadenaABuscar + "%";
        String consulta = String.format("SELECT * FROM agenda WHERE (nombre LIKE '%s') OR (telefono like '%s');", str,
                str);
        Contacto dummy = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
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
     * Método para hacer consultas sobre el campo COD de la agenda para mostrar las
     * coincidencias a la hora de dar de baja algún contacto. En este caso sólo
     * devuelve por pantalla todos los contactos que coinciden con el patrón de
     * búsqueda, no devuelve un objeto de tipo <code>Contacto</code> como sería de
     * esperar.
     * 
     * @param con    Connection sobre la que realizar la consulta
     * @param codigo integer código que se quiere buscar
     * @return String con los datos de ese código
     */
    public static String consultaCodigo(Connection con, int codigo) {
        String datosContacto = "";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM agenda WHERE codigo =" + codigo + ";");
            while (rs.next()) {
                datosContacto = rs.getInt(1) + "\t - " + rs.getString(2) + "\t - " + rs.getString(3);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return datosContacto;
    }

    /**
     * Método para hacer consultas en la BBDD sobre el campo COD
     * 
     * @param con     <code>java.sql.Connection</code> sobre la que realizar la
     *                cosulta.
     * @param codigo  <code>int</code> con el valor del campo código a buscar.
     * @param control <code>boolean</code> para tener el control de la operación.
     *                <code>true</code> si todo va bien, <code>false</code> si hay
     *                algún error. Este parámetro es una variable del programa
     *                principal.
     * @return <code>Contacto</code> con los datos correspondientes a ese código.
     */
    public static Contacto consultaCodigoContacto(Connection con, int codigo, boolean control) {
        Contacto dummy = null;
        String consulta = String.format("SELECT * FROM agenda WHERE codigo=%d;", codigo);
        control = false;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            dummy = new Contacto(rs.getInt(1), rs.getString(2), rs.getString(3));
            control = true;
        } catch (Exception e) {
            mostrarError(e);
            control = false;
        }
        return dummy;
    }

    // -------------------------------------------------------------------------
    // OTROS MÉTODOS Y UTILIDADES ---------------------------------------------
    // -------------------------------------------------------------------------

    /**
     * Método para aceptar sólo una tecla para continuar
     * 
     * @param entradaDatos Scanner para la entrada de datos
     */
    public static void pulsarTecla(Scanner entradaDatos, char teclaAPulsar) {
        char tecla;
        String texto = String.format("pulsa %s y presiona ENTER para volver al menú", teclaAPulsar);
        do {
            System.out.println(texto);
            tecla = entradaDatos.next().toUpperCase().charAt(0);
        } while (tecla != teclaAPulsar);
    }

    /**
     * Método para mostrar los errores de las excepciones
     * 
     * @param excepcion Exception a mostrar los errores
     */
    public static void mostrarError(Exception e) {
        System.out.println("* ERROR: " + e.getMessage());
        e.getStackTrace();
    }

    /**
     * Método para comprobar que un código exite, a la hora de modificar o borrar un
     * contacto
     * 
     * @param con    <code>java.sql.Connection</code> sobre la que hacer la
     *               consulta.
     * @param codigo <code>Integer</code> con el código a comprobar.
     * @return Devuelve <code>true</code> si el código existe, <code>false</code> si
     *         el código no existe.
     */
    public static boolean existeCodigo(Connection con, int codigo) {
        boolean encontrado = false;
        String consulta = String.format("SELECT codigo FROM agenda WHERE codigo=%d;", codigo);
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            if (rs.next()) {
                encontrado = true;
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return encontrado;
    }
}