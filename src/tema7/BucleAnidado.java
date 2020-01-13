package tema7;

import miscosas.MisClases;

/**
 * BucleAnidado
 */
public class BucleAnidado {
    public static void main(String[] args) {
        final int FILAS = 15;
        final int COLUMNAS = 7;
        for(int fila = 1; fila <= FILAS; fila++) {
            MisClases.escribe("fila-" + fila);
            for(int columna = 1; columna <= COLUMNAS; columna++) {
                MisClases.escribe(" columna-" + columna);
            }
            MisClases.escribeLinea(""); // cambio de línea 
        }
    }
}