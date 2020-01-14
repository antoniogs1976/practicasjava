package tema7;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * UtilArray
 */
public class UtilArray {

    public static void escribirNotas(int[][] dato) {
        for (int i = 0; i < dato.length; i++) {
            MisClases.escribeLinea("Asignatura - " + i);
            MisClases.escribeLinea("===============");
            for (int j = 0; j < dato[i].length; j++) {
                MisClases.escribe("Alumno-" + j + " --> " + dato[i][j] + "\t");
            }
            MisClases.escribeLinea(""); // cambio de línea
        }
    }

    public static int[][] pedirNotas(int x, int y, Scanner leer) {
        int[][] retorno = new int[x][y];

        MisClases.escribeLinea("-----------------------------------------------------------"); // cambio de línea
        MisClases.escribeLinea("Introduce las notas de los alumnos en las asignaturas:");
        for (int i = 0; i < retorno.length; i++) {
            for (int j = 0; j < retorno[i].length; j++) {
                MisClases.escribe("Asignatura - " + i + " || Alumno - " + j + ": ");
                retorno[i][j] = leer.nextInt();
            }
            MisClases.escribeLinea(""); // cambio de línea
        }
        return retorno;
    }

    public static void pedirNotas2(int[][] dato, Scanner leer) {
        MisClases.escribeLinea("Introduce las notas de los alumnos en las asignaturas:");
        for (int i = 0; i < dato.length; i++) {
            for (int j = 0; j < dato[i].length; j++) {
                MisClases.escribe("Asignatura - " + i + " || Alumno - " + j + ": ");
                dato[i][j] = leer.nextInt();
            }
            MisClases.escribeLinea("--------------------------------------------------"); // cambio de línea
        }
    }
}