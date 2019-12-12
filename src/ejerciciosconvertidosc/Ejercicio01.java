package ejerciciosconvertidosc;

import java.util.Scanner; // Import the Scanner class

/**
 * Ejercicio1
 * 
 * Operaciones básicas con dos números
 */
public class Ejercicio01 {
    private double num1;
    private double num2;
    private double suma;
    private double resta;
    private double producto;
    private double cociente;
    private double resto;
    // constructor
    public Ejercicio01() {
        this.num1 = 0;
        this.num2 = 0;
        this.suma = 0;
        this.resta = 0;
        this.producto = 0;
        this.cociente = 0;
        this.resto = 0;
    }
    // getter y setter
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public double getResta() {
        return resta;
    }

    public void setResta(double resta) {
        this.resta = resta;
    }

    public double getProducto() {
        return producto;
    }

    public void setProducto(double producto) {
        this.producto = producto;
    }

    public double getCociente() {
        return cociente;
    }

    public void setCociente(double cociente) {
        this.cociente = cociente;
    }

    public double getResto() {
        return resto;
    }

    public void setResto(double resto) {
        this.resto = resto;
    }
    // otros
    

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

    public static double readDouble() {
        double x;
        Scanner leer = new Scanner(System.in); // Create a Scanner object
        x = leer.nextDouble();
        return x;
    }

    public static void main(String[] args) {
        double num1 = 0, num2 = 0;
        println("************************************************************");
        println("**         O P E R A C I O N E S    B Á S I C A S         **");
        println("************************************************************");
        print("- Teclea un valor para Número 1: ");
        num1 = readDouble();
        print("- Teclea un valor para Número 2: ");
        num2 = readDouble();
        println("************************************************************");
        // operaciones
        println(num1 + " " + num2);
        println("************************************************************");
    }

}