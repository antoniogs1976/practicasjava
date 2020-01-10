package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * Ejercicio07V1
 * 
 * Programa que lea números enteros por teclado y para cada número introducido
 * indique si es positivo o negativo y si es par o impar. Se deben realizar tres
 * versiones del programa:
 * 
 * En la primera versión se utilizará un bucle while. La lectura de números
 * finalizará cuando se introduzca un cero.
 * 
 */
public class Ejercicio07V1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        boolean bucle = true;
        String tipo1 = "", tipo2 = "";

        MisClases.limpiarPantalla();
        MisClases.escribeLinea("------------------------------------------------------------");
        MisClases.escribeLinea("-                Identificación de Números                 -");
        MisClases.escribeLinea("------------------------------------------------------------");
        while (bucle) {
            MisClases.escribe("Introduce un número (0 para salir): ");
            numero = entrada.nextInt();
            if (numero == 0) {
                bucle = false;
            } else {
                // Comprobamos si es par o impar
                if (numero % 2 == 0) {
                    tipo1 = "par ";
                } else {
                    tipo1 = "impar ";
                }
                // Comprobamos si es positivo o negativo
                if (numero < 0) {
                    tipo2 = "y negativo.";
                } else {
                    tipo2 = "y positivo.";
                }
                // Mostramos el resultado
                MisClases.escribeLinea("El número " + numero + " es " + tipo1 + tipo2);
            }
        }
        MisClases.escribeLinea("bye!");
        entrada.close();
    }
}