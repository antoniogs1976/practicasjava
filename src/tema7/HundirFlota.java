package tema7;

import java.util.Scanner;
import miscosas.MisClases;
import java.util.Random;

/**
 * HundirFlota
 */
public class HundirFlota {

    public static boolean[][] crearTablero(Scanner leer) {
        int filas, columnas;

        MisClases.escribeLinea("Configurar el tablero de juego");
        MisClases.escribe("Introduce la cantidad de filas: ");
        filas = leer.nextInt();
        MisClases.escribe("Introduce la cantidad de columnas: ");
        columnas = leer.nextInt();
        // Crear el array y devolverlo
        boolean[][] retorno = new boolean[filas][columnas];
        // Llenarlo de false
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                retorno[i][j] = false;
            }
        }

        return retorno;
    } // fin crearTablero

    /************************************************************/
    public static boolean[][] ubicarBarco(boolean[][] tablerillo) {
        boolean[][] retorno = tablerillo;
        Random alea = new Random();
        // Seleccionar fila y columna
        retorno[alea.nextInt(retorno.length)][alea.nextInt(retorno[0].length)] = true;
        return retorno;
    } // fin ubicarBarco

    public static boolean coordinadasDisparo(boolean[][] tablero, boolean[][] tableroDescartes, Scanner leer) {
        boolean retorno;
        int x, y;
        MisClases.escribeLinea("Teclea las coordenadas para dispara el misil:");
        MisClases.escribe("Fila (0 a " + (tablero.length - 1) + "): ");
        x = leer.nextInt();
        MisClases.escribe("Columna (0 a " + (tablero[0].length - 1) + "): ");
        y = leer.nextInt();
        if (tablero[x][y] == true) {
            MisClases.escribeLinea("Barco enemigo destruido");
            retorno = false;
        } else {
            MisClases.escribeLinea("¡Agua!");
            retorno = true;
        }
        return retorno;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean[][] tablero = crearTablero(entrada);
        boolean[][] tablero2 = tablero.clone();
        boolean juego = true;
        // ubicar el barco enemigo
        tablero = ubicarBarco(tablero);

        // ver el tablero
        MisClases.escribeLinea("Tablero:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                MisClases.escribe("" + tablero[i][j] + "\t");
            }
            MisClases.escribeLinea("");
        }

        while (juego) {
            juego = coordinadasDisparo(tablero, tablero2, entrada);
        }
        entrada.close();
    }
}