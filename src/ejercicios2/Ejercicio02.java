package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * Ejercicio02
 * 
 * Programa que lea un carácter por teclado y compruebe si es una letra
 * mayúscula
 * 
 * Tal como está hecho, no acepta la ñ ni la Ñ
 */
public class Ejercicio02 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        //char caracter;
        String letra;
        boolean bucle = true;
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("------------------------------------------------------------");
        MisClases.escribeLinea("-              L E T R A   M A Y Ú S C U L A               -");
        MisClases.escribeLinea("------------------------------------------------------------");
        while (bucle == true) {
            MisClases.escribe("Introduce un letra (-1 para salir): ");
            letra = entrada.nextLine();
            if (letra.equals("-1")){
                bucle = false;
            } else {
                //caracter = entrada.nextLine().charAt(0);
                if (Character.isDigit(letra.charAt(0)) == true){
                    MisClases.escribeLinea("Has introducido un número, no una letra...");
                } else if (Character.isUpperCase(letra.charAt(0)) == true){
                    MisClases.escribeLinea("La letra es mayúscula.");
                } else {
                    MisClases.escribeLinea("La letra es minúscula.");
                }    
            }
        }
        // cerrar scanner
        entrada.close();
    }
}