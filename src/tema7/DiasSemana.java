package tema7;

import java.util.Scanner;
import static java.lang.System.out;

/**
 * DiaSemana
 * 
 * introduciendo un número (0 a 7) devolver el día de la semana que es. Usando
 * arrays
 */

public class DiasSemana {

    public static void escribeLinea(String texto) {
        out.println(texto);
    }

    public static void escribe(String texto) {
        out.print(texto);
    }

    public static void main(String[] args) {
        int numero;
        Scanner entrada = new Scanner(System.in);
        do {
            escribe("Introduce el número del día (0=domingo...6=sábado): ");
            numero = entrada.nextInt();
            // llamamos sin control de errores, que ya lo tiene el método
            //escribeLinea("Sin control de errores----------------------------------");
            escribeLinea(Utilidades.diaSemana(numero));
            //escribeLinea("Con control de errores----------------------------------");
            //if (numero < 0 || numero > 6) {
            //    escribeLinea("--> ** Error ** día no válido. Escribe otro");
            //} else {
            //    escribeLinea(Utilidades.diaSemana(numero));
            //}
        } while (numero < 0 || numero > 6);
        escribeLinea("---------------------------------------------------------------------");
        escribeLinea("Mostrar todos los datos del método:");
        for (int i=0; i <= 6; i++){
            escribeLinea(i+" corresponde a " + Utilidades.diaSemana(i));
        }
        // "matar" scanner
        entrada.close();
    }
}