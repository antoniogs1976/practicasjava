package tema5;

/**
 * Matematicas
 */
public class Matematicas {

    /**
     * Método que devuelve el factorial de un número. Número más alto del que
     * devuelve datos es de 170, por el número tan inmenso que genera.
     * 
     * @param numero número entero a calcular su factorial
     * @return número (double) con el resultado
     * 
     */
    public static double calcularFactorial(int numero) {
        double retonno = 1;
        for (int i = 1; i <= numero; i++) {
            retonno = retonno * i;
        }
        return retonno;
    }

    /**
     * Método que devuelve la media de los valores almacenados en un array de
     * enteros de cualquier tamaño.
     * 
     * @param lista array de enteros del que se quiere calcular la media
     * @return double con la media
     */
    public static double calcularMedia(int[] lista) {
        double resultado = 0;
        for (int i = 0; i < lista.length; i++) {
            resultado = resultado + lista[i];
        }
        resultado = resultado / lista.length;
        return resultado;
    }

    /**
     * Método que devuelve el valor máximo dentro de un array de entros.
     * 
     * @param lista array con los valores
     * @return Integer con el valor máximo
     */
    public static int maximo(int[] lista) {
        int max = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] > max) {
                max = lista[i];
            }
        }
        return max;
    }

    /**
     * Método que devuelve el valor minimo dentro de un array de enteros.
     * 
     * @param lista array con los valores
     * @return Integer con el valor minimo
     */
    public static int minimo(int[] lista) {
        int min = lista[0];
        for (int i = 1; i < lista.length; i++) {
            if (lista[i] < min) {
                min = lista[i];
            }
        }
        return min;
    }

    /**
     * Método que devuelve los valores máximo y minimo dentro de un array de enteros
     * 
     * @param lista Array de entros con los valores a averiguar el máximo y el
     *              minimo
     * @return String con los valores ya formateados.
     */
    public static String maximoYminimo(int[] lista) {
        int max = maximo(lista);
        int min = minimo(lista);
        String cadena = "El minimo es " + min + " y el máximo es " + max;
        return cadena;
    }

    /**
     * Método que calcula los valores máximo y minimo de un array de enteros, y
     * devuelve un array de 2 elementos con el valor (minimo) y el (máximo)
     * 
     * @param lista Array de entros con los valores a averiguar el máximo y el
     *              minimo.
     * @return Array con los valores [0]minimo y [1]máximo
     */
    public static int[] maximoYminimoenLista(int[] lista) {
        int max = maximo(lista);
        int min = minimo(lista);
        int[] resultado = { min, max };
        return resultado;
    }
}