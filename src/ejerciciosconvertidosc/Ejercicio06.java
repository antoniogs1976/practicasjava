package ejerciciosconvertidosc;

import java.util.Scanner;

/**
 * Ejercicio06
 * 
 * Escribir un número entero y devolver
 * su cuadrado y su raíz cuadrada
 */
public class Ejercicio06 {
    public static void print(String texto) {
        System.out.print(texto);
    }

    public static void print(double numero) {
        System.out.print(numero);
    }

    public static void println(String texto) {
        System.out.println(texto);
    }

    public static void println(double numero) {
        System.out.println(numero);
    }

    public static void println(int numero) {
        System.out.println(numero);
    }

    public static double readDouble() {
        double x;
        Scanner leer = new Scanner(System.in); // Create a Scanner object
        x = leer.nextDouble();
        return x;
    }

    public static int readInt() {
        int x;
        Scanner leer = new Scanner(System.in); // Create a Scanner object
        x = leer.nextInt();
        return x;
    }
    public static void main(String[] args) {
        int num = 0;
        double raiz, cuadrado;
        println("************************************************************");
        print("** Introduce un número que no sea cero: ");
        num = readInt();
        println("------------------------------------------------------------");
        if (num == 0){
            println("-- No puede ser cero... ¬¬");
        } else {
            raiz = Math.sqrt(num);
            cuadrado = Math.pow(num, 2);
            println("-- Para el número "+num+" su cuadrado es " + cuadrado+" y su raíz cuadrada es "+raiz);
        }
        println("************************************************************");
    }
    
}