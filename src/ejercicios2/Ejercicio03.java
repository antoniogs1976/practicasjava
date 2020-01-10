package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * Ejercicio03
 * 
 * Programa que lea por teclado tres números enteros y calcule el mayor de los
 * tres.
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2, num3;
        boolean bucle = true;
        char siOno;
        while (bucle) {
            MisClases.limpiarPantalla();
            MisClases.escribeLinea("------------------------------------------------------------");
            MisClases.escribeLinea("-                  MAYOR DE TRES NÚMEROS                   -");
            MisClases.escribeLinea("------------------------------------------------------------");
            MisClases.escribe("Introduce el valor de Número 1: ");
            num1 = entrada.nextInt();
            MisClases.escribe("Introduce el valor de Número 2: ");
            num2 = entrada.nextInt();
            MisClases.escribe("Introduce el valor de Número 3: ");
            num3 = entrada.nextInt();

            // comparaciones
            if (num1 > num2 && num1 > num3) {
                MisClases.escribeLinea("El Número 1 (" + num1 + ") es el mayor de los tres números");
            } else if (num2 > num1 && num2 > num3) {
                MisClases.escribeLinea("El Número 2 (" + num2 + ") es el mayor de los tres números");
            } else {
                MisClases.escribeLinea("El Número 3 (" + num3 + ") es el mayor de los tres números");
            }
            
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
        // cerrar scanner
        entrada.close();
        MisClases.escribeLinea("bye!");
    }
}