package tema5;

import java.util.Scanner;

/**
 * TablaMultiplicar
 * 
 * Escribir un número y escribir la tabla de multiplicar de ese número
 */
public class TablaMultiplicar {
    public static void limpiarPantalla() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero, i;
        String tecla = "";
        boolean bucle = true;
        while (bucle == true) {
            // limpiarPantalla();
            escribeLinea("*--------------------------------------------------------------------------------*");
            escribe("* Introduce un número para ver su tabla de multiplicar: ");
            numero = entrada.nextInt();
            // Bucle FOR
            escribeLinea("*** Con bucle FOR ***");
            for (i = 1; i <= 10; i++) {
                escribeLinea("- " + numero + "x" + i + "=" + (numero * i));
            }
            // Bucle WHILE
            escribeLinea("*** Con bucle WHILE ***");
            i = 1;
            while (i <= 10) {
                escribeLinea("- " + numero + "x" + i + "=" + (numero * i));
                i++;
            }
            // Bucle DO-WHILE
            i = 1;
            escribeLinea("*** Con bucle DO-WHILE ***");
            do {
                escribeLinea("- " + numero + "x" + i + "=" + (numero * i));
                i++;
            } while (i <= 10);

            escribeLinea("*--------------------------------------------------------------------------------*");
            escribe("-- ¿Desea ver la tabla de otro número? (S/N): ");
            tecla = entrada.next();
            if ((tecla.equals("N") || (tecla.equals("n")))) {
                bucle = false;
            } else {
                bucle = true;
            }
        }

        // "matar" el scanner
        entrada.close();
    }
}