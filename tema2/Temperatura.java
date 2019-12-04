package tema2;

/**
 * Temperatura
 */
public class Temperatura {

    public static void main(String[] args) {
        double centigrados, fahrenheit;
        int temperatura;

        fahrenheit = 81;
        centigrados = ((fahrenheit - 32.0) * 5.0) / 9.0;
        /*
            Si asignamos directmente sin convertir (temperatura = centigrados) da error:
            Type mismatch: cannot convert from double to int
            por eso se pone (int) delante de centigrados.
            Convertir de INT a DOUBLE no da error.
        */
        temperatura = (int)centigrados;
        System.out.print("\033\143");
        System.out.println("********************************************************************************");
        System.out.println("Grados Fharenheit: " + fahrenheit);
        System.out.println("Grados Centígrados: " + centigrados);
        // Si todos los valores son enteros, la división da un resultado entero
        System.out.println("3/2: " + (3/2));
        // Si alguno de los valores es "real", la división da un resultado real
        System.out.println("3.0/2: " + (3.0/2));
        System.out.println("fahrenheit/2: " + (fahrenheit/2));
        System.out.println("temperatura = (int)centigrados = " + temperatura);
        System.out.println("********************************************************************************");
    }
}