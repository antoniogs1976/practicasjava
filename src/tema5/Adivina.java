package tema5;

import java.util.Random;
import java.util.Scanner;

/**
 * Adivina
 * 
 */
public class Adivina {
    public static int aleatorio(int maximo){
        Random cosa = new Random();
        return cosa.nextInt(maximo)+1;
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    // ----- MAIN ------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero = 0, secreto, contador, opcion;
        boolean bucle = true;
        String tecla;

        while (bucle) {
            opcion = 0;
            contador = 0;
            secreto = aleatorio(100);
            do{
                escribeLinea("Selecciona Opción:\n1.- Jugar sin intentos\n2.- Jugar con 3 intentos máximo\n"+secreto);
                opcion = entrada.nextInt();
            }while (opcion != 1 && opcion !=2);
            switch (opcion) {
            //----- JUGAR SIN LÍMITE DE INTENTOS -------------------------------------------------
            case 1: // hacer las cosas del juego normal sin intentos.
                escribeLinea("Intenta adivinar el número");
                escribeLinea("introduce un número del 1 al 100: ");
                do {
                    numero = entrada.nextInt();
                    contador++;
                    if (numero == secreto) {
                        escribeLinea("¡¡¡Suerte!!! Has acertado");
                    } else if (numero > secreto) {
                        escribeLinea("(AYUDA: el número es menor al que has introducido)");
                    } else {
                        escribeLinea("(AYUDA: el número es mayor al que has introducido)");
                    }
                } while (numero != secreto);
                escribeLinea("Has utilizado " + contador + " intentos.");
                break;
            // ----- JUGAR CON 3 INTENTOS MÁXIMO ---------------------------------------------------
            case 2: // hacer las cosas con 3 intentos.
                escribeLinea("Intenta adivinar el número");
                escribeLinea("introduce un número del 1 al 100: ");
                do {
                    numero = entrada.nextInt();
                    contador++;
                    if (numero == secreto) {
                        escribeLinea("¡¡¡Suerte!!! Has acertado en " + contador + " intentos");
                    } else if (numero > secreto) {
                        escribeLinea("¡¡¡JAJAJA!!! Sige probando\n(AYUDA: el número es menor al que has introducido)\n(llevas " + contador + " intentos)");
                    } else {
                        escribeLinea("¡¡¡JAJAJA!!! Sige probando\n(AYUDA: el número es mayor al que has introducido)\n(llevas " + contador + " intentos)");
                    }
                } while ((numero != secreto) && (contador != 3));
                escribeLinea("El número era: " + secreto);
                break;
            }
            // ----- SEGUIR O SALIR -----------------------------------------------------------------
            do {
                escribe("¿Repetir el juego? (S/N): ");
                tecla = entrada.next();
                if ((tecla.equals("N") || (tecla.equals("n")))) {
                    bucle = false;
                } else if ((tecla.equals("S") || (tecla.equals("s")))) {
                    bucle = true;
                }
            } while (!tecla.equals("N") && !tecla.equals("n") && !tecla.equals("S") && !tecla.equals("s"));
        }
        // "matar" scanner
        entrada.close();
    }
}