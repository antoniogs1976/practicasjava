package ejerciciosconvertidosc;

import java.util.Scanner;

/**
 * Ejercicio05
 * 
 * Leer tres números:
 * Si NUM1 es menor que 0 hacer el producto de los tres números.
 * Si no es menor, hacer la suma de los tres números.
 */
public class Ejercicio05 {
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
        int num1, num2, num3, suma, producto;
        println("************************************************************");
        print("** Introduce el valor de Num1: ");
        num1 = readInt();
        print("** Introduce el valor de Num2: ");
        num2 = readInt();
        print("** Introduce el valor de Num3: ");
        num3 = readInt();
        println("------------------------------------------------------------");
        if (num1 < 0) {
            producto = num1 * num2 * num3;
            println("** Producto: " + producto);
        } else {
            suma = num1 + num2 + num3;
            println("** Suma: " + suma);
        }
        println("************************************************************");
    }
}