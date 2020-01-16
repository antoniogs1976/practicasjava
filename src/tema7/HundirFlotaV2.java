package tema7;

import java.util.Scanner;
import miscosas.MisClases;
import java.util.Random;

/**
 * HundirFlotaV2
 * 
 * ayuda
 * 
 * https://codereview.stackexchange.com/questions/161680/oop-battleship-console-game-in-java/161695
 */
public class HundirFlotaV2 {
    public static final int TAMANO = 10;
    public static final char ICONO_AGUA = '·';
    public static final char ICONO_AGUA_FALLO = '*';
    public static final char ICONO_BARCO = 'B';
    public static final char ICONO_BARCO_TOCADO = 'X';

    public static void main(String[] args) {
        // * 1 crear el tablero de 10x10
        // * 1.1 inicializar el tablero
        // * 2 crear tablero de disparos 10x10
        // * 2.2 inicializar el tablero
        // * 3 ubicar el barquito (de momento 1) de forma aleatoria
        // 4 dibujar el tablero sin indicar el barco, todo lleno de agua
        // 5 comenzar a disparar
        // 6.1 comprobar si hay agua o barco
        // 6.2 indicar si has dado al agua o al barco
        // 6.3 indicar si ya has disparado a esas coordenadas
        // 6.4 aumentar el contador de disparos

        // variables y cosas que necesitamos
        Scanner entrada = new Scanner(System.in);
        char[][] tablero;
        boolean[][] tableroDisparos;
        int disparos = 0;

        MisClases.limpiarPantalla();
        tablero = crearTablero();
        ubicarBarco(tablero);
        tableroDisparos = crearTableroDisparos();
        // ayuda
        dibujarTablero(tablero);
        disparo(tablero, tableroDisparos, disparos, entrada);
        
        // mostrar los disparos realizados
        dibujarTableroDisparos(tableroDisparos);
        // mostrar el tablero con los iconos
        dibujarTablero(tablero);

        // cerrar el scanner
        entrada.close();
    } // main

    /***************************************************************************************************
     * crearTablero
     * 
     * Crea el tablero de juego en base a la constante TAMANO.
     * 
     * @return Devuelve un array char[][] con el tamanño de TAMANO rellenado con el
     *         icono de agua.
     */
    public static char[][] crearTablero() {
        char[][] retorno = new char[TAMANO][TAMANO];
        // Inicialiarlo
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                retorno[i][j] = ICONO_AGUA;
            }
        }
        return retorno;
    }

    /***************************************************************************************************
     * crearTableroDisparos
     * 
     * Crea un tablero para almacenar los disparos realizados
     * 
     * @return Devuelve un array boolean[][] con el tamaño de TAMANO rellenado con
     *         false.
     */
    public static boolean[][] crearTableroDisparos() {
        boolean[][] retorno = new boolean[TAMANO][TAMANO];
        // Inicializarlo
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                retorno[i][j] = false;
            }
        }
        return retorno;
    }

    /***************************************************************************************************
     * ubicarBarco
     * 
     * Ubica un barco de 1 casilla en el "tableroJuego" que se le indique
     * 
     * @param tableroJuego array char[][] del tablero de juego
     */
    public static void ubicarBarco(char[][] tableroJuego) {
        Random cosa = new Random();
        tableroJuego[cosa.nextInt(TAMANO)][cosa.nextInt(TAMANO)] = ICONO_BARCO;
    }

    /***************************************************************************************************
     * disparo
     * 
     * para realizar y controlar los disparos en el juego
     * 
     * @param tableroJuego      Tablero de juego con el barco ubicado
     * @param tableroDisparados Tablero de control de las coordenads disparadas
     * @param contador          contador para saber los disparos realizados
     * @param input             scanner de entrada de datos
     */
    public static void disparo(char[][] tableroJuego, boolean[][] tableroDisparados, int contador, Scanner input) {
        int fila, columna;
        boolean control = true;
        do {
            MisClases.escribeLinea("(has hecho " + contador + " disparos)");
            MisClases.escribe("Introduce la fila: ");
            fila = input.nextInt();
            MisClases.escribe("Introduce la columna: ");
            columna = input.nextInt();

            // comprobar si se ha disparado o no a esas mismas coordenadas
            if (tableroDisparados[fila][columna] == true) {
                MisClases.escribeLinea("Ya has disparado antes a esas coordenadas. Elije otra.");
            } else {
                switch (tableroJuego[fila][columna]) {
                case ICONO_AGUA:
                    contador++;
                    tableroJuego[fila][columna] = ICONO_AGUA_FALLO;
                    tableroDisparados[fila][columna] = true;
                    MisClases.escribeLinea("¡Fallo! Disparo al agua");
                    break;
                case ICONO_BARCO:
                    contador++;
                    tableroJuego[fila][columna] = ICONO_BARCO_TOCADO;
                    tableroDisparados[fila][columna] = true;
                    MisClases.escribeLinea("¡Acierto! Barco hundido");
                    MisClases.escribeLinea("(Barco hundido en " + contador + " disparos)");
                    control = false;
                    break;
                default:
                    break;
                } // switch
            } // else
        } while (control);
    }

    //
    public static void dibujarTablero(char[][] tableroJuego) {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0 && j == 0) {
                    // Primera casilla, una X para diferenciar
                    MisClases.escribe("X\t");
                } else if (i == 0 && j > 0) {
                    // Primera fila, con las cabeceras
                    MisClases.escribe((j - 1) + "\t");
                } else if (i > 0 && j == 0) {
                    // Columnas, escribir el número
                    MisClases.escribe((i - 1) + "\t");
                } else if (i > 0 && j > 0) {
                    MisClases.escribe(tableroJuego[i - 1][j - 1] + "\t");
                }
            }
            MisClases.escribeLinea(" ");
        } // Borrar desde el comentario "para dibujar..." hasta aquí
    }

    //
    public static void dibujarTableroDisparos(boolean[][] tableroDisparados) {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0 && j == 0) {
                    // Primera casilla, una X para diferenciar
                    MisClases.escribe("X\t");
                } else if (i == 0 && j > 0) {
                    // Primera fila, con las cabeceras
                    MisClases.escribe("  " + (j - 1) + "\t");
                } else if (i > 0 && j == 0) {
                    // Columnas, escribir el número
                    MisClases.escribe("" + (i - 1) + "\t");
                } else if (i > 0 && j > 0) {
                    MisClases.escribe(tableroDisparados[i - 1][j - 1] + "\t");
                }
            }
            MisClases.escribeLinea(" ");
        } // Borrar desde el comentario "para dibujar..." hasta aquí
    }
}