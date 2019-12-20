package tema5;

import java.util.Random;

/**
 * UsaMatematicas2
 */
public class UsaMatematicas2 {
    public static int aleatorio(int numero) {
        Random xRandom = new Random();
        return xRandom.nextInt(numero) + 1;
    }

    public static void escribeln(String texto) {
        System.out.println(texto);
    }

    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void main(String[] args) {
        int[] notas = { 4, 9, 7, 5, 10 };
        int[] cosa = new int[aleatorio(20)];

        escribeln("================================================================================");
        escribeln("Vamos a calcular la media del array \"notas\"");
        escribeln("\"notas\" tiene estos valores:");
        for (int i = 0; i < notas.length; i++) {
            escribeln("" + notas[i]);
        }
        escribeln(Matematicas.maximoYminimo(notas));
        escribeln("Usando Matematicas.maximoYminimoenLista(notas): minimo=" + Matematicas.maximoYminimoenLista(notas)[0] + "; máximo=" + Matematicas.maximoYminimoenLista(notas)[1]);
        escribeln("El minimo es " + Matematicas.minimo(notas) + " (usando Matematicas.minimo(notas))");
        escribeln("El máximo es " + Matematicas.maximo(notas) + " (usando Matematicas.maximo(notas))");
        escribeln("Y la media de estos valores es: " + Matematicas.calcularMedia(notas));
        escribeln("--------------------------------------------------------------------------------");
        escribeln("El array \"cosa\" se crea de forma aleatoria.");
        escribeln("En esta ocasión, tiene un tamaño de " + cosa.length);
        escribeln("Vamos a rellenar de forma aleatoria, también, el array \"cosa\" con valores de 1 a 20.");
        for (int i = 0; i < cosa.length; i++) {
            cosa[i] = aleatorio(20);
        }
        escribeln("Los valores de \"cosa\" son:");
        for (int i = 0; i < cosa.length; i++) {
            escribeln("" + cosa[i]);
        }
        escribeln(Matematicas.maximoYminimo(cosa));
        escribeln("Usando Matematicas.maximoYminimoenLista(cosa): minimo=" + Matematicas.maximoYminimoenLista(cosa)[0]
                + "; máximo=" + Matematicas.maximoYminimoenLista(cosa)[1]);
        escribeln("El minimo es " + Matematicas.minimo(cosa) + " (usando Matematicas.minimo(cosa))");
        escribeln("El máximo es " + Matematicas.maximo(cosa) + " (usando Matematicas.maximo(cosa))");
        escribeln("La media de sus valores es de: " + Matematicas.calcularMedia(cosa));
    }
}