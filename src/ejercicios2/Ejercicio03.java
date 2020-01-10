package ejercicios2;

import java.util.Scanner;
import miscosas.MisClases;

/**
 * Ejercicio03
 * 
 * Programa que lea por teclado tres números enteros y calcule el mayor de los tres.
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2, num3;
        boolean bucle = true;
        char SioNo;
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("------------------------------------------------------------");
        MisClases.escribeLinea("-                  MAYOR DE TRES NÚMEROS                   -");
        MisClases.escribeLinea("------------------------------------------------------------");
        while (bucle){
            MisClases.escribe("Introduce el valor de Número 1: ");
            num1 = entrada.nextInt();
            MisClases.escribe("Introduce el valor de Número 2: ");
            num2 = entrada.nextInt();
            MisClases.escribe("Introduce el valor de Número 3: ");
            num3 = entrada.nextInt();

            // comparaciones
            if (num1 > num2 && num1 > num3){
                MisClases.escribeLinea("El Número 1 ("+num1+") es el mayor de los tres números");
            } else if (num2 > num1 && num2 > num3) {
                MisClases.escribeLinea("El Número 2 ("+num2+") es el mayor de los tres números");
            } else {
                MisClases.escribeLinea("El Número 3 ("+num3+") es el mayor de los tres números");
            }
            //
            MisClases.escribe("¿Seguir comprobando números? (S/N): ");
            SioNo = entrada.next().charAt(0);
            if (SioNo == 'n' || SioNo == 'N'){
                bucle = false;
            } else {
                bucle = true;
            }
        }
        MisClases.escribeLinea("bye bye!");
        // cerrar scanner
        entrada.close();
    }
}