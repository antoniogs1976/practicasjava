package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio03
 * 
 * dados 2 números, comprobar cual de los es mayor, menor o si son iguales
 */
public class ejercicio03 {
    
    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1, num2;
        String tecla;
        boolean bucle = true;
        while (bucle == true) {
            escribeLinea("************************************************************");
            escribeLinea("*                   MAYOR - MENOR - IGUAL                  *");
            escribeLinea("************************************************************");
            escribe("- Introduce un valor para num1: ");
            num1 = entrada.nextInt();
            escribe("- Introduce un valor para num2: ");
            num2 = entrada.nextInt();
            escribeLinea("\n************************************************************\n");
            if (num1 > num2){
                escribeLinea("- num1 ("+num1+") es mayor que num2 ("+num2+")\n");
            } else if (num2 > num1){
                escribeLinea("- num2 ("+num2+") es mayor que num1 ("+num1+")\n");
            } else {
                escribeLinea("- num1 ("+num1+") es igual a num2 ("+num2+")\n");
            }
            escribeLinea("************************************************************");
            escribeLinea("*      ¿Desea repetir la operación con otros números?      *");
            escribeLinea("************************************************************");
            escribeLinea("*                  (pulsa S o N y Enter)                   *");
            escribeLinea("************************************************************");
            tecla = entrada.next();
            if (tecla.equals("N") || (tecla.equals("n"))){
                bucle = false;
            } else {
                bucle = true;
            }
        } // While principal
        entrada.close();

    } // Main
    
}