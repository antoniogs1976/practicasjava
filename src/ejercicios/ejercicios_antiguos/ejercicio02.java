package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio02
 * 
 * Dados dos números, intercambiar su valor con una variable extra
 */
public class ejercicio02 {

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2, extra;
        String tecla;
        boolean bucle = true;
        while (bucle == true) {
            escribeLinea("************************************************************");
            escribeLinea("*            INTERCAMBIO DE VALOR DE VARIABLES             *");
            escribeLinea("************************************************************");
            escribe("- Introduce un valor para num1: ");
            num1 = entrada.nextInt();
            escribe("- Introduce un valor para num2: ");
            num2 = entrada.nextInt();
            escribeLinea("************************************************************");
            escribeLinea("- El valor de num1 es "+num1+" y de num2 es "+num2);
            escribeLinea("\n----------       INTERCAMBIAMOS LOS VALORES       ----------\n");
            extra=num1;
            num1=num2;
            num2=extra;
            escribeLinea("- Ahora, num1 tiene le valor "+num1+" y num2 "+num2);
            escribeLinea("************************************************************");
            escribeLinea("*      ¿Desea repetir la operación con otros números?      *");
            escribeLinea("************************************************************");
            escribeLinea("*                  (pulsa S o N y Enter)                   *");
            escribeLinea("************************************************************");
            tecla = entrada.next();
            if (tecla.equals("N") || (tecla.equals("n"))){
                bucle = false;
            } else {
                bucle = true;
            }

        }// fin del bucle principal
        // "matar" scanner
        entrada.close();
    }

}