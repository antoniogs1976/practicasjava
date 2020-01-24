package miscosas;

import java.io.IOException;

/**
 * Utilidades
 */
public class Utilidades {

    /**
     * Método para escribir una línea sin tener que escribir todo el churro del
     * System.out.println();
     * 
     * @param texto Texto a mostrar
     */
    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    /**
     * Método para escribir sin tener que escribir todo el curro del
     * System.out.print();
     * 
     * @param texto Texto a mostrar
     */
    public static void escribe(String texto) {
        System.out.print(texto);
    }

    /**
     * Método para limpar la consola
     */
    public static void limpiarPantalla() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

}