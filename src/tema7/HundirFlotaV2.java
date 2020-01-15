package tema7;

import java.util.Scanner;
import miscosas.MisClases;
import java.util.Random;

/**
 * HundirFlotaV2
 */
public class HundirFlotaV2 {
    public static void main(String[] args) {
        // 1    crear el tablero de 10x10
        // 1.1  inicializar el tablero
        // 2    ubicar el barquito (de momento 1) de forma aleatoria
        // 3    dibujar el tablero sin indicar el barco, todo lleno de agua
        // 4    comenzar a disparar
        // 4.1  comprobar si hay agua o barco
        // 5.2  indicar si has dado al agua o al barco
        // 5.3  indicar si ya has disparado a esas coordenadas
        // 5.4  aumentar el contador de disparos

        // variables y cosas que necesitamos
        boolean[][] tablero;
        tablero = crearTablero();




        //for(int i = 0; i<10;i++)
        //    if (i==9){
        //        MisClases.escribe("  "+i+"\n");
        //    } else {
        //        MisClases.escribe("  "+i+"\t");
        //    }


        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                if (i == 0 && j == 0){
                    // que haga cosas
                    MisClases.escribe("  X\t");
                } else if (i != 0 && j == 0){
                    MisClases.escribe("  "+(j-1)+"\t");
                } else {
                    MisClases.escribe(tablero[i-1][j-1]+"\t");
                }
            }
            MisClases.escribeLinea(" ");
        }
    }

    public static boolean[][] crearTablero() {
        boolean[][] retorno = new boolean[10][10];
        // Inicialiarlo
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                    retorno[i][j] = false;
            } // for j
        } // for i
        return retorno;
    }
}