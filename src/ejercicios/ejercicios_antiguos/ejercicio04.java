package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio04
 * 
 * dados 3 números, averiguar cual es mayor, cual es menor o si los tres son
 * iguales
 */
public class ejercicio04 {
    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2, num3;
        String tecla;
        boolean bucle = true;
        while (bucle == true) {
            escribeLinea("************************************************************");
            escribeLinea("*             MAYOR - MENOR - IGUAL - 3 NÚMEROS            *");
            escribeLinea("************************************************************");
            escribe("- Introduce un valor para num1: ");
            num1 = entrada.nextInt();
            escribe("- Introduce un valor para num2: ");
            num2 = entrada.nextInt();
            escribe("- Introduce un valor para num3: ");
            num3 = entrada.nextInt();
            escribeLinea("\n************************************************************\n");
            if ((num1 > num2) && (num1 > num3)) {
                escribeLinea("- num1 (" + num1 + ") es mayor que num2 (" + num2 + ") y que num3 ("+num3+")\n");
            } else if ((num2 > num1) && (num2 > num3)) {
                escribeLinea("- num2 (" + num2 + ") es mayor que num1 (" + num1 + ") y que num3 ("+num3+")\n");
            } else if ((num3 > num1) && (num3 > num2)) {
                escribeLinea("- num3 (" + num3 + ") es mayor que num1 (" + num1 + ") y que num2 ("+num2+")\n");
            } else {
                escribeLinea("- num1 (" + num1 + ") es igual a num2 (" + num2 + ") y a num3 ("+num3+")\n");
            }
            escribeLinea("************************************************************");
            escribeLinea("*      ¿Desea repetir la operación con otros números?      *");
            escribeLinea("************************************************************");
            escribeLinea("*                  (pulsa S o N y Enter)                   *");
            escribeLinea("************************************************************");
            tecla = entrada.next();
            if (tecla.equals("N") || (tecla.equals("n"))) {
                bucle = false;
            } else {
                bucle = true;
            }
        } // While principal
        entrada.close();

    } // Main

}