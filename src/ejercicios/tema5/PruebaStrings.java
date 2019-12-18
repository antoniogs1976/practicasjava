package ejercicios.tema5;

/**
 * PruebaStrings
 */
public class PruebaStrings {

    public static void main(String[] args) {
        String cosa1 = new String("Cosa");
        String cosa2 = new String("Cosa");
        String cosa3;

        // cosa1 y cosa2 son dos objetos diferentes así que son distintos
        if (cosa1 == cosa2){
            System.out.println("Ambas refencias a objeto son iguales");
        } else {
            System.out.println("Ambas referencias a objeto son diferentes");
        }
        // ahora vamos a "igualar" cosa3 a cosa1
        cosa3 = cosa1;
        // comprobamos si cosa3 y cosa1 son iguales
        if (cosa3 == cosa1) {
            System.out.println("Ambas refencias son iguales");
        } else {
            System.out.println("Ambas referencias son diferentes");
        }
    }
}