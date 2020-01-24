package tema8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

/**
 * fiecheros
 */
public class fiecheros {

    private static void escribir() {
        FileWriter fichero = null;
        PrintWriter salida = null;
        try {
            // para separar los nombres del camino se puede utilizar / o \\
            // si ponemos true al final indica que se abra para añadir (no sobreescribe)
            fichero = new FileWriter("c:/datos/fichero.txt", false);
            // crear un canal de salida para el fichero
            salida = new PrintWriter(fichero);
            // escribir en el canal de salida (analogo al out, que sale por pantalla)
            salida.println("primera escritura, con salto de linea");
            salida.print("segunda escritura, sin salto de linea");
            salida.print(" tercera escritura, sin salto de linea");
            // escribir dos saltos de linea
            salida.println();
            salida.println();
            salida.println("cuarta escritura, más abajo");
            // escribir con un bucle
            for (int i = 1; i <= 10; i++) {
                salida.println("linea-" + i);
            }
            fichero.close();
        } catch (IOException e) {
            System.out.println("ERROR de fichero");
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error puntero nulo");
        } finally {
            System.out.println("El finally se ejecuta siempre, haya error o no");
        }
    } // fin escribir

    private static void leer() {
        FileReader fichero = null;
        BufferedReader entrada = null;
        String linea;
        try {
            // abrir el fichero para lectura
            fichero = new FileReader("c:/datos/fichero.txt");
            // abrir un canal de lectura para el fichero
            entrada = new BufferedReader(fichero);
            // leer lineas del canal entrada
            System.out.println("LEYENDO EL FICHERO:");
            do {
                linea = entrada.readLine();
                if (linea != null) {
                    System.out.println(linea);
                }
            } while (linea != null);
            fichero.close();
        } catch (Exception e) { // Exception es la más general de las excepciones
                                // Aqui salta cuando se produce cualquier excepción
            System.out.println("ERROR: " + e.getMessage());
        }
    } // fin leer

    private static void info(){
        File fichero = new File("c:/datos/fichero.txt");
        System.out.println("-------------------- INFORMACIÓN DEL FICHERO --------------------");
        System.out.println("Fichero            : "+fichero.getName()); 
        System.out.println("Path               : "+fichero.getPath()); 
        System.out.println("Path Absoluto:     : " +fichero.getAbsolutePath()); 
        System.out.println("Path Superior      : "+fichero.getParent()); 
        if(fichero.exists()) 
        { 
            System.out.println("Existe             : "+fichero.exists()); 
            System.out.println("¿Se puede escribir?: "+fichero.canWrite()); 
            System.out.println("¿Se puede leer?    : "+fichero.canRead()); 
            System.out.println("¿Es un directorio? : "+fichero.isDirectory()); 
            System.out.println("Tamaño en bytes    : "+fichero.length()); 
        }
    }

    public static void main(String[] args) {
        escribir();
        leer();
        info();
    }
}