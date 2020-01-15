package tema7;

import java.util.Scanner;
import miscosas.MisClases;
import java.util.Random;

/**
 * HundirFlotaV2
 */
public class HundirFlotaV2 {
    public static final int TAMANO = 10;
    public static final char ICONO_AGUA = '·';
    public static final char ICONO_AGUA_FALLO = '*';
    public static final char ICONO_BARCO = 'B';
    public static final char ICONO_BARCO_TOCADO = 'X';
    
    public static void main(String[] args) {
        // * 1    crear el tablero de 10x10
        // * 1.1  inicializar el tablero
        // * 2    crear tablero de disparos 10x10
        // * 2.2  inicializar el tablero
        // * 3    ubicar el barquito (de momento 1) de forma aleatoria
        // 4    dibujar el tablero sin indicar el barco, todo lleno de agua
        // 5    comenzar a disparar
        // 6.1  comprobar si hay agua o barco
        // 6.2  indicar si has dado al agua o al barco
        // 6.3  indicar si ya has disparado a esas coordenadas
        // 6.4  aumentar el contador de disparos

        // variables y cosas que necesitamos
        char[][] tablero;
        boolean[][] tableroDisparos;
        int disparos = 0;

        MisClases.limpiarPantalla();
        tablero = crearTablero();
        ubicarBarco(tablero);
        tableroDisparos = crearTableroDisparos();
        


        // para dibujar (temporalmente) el tablero de juego
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0 && j == 0){
                    // Primera casilla, una X para diferenciar
                    MisClases.escribe("X");
                } else if (i == 0 && j > 0){
                    // Primera fila, con las cabeceras
                    MisClases.escribe((j-1)+"");
                } else if(i > 0 && j == 0){
                    // Columnas, escribir el número
                    MisClases.escribe((i-1)+"");
                } else if (i > 0 && j > 0){
                    MisClases.escribe(tablero[i-1][j-1]+"");
                }
            }
            MisClases.escribeLinea(" ");
        }
        // Borrar desde el comentario "para dibujar..." hasta aquí
    }

    /**
     * crearTablero
     * Crea el tablero de juego en base a la constante TAMANO.
     * 
     * @return Devuelve un array char[][] con el tamanño de TAMANO rellenado con el icono de agua.
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
    }   // crearTablero

    /**
     * crearTableroDisparos
     * Crea un tablero para almacenar los disparos realizados
     * 
     * @return Devuelve un array boolean[][] con el tamaño de TAMANO rellenado con false.
     */
    public static boolean[][] crearTableroDisparos(){
        boolean[][] retorno = new boolean[TAMANO][TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                    retorno[i][j] = false;
            }
        }
        return retorno;
    }   // crearTableroDisparos

    /**
     * ubicarBarco
     * Ubica un barco de 1 casilla en el "tableroJuego" que se le indique
     * @param tableroJuego array char[][] del tablero de juego
     */
    public static void ubicarBarco(char[][] tableroJuego){
        Random cosa = new Random();
        tableroJuego[cosa.nextInt(TAMANO) + 1][cosa.nextInt(TAMANO) + 1] = ICONO_BARCO;
    }
}