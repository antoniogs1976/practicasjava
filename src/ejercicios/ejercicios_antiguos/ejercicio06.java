package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio06
 * 
 * dado un número mayor de 0, presentar su raíz cuadrada y su cuadrado
 */
public class ejercicio06 {
    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1;
        String tecla;
        boolean bucle = true;
        while (bucle == true) {
            escribeLinea("************************************************************");
            escribeLinea("*                 CUADRADO - RAÍZ CUADRADA                 *");
            escribeLinea("************************************************************");
            escribe("\n- Introduce un valor para num1 que no sea 0 (cero) o negativo: ");
            num1 = entrada.nextInt();
            escribeLinea("\n************************************************************\n");
            if (num1 <= 0) {
                escribeLinea("- ¡¡¡MAAAAAAAAAAAAAAL!!! Dije que no fuese 0 o negativo ¬¬\n");
            } else {
                escribeLinea("- " + num1 + " al cuadrado es: " + Math.sqrt(num1));
                escribeLinea("Raíz cuadrada de " + num1 + " es: " + Math.pow(num1, 2)+"\n");
            }

            escribeLinea("************************************************************");
            escribeLinea("*       ¿Desea repetir la operación con otro número?       *");
            escribeLinea("************************************************************");
            escribeLinea("*                  (pulsa S o N y Enter)                   *");
            escribeLinea("************************************************************");
            tecla = entrada.next();
            if (tecla.equals("N") || (tecla.equals("n"))) {
                bucle = false;
            } else {
                bucle = true;
            }
        } // while
        entrada.close();
    }
}