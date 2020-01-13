package tema7;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * ArrayMultiV2
 * 
 * Array multidimensionales
 */
public class ArrayMultiV2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[][] notas = {{5, 7, 9}, {4, 6, 5}};
        int [][] notas2 = new int[2][3];

        MisClases.escribeLinea("Array notas");
        UtilArray.escribirNotas(notas);
        // pedir las notas de todas las asignaturas y de todos alumnos
        MisClases.escribeLinea("Array notas2");
        //UtilArray.pedirNotas(notas2);
        // mostrar las notas2 (por asignatura y por alumno)
        UtilArray.escribirNotas(notas2);

        // cerrar scanner
        entrada.close();
    }

}