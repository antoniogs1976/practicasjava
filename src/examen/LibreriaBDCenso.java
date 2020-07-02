package examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LibreriaBDCenso {

    // ==================================================================================
    // Métodos varios
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
    // ==================================================================================

    /**
     * Método para conectar a la base de datos
     * 
     * @return Connection
     */
    public static Connection conectar() {
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://cursosporinternet.es:3306/"; // <----- INSERTAR AQUÍ LA URL
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
    // ==================================================================================

    /**
     * Método para hacer consultas a la Base de datos.<br>
     * Devuelve un <b>ArrayList</b> con objetos <b>Censo</b> con los datos del censo
     * 
     * @param con      <code>Connection</code> sobre la que hacer la consulta
     * @param ordenada <code>Boolean</code> para ordenar por nombre la
     *                 consulta
     * @return <code>ArrayList<Censo></code> con los resultados
     */
    public static ArrayList<Censo> listado(Connection con, boolean ordenada) {
        ArrayList<Censo> listado = new ArrayList<>();
        Censo datoCenso = null;
        String consulta;
        if (ordenada) {
            consulta = "SELECT * FROM censo ORDER BY nombre ASC;";
        } else {
            consulta = "SELECT * FROM censo;";
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                datoCenso = new Censo(rs.getInt(1), rs.getString(2), rs.getInt(3));
                listado.add(datoCenso);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return listado;
    }

    /**
     * Método para sacar la media de edad
     * 
     * @param con <code>Connection</code> sobre la que realizar la consulta
     * @return <code>int</code> con el resultado
     */
    public static int mediaEdad (Connection con){
        int resultado = 0;
        String consulta = "SELECT AVG(edad) FROM censo;";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()){
                resultado = rs.getInt(1);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return resultado;
    }

    /**
     * Método que devuelve la edad más alta
     * @param con <code>Connection</code> sobre la que hace la consulta
     * @return <code>int</code> con el resultado
     */
    public static int edadMayor (Connection con){
        int resultado = 0;
        String consulta = "SELECT MAX(edad) FROM censo;";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()){
                resultado = rs.getInt(1);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return resultado;        
    }

    /**
     * Método que devuelve la edad más baja
     * @param con <code>Connection</code> sobre la que hace la consulta
     * @return <code>int</code> con el resultado
     */
    public static int edadMenor (Connection con){
        int resultado = 0;
        String consulta = "SELECT MIN(edad) FROM censo;";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            if (rs.next()){
                resultado = rs.getInt(1);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return resultado;        
    }

    /**
     * Método que devuelve una lista de <code>Censo</code> con los datos de los que tengan
     * menor edad en el censo.
     * @param con <code>Connection</code> sobre la que hace la consulta
     * @return <code>ArrayList<Censo></code> con los datos de los menores en el censo
     */
    public static ArrayList<Censo> nombreMenores (Connection con){
        ArrayList<Censo> resultado = new ArrayList<>();
        Censo censo = null;
        //String consulta = "SELECT MIN(edad), nombre, codigo FROM censo;";
        String consulta = "SELECT * FROM censo WHERE edad = (SELECT MIN(edad) FROM censo)";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()){
                censo = new Censo(rs.getInt(1), rs.getString(2), rs.getInt(3));
                resultado.add(censo);
            }
        } catch (Exception e) {
            mostrarError(e);
        }
        return resultado;        
    }
}
