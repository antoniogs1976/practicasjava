package ejerciciosconvertidosc;

import java.util.Scanner;

/**
 * Ejercicio02
 * 
 * Intercambiar el valor de 2 variables usando una tercera
 */
public class Ejercicio02 {
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

    public static double read(double numero) {
        double x = numero;
        Scanner leer = new Scanner(System.in); // Create a Scanner object
        x = leer.nextDouble();
        return x;
    }

    public static int read(int numero) {
        int x = numero;
        Scanner leer = new Scanner(System.in); // Create a Scanner object
        x = leer.nextInt();
        return x;
    }

    public static void main(String[] args) {
        int num1 = 0, num2 = 0, num3 = 0;
        println("************************************************************");
        print("-- Introduce el valor de Numero 1: ");
        num1 = read(num1);
        print("-- Introduce el valor de Numero 2: ");
        num2 = read(num2);
        println("------------------------------------------------------------");
        println("-- Numero 1 tiene un valor de: " + num1);
        println("-- Numero 2 tiene un vlaor de: " + num2);
        println("-----            INTERCAMBIAMOS LOS VALORES            -----");
        num3 = num1;
        num1 = num2;
        num2 = num3;
        println("-- Ahora Numero 1 tiene un valor de: " + num1);
        println("-- Ahora Numero 2 tiene un valor de: " + num2);
        println("************************************************************");

    }
}