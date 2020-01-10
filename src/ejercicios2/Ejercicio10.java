package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * Ejercicio10
 * 
 * Programa que guarda en un array 10 números enteros que se leen por teclado. A
 * continuación se recorre el array y calcula cuántos números son positivos,
 * cuántos negativos y cuántos ceros.
 * 
 */
public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[10];
        int i, ceros, positivos, negativos;
        boolean bucle = true;
        char siOno;

        while (bucle) {
            // inicializar variables
            ceros = 0;
            positivos = 0;
            negativos = 0;
            MisClases.limpiarPantalla();
            MisClases.escribeLinea("------------------------------------------------------------");
            MisClases.escribeLinea("-  Array 10 números y contar positivos, negativos y ceros  -");
            MisClases.escribeLinea("------------------------------------------------------------");
            for (i = 0; i <= 9; i++) {
                MisClases.escribe("Introduce el valor del número " + (i + 1) + ": ");
                numeros[i] = entrada.nextInt();
            }
            // Recorrer el array actualizando las medias y el total según sea el valor del
            // elemento del array
            for (i = 0; i < numeros.length; i++) {
                if (numeros[i] == 0) {
                    ceros++;
                } else if (numeros[i] > 0) {
                    positivos++;
                } else {
                    negativos++;
                }
            }
            // Mostramos los resultados utilizo el formato %.2f para que imprima 2 decimales
            MisClases.escribeLinea("Has introducido " + positivos + " números positivos.");
            MisClases.escribeLinea("Has introducido " + negativos + " números negativos.");
            MisClases.escribeLinea("Has introducido " + ceros + " ceros.");

            // Preguntar si se continúa o no
            do {
                MisClases.escribe("¿Desea repetir la operación? (S/N): ");
                siOno = entrada.next().charAt(0);
                if (siOno == 'n' || siOno == 'N') {
                    bucle = false;
                } else if (siOno == 's' || siOno == 'S') {
                    bucle = true;
                }
            } while (siOno == 's' && siOno == 'S' && siOno == 'n' && siOno == 'N');
        }
        MisClases.escribeLinea("bye!");
        // cerrar el scanner
        entrada.close();
    }
}