package examen;

import java.sql.Connection;

// Se conecta a la BD utilizando el método "conectar" de "LibreriaBD.java"

public class Conexion2 {
    public static void main(String[] args) {
        // Limpiar la consola para ver las cosas mejor
        miscosas.MisClases.limpiarPantalla();

        // Conectar a la BD
        Connection conexion = LibreriaBD.conectar();
        if (conexion != null){
            System.out.println("Conexión establecida.");
        }

        // cerrar la conexión
        LibreriaBD.cerrarConexion(conexion);
        try{
            if (conexion.isClosed()){
                System.out.println("Conexión cerrada.");
            }
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e);
            e.printStackTrace();
        }
    }
}