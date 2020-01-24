package tema8;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.util.StringTokenizer;

/**
 * ficheros3
 */
public class ficheros3 {

    public static void escribir(int[][] datos, String nombreFichero) {
        FileWriter fichero = null; // Fichero para escritura
        PrintWriter salida = null; // Canal de salida
        // escribir los datos de "numeros" en el disco duro
        System.out.println("# ESCRIBIENDO DATOS EN EL ARCHIVO #");
        try {
            // preparar las cosas para poder escribir
            fichero = new FileWriter(nombreFichero, false);
            salida = new PrintWriter(fichero);
            // escribir los datos
            for (int i = 0; i < datos.length; i++) {
                for (int j = 0; j < datos[i].length; j++) {
                    if (j == (datos[i].length - 1)) {
                        salida.print(datos[i][j] + "\n");
                    } else {
                        salida.print(datos[i][j] + ",");
                    }
                }
            }
            // cerrar el fichero
            salida.flush();
            fichero.close();

            // LEER LOS DATOS (sacar esto luego)

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    } // fin escribir

    public static void leer(String nombreFichero) {
        FileReader fichero = null;
        BufferedReader entrada = null;
        String linea, elemento;
        StringTokenizer numerosFichero;
        System.out.println("# LEYENDO LOS DATOS DEL ARCHIVO #");
        try {
            // preparar las cosas para leer
            fichero = new FileReader(nombreFichero);
            entrada = new BufferedReader(fichero);
            do {
                linea = entrada.readLine();
                if (linea != null) {
                    numerosFichero = new StringTokenizer(linea, ",");
                    while(numerosFichero.hasMoreTokens()){
                        elemento = numerosFichero.nextToken();
                        System.out.print(elemento + "\t");
                    }
                }
                System.out.println("");
            } while (linea != null);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int[][] numeros = {
                            {  1,  2,  3,  4,  5 },
                            {  6,  7,  8,  9, 10 },
                            { 11, 12, 13, 14, 15 },
                            { 16, 17, 18, 19, 20 },
                            { 21, 22, 23, 24, 25 }
                        };
        escribir(numeros, "c:/datos/ficheros3-1.txt");
        leer("c:/datos/ficheros3-1.txt");
    } // fin main
}