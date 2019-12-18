package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio01
 * 
 * dados 2 números, calcular su suma, resta, multiplicación y división.
 */
public class ejercicio01 {
    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double num1, num2, suma, resta, producto, cociente, resto;
        String tecla;
        boolean bucle = true, error = false;

        while (bucle == true) {
            error = false;
            escribeLinea("************************************************************");
            escribe("Introduce un valor para num1: ");
            num1 = entrada.nextInt();
            escribe("Introduce un valor para num2: ");
            num2 = entrada.nextInt();
            escribeLinea("************************************************************");
            escribeLinea("**                   R E S U L T A D O S                  **");
            escribeLinea("************************************************************");
            // Operaciones
            suma = num1 + num2;
            resta = num1 - num2;
            producto = num1 * num2;
            // División:
            if (num2 == 0) {
                cociente = 0;
                resto = 0;
                error = true;
            } else {
                cociente = num1 / num2;
                resto = num1 % num2;
            }
            // Escribimos las cosas
            escribeLinea("- Suma de " + num1 + " y de " + num2 + " = " + suma);
            escribeLinea("- Resta de " + num1 + " y de " + num2 + " = " + resta);
            escribeLinea("- Producto de " + num1 + " y de " + num2 + " = " + producto);
            escribeLinea("- División:");
            if (error == true) {
                escribeLinea("---- ERROR: División entre cero.");
            } else {
                escribeLinea("---- Cociente de " + num1 + " y de " + num2 + " = " + cociente);
                escribeLinea("---- Resto de " + num1 + " y de " + num2 + " = " + resto);
            }
            escribeLinea("************************************************************");
            escribeLinea("**    ¿Deseas repetir la operación con otros números?     **");
            escribeLinea("************************************************************");
            escribeLinea("**                  (pulsa S o N y ENTER)                 **");
            escribeLinea("************************************************************");
            tecla = entrada.next();
            if (tecla.equals("N") || tecla.equals("n")) {
                bucle = false;
            } else {
                bucle = true;
            }
        }
        // "matar" el scanner
        entrada.close();
    }

}
