package tema7;

import miscosas.MisClases;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * GestionClientes
 */
public class GestionClientes {
    private static class Cliente {
        String nif;
        String nombre;
        String apellido;
        int edad;

        // Constructor
        public Cliente(String nif, String nombre, String apellido, int edad) {
            this.nif = nif;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
        }

        // Getters y Setters
        public String getNif() {
            return nif;
        }

        public void setNif(String nif) {
            this.nif = nif;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }
    }

    public static int menu(Scanner entradaDatos) {
        int retorno;
        do {
            // limpiar pantalla
            MisClases.limpiarPantalla();
            MisClases.escribeLinea("************************************************************");
            MisClases.escribeLinea("**                  GESTIÓN DE CLIENTES                   **");
            MisClases.escribeLinea("************************************************************");
            MisClases.escribeLinea("**  1.- Añadir cliente                                    **");
            MisClases.escribeLinea("**  2.- Borrar cliente                                    **");
            MisClases.escribeLinea("**  3.- Listar clientes                                   **");
            MisClases.escribeLinea("**  4.- Salir                                             **");
            MisClases.escribeLinea("************************************************************");
            MisClases.escribe("Selecciona una opción y pulsa Enter: ");
            retorno = entradaDatos.nextInt();
        } while (retorno < 1 || retorno > 4);
        return retorno;
    } // menu

    public static boolean anadirCliente(Scanner entradaDatos, ArrayList<Cliente> lista) {
        boolean retorno = false;
        Cliente nuevoCliente;
        char tecla;
        String vNIF, vNombre, vApellido;
        int vEdad, contador, posicion;
        contador = lista.size();
        // limpiar pantalla
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("**                     AÑADIR CLIENTE                     **");
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("Introduce los datos del cliente:");
        MisClases.escribe("N.I.F.: ");
        vNIF = entradaDatos.next();
        MisClases.escribe("Nombre: ");
        vNombre = entradaDatos.next();
        MisClases.escribe("Apellido: ");
        vApellido = entradaDatos.next();
        MisClases.escribe("Edad: ");
        vEdad = entradaDatos.nextInt();
        do{
            MisClases.escribe("¿En qué posición quieres insertarlo? (0-"+contador+"): ");
            posicion = entradaDatos.nextInt();
        } while(posicion < 0 && posicion > contador);
        do{
            MisClases.escribeLinea("¿Añadir este cliente? (S/N): ");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S' && tecla == 'n' && tecla == 'N');
        if (tecla == 's' || tecla == 'S'){
            nuevoCliente = new Cliente(vNIF, vNombre, vApellido, vEdad);
            retorno = lista.add(nuevoCliente);
        } else {
            retorno = false;
        }
        return retorno;
    }

    public static boolean borrarCliente(Scanner entradaDatos, ArrayList<Cliente> lista) {
        boolean retorno;
        int eleccion;
        char tecla;
        // limpiar pantalla
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("**                     BORRAR CLIENTE                     **");
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("Te dispones a eliminar un cliente de la lista.");
        MisClases.escribeLinea("Asegúrate de que es el número correcto.");
        MisClases.escribeLinea("Por favor, introduce el número del cliente (0 a " + lista.size() + "): ");
        eleccion = entradaDatos.nextInt();
        MisClases.escribeLinea("Has introducido " + eleccion + " como número de cliente a borrar.");
        do {
            MisClases.escribe("¿Estás completamente seguro? (Esta acción no se puede deshacer) (S/N): ");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S' && tecla == 'n' && tecla == 'N');
        if (tecla == 's' || tecla == 'S') {
            // Borrar
            MisClases.escribeLinea("Borrar");
            retorno = true;
        } else {
            // No borrar
            MisClases.escribeLinea("No Borrar");
            retorno = false;
        }
        return retorno;
    }

    public static void listarClientes(Scanner entradaDatos, ArrayList<Cliente> lista) {
        // limpiar pantalla
        char tecla;
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("**                   LISTADO DE CLIENTE                   **");
        MisClases.escribeLinea("************************************************************");
        for (int i = 0; i< lista.size();i++){
            MisClases.escribeLinea(i+" - "+datosCliente(lista.get(i)));
        }
        do{
            MisClases.escribeLinea("(pulsa S y presiona Enter para volver al menú)");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S');
    }

    public static String datosCliente(Cliente cliente){
        String retorno = "";
        retorno = cliente.getNif()+" - "+cliente.getNombre()+" "+cliente.getApellido()+" - Edad: "+cliente.getEdad()+" años.";
        return retorno;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Cliente> listadoClientes = new ArrayList<Cliente>();
        int itemMenu = 0;
        while (itemMenu != 4) {
            itemMenu = menu(entrada);
            switch (itemMenu) {
            case 1:     // Añadir cliente
                anadirCliente(entrada, listadoClientes);
                break;
            case 2:     // Borrar cliente
                borrarCliente(entrada, listadoClientes);
                break;
            case 3:     // Listado de clientes
                listarClientes(entrada, listadoClientes);
                break;
            }
        }
        // cerrar el scanner
        entrada.close();
    }
}