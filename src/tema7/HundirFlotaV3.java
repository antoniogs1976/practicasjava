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
        private Barco[] barcos = new Barco[10];
        // Constructor
        public Tablero(){
            this.tablero = new Celda[TAMANO][TAMANO];
            for(int i=0;i<TAMANO;i++){
                for(int j=0;j<TAMANO;j++){
                    this.tablero[i][j] = new Celda(i, j);
                }
            }
            for(int i = 0; i< barcos.length; i++){
                switch (i){
                    case 0:
                        barcos[i].nombre = "Portaaviones";
                        barcos[i].tamano = 4;
                        barcos[i].vidas = 4;
                        break;
                    case 1:
                        barcos[i].nombre = "Submarino 1";
                        barcos[i].tamano = 3;
                        barcos[i].vidas = 3;
                        break;
                    case 2:
                        barcos[i].nombre = "Submarino 2";
                        barcos[i].tamano = 3;
                        barcos[i].vidas = 3;
                        break;
                    case 3:
                        barcos[i].nombre = "Destructor 1";
                        barcos[i].tamano = 2;
                        barcos[i].vidas = 2;
                        break;
                    case 4:
                        barcos[i].nombre = "Destructor 2";
                        barcos[i].tamano = 2;
                        barcos[i].vidas = 2;
                        break;
                    case 5:
                        barcos[i].nombre = "Destructor 3";
                        barcos[i].tamano = 2;
                        barcos[i].vidas = 2;
                        break;
                    case 6:
                        barcos[i].nombre = "Fragata 1";
                        barcos[i].tamano = 1;
                        barcos[i].vidas = 1;
                        break;
                    case 7:
                        barcos[i].nombre = "Fragata 2";
                        barcos[i].tamano = 1;
                        barcos[i].vidas = 1;
                        break;
                    case 8:
                        barcos[i].nombre = "Fragata 3";
                        barcos[i].tamano = 1;
                        barcos[i].vidas = 1;
                        break;
                    case 9:
                        barcos[i].nombre = "Fragata 4";
                        barcos[i].tamano = 1;
                        barcos[i].vidas = 1;
                        break;
                }
            }
        } // Constructor
        // Otros Métodos

        // Ubicar los barcos
        public void ubicarBarcos(Tablero tableroJuego){

        }

        // Dibujar el tablero
        public void dibujarTablero(boolean disparos){
            if (disparos){
                // Dibujar el tablero de disparos (sin barcos)
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
                            if (tablero[i-1][j-1].isUsado()){
                                MisClases.escribe(ICONO_AGUA+"\t");
                            } else {
                                MisClases.escribe(tablero[i-1][j-1].getEstado()+"\t");
                            }
                        }
                    }
                    MisClases.escribeLinea(" ");
                }
            } else {
                // Dibujar el tablero con todo
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
            } // else
        } // DibujarTablero
    } // Tablero

    /* ************************************************** */
    /* MAIN  */
    public static void main(String[] args) {
        // Limpiar pantalla
        MisClases.limpiarPantalla();
        // iniciar el tablero
        Tablero tablero = new Tablero();
        // Dibujar el tablero de disparos nada más, sin barcos ni nada sólo agua y disparos
        tablero.dibujarTablero(true);
        // tablero.dibujarTablero(false);

    } // main    
} // fin del todo