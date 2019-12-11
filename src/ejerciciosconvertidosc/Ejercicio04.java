package ejerciciosconvertidosc;

import java.util.Scanner;

/**
 * Ejercicio04
 * 
 * Mayor menor o igual entre 3 números
 */
public class Ejercicio04 {
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
        int num1 = 0, num2 = 0, num3 = 0;
        println("************************************************************");
        println("**       M A Y O R   -   M E N O R   -   I G U A L        **");
        println("**             C O N   T R E S   N Ú M E R O S            **");
        println("************************************************************");
        print("-- Introduce el valor de Num1: ");
        num1 = readInt();
        print("-- Introduce el valor de Num2: ");
        num2 = readInt();
        print("-- Introduce el valor de Num3: ");
        num3 = readInt();
        println("------------------------------------------------------------");
        // Operaciones
        if ((num1 == num2) && (num1 == num3)){
            println("-- Los tres números son iguales.");
        } else if ((num1 > num2) && (num1 > num3)) {
            println("-- Num1 es mayor que Num2 y que Num3");
        } else if ((num2 > num1) && (num2 > num3)) {
            println("-- Num2 es mayor que Num1 y que Num3");
        } else {
            println("-- Num3 es mayor que Num1 y que Num2");
        }
        

    }

}