package tema7;

import java.util.Scanner;
import miscosas.MisClases;
import java.util.Random;

/**
 * HundirFlota
 */
public class HundirFlota {

    public static boolean[][] crearTablero(Scanner leer) {
        int filas, columnas;

        MisClases.limpiarPantalla();
        MisClases.escribeLinea("Configurar el tablero de juego");
        MisClases.escribe("Introduce la cantidad de filas: ");
        filas = leer.nextInt();
        MisClases.escribe("Introduce la cantidad de columnas: ");
        columnas = leer.nextInt();
        // Crear el array y devolverlo
        boolean[][] retorno = new boolean[filas][columnas];
        // Llenarlo de false
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                retorno[i][j] = false;
            }
        }

        return retorno;
    } // fin crearTablero

    /************************************************************/
    public static boolean[][] ubicarBarco(boolean[][] tablerillo) {
        boolean[][] retorno = tablerillo;
        Random alea = new Random();
        // Seleccionar fila y columna
        retorno[alea.nextInt(retorno.length)][alea.nextInt(retorno[0].length)] = true;
        return retorno;
    } // fin ubicarBarco

    public static boolean coordinadasDisparo(boolean[][] tablero, boolean[][] tableroDescartes, Scanner leer, int contador) {
        boolean retorno;
        int x, y;
        MisClases.escribeLinea("Teclea las coordenadas para dispara el misil:");
        do {
            MisClases.escribe("Fila (0 a " + (tablero.length - 1) + "): ");
            x = leer.nextInt();
            if (x > tablero.length - 1) {
                MisClases.escribeLinea("Esa coordenada no existe");
            }
        } while (x > tablero.length - 1);
        do {
            MisClases.escribe("Columna (0 a " + (tablero[0].length - 1) + "): ");
            y = leer.nextInt();
        } while (y > tablero[0].length - 1);
        contador++;
        // Comprobar si explota el barco o no
        if (tablero[x][y] == true) {
            MisClases.escribeLinea("¡Acierto! Barco enemigo destruido");
            MisClases.escribeLinea("(has usado "+ contador +" intentos)");
            retorno = false;
        } else {
            MisClases.escribeLinea("¡Agua! Fallaste");
            MisClases.escribeLinea("(llevas " + contador + " intentos)");
            retorno = true;
        }
        return retorno;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean[][] tablero = crearTablero(entrada);
        boolean[][] tablero2 = tablero.clone();
        boolean juego = true;
        int cuenta;
        cuenta = 0;
        // ubicar el barco enemigo
        tablero = ubicarBarco(tablero);

        // BORRAR DESDE AQUÍ
        //MisClases.escribeLinea("Tablero:");
        //for (int i = 0; i < tablero.length; i++) {
        //    for (int j = 0; j < tablero[i].length; j++) {
        //        MisClases.escribe("" + tablero[i][j] + "\t");
        //    }
        //    MisClases.escribeLinea("");
        //}
        // BORRAR HASTA AQUÍ

        while (juego) {
            juego = coordinadasDisparo(tablero, tablero2, entrada, cuenta);
        }
        entrada.close();
    }

}

/*
 * ESTO ESTÁ COPIADO DE INTERNET Y NO ESTÁ COMPROBADO, PERO LO DEJO AQUÍ PARA
 * SACAR IDEAS
 * 
 * 
 * 
 * public void seleccionarCasillaFacil() { int x, y; do { x = (int)
 * (Math.random() * n); y = (int) (Math.random() * n); } while
 * (tabJugador.getCasilla(x, y).isSeleccionada()); tabJugador.getCasilla(x,
 * y).Seleccionar(); }
 * 
 * public void seleccionarCasillaMedio() { if
 * (ultimaTocada.getBarco().getEstadoBarco() == EstadoBarco.TOCADO) { int aux =
 * seguirRastro(); switch (aux) { case 0: if
 * (!tabJugador.getCasilla(ultimaTocada.getX() + 1,
 * ultimaTocada.getY()).isSeleccionada()) {
 * tabJugador.getCasilla(ultimaTocada.getX() + 1,
 * ultimaTocada.getY()).Seleccionar(); return; } case 1: if
 * (!tabJugador.getCasilla(ultimaTocada.getX() - 1,
 * ultimaTocada.getY()).isSeleccionada()) {
 * tabJugador.getCasilla(ultimaTocada.getX() - 1,
 * ultimaTocada.getY()).Seleccionar(); return; } case 2: if
 * (!tabJugador.getCasilla(ultimaTocada.getX(), ultimaTocada.getY() +
 * 1).isSeleccionada()) { tabJugador.getCasilla(ultimaTocada.getX(),
 * ultimaTocada.getY() + 1).Seleccionar(); return; } case 3: if
 * (!tabJugador.getCasilla(ultimaTocada.getX(), ultimaTocada.getY() -
 * 1).isSeleccionada()) { tabJugador.getCasilla(ultimaTocada.getX(),
 * ultimaTocada.getY() - 1).Seleccionar(); return; } default: break; } if
 * (!elegirVecinaAleatoria()) { casillaVecinaTocada();
 * seleccionarCasillaMedio(); } else return; } else seleccionarCasillaFacil(); }
 * 
 * public void seleccionarCasillaDificil() { if
 * (ultimaTocada.getBarco().getEstadoBarco() == EstadoBarco.TOCADO) { int aux =
 * seguirRastro(); switch (aux) { case 0: if
 * (!tabJugador.getCasilla(ultimaTocada.getX() + 1,
 * ultimaTocada.getY()).isSeleccionada()) {
 * tabJugador.getCasilla(ultimaTocada.getX() + 1,
 * ultimaTocada.getY()).Seleccionar(); return; } case 1: if
 * (!tabJugador.getCasilla(ultimaTocada.getX() - 1,
 * ultimaTocada.getY()).isSeleccionada()) {
 * tabJugador.getCasilla(ultimaTocada.getX() - 1,
 * ultimaTocada.getY()).Seleccionar(); return; } case 2: if
 * (!tabJugador.getCasilla(ultimaTocada.getX(), ultimaTocada.getY() +
 * 1).isSeleccionada()) { tabJugador.getCasilla(ultimaTocada.getX(),
 * ultimaTocada.getY() + 1).Seleccionar(); return; } case 3: if
 * (!tabJugador.getCasilla(ultimaTocada.getX(), ultimaTocada.getY() -
 * 1).isSeleccionada()) { tabJugador.getCasilla(ultimaTocada.getX(),
 * ultimaTocada.getY() - 1).Seleccionar(); return; } default: break; } if
 * (!elegirVecinaAleatoria()) { casillaVecinaTocada();
 * seleccionarCasillaMedio(); } else return; } else seleccionarCasillaDificil();
 * }
 */

/**
 * elige una casilla tocada vecina aleatoria
 */
/*
 * private void casillaVecinaTocada(){ Casilla[]
 * aux=ultimaTocada.getBarco().getCasillas(); if(getRandomBoolean()){
 * 
 * for(int i=0;i<aux.length;i++){ if(aux[i].isSeleccionada() &&
 * aux[i]!=ultimaTocada){ ultimaTocada=aux[i]; } } } else { for(int
 * i=aux.length-1;i>=0;i--){ if(aux[i].isSeleccionada() &&
 * aux[i]!=ultimaTocada){ ultimaTocada=aux[i]; } } } }
 */