package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * Ejercicio08
 * 
 * Programa que lea por teclado 10 números enteros y los guarde en un array. A
 * continuación calcula y muestra por separado la media de los valores positivos
 * y la de los valores negativos.
 * 
 */
public class Ejercicio08 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[10];
        int i, total, positivos, negativos;
        float mediaPositivos, mediaNegativos;
        boolean bucle = true;
        char siOno;

        while (bucle) {
            // Inicializar variables
            total = 0;
            positivos = 0;
            negativos = 0;
            mediaNegativos = 0;
            mediaPositivos = 0;
            /*************************************/
            MisClases.limpiarPantalla();
            MisClases.escribeLinea("------------------------------------------------------------");
            MisClases.escribeLinea("-     Array 10 números y media de positivos y negativos    -");
            MisClases.escribeLinea("------------------------------------------------------------");
            for (i = 0; i <= 9; i++) {
                MisClases.escribe("Introduce el valor del número " + (i + 1) + ": ");
                numeros[i] = entrada.nextInt();
            }
            // Recorrer el array actualizando las medias y el total según sea el valor del
            // elemento del array
            for (i = 0; i < numeros.length; i++) {
                total += numeros[i];
                if (numeros[i] > 0) {
                    mediaPositivos += numeros[i];
                    positivos++;
                } else {
                    mediaNegativos += numeros[i];
                    negativos++;
                }
            }

            // Ahora tocal calcular las medias reales dividiendo por el número de elementos
            if (positivos > 0) {
                mediaPositivos = mediaPositivos / positivos;
            }
            if (negativos > 0) {
                mediaNegativos = mediaNegativos / negativos;
            }

            // Mostramos los resultados utilizo el formato %.2f para que imprima 2 decimales
            MisClases.escribeLinea("Media de los números positivos: " + mediaPositivos);
            MisClases.escribeLinea("Media de los números negativos: " + mediaNegativos);
            MisClases.escribeLinea("Suma total de los números: " + total);

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