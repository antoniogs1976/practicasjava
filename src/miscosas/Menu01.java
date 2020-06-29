package miscosas;

import java.util.Scanner;

/**
 * Menu01
 */
public class Menu01 {

    public static int menu() {
        int selection;
        Scanner entrada = new Scanner(System.in);
        /***************************************************/
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("Ejercicios 2. Condicionales, bucles y arrays");
        MisClases.escribeLinea("Elije el ejercicio a ejecutar:");
        MisClases.escribeLinea("------------------------------\n");
        MisClases.escribeLinea(" 0 - Ejercicio 01");
        MisClases.escribeLinea(" 1 - Ejercicio 02");
        MisClases.escribeLinea(" 2 - Ejercicio 03");
        MisClases.escribeLinea(" 3 - Ejercicio 04");
        MisClases.escribeLinea(" 4 - Ejercicio 05");
        MisClases.escribeLinea(" 5 - Ejercicio 06");
        MisClases.escribeLinea(" 6 - Ejercicio 07");
        MisClases.escribeLinea(" 7 - Ejercicio 08");
        MisClases.escribeLinea(" 8 - Ejercicio 09");
        MisClases.escribeLinea(" 9 - Ejercicio 10");
        MisClases.escribeLinea("------------------------------");
        MisClases.escribeLinea("99 - Salir");

        selection = entrada.nextInt();
        entrada.close();    // BORRAR ESTO
        return selection;
    }

    public static int subMenu() {
        int selection;
        Scanner entrada = new Scanner(System.in);
        /***************************************************/
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("Elije qué versión ejecutar:");
        MisClases.escribeLinea("---------------------------\n");
        MisClases.escribeLinea(" 0 - Versión 1");
        MisClases.escribeLinea(" 1 - Versión 2");
        MisClases.escribeLinea(" 2 - Versión 3");
        MisClases.escribeLinea("------------------------------");
        MisClases.escribeLinea("99 - volver");

        selection = entrada.nextInt();
        entrada.close();    // BORRAR ESTO
        return selection;
    }

    /*********************************************************************************************/

    public static void main(String[] args) {
        int userChoice, userSubChoice;
        boolean bucle = true, bucle2 = true;
        /*********************************************************/
        while (bucle){
            userChoice = menu();
            switch (userChoice) {
            case 0:
                // lo que tenga que hacer
                break;
            case 1:
                // lo que tenga que hacer
                break;
            case 2:
                // lo que tenga que hacer
                break;
            case 3:
                // lo que tenga que hacer
                break;
            case 4:
                // lo que tenga que hacer
                break;
            case 5:
                // lo que tenga que hacer
                break;
            case 6:
                // lo que tenga que hacer
                break;
            case 7:
                userSubChoice = subMenu();
                while (bucle2){
                    switch (userSubChoice) {
                    case 0:
                        // lo que tenga que hacer
                        bucle2 = false;
                        break;
                    case 1:
                        // 
                        bucle2 = false;
                        break;
                    case 2:
                        //
                        bucle2 = false;
                        break;
                    }
                }
                break;
            case 8:
                // lo que tenga que hacer
                break;
            case 9:
                // lo que tenga que hacer
                break;
            case 99:
                bucle = false;
                break;
            }
        }
    }
}