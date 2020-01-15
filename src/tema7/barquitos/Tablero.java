package tema7.barquitos;

/**
 * Tablero
 */
public class Tablero {
    /*
    el tablero tiene unas dimensiones de 10x10
    - AGUA pintar ·
    - BARCO TOCADO pintar #
    - DISPARO FALLIDO pintar o
    */

    /* ********** CONSTANTES ********** */
    final int TAMANO = 10;
    
    final char ICONO_BARCO = 'B';
    final char ICONO_DISPARO_BARCO ='X';
    final char ICONO_AGUA = '·';
    final char ICONO_DISPARO_AGUA = '*';
    
    final char[] LETRAS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    final char[] NUMEROS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    /* ********** VARIABLES ********** */
    private char[][] tablero;

    /* ********** Constructor ********** */
    public Tablero(){
        tablero = new char[TAMANO][TAMANO];
        
        // Inicializar el tablero
        for(int i = 0; i<=TAMANO; i++){
            for(int j = 0; j<=TAMANO;j++){
                tablero[i][j] = ICONO_AGUA;
            }
        }
        // aquí iría lo de colocar los barcos

    } // fin del constructor
   

    /* ********** OTROS MÉTODOS ********** */
    
    
}