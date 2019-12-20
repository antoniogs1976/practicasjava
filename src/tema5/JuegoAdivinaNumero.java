package tema5;

import java.util.Random;

/**
 * Adivina2
 * 
 * clase con todas las opciones del juego
 */
public class JuegoAdivinaNumero {
    
    // Atributos
    private static int numeroIntentos;  // por defecto, 3
    private static int numeroSecreto;
    private static int numeroMaximo;    // Para limitar el máximo a encontrar

    // Constantes
    private static final String msgMayor = " el número es mayor";
    private static final String msgMenor = " el número es menor";

    public static int getNumeroIntentos() {
        return numeroIntentos;
    }

    public static void setNumeroIntentos(int numeroIntentos) {
        JuegoAdivinaNumero.numeroIntentos = numeroIntentos;
    }

    public static int getNumeroSecreto() {
        return numeroSecreto;
    }

    public static void setNumeroSecreto(int numeroSecreto) {
        JuegoAdivinaNumero.numeroSecreto = numeroSecreto;
    }

    public static int getNumeroMaximo() {
        return numeroMaximo;
    }

    public static void setNumeroMaximo(int numeroMaximo) {
        JuegoAdivinaNumero.numeroMaximo = numeroMaximo;
    }

    // ----- MÉTODOS VARIOS ----------------------------------------
    /**
     * Método que devuleve un número aleatorio
     * @param maximo número máximo a devolver (no inclusivo)
     * @return número aleatorio generado
     */
    public static int aleatorio(int maximo){
        Random numero = new Random();
        return numero.nextInt(maximo)+1;
    }

    /**
     * Método que devuelve un mensaje de ayuda para el usuario y saber
     * por donde va (si el número es mayor o menor)
     * @param numero Número tecleado por el usuario
     * @param secreto Núemro secreto a adivinar
     * @return Mensaje de ayuda
     */
    public static String mensaje(int numero, int secreto){
        if (numero > secreto){
            return numero+msgMayor;
        } else {
            return numero+msgMenor;
        }
    }

    

}