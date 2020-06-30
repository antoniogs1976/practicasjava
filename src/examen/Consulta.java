package examen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Se conecta a la BD utilizando el método "conectar" de "LibreriaBD.java"
// Y hace una consulta a la tabla "agenda"

public class Consulta {
    public static void main(String[] args) {
        // Limpiar la consola para ver las cosas mejor
        miscosas.MisClases.limpiarPantalla();

        // Conectar a la BD
        Connection conexion = LibreriaBD.conectar();
        if (conexion != null) {
            System.out.println("Conexión establecida.");
        }

        // Realizar la consulta
        Statement stmt;
        try {
            stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select * from agenda");
            while (rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) +"\t" + rs.getString(3));
            }
        } catch (SQLException e1) {
            System.err.println("Error en la sentencia SQL: " + e1);
            e1.printStackTrace();
        }

        // cerrar la conexión
        LibreriaBD.cerrarConexion(conexion);
        try{
            if (conexion.isClosed()){
                System.out.println("Conexión cerrada.");
            }
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexión: " + e);
            e.printStackTrace();
        }
    }
}