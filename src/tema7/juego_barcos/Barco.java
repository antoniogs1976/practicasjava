package tema7.juego_barcos;

import tema7.juego_barcos.Resultado;


public class Barco {
    // 1xtamaño4
    // 2xtamaño3
    // 3xtamaño2
    // 4xtamaño1
    // Constantes
    public static final int PORTAAVIONES = 5;
    public static final int ACORAZADO = 4;
    public static final int CORBETA = 3;
    public static final int SUBMARINO = 3;
    public static final int DESTRUCTOR = 2;

    private final String name;
    private final int size;
    private int lives;

    public Barco(String name, int size) {
        this.name = name;
        this.size = size;
        this.lives = size;
    }

    public void hit() {
        if(lives > 0) {
            System.out.printf("%nGood shot! The %s was hit", name);
            lives--;
        } else {
            System.out.format("Ship %s is destroyed", name);
        }
    }

    public Resultado getState() {
        if(lives == 0) {
            return Resultado.DESTRUIDO;
        } else if(lives < size) {
            return Resultado.PARCIALMENTE_ACERTADO;
        } else {
            return Resultado.SIN_ACIERTO;
        }
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}