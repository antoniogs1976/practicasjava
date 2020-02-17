package basedatos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import miscosas.Utilidades;

/**
 * AgendaBD
 */
public class AgendaBD {

    /**
     * Método para mostrar el menú principal de la aplicación
     */
    public static void menuPrincipal() {
        // Utilidades.limpiarPantalla();
        System.out.println("################################################################################");
        System.out.println("##                  JavAgendaDB - Base de Datos de Contactos                  ##");
        System.out.println("################################################################################");
        System.out.println("##  1.- Añadir un contacto a la Base de Datos                                 ##");
        System.out.println("##  2.- Borrar un contacto de la Base de Datos                                ##");
        System.out.println("##  3.- Editar un contacto de la Base de Datos                                ##");
        System.out.println("##  4.- Consultar contactos en la Base de Datos                               ##");
        System.out.println("################################################################################");
        System.out.println("##  9.- Salir de JAVAGENDA BD                                                 ##");
        System.out.println("################################################################################");
    }

    /**
     * Método para mostrar el menú para dar de alta un contacto en la agenda
     * 
     * @param entradaDatos Scanner para la introducción de datos
     * @param con          Connection sobre la que realizar la consulta
     * @param contacto     Contacto en el que almacenar los datos
     */
    public static void menuAlta(Scanner entradaDatos, Connection con, Contacto contacto) {
        int codigo;
        String nombre;
        String telefono;
        // Utilidades.limpiarPantalla();
        entradaDatos.nextLine();
        System.out.println("################################################################################");
        System.out.println("##                     JavAgendaDB - Dar de Alta Contacto                     ##");
        System.out.println("################################################################################");
        System.out.println("Por favor, introduce los datos del contacto.");
        System.out.print("Introduce el nombre (máximo 50 car.): ");
        nombre = entradaDatos.nextLine();
        System.out.print("Introduce el teléfono (máximo 9 car.): ");
        telefono = entradaDatos.nextLine();
        System.out.println("################################################################################");
        System.out.println("Se va a añadir el siguiente contacto:");
        System.out.println(nombre + " - " + telefono);
        char tecla;
        do {
            System.out.println("¿son correctos estos datos? (S/N): ");
            tecla = entradaDatos.next().toUpperCase().charAt(0);
        } while (tecla != 'S' && tecla != 'N');
        if (tecla == 'S') {
            codigo = BDUtil.contarRegistros(con) + 1;
            contacto.setCodigo(codigo);
            contacto.setNombre(nombre);
            contacto.setTelefono(telefono);
        }
    }

    /**
     * Método para mostrar el menú de dar de baja contactos de la agenda
     * 
     * @param entradaDatos Scanner para la entrada de datos
     * @param con          Connection sobre la que realizar la consulta
     * @return Int devuelve el código del contacto que se quiere dar de baja, o -1
     *         si hay algún error
     */
    public static int menuBorrar(Scanner entradaDatos, Connection con) {
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        String nombre;
        int codigo;
        // Utilidades.limpiarPantalla();
        entradaDatos.nextLine();
        System.out.println("################################################################################");
        System.out.println("##                     JavAgendaDB - Dar de Baja Contacto                     ##");
        System.out.println("################################################################################");
        System.out.println("##                Te dispones a borrar un contacto de tú agenda               ##");
        System.out.println("##                      ESTA ACCIÓN NO SE PUEDE DESHACER                      ##");
        System.out.println("################################################################################");
        System.out.println("Por favor, introduce el nombre del contacto a borrar");
        nombre = entradaDatos.nextLine();
        System.out.println("##  ====================          COINCIDENCIAS         ====================  ##");
        coincidencias = BDUtil.consultaNombre(con, nombre);
        for (int i = 0; i < coincidencias.size(); i++) {
            System.out.println(coincidencias.get(i).getDatos());
        }
        System.out.println("################################################################################");
        System.out.print("Por favor, introduce el código del contacto a dar de baja: ");
        codigo = entradaDatos.nextInt();
        System.out.println("Vas a eliminar este contacto:");
        System.out.println(BDUtil.consultaCodigo(con, codigo));
        char tecla;
        do {
            System.out.println("¿Estás completamente seguro? (S/N): ");
            tecla = entradaDatos.next().toUpperCase().charAt(0);
        } while (tecla != 'S' && tecla != 'N');
        if (tecla == 'S') {
            return codigo;
        } else {
            codigo = -1;
            return codigo;
        }
    }

