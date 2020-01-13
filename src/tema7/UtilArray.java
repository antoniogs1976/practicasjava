package tema7;

import miscosas.MisClases;

/**
 * UtilArray
 */
public class UtilArray {
    final static int ASIGNATURAS = 2;
    final static int ALUMNOS = 3;
    public static void escribirNotas(int[][] dato) {
        for(int asignatura = 0; asignatura < ASIGNATURAS; asignatura++) {
            MisClases.escribe("asignatura-" + asignatura);
            for(int alumno = 0; alumno < ALUMNOS; alumno++) {
                MisClases.escribe(" alumno-" + alumno);
                // acceso al array notas2, mediante fila y columna
                MisClases.escribe("-->" + dato[asignatura][alumno]);
            }
            MisClases.escribeLinea(""); // cambio de línea 
        }
    }
}