package tema8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import miscosas.Utilidades;

/**
 * CrearDirectorio02
 * 
 * leer los nombres de los directorios de un archivo de texto para crear esa
 * estructura en el disco duro.
 */
public class CrearDirectorio02 {

    /**
     * Método para crear una serie de carpetas según las líneas de un archivo de
     * texto
     * 
     * @param path    path donde crear la esctructura de carpetas
     * @param archivo archivo con los nombres de las carpetas a crear
     */
    public static void crearCarpetasEstructura(String path, String archivo) {
        FileReader fichero = null;
        BufferedReader entrada = null;
        String linea;

        // crear la carpeta principal (la del ejercicio)
        Utilidades.crearCarpeta(path);
        // ahora, leer el arhcivo e ir creando las carpetas
        try {
            fichero = new FileReader(archivo);
            entrada = new BufferedReader(fichero);
            // System.out.println("LEYENDO EL FICHERO:");
            do {
                linea = entrada.readLine();
                if (linea != null) {
                    // crear las carpetas
                    Utilidades.crearCarpeta(path + linea);
                }
            } while (linea != null);
            fichero.close();
        } catch (Exception e) { // Exception es la más general de las excepciones
                                // Aqui salta cuando se produce cualquier excepción
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static boolean crearArchivoEstructura(String rutaAlArchivo, String nombreDelArchivo) {
        FileWriter fichero = null;
        PrintWriter salida = null;
        boolean retorno = false;
        try {
            fichero = new FileWriter(rutaAlArchivo + nombreDelArchivo, false);
            salida = new PrintWriter(fichero);
            salida.println("clientes");
            salida.println("proveedores");
            salida.println("albaranes");
            salida.println("facturas");
            salida.println("productos");
            salida.println("servicios");
            fichero.close();
            retorno = true;
        } catch (IOException e) {
            System.out.println("* ERROR: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error puntero nulo");
        }

        return retorno;
    }

    public static void main(String[] args) {
        final String ARCHIVO_ESTRUCTURA = "estructura.txt";
        final String CARPETA_DATOS = "/datos/";

        File archivo = null;
        Scanner entrada = new Scanner(System.in);
        String path;
        boolean datoOK = false;
        int dato = 0;

        Utilidades.limpiarPantalla();

        // primero, comprobar si el archivo de configuración existe o no
        try {
            archivo = new File(CARPETA_DATOS + ARCHIVO_ESTRUCTURA);
            if (archivo.exists()) {
                // hacer cosas si existe el archivo
                // pedir el año del ejercicio, sólo números
                do {
                    System.out.print("Introduce el año del ejercicio: ");
                    try {
                        dato = Integer.parseInt(entrada.nextLine());
                        datoOK = true;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Que sea un número...");
                        datoOK = false;
                    }
                } while (!datoOK);
                path = CARPETA_DATOS + dato + "/";
                crearCarpetasEstructura(path, (CARPETA_DATOS + ARCHIVO_ESTRUCTURA));
            } else {
                // si no existe el archivo, crearlo, por ejemplo
                if (crearArchivoEstructura(CARPETA_DATOS, ARCHIVO_ESTRUCTURA)) {
                    System.out.println("Archivo de estructura creado correcamente");
                } else {
                    System.out.println("Erro al crear el archivo de estructura");
                }
            }
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
        }

        // cerrar scanner
        entrada.close();
    }
}