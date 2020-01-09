package ejercicios2;

import java.util.Scanner;
import tema5.CosasVarias;

/**
 * Ejercicio05V2
 * 
 * Programa que lea una variable entera mes y compruebe si el valor corresponde
 * a un mes de 30 días, de 31 o de 28. Supondremos que febrero tiene 28 días. Se
 * mostrará además el nombre del mes. Se debe comprobar que el valor introducido
 * esté comprendido entre 1 y 12.
 * 
 * V2 Con switch en lugar de con if para mostrar los días y los nombres
 * 
 */
public class Ejercicio05V2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio",
        // "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre" };
        String meses = "";
        String dias = "";
        int mes;
        boolean bucle = true;
        char SioNo;

        CosasVarias.escribeLinea("------------------------------------------------------------");
        CosasVarias.escribeLinea("-                ¿Cuántos días tiene el mes?               -");
        CosasVarias.escribeLinea("------------------------------------------------------------");
        while (bucle) {
            do {
                CosasVarias.escribe("Introduce el número de mes (1-12): ");
                mes = entrada.nextInt();
                if (mes < 1 || mes > 12) {
                    CosasVarias.escribeLinea("El número de mes introducido (" + mes + ") no es válido.");
                }
            } while (mes < 1 || mes > 12);
            switch (mes) {
            case 1:
                meses = "enero";
                dias = "31";
                break;
            case 2:
                meses = "febrero";
                dias = "28";
                break;
            case 3:
                meses = "marzo";
                dias = "31";
                break;
            case 4:
                meses = "abril";
                dias = "30";
                break;
            case 5:
                meses = "mayo";
                dias = "31";
                break;
            case 6:
                meses = "junio";
                dias = "30";
                break;
            case 7:
                meses = "julio";
                dias = "31";
                break;
            case 8:
                meses = "agosto";
                dias = "31";
                break;
            case 9:
                meses = "septiembre";
                dias = "30";
                break;
            case 10:
                meses = "octubre";
                dias = "31";
                break;
            case 11:
                meses = "noviembre";
                dias = "30";
                break;
            case 12:
                meses = "diciembre";
                dias = "31";
                break;
            }
            // En este caso no uso el DEFAULT porque ya está controlado el error del mes no válido.

            // Mostramos los datos
            CosasVarias.escribeLinea("El mes " + mes + " corresponde a " + meses + " y tiene " + dias + " días.");
            // Comprobamos bucle general
            CosasVarias.escribe("¿Desea comprobar más meses? (S/N): ");
            SioNo = entrada.next().charAt(0);
            if (SioNo == 'n' || SioNo == 'N') {
                bucle = false;
            } else {
                bucle = true;
            }
        }
        // cerrar scanner
        entrada.close();
    }
}