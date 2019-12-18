package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio05
 * 
 * Dados 3 números, mostrar su suma si el numero 1 es menor de 0 o su producto
 * si es mayor de 0
 * 
 */
public class ejercicio05 {
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
            escribeLinea("*                      SUMA O PRODUCTO                     *");
            escribeLinea("************************************************************");
            escribe("- Introduce un valor para num1: ");
            num1 = entrada.nextInt();
            escribe("- Introduce un valor para num2: ");
            num2 = entrada.nextInt();
            escribe("- Introduce un valor para num3: ");
            num3 = entrada.nextInt();
            escribeLinea("\n************************************************************\n");
            if (num1 < 0) {
                escribeLinea("- Como num1 es inferior a 0 (" + num1 + "), mostramos la suma:");
                escribeLinea("-- Suma = " + (num1 + num2 + num3));
            } else {
                escribeLinea("- Como num1 es superior a 0 (" + num1 + "), mostramos el producto:");
                escribeLinea("-- Producto = " + (num1 * num2 * num3) + "\n");
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
        } // while
        entrada.close();
    }
}