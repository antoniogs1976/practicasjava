package tema5;

import java.util.Scanner;

/**
 * UsaMatematicas
 */
public class UsaMatematicas {

    public static void limpiarPantalla() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
        System.out.flush();
    }

    public static void escribe(String texto) {
        System.out.print(texto);
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        double resultado;
        boolean bucle = true;
        String tecla;
        while (bucle == true) {
            numero = 0;
            escribeLinea("============================================================");
            escribe("Introduce un número para calcular su factorial: ");
            numero = entrada.nextInt();
            // usamos el factorial
            resultado = Matematicas.calcularFactorial(numero);
            escribeLinea("- El factorial de " + numero + " es: " + resultado);
            escribeLinea("------------------------------------------------------------");
            do {
                escribe("¿Repetir la operación? (S/N): ");
                tecla = entrada.next();
                if ((tecla.equals("N") || (tecla.equals("n")))) {
                    bucle = false;
                } else if ((tecla.equals("S") || (tecla.equals("s")))) {
                    bucle = true;
                }
            } while (!tecla.equals("N") && !tecla.equals("n") && !tecla.equals("S") && !tecla.equals("s"));
        }

        // matar Scanner
        entrada.close();
    }
}