package ejerciciosconvertidosc;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Ejercicio07
 * 
 * Porcentaje de niños y niñas
 */
public class Ejercicio07 {
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

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void main(String[] args) {
        double ninos, ninas, total, pninos, pninas;
        println("************************************************************");
        println("** P O R C E N T A J E   D E   N I Ñ O S   Y   N I Ñ A S  **");
        println("************************************************************");
        print("-- Introduce el número de niños: ");
        ninos = readDouble();
        print("-- Introduce el número de niñas: ");
        ninas = readDouble();
        println("------------------------------------------------------------");
        total = ninos + ninas;
        pninos = (ninos*100)/total;
        pninas = (ninas*100)/total;
        println("-- El porcentaje de niños es de: "+df2.format(pninos)+"%");
        println("-- El porcentaje de niñas es de: "+df2.format(pninas)+"%");
        println("************************************************************");
    }

}