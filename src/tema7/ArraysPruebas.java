package tema7;

import java.util.Random;

/**
 * ArraysPruebas
 */
public class ArraysPruebas {

    public static void main(String[] args) {
        Random cosa = new Random();
        int[] notas = new int[(cosa.nextInt(100) + 1)]; // creación de un objeto array
        int[] notas2 = { 8, 18, 7, 43, 54, 65, 76, 77, 8, 109 }; // Creación de un array asignadole valores
        int i;

        for (i = 0; i < notas.length; i++) {
            notas[i] = notas.length - i;
        }

        System.out.println("====================================================");
        for (i = 0; i < notas2.length; i++) {
            System.out.println("La posición " + i + " de \"notas2\" tiene un valor de " + notas2[i]);
        }
        System.out.println("----------------------------------------------------");

        System.out.println("El tamaño del array \"notas\" es de " + notas.length);
        System.out.println("(las posiciones van de 0 hasta " + (notas.length - 1) + ")");
        System.out.println("----------------------------------------------------");
        System.out.println("Operaciones varias con array \"notas\"");

        for (i = 0; i < notas.length; i++) {
            if (i < 10) {
                System.out.println("La posición 0" + i + " tiene un valor de: " + notas[i]);
            } else {
                System.out.println("La posición " + i + " tiene un valor de: " + notas[i]);
            }
        }
        notas[2] = -1;
        System.out.println(notas[2]);
        if (notas.equals(notas2)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

        System.out.println("Puntero de notas: " + notas);
        System.out.println("Puntero de notas2: " + notas2);
        i = 0;
        for (int j : notas2) {
            System.out.println("valor de notas2[" + i + "] con un foreach - " + j);
            i++;
        }
    }
}