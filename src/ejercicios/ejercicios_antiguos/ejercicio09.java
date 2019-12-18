package ejercicios.ejercicios_antiguos;

import java.util.Scanner;

/**
 * ejercicio09
 * 
 * Comprobar si un número es par o impar
 */
public class ejercicio09 {
    
    public static void escribe(String texto) {
        System.out.print(texto);
    }

    public static void escribeLinea(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        String tecla;
        boolean bucle = true;

        while (bucle == true){
            escribeLinea("************************************************************");
            escribeLinea("*                       PAR O IMPAR                        *");
            escribeLinea("************************************************************\n");
            escribe("- Introduce número entro: ");
            numero = entrada.nextInt();
            escribeLinea("\n************************************************************\n");
            if (numero == 0){
                escribeLinea("- El número introducido no es ni par ni impar, es 0.");
            } else if ((numero % 2) == 0) {
                escribeLinea("- El número introducido es par.");
            } else {
                escribeLinea("- El número introducido es impar");
            }
            escribeLinea("\n************************************************************");
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
        }
        entrada.close();
    }
    
}