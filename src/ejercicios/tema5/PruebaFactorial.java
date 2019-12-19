package ejercicios.tema5;

import java.util.Scanner;

/**
 * Factorial
 */
public class PruebaFactorial {

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero, i, factorial;
        String tecla = "";
        boolean bucle = true;
        while (bucle == true) {
            factorial = 1;
            tecla = "";
            escribeLinea("*--------------------------------------------------------------------------------*");
            escribe("- Introduce un número para calcular su factorial: ");
            numero = entrada.nextInt();

            // hacer cosas
            for (i = 1; i <= numero; i++) {
                factorial = factorial * i;
            }
            escribeLinea("El resultado es: " + factorial);

            escribeLinea("*--------------------------------------------------------------------------------*");
            escribe("-- ¿Desea repetir con otro número? (S/N): ");
            tecla = entrada.next();
            if ((tecla.equals("N")) || (tecla.equals("n"))) {
                bucle = false;
            } else {
                bucle = true;
            }
        }

        // "matar" el scanner
        entrada.close();
    }
}