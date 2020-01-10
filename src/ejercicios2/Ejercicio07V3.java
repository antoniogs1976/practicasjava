package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

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
        String tipo1 = "", tipo2 = "";

        MisClases.limpiarPantalla();
        MisClases.escribeLinea("------------------------------------------------------------");
        MisClases.escribeLinea("-                Identificación de Números                 -");
        MisClases.escribeLinea("------------------------------------------------------------");
        do {
            MisClases.escribe("Introduce un número: ");
            numero = entrada.nextInt();    
            
            // Comprobamos si es cero o no
            if (numero == 0) {
                MisClases.escribeLinea("El número es cero.");
            } else {
                // Comprobar si es par o impar
                if (numero % 2 == 0) {
                    tipo1 = "par ";
                } else {
                    tipo1 = "impar ";
                }
                // Comprobar si es positivo o negativo
                if (numero < 0) {
                    tipo2 = "y negativo.";
                } else {
                    tipo2 = "y positivo.";
                }
                // Mostramos el resultado
                MisClases.escribeLinea("El número " + numero + " es " + tipo1 + tipo2);
            }
            // preguntar si se sigue o no se sigue
            do {
                MisClases.escribe("¿Desea introducir más números? (S/N): ");
                siOno = entrada.next().charAt(0);
                if (siOno == 'n' || siOno == 'N') {
                    bucle = false;
                } else if (siOno == 's' || siOno == 'S') {
                    bucle = true;
                }
            } while (siOno != 'n' && siOno != 'N' && siOno != 's' && siOno != 'S');

        } while (bucle != false);
        MisClases.escribeLinea("bye!");
        entrada.close();
    }
}