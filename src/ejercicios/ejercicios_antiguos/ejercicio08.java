package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio08
 * 
 * aplicar un descuento del 15% cuando el mes sea octubre.
 * 
 */
public class ejercicio08 {

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double importe, descuento, total;
        int mes;
        String tecla;
        boolean bucle = true;
        while (bucle == true) {
            // inicializar las variables
            importe = 0;
            descuento = 0;
            total = 0;
            mes = 0;
            escribeLinea("************************************************************");
            escribeLinea("*                 DESCUENTOS Y PROMOCIONES                 *");
            escribeLinea("************************************************************\n");
            escribe("- Introduce el número del mes en curso: ");
            mes = entrada.nextInt();
            escribe("- Importe a cobrar: ");
            importe = entrada.nextDouble();
            if (mes == 10) {
                // si el mes es octubre, hacer el descuento
                escribeLinea("\n*****         PROMOCIÓN OCTUBRE 15% DESCUENTO          *****\n");
                descuento = (15 * importe) / 100;
            } else {
                // Si no es octubre, cobrar normalmente
                escribeLinea("\n************************************************************\n");
                descuento = 0;
            }
            total = importe - descuento;
            escribeLinea("Importe a cobrar: " + total);
            escribeLinea("Importe del descuento: " + descuento);
            escribeLinea("\n************************************************************");
            escribeLinea("*       ¿Desea repetir la operación con otro número?       *");
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
          // "matar" scanner
        entrada.close();
    }
}