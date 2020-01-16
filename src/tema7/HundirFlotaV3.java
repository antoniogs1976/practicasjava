package tema7;

import java.util.Scanner;
import java.util.Random;
import miscosas.MisClases;


/**
 * HundirFlotaV3
 */
public class HundirFlotaV3 {

    /* ********** Constantes ********** */
    // Tamaño del tablero
    private static final int TAMANO = 10;
    // Iconos del juego
    private static final char ICONO_AGUA = '·';
    private static final char ICONO_AGUA_FALLO = '*';
    private static final char ICONO_BARCO = 'B';
    private static final char ICONO_BARCO_TOCADO = 'X';
    // Tamaños de los barcos
    private static final int TAMANO_FRAGATA = 1;
    private static final int TAMANO_DESTRUCTOR = 2;
    private static final int TAMANO_SUBMARINO = 3;
    private static final int TAMANO_PORTAAVIONES = 4;
    // Numero de barcos
    private static final int NUMERO_FRAGATA = 4;
    private static final int NUMERO_DESTRUCTOR = 3;
    private static final int NUMERO_SUBMARINO = 2;
    private static final int NUMERO_PORTAAVIONES = 1;
    // Distancia mínima entre barcos (casillas)
    private static final int DISTANCIA_BARCOS = 1;

    /* ********** Variables ********** */
    // Entrada de datos
    private static Scanner entrada = new Scanner(System.in);
    // Tableros
    private static char[][] tableroJuego = new char[TAMANO][TAMANO];
    private static boolean[][] tableroDisparos = new boolean[TAMANO][TAMANO];
    // Contador
    private static int disparosRealizados = 0;
    // Orientación de los barcos
    private static boolean horizontal = false;  // true = horizontal // false = vertical
    
    // CLASE CELDA
    private static class Celda{
        // Cada celda puede tener 4 valores:
        // ICONO_AGUA = '·';
        // ICONO_AGUA_FALLO = '*';
        // ICONO_BARCO = 'B';
        // ICONO_BARCO_TOCADO = 'X';
        private char estadoCelda;
    }

    // CLASE BARCO
    private static class Barco{
        // Para definir cada barco
        private static String nombre;
        private static int tamano;
        private static int vidas;

        public Barco(String vnombre, int vtamano){
            this.nombre = vnombre;
            this.tamano = vtamano;
            this.vidas = this.tamano;
        }

    }

    /* ************************************************** */
    /* MAIN  */
    public static void main(String[] args) {
        
    }
 
    

    
}