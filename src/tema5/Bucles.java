package tema5;

import java.util.Scanner;

/**
 * Bucles
 */
public class Bucles {

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void limpiarPantalla() {
        System.out.print("\033\143");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero, multiplicador, i, opcion;
        String tecla;
        boolean bucle = true;
        while (bucle) {
            //limpiarPantalla();
            escribeLinea("*--------------------------------------------------------------------------------*");
            escribe("¿De qué nuero quieres ver su tabla de multiplicar?: ");
            numero = entrada.nextInt();
            escribe("¿Hasta qué número quieres ver su tabla?: ");
            multiplicador = entrada.nextInt();
            escribeLinea("¿Qué tipo de bucle quieres usar?");
            escribe("1.- Bucle FOR || 2.- Bucle WHILE || 3.- Bucle DO-WHILE: ");
            opcion = entrada.nextInt();
            escribeLinea("*--------------------------------------------------------------------------------*");
            switch (opcion){
                case 1:
                    for (i = 1; i <= multiplicador; i++) {
                        escribeLinea(numero + "x" + i + "=" + (numero * i));
                    }
                    break;
                case 2:
                    i=1;
                    while (i <= multiplicador){
                        escribeLinea(numero + "x" + i + "=" + (numero * i));
                        i++;
                    }
                    break;
                case 3:
                    i = 1;
                    do{
                        escribeLinea(numero + "x" + i + "=" + (numero * i));
                        i++;
                    } while (i <= multiplicador);

            } // fin del switch
            escribeLinea("*--------------------------------------------------------------------------------*");
            escribe("¿Deseas repetir con otros valores? (S/N): ");
            tecla = entrada.next();
            if ((tecla.equals("N") || (tecla.equals("n")))) {
                bucle = false;
            } else {
                bucle = true;
            }
        } // fin del bucle general

        // "Matar" el scanner
        entrada.close();
    }

}