package tema8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Agenda
 */
public class Agenda {

    public static void main(String[] args) {
        ArrayList<String> listaContactos = new ArrayList<String>();
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            LibreriaAgenda.menu();
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    LibreriaAgenda.menuAnadir(entrada, listaContactos);
                    break;
                case 2:
                    LibreriaAgenda.listarClientes(entrada, listaContactos);
                    break;
                case 3:
                    LibreriaAgenda.guardarClientes(, listaContactos);
                    break;
                default:
                    break;
            }

        } while (opcion != 9);
        entrada.close();
    }
}