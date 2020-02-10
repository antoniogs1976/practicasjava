package miscosas;

import java.io.File;
import java.io.IOException;

/**
 * Utilidades
 */
public class Utilidades {

    /**
     * Método para escribir una línea sin tener que escribir todo el churro del
     * System.out.println();
     * 
     * @param texto Texto a mostrar
     */
    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    /**
     * Método para escribir sin tener que escribir todo el curro del
     * System.out.print();
     * 
     * @param texto Texto a mostrar
     */
    public static void escribe(String texto) {
        System.out.print(texto);
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
        }
    }

    /**
     * Método para medir el tiempo de ejecución Se usa System.nanoTime() para
     * obtener los valores
     * 
     * @param tiempoInicio System.nanoTime() de inicio
     * @param tiempoFin    System.nanoTime() de fin
     * @return el tiempo que ha tardado en milisegundos
     */
    public static String medirTiempoEjecucion(String proceso, Long tiempoInicio, Long tiempoFin) {
        // como se usan nanosegundos, dividir entre 1 millón el resultado
        return "Proceso: "+ proceso + " | Tiempo de ejecución: "+ ((tiempoFin - tiempoInicio) / 1000000)+"ms.";
    }

    /**
     * Método para mostrar mensajes de creación y demás
     * 
     * @param nombreFichero Nombre del fichero/carpeta
     * @param tipoMensaje   1- El fichero se va a crear, 2- El fichero se ha creado
     *                      corectamente, 3- El fichero ya existe, 4- Ha ocurrido
     *                      algún error
     * @param tipoFichero   tipo de fichero a crear, FALSE para directorio, TRUE
     *                      para archivos
     */
    public static void mostrarMensajesCreacionFicheros(String nombreFichero, int tipoMensaje, boolean tipoFichero) {
        String identificador, Identificador;
        // poner qué es lo que está creando, si una carpeta/directorio o un
        // fichero/archivo
        if (tipoFichero == false) {
            identificador = " directorio ";
            Identificador = "Directorio ";
        } else {
            identificador = " fichero ";
            Identificador = "Fichero ";
        }
        // Mostrar el mensaje
        switch (tipoMensaje) {
        case 1: // el fichero ya existe
            System.out.println(Identificador + nombreFichero + " ya existe.");
            break;
        case 2: // el ficho se va a crear
            System.out.println("Creando" + identificador + nombreFichero);
            break;
        case 3: // el fichero se ha creado correctamente
            System.out.println(Identificador + nombreFichero + " ha sido creado");
            break;
        case 4: // ha ocurrido algún error
            System.out.println("Ha ocurrido un error creando" + identificador + nombreFichero);
        default:
            break;
        }
    }

    /**
     * Método para crear carpetas mostrando mensajes, tanto de estado como de error
     * 
     * @param nombreCarpeta Nombre de la carpeta a crear
     * @return devuelve True si todo ha ido bien, False si ha ocurrido algún error
     */
    public static boolean crearCarpeta(String nombreCarpeta) {
        boolean retorno = false;
        File carpeta = new File(nombreCarpeta);

        if (carpeta.exists()) { // comprobar si existe
            Utilidades.mostrarMensajesCreacionFicheros(nombreCarpeta, 1, false);
            retorno = true;
        } else { // si no existe, la creamos
            // mensaje de "creando..."
            Utilidades.mostrarMensajesCreacionFicheros(nombreCarpeta, 2, false);
            if (carpeta.mkdir()) {  // si se crea..
                // mensaje de carpeta creada
                Utilidades.mostrarMensajesCreacionFicheros(nombreCarpeta, 3, false);
                retorno = true;
            } else { // Si no se crea, algo pasa..
                // mensaje de error
                Utilidades.mostrarMensajesCreacionFicheros(nombreCarpeta, 4, false);
                retorno = false;
            }
        }
        return retorno;
    }
}