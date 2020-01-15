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

    final int ROW = 10;
    final int COL = 10;
    final char[] LET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    final char[] NUM = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    int[][] tableroJuego;

    /* ********** Constructor ********** */
    public Tablero(){
        tableroJuego = new int[ROW][COL];
        
        // Inicializar el tablero
        for(int i = 0; i<=ROW; i++){
            for(int j = 0; j<=COL;j++){
                
            }
        }
    }
    /* ********** Getters y Setters ********** */
   

    /* ********** OTROS MÉTODOS ********** */
    
    
}