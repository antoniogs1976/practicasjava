package basedatos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Locale;
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
        Utilidades.limpiarPantalla();
        System.out.println("################################################################################");
        System.out.println("##                  JavAgendaDB - Base de Datos de Contactos                  ##");
        System.out.println("################################################################################");
        System.out.println("##  1.- Añadir un contacto a la Base de Datos                                 ##");
        System.out.println("##  2.- Borrar un contacto de la Base de Datos                                ##");
        System.out.println("##  3.- Editar un contacto de la Base de Datos                                ##");
        System.out.println("##  4.- Buscar un contacto de la Base de Datos                                ##");
        System.out.println("##  ------------------------------------------------------------------------  ##");
        System.out.println("##  5.- Listar todos los contactos de la Base de Datos                        ##");
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
     * @return Devuelve <code>true</code> si todo ha ido bien, <code>false</code> en
     *         caso de error.
     */
    public static boolean menuAlta(Scanner entradaDatos, Connection con, Contacto contacto) {
        boolean resultado = false;
        int codigo;;
        String nombre;
        String telefono;
        Utilidades.limpiarPantalla();
        entradaDatos.nextLine();
        System.out.println("################################################################################");
        System.out.println("##                     JavAgendaDB - Dar de Alta Contacto                     ##");
        System.out.println("################################################################################");
        codigo = BDUtil.contarRegistros(con) + 1;
        System.out.println("Código (autogenerado): " + codigo);
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
            contacto.setCodigo(codigo);
            contacto.setNombre(nombre);
            contacto.setTelefono(telefono);
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    /**
     * Método para mostrar el menú de dar de baja contactos de la agenda
     * 
     * @param entradaDatos Scanner para la entrada de datos
     * @param con          Connection sobre la que realizar la consulta
     * @return devuelve el código <code>integer</code> del contacto que se quiere
     *         dar de baja, o <code>-1</code> si hay algún error
     */
    public static int menuBorrar(Scanner entradaDatos, Connection con) {
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        String nombre;
        int codigo;
        Utilidades.limpiarPantalla();
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
        System.out.println("--------------------------------------------------------------------------------");
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
     * @return <code>Contacto</code> con los datos modificados
     */
    public static Contacto menuModificar(Scanner entradaDatos, Connection con) {
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        Contacto contacto = new Contacto();
        int codigo;
        String nombre;
        String telefono;
        Utilidades.limpiarPantalla();
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
        System.out.println("--------------------------------------------------------------------------------");
        System.out.print("Introduce el nuevo nombre: ");
        nombre = entradaDatos.nextLine();
        System.out.print("Introduce el nuevo teléfono: ");
        telefono = entradaDatos.nextLine();
        contacto = new Contacto(codigo, nombre, telefono);
        return contacto;
    }

    public static boolean menuConsulta(Scanner entrada, Connection con){
        boolean resultado = false;
        Utilidades.limpiarPantalla();
        entrada.nextLine();
        System.out.println("################################################################################");
        System.out.println("##                 JavAgendaDB - Listado Completo de Contactos                ##");
        System.out.println("################################################################################");
        char tecla;
        do {
            System.out.print("¿Deseas ordenar los contactos por nombre? (S/N): ");
            tecla = entrada.next().toUpperCase().charAt(0);
        } while (tecla != 'S' && tecla != 'N');
        if (tecla == 'S') {
            resultado = true;
        } else {
            resultado = false;
        }
        return resultado;
    }

    /**
     * Método para mostrar el menú de buscar contactos Sólo los muestra por
     * pantalla.
     * 
     * @param entrada <code>Scanner</code> para la entrada de datos.
     * @param con     <code>java.sql.Connection</code> sobre la que realizar la
     *                cosulta.
     */
    public static void menuBuscar(Scanner entrada, Connection con) {
        String cadena;
        char tecla;
        ArrayList<Contacto> coincidencias = new ArrayList<>();
        do {
            Utilidades.limpiarPantalla();
            entrada.nextLine();
            System.out.println("################################################################################");
            System.out.println("##              JavAgendaDB - Buscar Contacto en la Base de Datos             ##");
            System.out.println("################################################################################");
            System.out.println("Por favor, introduce un patrón a buscar en la base de datos:");
            System.out.println("(puede ser nombre (ant, cosa, pep, etc...) o teléfono (646, 6589, etc...))");
            cadena = entrada.nextLine();
            coincidencias = BDUtil.buscarContacto(con, cadena);
            if (coincidencias.size()==0){
                System.out.println("##  ====================      NO HAY COINCIDENCIAS      ====================  ##");
            } else {
                System.out.println("##  ====================          COINCIDENCIAS         ====================  ##");
                for (int i = 0; i < coincidencias.size(); i++) {
                    System.out.println("    " + coincidencias.get(i).getDatos());
                }
            }
            // repetir búsqueda o salir al menu
            do {
                System.out.println("Pulsa B para volver a Buscar, o V para Volver al menú principal: ");
                tecla = entrada.next().toUpperCase().charAt(0);
            } while (tecla != 'B' && tecla != 'V');
        } while (tecla != 'V');
    }

    /**
     * Método que dibuja la "pantalla" de salida del programa
     */
    public static void pantallaSalida() {
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
        Locale loc = new Locale("es", "ES");
        // Scanner par la entrada de datos
        Scanner entrada = new Scanner(System.in, "UTF-8"); // para entrada de datos
        entrada.useLocale(loc);
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
                    if (menuAlta(entrada, con, contacto)) {
                        BDUtil.alta(con, contacto);
                        System.out.println("Operación realizada.");
                    } else {
                        System.out.println("Operación cancelada.");
                    }
                    BDUtil.pulsarTecla(entrada, 'V');
                    break;
                case 2: // Eliminar un contacto de la agenda
                    int resultado = menuBorrar(entrada, con);
                    if (resultado != -1) {
                        if (BDUtil.existeCodigo(con, resultado)) {
                            BDUtil.baja(con, resultado);
                        } else {
                            System.out.println("El código suministrado no existe.");
                        }
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
                case 4: // Buscar un contacto en la agenda
                    menuBuscar(entrada, con);
                    break;
                case 5: // Ver los contactos de la agenda
                    boolean tipoConsulta = menuConsulta(entrada, con);
                    if (tipoConsulta){
                        listaContactos = BDUtil.consulta(con, true);
                    } else {
                        listaContactos = BDUtil.consulta(con, false);
                    }
                    // mostrar los contactos en plan listado
                    for (int i = 0; i < listaContactos.size(); i++) {
                        System.out.println(listaContactos.get(i).getDatos());
                    }
                    System.out.println("--------------------------------------------------------------------------------");
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