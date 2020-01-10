package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * Ejercicio04
 * 
 * Programa que lea por teclado tres números enteros H, M, S correspondientes a
 * hora, minutos y segundos respectivamente, y comprueba si la hora que indican
 * es una hora válida.
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int HH, MM, SS;
        boolean bucle = true;
        char siOno;

        while (bucle) {
            MisClases.limpiarPantalla();
            MisClases.escribeLinea("------------------------------------------------------------");
            MisClases.escribeLinea("-             Horas, Minutos y Segundos válidos            -");
            MisClases.escribeLinea("------------------------------------------------------------");
            MisClases.escribe("Introduce las horas (HH): ");
            HH = entrada.nextInt();
            MisClases.escribe("Introduce los minutos (MM): ");
            MM = entrada.nextInt();
            MisClases.escribe("Introduce los segundos (SS): ");
            SS = entrada.nextInt();
            // Comprobar que los datos son válidos
            // HH debe tener un valor entre 0 y 23
            // MM y SS debe tener un valor entre 0 y 59
            if ((HH >= 0 && HH <= 23) && (MM >= 0 && MM <= 59) && (SS >= 0 && SS <= 59)) {
                MisClases.escribeLinea("La hora " + HH + ":" + MM + ":" + SS + " es válida.");
            } else {
                MisClases.escribeLinea("La hora " + HH + ":" + MM + ":" + SS + " no es válida.");
            }
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