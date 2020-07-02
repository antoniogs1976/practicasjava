package examen;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class ConsultaCenso {
    public static void main(String[] args) {
        // limpiar la consola para ver las cosas mejor ----------------------------------
        // (método al final de este archivo)
        limpiarPantalla();

        // conectar a la base de datos --------------------------------------------------
        Connection conexion = LibreriaBDCenso.conectar();
        if (conexion != null) {
            System.out.println("Conexión establecida.");
        }

        // listado del censo ------------------------------------------------------------
        ArrayList<Censo> listaCenso = LibreriaBDCenso.listado(conexion, false);
        for (int i = 0; i < listaCenso.size(); i++) {
            System.out.println(listaCenso.get(i).getCodigo() + " - " + listaCenso.get(i).getNombre() + " - " + listaCenso.get(i).getEdad());
        }

        // media de edad ----------------------------------------------------------------
        System.out.println("----------");
        System.out.println("La media de edad es: " + LibreriaBDCenso.mediaEdad(conexion));

        // edad del mayor ---------------------------------------------------------------
        System.out.println("----------");
        System.out.println("La edad más alta es: " + LibreriaBDCenso.edadMayor(conexion));

        // edad del menor ---------------------------------------------------------------
        System.out.println("----------");
        System.out.println("La edad más baja es: " + LibreriaBDCenso.edadMenor(conexion));

        // nombres de los menores -------------------------------------------------------
        System.out.println("----------");
        System.out.println("Los menores son:");
        ArrayList<Censo> listaMenores = LibreriaBDCenso.nombreMenores(conexion);
        for (int i = 0; i < listaMenores.size(); i++){
            System.out.println(listaMenores.get(i).getCodigo() + " - " + listaMenores.get(i).getNombre() + " - " + listaMenores.get(i).getEdad());
        }

        // cerrar la conexión -----------------------------------------------------------
            LibreriaBDCenso.cerrarConexion(conexion);
        try {
            if (conexion.isClosed()) {
                System.out.println("Conexión cerrada.");
            }
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexión: " + e);
            e.printStackTrace();
        }

    }

    /**
     * Método para limpar la consola
     */
    public static void limpiarPantalla() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.err.println("* Error: " + ex);
            ex.printStackTrace();
        }
    }
}