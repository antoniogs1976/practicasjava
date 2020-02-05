package tema8;

import java.io.File;
import java.util.Scanner;

import miscosas.Utilidades;

/**
 * CrearDirectorios
 */
public class CrearDirectorios {

    /**
     * Método para crear las carpetas necesarias para el proyecto/ejercicio
     * 
     * @param nombreCarpeta Nombre de la carpeta a crear
     * @return              devuelve True si todo ha ido bien, False si ha ocurrido algún error
     */
    public static boolean crearCarpeta(String nombreCarpeta) {
        boolean retorno = false;
        File carpeta = new File(nombreCarpeta);

        if (carpeta.exists()) {
            System.out.println("Carpeta " + nombreCarpeta + " ya existe.");
            retorno = true;
        } else {
            System.out.println("Creando la carpeta " + nombreCarpeta);
            if (carpeta.mkdir()) {
                System.out.println("Carpeta creada");
                retorno = true;
            } else {
                mostrarErrorCreacion(nombreCarpeta);
                retorno = false;
            }
        }
        return retorno;
    }

    /**
     * Método para mostrar un error si ocurre algo al crear una carpeta
     * 
     * @param nombreCarpeta Nombre de la carpeta para mostrar en el error
     */
    public static void mostrarErrorCreacion(String nombreCarpeta) {
        System.out.println("Ha ocurrido un error al crear la carpeta " + nombreCarpeta);
    }

    public static void main(String[] args) {
        // constantes varias
        final String PATH = "/datos/";
        final String CLI = "clientes";
        final String PRO = "proveedores";
        final String ALB = "albaranes";
        final String FAC = "facturas";
        // variables varias
        Scanner entrada = new Scanner(System.in);
        int dato = 0;
        boolean datoOK = false;
        String directorio;

        // limpiar pantalla
        Utilidades.limpiarPantalla();

        // pedir año
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

        // CUANDO EL valor es correcto, creamos la carpeta y las subcarpetas
        directorio = PATH + dato;
        if (crearCarpeta(directorio)) {
            // si se ha creado bien la primera carpeta, creamos las subcarpetas

            // carpeta ALBARANES
            directorio = PATH + dato + "/" + ALB;
            crearCarpeta(directorio);

            // carpeata CLIENTES
            directorio = PATH + dato + "/" + CLI;
            crearCarpeta(directorio);

            // carpeta FACTURAS
            directorio = PATH + dato + "/" + FAC;
            crearCarpeta(directorio);

            // carpeta PROVEEDORES
            directorio = PATH + dato + "/" + PRO;
            crearCarpeta(directorio);
        } else {
            System.out.println("Ocurrió algún error...");
        }

        // cerrar el scanner
        entrada.close();
    }
}