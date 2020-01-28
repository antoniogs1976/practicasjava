package tema8;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * LibreriaAgenda
 */
public class LibreriaAgenda {

    private static final String PATH = "c:/datos/";
    private static final String EXT = ".txt";

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
        }
    } // final limpiarPantalla

    /**
     * Método para dibujar el menú principal
     * 
     * @param entradaDatos Scanner para la introducción de datos (opción del menú)
     * @return int con la opción elegida
     */
    public static void menu() {
        LibreriaAgenda.limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##                        JAVAGENDA                       ##");
        System.out.println("############################################################");
        System.out.println("##  1.- Añadir un contacto                                ##");
        System.out.println("##  2.- Ver listado de contactos                          ##");
        System.out.println("##  3.- Guardar archvivo de contactos                     ##");
        System.out.println("##--------------------------------------------------------##");
        System.out.println("##  9.- Salir                                             ##");
        System.out.println("############################################################");
    }

    /**
     * Método para dibujar el menú de añadir un contacto a la agenda
     * 
     * @param entradaDatos   Scanner para la entrada de datos
     * @param listaContactos ArrayList<String> para almacenar los contactos
     */
    public static void menuAnadir(Scanner entradaDatos, ArrayList<String> listaContactos) {
        String nombre;
        String telefono;
        char tecla;
        entradaDatos.nextLine();
        // dibujar el menu
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##                   AÑADIR UN CONTACTO                   ##");
        System.out.println("############################################################");
        System.out.print("Nombre: ");
        nombre = entradaDatos.nextLine();
        System.out.print("Teléfono: ");
        telefono = entradaDatos.nextLine();
        System.out.println("############################################################");
        listaContactos.add(nombre + ": " + telefono);
        System.out.println("Contacto añadido.");
        do {
            System.out.println("(pulsa S y presiona Enter para volver al menú)");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S');
    }

    /**
     * Método para dibujar el menú/listado de clientes
     * 
     * @param entradaDatos   Scanner para la introducción de datos
     * @param listaContactos ArrayList<String> con los contactos
     */
    public static void listarClientes(Scanner entradaDatos, ArrayList<String> listaContactos) {
        String contacto;
        char tecla;
        entradaDatos.nextLine();
        // dibujar
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##                  LISTADO DE CONTACTOS                  ##");
        System.out.println("############################################################");
        if (listaContactos.size() == 0) {
            System.out.println("\n\nTodavía no hay contactos en la agenda.\n\n");
        } else {
            for (int i = 0; i < listaContactos.size(); i++) {
                contacto = listaContactos.get(i);
                System.out.println(i + ".- " + contacto);
            }
        }
        System.out.println("############################################################");
        System.out.println("Listado completo");
        do {
            System.out.println("(pulsa S y presiona Enter para volver al menú)");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S');
    }

    /**
     * Método para esribir los datos en un archivo de texto.
     * 
     * @param entradaDatos   Scanner para la entrada de datos
     * @param listaContactos ArrayList<String> con los contactos
     */
    public static void guardarClientes(Scanner entradaDatos, ArrayList<String> listaContactos) {
        FileWriter fichero = null;
        PrintWriter salida = null;
        String nombreFichero;
        entradaDatos.nextLine();
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##              GUARDAR CONTACTOS EN FICHERO              ##");
        System.out.println("############################################################");
        System.out.println("Introduce el nombre del fichero a guardar: ");
        nombreFichero = entradaDatos.nextLine();
        try {
            fichero = new FileWriter(PATH + nombreFichero + EXT, false);
            salida = new PrintWriter(fichero);
            for (int i = 0; i < listaContactos.size(); i++) {
                salida.print(listaContactos.get(i));
            }
            fichero.close();
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
        }
    }

    /**
     * Método para dibujar una patallita de salida
     */
    public static void salir() {
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##               GRACIAS POR USAR JAVAGENDA               ##");
        System.out.println("############################################################");
    }

}