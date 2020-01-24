package tema8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * ficheros2 leer un fichero de texto y escribirlo en otro numerando las lineas
 */
public class ficheros2 {

    public static void main(String[] args) {
        FileReader fichero = null;
        BufferedReader entrada = null;
        FileWriter fichero2 = null;
        PrintWriter salida = null;
        String linea;
        try {
            // abrir el fichero para lectura
            fichero = new FileReader("c:/datos/clientes.txt");
            // abrir el fichero de escritura
            fichero2 = new FileWriter("c:/datos/clientesNumerados.txt");
            // abrir un canal de lectura para el fichero
            entrada = new BufferedReader(fichero);
            // abrir un canal de escritura para el otro fichero
            salida = new PrintWriter(fichero2);
            // leer lineas del canal entrada
            System.out.println("LEYENDO EL FICHERO:");
            int i = 1;
            do {
                linea = entrada.readLine();
                if (linea != null) {
                    System.out.println(linea);
                    // escribir cada linea en el canal de salida
                    salida.println(i + ".- " + linea.toUpperCase());
                    i++;
                }
            } while (linea != null);
            // cerrar ficheros
            fichero.close();
            fichero2.close();
        }
        catch (Exception e) { // Exception es la más general de las excepciones
                              // Aqui salta cuando se produce cualquier excepción
            System.out.println("ERROR: " + e.getMessage());
        } 
    }
}