package tema8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * LibreriaAgenda
 */
public class LibreriaAgenda {

    private static final String NOMBRE_ARCHIVO = "c:/datos/contactos.txt";

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

    public static void pulsarTecla(Scanner entradaDatos) {
        char tecla;
        do {
            System.out.println("(pulsa S y presiona Enter para volver al menú)");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S');
    }

    /**
     * Método para dibujar el menú principal
     * 
     * @param entradaDatos Scanner para la introducción de datos (opción del menú)
     * @return int con la opción elegida
     */
    public static void menu(int numeroContactos) {
        LibreriaAgenda.limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##                        JAVAGENDA                       ##");
        System.out.println("############################################################");
        System.out.println("##  1.- Añadir un contacto                                ##");
        System.out.println("##  2.- Borrar un contacto                                ##");
        System.out.println("##  3.- Ver listado de contactos                          ##");
        System.out.println("##  4.- Guardar archvivo de contactos                     ##");
        System.out.println("##  5.- Buscar contacto                                   ##");
        System.out.println("##  ----------------------------------------------------  ##");
        System.out.println("##  9.- Salir                                             ##");
        System.out.println("##  ----------------------------------------------------  ##");
        if (numeroContactos < 10) {
            System.out.println("##       (Actualmente hay " + numeroContactos + " contactos en la agenda)       ##");
        } else if (numeroContactos >= 10 && numeroContactos < 100) {
            System.out.println("##       (Actualmente hay " + numeroContactos + " contactos en la agenda)      ##");
        } else if (numeroContactos >= 100 && numeroContactos < 1000) {
            System.out.println("##      (Actualmente hay " + numeroContactos + " contactos en la agenda)      ##");
        } else if (numeroContactos >= 1000 && numeroContactos < 10000) {
            System.out.println("##      (Actualmente hay " + numeroContactos + " contactos en la agenda)     ##");
        } else if (numeroContactos >= 10000) {
            System.out.println("##     (Actualmente hay " + numeroContactos + " contactos en la agenda)     ##");
        }
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
        entradaDatos.nextLine();
        // dibujar el menu
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##                   AÑADIR UN CONTACTO                   ##");
        System.out.println("############################################################");
        System.out.print("##  Nombre: ");
        nombre = entradaDatos.nextLine();
        System.out.print("##  Teléfono: ");
        telefono = entradaDatos.nextLine();
        System.out.println("##  ----------------------------------------------------  ##");
        listaContactos.add(nombre + ": " + telefono);
        System.out.println("##                    Contacto añadido                    ##");
        System.out.println("############################################################");
        pulsarTecla(entradaDatos);
    }

    public static void borrarContacto(Scanner entradaDatos, ArrayList<String> listaContactos) {
        String nombre, contacto;
        int opcion;
        char tecla;
        entradaDatos.nextLine();
        // dibujar el menu
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##                   BORRAR UN CONTACTO                   ##");
        System.out.println("############################################################");
        System.out.println("##      Te dispones a borrar un contacto de tú agenda     ##");
        System.out.println("##            ESTA ACCIÓN NO SE PUEDE DESHACER            ##");
        System.out.println("############################################################");
        System.out.println("##  Por favor, introduce el nombre del contacto a borrar  ##");
        System.out.println("##  ----------------------------------------------------  ##");
        System.out.print("##  ");
        nombre = entradaDatos.next();
        System.out.println("##  ----------------------------------------------------  ##");
        System.out.println("##                     COINCIDENCIAS                      ##");
        System.out.println("##  ----------------------------------------------------  ##");
        for (int i = 0; i < listaContactos.size(); i++) {
            contacto = listaContactos.get(i);
            if (contacto.toUpperCase().contains(nombre.toUpperCase())) {
                System.out.println("##  " + i + " - " + contacto);
            }
        }
        System.out.println("##  ----------------------------------------------------  ##");
        System.out.println("##  Si hay varias coincidencias introduce el número  que  ##");
        System.out.println("##         aparece delante del nombre del contacto        ##");
        System.out.println("##       ASEGÚRATE DE INTRODUCIR EL NÚMERO CORRECTO       ##");
        System.out.println("##   porque si introduce el número erróneo, borrarás el   ##");
        System.out.println("##          contacto que no es, y menuda faena...         ##");
        System.out.println("##  ----------------------------------------------------  ##");
        System.out.print("##  ¿Qué contacto deseas eleminar? (-1 para cancelar): ");
        opcion = entradaDatos.nextInt();
        if (opcion != -1) {
            System.out.println("##  vas a eleminar " + listaContactos.get(opcion));
            System.out.print("##  ¿Deseas eliminar este contacto? (S/N): ");
            tecla = entradaDatos.next().charAt(0);
            if (tecla == 's' || tecla == 'S') {
                listaContactos.remove(opcion);
                System.out.println("##  ----------------------------------------------------  ##");
                System.out.println("##                   CONTACTO ELIMINADO                   ##");
                System.out.println("##  ----------------------------------------------------  ##");
            }
        } else {
            System.out.println("##  ----------------------------------------------------  ##");
            System.out.println("##                 OPERACIÓN CANCELADA                    ##");
            System.out.println("##  ----------------------------------------------------  ##");
        }
        pulsarTecla(entradaDatos);
    }

    /**
     * Método para dibujar el menú/listado de contactos
     * 
     * @param entradaDatos   Scanner para la introducción de datos
     * @param listaContactos ArrayList<String> con los contactos
     */
    public static void listarContactos(Scanner entradaDatos, ArrayList<String> listaContactos) {
        String contacto;
        entradaDatos.nextLine();
        // dibujar
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##                  LISTADO DE CONTACTOS                  ##");
        System.out.println("############################################################");
        if (listaContactos.size() == 0) {
            System.out.println("##         Todavía no hay contactos en la agenda          ##");
        } else {
            for (int i = 0; i < listaContactos.size(); i++) {
                contacto = listaContactos.get(i);
                System.out.println((i + 1) + ".- " + contacto);
            }
        }
        System.out.println("##  ----------------------------------------------------  ##");
        System.out.println("##                    Listado completo                    ##");
        System.out.println("############################################################");
        pulsarTecla(entradaDatos);
    }

    /**
     * Método para filtrar/buscar un contacto. Escribe en pantalla todas las
     * coincidencias que encuentre, o avisa de que no ha encontrado nada
     * 
     * @param entradaDatos   Scanner para la entrada de datos
     * @param listaContactos ArrayList<String> con la lista de contactos
     */
    public static void buscarContacto(Scanner entradaDatos, ArrayList<String> listaContactos) {
        String aBuscar, contacto;
        boolean encontrado = false;
        entradaDatos.nextLine();
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##                     BUSCAR CONTACTO                    ##");
        System.out.println("############################################################");
        System.out.print("##  Contacto a buscar: ");
        aBuscar = entradaDatos.next();
        System.out.println("##  ----------------------------------------------------  ##");
        for (int i = 0; i < listaContactos.size(); i++) {
            contacto = listaContactos.get(i);
            if (contacto.toUpperCase().contains(aBuscar.toUpperCase())) {
                System.out.println("##  " + contacto);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("##  " + aBuscar + "no encontrado entre los contactos :(");
        }
        System.out.println("############################################################");
        pulsarTecla(entradaDatos);
    }

    /**
     * Método para esribir los datos en un archivo de texto.
     * 
     * @param listaContactos ArrayList<String> con los contactos
     */
    public static void menuGuardarContactos(Scanner entradaDatos, ArrayList<String> listaContactos) {
        entradaDatos.nextLine();
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##              GUARDAR CONTACTOS EN FICHERO              ##");
        System.out.println("############################################################");
        System.out.println("Guardando datos en " + NOMBRE_ARCHIVO);
        guardarArchivoSinPreguntar(listaContactos);
        System.out.println("##  ----------------------------------------------------  ##");
        System.out.println("##       Datos guardados en " + NOMBRE_ARCHIVO + " ##       ");
        System.out.println("############################################################");
        pulsarTecla(entradaDatos);
    }

    /**
     * Método para guardar los datos directamente sin preguntar nada al usuario
     * 
     * @param listaContactos    ArrayList<String> con los contactos a guardar
     */
    public static void guardarArchivoSinPreguntar(ArrayList<String> listaContactos){
        FileWriter fichero = null;
        PrintWriter salida = null;
        try {
            fichero = new FileWriter(NOMBRE_ARCHIVO, false);
            salida = new PrintWriter(fichero);
            for (int i = 0; i < listaContactos.size(); i++) {
                salida.println(listaContactos.get(i));
            }
            fichero.close();
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
        }   
    }

    /**
     * Método para leer el fichero de contactos
     * 
     * @param listaContactos ArrayList<String> para almacenar la lista de contactos
     */
    public static void cargarFichero(ArrayList<String> listaContactos) {
        FileReader fichero = null;
        BufferedReader entrada = null;
        String linea;
        try {
            // preparar las cosas para leer
            fichero = new FileReader(NOMBRE_ARCHIVO);
            entrada = new BufferedReader(fichero);
            do {
                linea = entrada.readLine();
                if (linea != null) {
                    listaContactos.add(linea);
                }
            } while (linea != null);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    /**
     * Método paradibujar una pantallita de salida
     */
    public static void salir(ArrayList<String> listaContactos) {
        listaContactos.clear();
        limpiarPantalla();
        System.out.println("############################################################");
        System.out.println("##               GRACIAS POR USAR JAVAGENDA               ##");
        System.out.println("############################################################");
    }
}