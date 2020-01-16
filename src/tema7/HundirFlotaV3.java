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
    private static final char ICONO_AGUA = '~';
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
        private int fila;
        private int columna;
        private char estado;
        private boolean usado;
        // Constructor
        public Celda(int fila, int columna){
            this.fila = fila;
            this.columna = columna;
            this.estado = ICONO_AGUA;
            this.usado = false;
        }
        // Getters y Setters
        public char getEstado() {
            return estado;
        }

        public void setEstado(char estado) {
            this.estado = estado;
        }

        public boolean isUsado() {
            return usado;
        }

        public void setUsado(boolean usado) {
            this.usado = usado;
        }
        // Otros métodos
        public void cambiarIcono(char tipoIcono){
            this.estado = tipoIcono;
        }
    } // Celda

    // CLASE BARCO
    private static class Barco{
        // Para definir cada barco
        private static String nombre;
        private static int tamano;
        private static int vidas;
        // Constructor
        public Barco(String vNombre, int vTamano){
            this.nombre = vNombre;
            this.tamano = vTamano;
            this.vidas = this.tamano;
        }
        // Getters y Setters
        public static String getNombre() {
            return nombre;
        }

        public static void setNombre(String nombre) {
            Barco.nombre = nombre;
        }

        public static int getTamano() {
            return tamano;
        }

        public static void setTamano(int tamano) {
            Barco.tamano = tamano;
        }

        public static int getVidas() {
            return vidas;
        }

        public static void setVidas(int vidas) {
            Barco.vidas = vidas;
        }
    } // Barco

    // CLASE TABLERO
    public static class Tablero{
        private Celda[][] tablero;
        // Constructor
        public Tablero(){
            this.tablero = new Celda[TAMANO][TAMANO];
            for(int i=0;i<TAMANO;i++){
                for(int j=0;j<TAMANO;j++){
                    this.tablero[i][j] = new Celda(i, j);
                }
            }
            // Aquí habría que inicializar los barcos y ubicarlos
        } // Constructor
        // Otros Métodos
        public void dibujarTableroDemo(){
            for(int i=0;i<=TAMANO;i++){
                for(int j=0;j<=TAMANO;j++){
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
                        MisClases.escribe(tablero[i-1][j-1].estado+"\t");                        
                    }
                }
                MisClases.escribeLinea(" ");
            }
        }
    } // Tablero


    /* ************************************************** */
    /* MAIN  */
    public static void main(String[] args) {
        // Limpiar pantalla
        MisClases.limpiarPantalla();
        // iniciar el tablero
        Tablero tablero = new Tablero();
        tablero.dibujarTableroDemo();
    }
 
    

    
}