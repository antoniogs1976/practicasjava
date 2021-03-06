package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * Ejercicio05
 * 
 * Programa que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30 días, de 31 o de 28. Supondremos que febrero tiene 28 días. Se
 * mostrará además el nombre del mes. Se debe comprobar que el valor introducido
 * esté comprendido entre 1 y 12.
 * 
 */
public class Ejercicio05 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
                "octubre", "noviembre", "diciembre" };
        String dias = "";
        int mes;
        boolean bucle = true;
        char siOno;

        while (bucle) {
            MisClases.limpiarPantalla();
            MisClases.escribeLinea("------------------------------------------------------------");
            MisClases.escribeLinea("-                ¿Cuántos días tiene el mes?               -");
            MisClases.escribeLinea("------------------------------------------------------------");
            do {
                MisClases.escribe("Introduce el número de mes (1-12): ");
                mes = entrada.nextInt();
                if (mes < 1 || mes > 12) {
                    MisClases.escribeLinea("El número de mes introducido (" + mes + ") no es válido.");
                }
            } while (mes < 1 || mes > 12);
            // comprobar mes para asignar días
            // febrero va fijo
            if (mes == 2) {
                dias = "28";
            } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                dias = "31";
            } else {
                dias = "30";
            }
            // mostramos los datos
            MisClases.escribeLinea("El mes " + mes + " corresponde a " + meses[mes - 1] + " y tiene " + dias + " días.");

            // Preguntar si se continúa o no
            do {
                MisClases.escribe("¿Desea repetir la operación? (S/N): ");
                siOno = entrada.next().charAt(0);
                if (siOno == 'n' || siOno == 'N') {
                    bucle = false;
                } else if (siOno == 's' || siOno == 'S') {
                    bucle = true;
                }
            } while (siOno == 's' && siOno == 'S' && siOno == 'n' && siOno == 'N');
        }
        // cerrar scanner
        entrada.close();
        MisClases.escribeLinea("bye!");
    }
}