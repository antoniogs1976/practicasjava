package ejercicios.tema5;

/**
 * Matematicas
 */
public class Matematicas {

    /**
     * 
     * @param numero número entero a calcular su factorial
     * @return número (double) con el resultado
     * 
     * Número más alto del que devuelve datos es de 170.
     */
    public static double factorial(int numero) {
        double retonno=1;
        for (int i=1;i<=numero;i++){
            retonno=retonno*i;
        }
        return retonno;
    }
}