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
        int numContactos = 0;
        // leer la lista de contactos
        LibreriaAgenda.cargarFichero(listaContactos);
        do {
            numContactos = listaContactos.size();
            LibreriaAgenda.menu(numContactos);
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    LibreriaAgenda.menuAnadir(entrada, listaContactos);
                    break;
                case 2:
                    LibreriaAgenda.borrarContacto(entrada, listaContactos);
                    break;
                case 3:
                    LibreriaAgenda.listarContactos(entrada, listaContactos);
                    break;
                case 4:
                    LibreriaAgenda.menuGuardarContactos(entrada, listaContactos);
                    break;
                case 5:
                    LibreriaAgenda.buscarContacto(entrada, listaContactos);
                    break;
                default:
                    break;
            }

        } while (opcion != 9);
        LibreriaAgenda.salir(entrada, listaContactos);
        entrada.close();
    }
}