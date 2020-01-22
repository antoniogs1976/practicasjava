package tema7;

import miscosas.MisClases;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * GestionClientes
 */
public class GestionClientes {
    // --------------------------------------------- \\
    // ------------------- CLASES ------------------ \\
    // --------------------------------------------- \\

    /**
     * CLASE CLIENTE
     */
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

        // public void setNif(String nif) {
        // this.nif = nif;
        // }

        public String getNombre() {
            return nombre;
        }

        // public void setNombre(String nombre) {
        // this.nombre = nombre;
        // }

        public String getApellido() {
            return apellido;
        }

        // public void setApellido(String apellido) {
        // this.apellido = apellido;
        // }

        public int getEdad() {
            return edad;
        }

        // public void setEdad(int edad) {
        // this.edad = edad;
        // }

        // Otros Métodos
        public String datosCliente() {
            String retorno = "";
            retorno = this.getNif() + " - " + this.getNombre() + " " + this.getApellido() + " - Edad: " + this.getEdad()
                    + " años.";
            return retorno;
        }
    } // clase cliente

    // --------------------------------------------- \\
    // ------------------- MÉTODOS ----------------- \\
    // --------------------------------------------- \\

    /**
     * Método para dibujar el menú principal
     * 
     * @param entradaDatos Scanner para la entrada de datos
     * @return devuelve un entero con la opción seleccionada del menú
     */
    public static int menu(Scanner entradaDatos) {
        int retorno;
        // ************************************************************ \\
        do {
            MisClases.limpiarPantalla();
            MisClases.escribeLinea("************************************************************");
            MisClases.escribeLinea("**                  GESTIÓN DE CLIENTES                   **");
            MisClases.escribeLinea("************************************************************");
            MisClases.escribeLinea("**  1.- Añadir cliente                                    **");
            MisClases.escribeLinea("**  2.- Borrar cliente                                    **");
            MisClases.escribeLinea("**  3.- Listar clientes                                   **");
            MisClases.escribeLinea("**  4.- Calcular media de edad                            **");
            MisClases.escribeLinea("**  5.- Salir                                             **");
            MisClases.escribeLinea("************************************************************");
            MisClases.escribe("Selecciona una opción y pulsa Enter: ");
            retorno = entradaDatos.nextInt();
        } while (retorno < 1 || retorno > 5);
        return retorno;
    } // menu

    /**
     * Método para dibujar el menú de añadir cliente
     * 
     * @param entradaDatos Scanner para la entrada de datos
     * @param lista        ArrayList<Cliente> con los datos de los clientes
     * @return Devuelve un boolean que se puede usar para control de errores
     */
    public static boolean anadirCliente(Scanner entradaDatos, ArrayList<Cliente> lista) {
        boolean retorno = false;
        Cliente nuevoCliente;
        char tecla;
        String vNIF = "", vNombre = "", vApellido = "";
        int vEdad = 0, contador, posicion;
        // ************************************************************ \\
        // Vaciar el Buffer de la entrada de texto
        entradaDatos.nextLine();
        contador = lista.size();
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("**                     AÑADIR CLIENTE                     **");
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("Introduce los datos del cliente:");
        MisClases.escribe("N.I.F.: ");
        vNIF = entradaDatos.nextLine();
        MisClases.escribe("Nombre: ");
        vNombre = entradaDatos.nextLine();
        MisClases.escribe("Apellido: ");
        vApellido = entradaDatos.nextLine();
        MisClases.escribe("Edad: ");
        vEdad = entradaDatos.nextInt();
        // Comprobar que la posición es válida
        do {
            MisClases.escribe("¿En qué posición quieres insertarlo? (0-" + contador + "): ");
            posicion = entradaDatos.nextInt();
        } while (posicion < 0 || posicion > contador);
        // Comprobar qué tecla es la que se pulsa para continuar o no
        do {
            MisClases.escribe("¿Añadir este cliente? (S/N): ");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S' && tecla == 'n' && tecla == 'N');
        // Si se "continúa" con la S, añadir el cliente
        if (tecla == 's' || tecla == 'S') {
            nuevoCliente = new Cliente(vNIF, vNombre, vApellido, vEdad);
            retorno = lista.add(nuevoCliente);
        } else {
            retorno = false;
        }
        return retorno;
    } // anadirCliente

    /**
     * Método para dibujar el menú de borrar cliente
     * 
     * @param entradaDatos Scanner para la entrada de datos
     * @param lista        ArrayList<Cliente> con los datos de los clientes
     * @return devuelve un boolean que se puede usar para control de errores
     */
    public static boolean borrarCliente(Scanner entradaDatos, ArrayList<Cliente> lista) {
        boolean retorno;
        int eleccion;
        char tecla;
        // ************************************************************ \\
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("**                     BORRAR CLIENTE                     **");
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("Te dispones a eliminar un cliente de la lista.");
        MisClases.escribeLinea("Asegúrate de que es el número correcto.");
        MisClases.escribeLinea("Por favor, introduce el número del cliente (0 a " + (lista.size() - 1) + "): ");
        eleccion = entradaDatos.nextInt();
        MisClases.escribeLinea("Has introducido " + eleccion + " como número de cliente a borrar.");
        // mostrar datos cliente
        MisClases.escribeLinea(lista.get(eleccion).datosCliente());
        do {
            MisClases.escribe("¿Estás completamente seguro? (Esta acción no se puede deshacer) (S/N): ");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S' && tecla == 'n' && tecla == 'N');
        if (tecla == 's' || tecla == 'S') {
            // Borrar
            lista.remove(eleccion);
            retorno = true;
        } else {
            // No borrar
            retorno = false;
        }
        return retorno;
    } // borrarCliente

    /**
     * Método para dibujar el listado de clientes
     * 
     * @param entradaDatos Scanner para la entrada de datos
     * @param lista        ArrayList<Cliente> con los datos de los clientes
     */
    public static void listarClientes(Scanner entradaDatos, ArrayList<Cliente> lista) {
        char tecla;
        // ************************************************************ \\
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("**                   LISTADO DE CLIENTE                   **");
        MisClases.escribeLinea("************************************************************");
        if (lista.size() == 0) {
            MisClases.escribeLinea("Todavía no hay ningún cliente.");
        } else {
            for (int i = 0; i < lista.size(); i++) {
                MisClases.escribeLinea(i + " - " + lista.get(i).datosCliente());
            }
        }
        do {
            MisClases.escribeLinea("(pulsa S y presiona Enter para volver al menú)");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S');
    } // listarClientes

    /**
     * Método para mostrar la media de edad de los clientes
     * 
     * @param entradaDatos      Scanner para la entrada de datos
     * @param listadoClientes   ArrayList<Cliente> con los datos de los clientes
     */
    private static void mostrarMedia(Scanner entradaDatos, ArrayList<Cliente> listadoClientes) {
        int numClientes;
        double media = 0.0;
        char tecla;
        // ************************************************************ \\
        MisClases.limpiarPantalla();
        MisClases.escribeLinea("************************************************************");
        MisClases.escribeLinea("**             MEDIA DE EDAD DE LOS CLIENTES              **");
        MisClases.escribeLinea("************************************************************");
        //
        numClientes = listadoClientes.size();
        if (numClientes != 0) {
            media = calcularMedia(listadoClientes);
            MisClases.escribeLinea("Hay " + numClientes + " clientes, con una media de edad de " + media + " años.");
        } else {
            MisClases.escribeLinea("No hay clientes para hacer la media.");
        }
        do {
            MisClases.escribeLinea("(pulsa S y presiona Enter para volver al menú)");
            tecla = entradaDatos.next().charAt(0);
        } while (tecla == 's' && tecla == 'S');
    } // mostrarMedia

    /**
     * Método para calcular la media de edad de los clientes
     * @param listadoClientes   ArrayList<Cliente> con los datos de los clientes
     * @return                  double con la media de edad de los clientes
     */
    private static double calcularMedia(ArrayList<Cliente> listadoClientes){
        double total = 0, retorno = 0;
        if (listadoClientes.size() > 0) {
            for (int i = 0; i < listadoClientes.size(); i++) {
                total += listadoClientes.get(i).getEdad();
            }
            retorno = total / listadoClientes.size();
        } else {
            retorno = 0;
        }
        return retorno;
    } // calcularMedia

    // --------------------------------------------- \\
    // -------------------- MAIN ------------------- \\
    // --------------------------------------------- \\

    public static void main(String[] args) {
        Locale locale = new Locale("spa", "ES"); 
        Scanner entrada = new Scanner(System.in, "UTF-8");
        entrada.useLocale(locale);
        ArrayList<Cliente> listadoClientes = new ArrayList<Cliente>();
        int itemMenu = 0;
        // ************************************************************ \\
        while (itemMenu != 5) {
            itemMenu = menu(entrada);
            switch (itemMenu) {
            case 1: // Añadir cliente
                anadirCliente(entrada, listadoClientes);
                break;
            case 2: // Borrar cliente
                borrarCliente(entrada, listadoClientes);
                break;
            case 3: // Listado de clientes
                listarClientes(entrada, listadoClientes);
                break;
            case 4: // Media de edad
                mostrarMedia(entrada, listadoClientes);
                break;
            default:
                break;
            }
        }
        // cerrar el scanner
        entrada.close();
    }
}