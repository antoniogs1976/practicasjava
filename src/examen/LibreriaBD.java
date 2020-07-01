package examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LibreriaBD {

    // ==================================================================================
    // Métodos varios
    // ===================================================================
    // ==================================================================================

    /**
     * Método para mostrar los errores de las excepciones
     * 
     * @param excepcion Exception a mostrar los errores
     */
    public static void mostrarError(Exception e) {
        System.err.println("* ERROR: " + e.getMessage());
        e.getStackTrace();
    }

    // ==================================================================================
    // Métodos para la conexión/desconexión de la base de datos
    // =========================
    // ==================================================================================

    /**
     * Método para conectar a la base de datos
     * 
     * @return Connection
     */
    public static Connection conectar() {
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://"; // <----- INSERTAR AQUÍ LA URL
        String usuario = ""; // <----- INSERTAR AQUÍ EL USUARIO
        String password = ""; // <----- INSERTAR AQUÍ EL PASSWORD
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e);
            e.printStackTrace();
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
            System.err.println("Error al cerrar la conexión: " + e);
            e.printStackTrace();
        }
    }

    // ==================================================================================
    // Métodos para la gestión de los datos de la base de datos
    // =========================
    // ==================================================================================

    /**
     * Método para hacer consultas a la Base de datos.<br>
     * Devuelve un <b>ArrayList</b> con objetos <b>contacto</b> con los datos de los
     * contactos en la base de datos.
     * 
     * @param con      <code><b>Connection</b></code> sobre la que hacer la consulta
     * @param ordenada <code><b>Boolean</b></code> para ordenar por nombre la
     *                 consulta
     * @return ArrayList<Contacto> con los resultados
     */
    public static ArrayList<Contacto> consulta(Connection con, boolean ordenada) {
        ArrayList<Contacto> listado = new ArrayList<>();
        Contacto contacto = null;
        String consulta;
        if (ordenada) {
            consulta = "SELECT * FROM agenda ORDER BY nombre ASC;";
        } else {
            consulta = "SELECT * FROM agenda;";
        }
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                contacto = new Contacto(rs.getInt(1), rs.getString(2), rs.getString(3));
                listado.add(contacto);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return listado;
    }

    /**
     * Método para dar de alta un contacto en la agenda
     * 
     * @param con      <code>Connection</code> sobre la que realizar la consulta
     * @param contacto Contacto con los datos del contacto
     */
    public static boolean alta(Connection con, Contacto contacto) {
        boolean resultado = false;
        String consulta = String.format("INSERT INTO agenda (codigo, nombre, telefono) VALUES ('%d', '%s', '%s');",
                contacto.getCodigo(), contacto.getNombre(), contacto.getTelefono());
        try {
            Statement stmt = con.createStatement();
            if (stmt.executeUpdate(consulta) != 0) {
                resultado = true;
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return resultado;
    }

    /**
     * Método que devuelve el número de filas en una tabla
     * 
     * @param con Connection sobre la que realizar la consulta
     * @return entero con el número de filas/registros
     */
    public static int siguienteCodigo(Connection con) {
        int numRegistros = 0;
        String consulta = String.format("SELECT MAX(codigo) FROM agenda;");
        // se puede asignar un "alias" a la hora de hacer la consulta para acceder a ese
        // campo
        // String consulta = String.format("SELECT MAX(codigo) AS NombreQueQueramos FROM
        // agenda;");
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()) {
                numRegistros = rs.getInt(1);
                // Si hemos usado un "alias" se puede acceder también así al campo
                // numRegistros = rs.getInt("NombreQueQueramos");
            }
            rs.close();
        } catch (Exception e) {
            mostrarError(e);
        }
        return numRegistros + 1;
    }

    public static String totalContactos(Connection con) {
        int total = 0;
        String consulta = String.format("SELECT COUNT(codigo) FROM agenda");
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()) {
                total = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            mostrarError(e);
        }
        String resultado = "Hay un total de " + total + " contactos en la agenda.";
        return resultado;
    }
}
