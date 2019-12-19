package ejercicios.tema5;

import java.util.Scanner;

/**
 * PedirDatosUsuario
 */
public class PedirDatosUsuario {

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void limpiarPantalla() {
        //System.out.print("\033[H\033[2J");
        System.out.print("\u001b[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        // Scanner
        Scanner entrada = new Scanner(System.in);
        int hora;
        String saludo1 = "Buenos días";
        String saludo2 = "Buenas tardes";
        String saludo3 = "Buenas noches";
        boolean bucle = true;
        String tecla = "";
        while (bucle == true) {
            limpiarPantalla();
            escribeLinea("*------------------------------------------------------------*");
            escribe("Por favor, introduce una hora (0-23): ");
            hora = entrada.nextInt();
            escribeLinea("*------------------------------------------------------------*");
            if ((hora >= 0) && (hora < 24)) {
                if ((hora >= 8) && (hora < 14)) {
                    escribeLinea(saludo1);
                } else if ((hora >= 14) && (hora <= 20)) {
                    escribeLinea(saludo2);
                } else {
                    escribeLinea(saludo3);
                }
            } else {
                escribeLinea("Error: hora no válida.");
            }
            escribeLinea("*------------------------------------------------------------*");
            escribe("Pulsa S para salir, C para continuar: ");
            tecla = entrada.next();
            if (tecla == "S" || tecla == "s")
                bucle = false;
            else
                bucle = true;
        }

        // "matar" el scanner al final de todo
        entrada.close();
    }
}