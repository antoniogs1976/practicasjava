package examen;

import java.sql.Connection;
import java.util.ArrayList;

// Se conecta a la BD utilizando el método "conectar" de "LibreriaBD.java"
// hace un inserto de datos en la agenda desde "LiberiaDB.java"
// y hace una consulta a la tabla "agenda" desde "LibreriaDB.java"

public class Consulta3 {
    public static void main(String[] args) {
        // Limpiar la consola para ver las cosas mejor
        miscosas.MisClases.limpiarPantalla();

        // Conectar a la BD -------------------------------------------------------------
        Connection conexion = LibreriaBD.conectar();
        if (conexion != null) {
            System.out.println("Conexión establecida.");
        }

        // Insertar un contacto en la agenda --------------------------------------------
        Contacto contacto = new Contacto(LibreriaBD.siguienteCodigo(conexion), "Dato Aleatorio", "123456789");
        LibreriaBD.alta(conexion, contacto);

        // Realizar la consulta desde la Librería ---------------------------------------
        ArrayList<Contacto> resultado = LibreriaBD.consulta(conexion, false);
        for (int i=0;i<resultado.size();i++){
            System.out.println(resultado.get(i).getDatos());
        }

        // Mostrar el número de contactos en la agenda ----------------------------------
        System.out.println(LibreriaBD.totalContactos(conexion));

        // cerrar la conexión -----------------------------------------------------------
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