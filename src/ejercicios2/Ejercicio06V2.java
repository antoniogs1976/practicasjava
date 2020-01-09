package ejercicios2;

import java.util.Scanner;
import tema5.CosasVarias;

/**
 * Ejercicio06V2
 * 
 * Programa que pida que se introduzcan dos números enteros por teclado y
 * muestre los números desde el menor hasta el mayor de los números
 * introducidos. Los dos números introducidos deben ser distintos. Si son
 * iguales se mostrará un mensaje indicandolo y se vuelven a introducir.
 * 
 * V2: Optimización del código
 * 
 */
public class Ejercicio06V2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2, min, max;
        boolean bucle = true;
        char siOno;

        CosasVarias.escribeLinea("------------------------------------------------------------");
        CosasVarias.escribeLinea("-       Mostrar los números que hay entre dos números      -");
        CosasVarias.escribeLinea("------------------------------------------------------------");
        while (bucle) {
            do {
                CosasVarias.escribe("Introduce el primer número: ");
                num1 = entrada.nextInt();
                CosasVarias.escribe("Introduce el segundo número: ");
                num2 = entrada.nextInt();
                if (num1 == num2) {
                    CosasVarias.escribeLinea("Los números deben ser distintos. Vuelve a introducirlos.");
                }
            } while (num1 == num2);
            // Comprobar cual de los dos es el menor
            if (num1 < num2) {
                min = num1;
                max = num2;
            } else {
                min = num2;
                max = num1;
            }

            // Mostrar los datos
            CosasVarias.escribeLinea("Los números comprendidos entre " + num2 + " y " + num1 + " son:");
            for (int i = min; i <= max; i++) {
                if (i == max) {
                    // para poner un . en el último elemento
                    CosasVarias.escribeLinea(i + ".");
                } else {
                    CosasVarias.escribe(i + ", ");
                }
            }

            CosasVarias.escribe("¿Desea introducir más números? (S/N): ");
            siOno = entrada.next().charAt(0);
            if (siOno == 'n' || siOno == 'N') {
                bucle = false;
            } else {
                bucle = true;
            }
        }
        // cerrar scanner
        entrada.close();
    }
}