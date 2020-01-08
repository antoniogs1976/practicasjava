package ejercicios2;

import java.util.Scanner;
import tema5.CosasVarias;

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
        int i, ceros = 0, positivos = 0, negativos = 0;
        boolean bucle = true;
        char siOno;

        CosasVarias.escribeLinea("------------------------------------------------------------");
        CosasVarias.escribeLinea("-  Array 10 números y contar positivos, negativos y ceros  -");
        CosasVarias.escribeLinea("------------------------------------------------------------");
        while (bucle) {
            for (i = 0; i <= 9; i++) {
                CosasVarias.escribe("Introduce el valor del número " + (i + 1) + ": ");
                numeros[i] = entrada.nextInt();
            }
            // Recorrer el array actualizando las medias y el total según sea el valor del
            // elemento del array
            for (i = 0; i < numeros.length; i++) {
                if (numeros[i] == 0){
                    ceros++;
                } else if (numeros[i] > 0) {
                    positivos++;
                } else {
                    negativos++;
                }
            }
            // Mostramos los resultados utilizo el formato %.2f para que imprima 2 decimales
            CosasVarias.escribeLinea("Has introducido " + positivos + " números positivos.");
            CosasVarias.escribeLinea("Has introducido " + negativos + " números negativos.");
            CosasVarias.escribeLinea("Has introducido " + ceros + " ceros.");
            
            // Preguntar si se continúa o no
            CosasVarias.escribeLinea("¿Desea repetir la operación? (S/N): ");
            siOno = entrada.next().charAt(0);
            if (siOno == 'n' || siOno == 'N') {
                bucle = false;
            } else {
                bucle = true;
            }
        }
        CosasVarias.escribeLinea("bye!");
        // cerrar el scanner
        entrada.close();
    }
}