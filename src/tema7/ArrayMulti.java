package tema7;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * ArrayMulti Array multidimensionales
 */
public class ArrayMulti {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[][] notas1 = {{5, 7, 9}, {4, 6, 5}};
        int[][] notas2 = new int[2][3];

        // recorrer el array notas2 y mostrarlo por pantalla
        // en filas y columnas
        final int ASIGNATURAS = 2;
        final int ALUMNOS = 3;
        // al recorrer un array el bucle debe ir
        // desde 0 hasta el TAMAÑO - 1
        MisClases.escribeLinea("Array notas");
        for(int asignatura = 0; asignatura < ASIGNATURAS; asignatura++) {
            MisClases.escribeLinea("asignatura-" + asignatura);
            for(int alumno = 0; alumno < ALUMNOS; alumno++) {
                MisClases.escribe(" alumno-" + alumno);
                // acceso al array notas2, mediante fila y columna
                MisClases.escribe(" --> " + notas1[asignatura][alumno] + "\t");
            }
            MisClases.escribeLinea(""); // cambio de línea 
        }
        // pedir las notas de todas las asignaturas y de todos alumnos
        MisClases.escribeLinea("Array notas2");
        for(int asignatura = 0; asignatura < ASIGNATURAS; asignatura++) {  
            for(int alumno = 0; alumno < ALUMNOS; alumno++) {
                MisClases.escribe("asignatura - " + asignatura);
                MisClases.escribe(" alumno - " + alumno + ": ");
                // pedir cada nota
                notas2[asignatura][alumno] = entrada.nextInt();
            }
            MisClases.escribeLinea(""); // cambio de línea 
        }

        // mostrar las notas2 (por asignatura y por alumno)
        MisClases.escribeLinea("Array notas2");
        for(int asignatura = 0; asignatura < ASIGNATURAS; asignatura++) {
            MisClases.escribe("asignatura-" + asignatura);
            for(int alumno = 0; alumno < ALUMNOS; alumno++) {
                MisClases.escribe(" alumno-" + alumno);
                // acceso al array notas2, mediante fila y columna
                MisClases.escribe(" --> " + notas2[asignatura][alumno] + "\t");
            }
            MisClases.escribeLinea(""); // cambio de línea 
        }
        // Cerrar scanner
        entrada.close();
    }

}