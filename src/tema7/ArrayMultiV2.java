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
        int numAsignaturas, numAlumnos;
        int[][] notas1 = { { 5, 7, 9 }, { 4, 6, 5 } };
        int[][] notas2 = new int[2][3];
        int[][] notas3 = new int[3][5];

        // Notas 1
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("----------             Array notas1              ----------");
        MisClases.escribeLinea(
                "         notas1.length = " + notas1.length + " || notas1[0].length = " + notas1[0].length);
        UtilArray.escribirNotas(notas1);
        // Notas 2
        MisClases.escribeLinea("");
        MisClases.escribeLinea("----------             Array notas2              ----------");
        MisClases.escribeLinea(
                "         notas2.length = " + notas2.length + " || notas2[0].length = " + notas2[0].length);
        MisClases.escribeLinea("- Introducir las notas de los alumnos según la asignatura -");
        notas2 = UtilArray.pedirNotas(notas2.length, notas2[0].length, entrada);
        // mostrar las notas2
        MisClases.escribeLinea("");
        MisClases.escribeLinea("-   Mostrar las notas de los alumnos según la asignatura  -");
        UtilArray.escribirNotas(notas2);
        // Notas 3
        MisClases.escribeLinea("");
        MisClases.escribeLinea("----------             Array notas3              ----------");
        MisClases.escribeLinea(
                "         notas3.length = " + notas3.length + " || notas3[0].length = " + notas3[0].length);
        MisClases.escribeLinea("- Introducir las notas de los alumnos según la asignatura -");
        notas3 = UtilArray.pedirNotas(notas3.length, notas3[0].length, entrada);
        // mostrar las notas3
        MisClases.escribeLinea("");
        MisClases.escribeLinea("-   Mostrar las notas de los alumnos según la asignatura  -");
        UtilArray.escribirNotas(notas3);
        // Notas 4
        MisClases.escribeLinea("");
        MisClases.escribeLinea("----------             Array notas4              ----------");
        MisClases.escribe("Por favor, introduce el número de Asignaturas: ");
        numAsignaturas = entrada.nextInt();
        MisClases.escribe("Por favor, introduce el número de Alumnos: ");
        numAlumnos = entrada.nextInt();
        // Crear el array notas4
        int[][] notas4 = new int[numAsignaturas][numAlumnos];
        MisClases.escribeLinea(
                "         notas4.length = " + notas4.length + " || notas4[0].length = " + notas4[0].length);
        MisClases.escribeLinea("- Introducir las notas de los alumnos según la asignatura -");
        // Se puede declarar así (que a mi me parece mejor opción)
        notas4 = UtilArray.pedirNotas(notas4.length, notas4[0].length, entrada);
        // O se puede declarar así también
        // notas4 = UtilArray.pedirNotas(numAsignaturas, numAlumnos);
        // mostrar las notas4
        MisClases.escribeLinea("");
        MisClases.escribeLinea("-   Mostrar las notas de los alumnos según la asignatura  -");
        UtilArray.escribirNotas(notas4);
        // Cerrar scanner
        entrada.close();
    }

}