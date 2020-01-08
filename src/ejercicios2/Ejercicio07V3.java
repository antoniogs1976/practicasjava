package ejercicios2;

import java.util.Scanner;
import tema5.CosasVarias;

/**
 * Ejercicio07V3
 * 
 * Programa que lea números enteros por teclado y para cada número introducido
 * indique si es positivo o negativo y si es par o impar. Se deben realizar tres
 * versiones del programa:
 * 
 * En la tercera versión también se utilizará un bucle do .. while pero en este
 * caso la lectura de números finaliza cuando se responda ‘N’ ó ‘n’ a la
 * pregunta “Desea introducir más números? (S/N):”
 * 
 */
public class Ejercicio07V3 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        char siOno;
        boolean bucle = true;

        CosasVarias.escribeLinea("------------------------------------------------------------");
        CosasVarias.escribeLinea("-                Identificación de Números                 -");
        CosasVarias.escribeLinea("------------------------------------------------------------");
        do {
            CosasVarias.escribe("Introduce un número (0 para salir): ");
            numero = entrada.nextInt();
            // Decimos si es par o impar
            if (numero % 2 == 0) {
                CosasVarias.escribeLinea("El número " + numero + " es par.");
            } else {
                CosasVarias.escribeLinea("El número " + numero + " es impar.");
            }
            // Decimos si es positivo o negativo
            if (numero < 0) {
                CosasVarias.escribeLinea("El número " + numero + " es negativo.");
            } else {
                CosasVarias.escribeLinea("El número " + numero + " es positivo.");
            }
            // preguntar si se sigue o no se sigue
            CosasVarias.escribe("¿Desea introducir más números? (S/N): ");
            siOno = entrada.next().charAt(0);
            if (siOno == 'n' || siOno == 'N'){
                bucle = false;
            } 
        } while (bucle != false);
        CosasVarias.escribeLinea("bye!");
        entrada.close();
    }
}