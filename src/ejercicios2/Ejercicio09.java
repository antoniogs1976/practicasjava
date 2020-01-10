package ejercicios2;

import miscosas.MisClases;

/**
 * Ejercicio09
 * 
 * Programa que crea un array de 20 elementos llamado Pares y guarde los 20
 * primeros números pares. Mostrar por pantalla el contenido del array creado.
 * 
 */
public class Ejercicio09 {

    public static void main(String[] args) {
        int[] pares = new int[20];
        int i;

        MisClases.limpiarPantalla();
        MisClases.escribeLinea("---------------------------------------------------------------------------");
        MisClases.escribeLinea("-                 Array con los 20 primeros números pares                 -");
        MisClases.escribeLinea("---------------------------------------------------------------------------");
        for (i = 0; i < pares.length; i++) {
            pares[i] = (i + 1) * 2;
        }
        for (i = 0; i < pares.length; i++) {
            if (i != pares.length - 1) {
                MisClases.escribe(pares[i] + ", ");
            } else {
                MisClases.escribeLinea(pares[i] + ".\n");
            }
        }
    }
}