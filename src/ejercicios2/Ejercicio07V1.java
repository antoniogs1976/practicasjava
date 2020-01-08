package ejercicios2;

import java.util.Scanner;
import tema5.CosasVarias;

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
        boolean bucle =true;

        CosasVarias.escribeLinea("------------------------------------------------------------");
        CosasVarias.escribeLinea("-                Identificación de Números                 -");
        CosasVarias.escribeLinea("------------------------------------------------------------");
        while (bucle){
            CosasVarias.escribe("Introduce un número (0 para salir): ");
            numero = entrada.nextInt();
            if (numero == 0){
                bucle = false;
            } else {
                // Decimos si es par o impar
                if (numero % 2 == 0){
                    CosasVarias.escribeLinea("El número "+numero+" es par.");
                } else {
                    CosasVarias.escribeLinea("El número "+numero+" es impar.");
                }
                // Decimos si es positivo o negativo
                if (numero < 0){
                    CosasVarias.escribeLinea("El número "+numero+" es negativo.");
                } else {
                    CosasVarias.escribeLinea("El número "+numero+" es positivo.");
                }
            }
        }
        CosasVarias.escribeLinea("bye!");
        entrada.close();
    }
}