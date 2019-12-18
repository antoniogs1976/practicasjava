package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio07
 * 
 * dado el número de niñas y de niños, mostrar el porcentaje de ambos
 */
public class ejercicio07 {

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double ninos, ninas, total, pninos, pninas;
        String tecla;
        boolean bucle = true;
        while (bucle == true) {
            escribeLinea("************************************************************");
            escribeLinea("*              PORCENTAJE DE NIÑOS Y DE NIÑAS              *");
            escribeLinea("************************************************************\n");
            escribe("- Introduce el número de niños que hay: ");
            ninos = entrada.nextInt();
            escribe("- Introduce el número de niñas que hay: ");
            ninas = entrada.nextInt();
            // cálculos
            total = ninos + ninas;
            pninos = (ninos * 100) / total;
            pninas = (ninas * 100) / total;
            escribeLinea("\n************************************************************\n");
            escribeLinea("- El total de alumnos es de: " + total);
            escribeLinea("- El porcentaje de niños es de: " + pninos);
            escribeLinea("- El porcentaje de niñas es de: " + pninas);
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
        }

        // "matar" scanner
        entrada.close();
    }

}