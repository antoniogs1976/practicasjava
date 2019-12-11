package ejerciciosconvertidosc;

import java.util.Scanner; // Import the Scanner class

/**
 * Ejercicio1
 * 
 * Operaciones básicas con dos números
 */
public class Ejercicio01 {
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

    public static double read(double numero) {
        double x = numero;
        Scanner leer = new Scanner(System.in); // Create a Scanner object
        x = leer.nextDouble();
        return x;
    }

    public static void main(String[] args) {
        double num1 = 0, num2 = 0; // Para almacenar los números que teclea el usuario.
        double suma = 0, resta = 0, producto = 0, cociente = 0, resto = 0; // Operaciones
        boolean error = false;

        println("************************************************************");
        println("**         O P E R A C I O N E S    B Á S I C A S         **");
        println("************************************************************");
        print("- Teclea un valor para Número 1: ");
        num1 = read(num1);
        print("- Teclea un valor para Número 2: ");
        num2 = read(num2);
        println("************************************************************");
        // operaciones
        suma = num1 + num2;
        resta = num1 - num2;
        producto = num1 * num2;
        // comprobación de la división entre cero
        if (num2 == 0) {
            error = true;
        } else {
            cociente = num1 / num2;
            resto = num1 % num2;
        }
        // Escribir las cosas
        println("-- La suma de " + num1 + " y de " + num2 + " es: " + suma);
        println("-- La resta de " + num1 + " y de " + num2 + " es: " + resta);
        println("-- El producto de " + num1 + " y de " + num2 + " es: " + producto);
        if (error == true) {
            println("-- El cociente de la división entre " + num1 + " y " + num2 + " no se puede hacer.");
            println("-- El resto de la división entre " + num1 + " y " + num2 + " no se puede hacer.");
            println("-- Hay una división entre cero.");
        } else {
            println("-- El cociente de la división entre " + num1 + " y " + num2 + " es: " + cociente);
            println("-- El resto de la división entre " + num1 + " y " + num2 + " es: " + resto);
        }
        println("************************************************************");
    }
}