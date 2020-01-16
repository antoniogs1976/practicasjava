package tema7;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] numerosDesordenados = { 2, 4, 6, 7, 5, 3, 9, 8, 1, 10 };
        // numerosOrdenados es una copia de numerosDesordenados
        // el método clone() copia del objeto al que se aplica
        int[] numerosOrdenados = numerosDesordenados.clone();
        System.out.println("El array de números desordenados");
        for (int numero : numerosDesordenados)
            System.out.print(numero + "\t");
        // el método sort(array-de-datos) de la clase Array ordena
        // ascendentemente todos los elementos de numerosOrdenados
        Arrays.sort(numerosOrdenados);
        System.out.println("\nEl array de números ordenados");
        for (int numero : numerosOrdenados)
            System.out.print(numero + "\t");
    }
}