    /**
     * Método para mostrar el menú de modificación de contactos de la agenda
     * 
     * @param entradaDatos Scanner para la entrada de datos
     * @param con          Connection sobre la que realizar la consulta
     * @return Contacto con los datos modificados
     */
    public static Contacto menuModificar(Scanner entradaDatos, Connection con) {
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        Contacto contacto = new Contacto();
        int codigo;
        String nombre;
        String telefono;
        // Utilidades.limpiarPantalla();
        entradaDatos.nextLine();
        System.out.println("################################################################################");
        System.out.println("##                JavAgendaDB - Modificar Datos de un Contacto                ##");
        System.out.println("################################################################################");
        System.out.println("Introduce el nombre del contacto a modificar:");
        nombre = entradaDatos.nextLine();
        System.out.println("##  ====================          COINCIDENCIAS         ====================  ##");
        coincidencias = BDUtil.consultaNombre(con, nombre);

        for (int i = 0; i < coincidencias.size(); i++) {
            System.out.println(coincidencias.get(i).getDatos());
        }
        System.out.print("Por favor, introduce el código del contacto que deseas modifar: ");
        codigo = entradaDatos.nextInt();
        System.out.println("Vas a modificar este contacto:");
        System.out.println(BDUtil.consultaCodigo(con, codigo));
        entradaDatos.nextLine();
        System.out.println("################################################################################");
        System.out.print("Introduce el nuevo nombre: ");
        nombre = entradaDatos.nextLine();
        System.out.print("Introduce el nuevo teléfono: ");
        telefono = entradaDatos.nextLine();
        contacto = new Contacto(codigo, nombre, telefono);
        return contacto;
    }

    public static void pantallaSalida(){
        Utilidades.limpiarPantalla();
        System.out.println("################################################################################");
        System.out.println("##                                                                            ##");
        System.out.println("##                                                                            ##");
        System.out.println("##                        Gracias por usar JavAgendaDB                        ##");
        System.out.println("##                                                                            ##");
        System.out.println("##                                                                            ##");
        System.out.println("################################################################################");
    }

    public static void main(String[] args) {
        // Scanner par la entrada de datos
        Scanner entrada = new Scanner(System.in); // para entrada de datos
        int opcion; // Opción del menú elegida

        Contacto contacto = new Contacto();
        ArrayList<Contacto> listaContactos = new ArrayList<>();

        // abrir conexion
        Connection con = BDUtil.conexion();
        if (con != null) {
            System.out.println("Conexión establecida con éxito");
        }

        // dibujamos el menú principal en bucle
        do {
            menuPrincipal();
            do {
                System.out.print("Elige una opción: ");
                while (!entrada.hasNextInt()) {
                    String input = entrada.next();
                    System.out.printf("\"%s\" no es una opción válida.\n", input);
                }
                opcion = entrada.nextInt();
            } while (opcion < 0);

            // vamos llamando cosas
            switch (opcion) {
            case 1: // Dar de alta un contacto en la agenda
                menuAlta(entrada, con, contacto);
                BDUtil.alta(con, contacto);
                // actualizar los datos (codigo)
                System.out.println("Operación realizada");
                BDUtil.pulsarTecla(entrada, 'V');
                break;
            case 2: // Eliminar un contacto de la agenda
                int resultado = menuBorrar(entrada, con);
                if (resultado != -1) {
                    BDUtil.baja(con, resultado);
                    // actualizar
                }
                break;
            case 3: // Modificar un contacto de la agenda
                Contacto tmp = menuModificar(entrada, con);
                BDUtil.modificar(con, tmp);
                // actualizar los datos (codigo)
                System.out.println("Operación realizada");
                BDUtil.pulsarTecla(entrada, 'V');
                break;
            case 4: // Ver los contactos de la agenda
                listaContactos = BDUtil.consulta(con);
                // mostrar los contactos en plan listado
                for (int i = 0; i < listaContactos.size(); i++) {
                    System.out.println(listaContactos.get(i).getDatos());
                }
                System.out.println("Operación realizada");
                BDUtil.pulsarTecla(entrada, 'V');
                break;
            }
        } while (opcion != 9);
        // mostrar la pantalla de despedida.
        pantallaSalida();
        // cerrar el scanner
        entrada.close();
        // cerrar la conexión a la BBDD
        BDUtil.cerrarConexion(con);
    }
}