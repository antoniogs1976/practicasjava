package ejerciciosconvertidosc;

import java.util.Scanner;

/**
 * Ejercicio03
 * 
 * Ver cual de las dos variables es mayor que la otra
 */
public class Ejercicio03 {
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
        int num1 = 0, num2 = 0;
        println("************************************************************");
        println("**       M A Y O R   -   M E N O R   -   I G U A L        **");
        println("************************************************************");
        print("-- Introduce el valor del Número 1: ");
        num1 = readInt();
        print("-- Introduce el valor del Número 2: ");
        num2 = readInt();
        println("------------------------------------------------------------");
        // operaciones
        if (num1 == num2) {
            println("Número 1 y Número 2 son iguales");
        } else if (num1 > num2) {
            println("Número 1 es mayor que Número 2");
        } else {
            println("Número 2 es mayor que Número 1");
        }
        println("************************************************************");

    }
}