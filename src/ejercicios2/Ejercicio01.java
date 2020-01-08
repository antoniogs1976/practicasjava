package ejercicios2;

import java.util.Scanner;
import tema5.CosasVarias;

/**
 * Ejercicio01
 * 
 * Programa que lea un número entero por teclado y calcule si es par o impar.
 */
public class Ejercicio01 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        CosasVarias.limpiarPantalla();
        do{    
            CosasVarias.escribeLinea("------------------------------------------------------------");
            CosasVarias.escribeLinea("-                  P A R   O   I M P A R                   -");
            CosasVarias.escribeLinea("------------------------------------------------------------");
            CosasVarias.escribe("Introduce un número (-1 para salir): ");
            numero = entrada.nextInt();
            if (numero == 0){
                CosasVarias.escribeLinea("El número no es par ni impar, es cero (0).");
            } else if ((numero % 2) == 0){
                CosasVarias.escribeLinea("El número " + numero +" es par.");
            } else {
                CosasVarias.escribeLinea("El número " + numero +" es impar.");
            }
        } while (numero != -1);
        

        // cerrar scanner
        entrada.close();
    }

}