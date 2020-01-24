package tema8;

import miscosas.Utilidades;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ficheros4
 * 
 * escribir objetos en fichero (binario)
 * leer esos objetos y mostrarlos por pantalla
 */
public class ficheros4 {

    public static void escribir(String nombreFichero){
        Persona jose = new Persona("11111111A", "José", "García García");
        Persona pedro = new Persona("22222222B", "Pedro", "López Marín");
        FileOutputStream fichero = null;
        ObjectOutputStream salida = null;
        // 1 abrir fichero
        // 2 abrir canal de salida
        // 3 escribir los objetos
        // 4 cerrar el fichero
        System.out.println("# INTENTAR ESCRIBIR LOS DATOS... #");
        try {
            // 1
            fichero = new FileOutputStream(nombreFichero);
            // 2
            salida = new ObjectOutputStream(fichero);
            // 3
            salida.writeObject(jose);
            salida.writeObject(pedro);
            // 4
            fichero.close();
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
        }
        System.out.println("# DATOS ESCRITOS Y FICHERO CERRADO #");
    }

    public static void leer(String nombreFichero){
        Persona jose = null;
        Persona pedro = null;
        FileInputStream fichero = null;
        ObjectInputStream entrada = null;
        
        System.out.println("# INTENTAR LEER LOS DATOS... #");
        try {
            fichero = new FileInputStream(nombreFichero);
            entrada = new ObjectInputStream(fichero);
            jose = (Persona) entrada.readObject();
            pedro = (Persona) entrada.readObject();
            fichero.close();
        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
        }
        System.out.println("# DATOS LEÍDOS Y FICHERO CERRADO #");
        System.out.println("---------- MOSTRAR DATOS LEÍDOS EN LOS OBJETOS ----------");
        System.out.println("Datos Persona 1 (José):");
        System.out.println(jose.getAtributos());
        System.out.println("Datos Persona 2 (Pedro):");
        System.out.println(pedro.getAtributos());
    }

    public static void main(String[] args) {
        // variables y demás

        // hacer cosas
        Utilidades.limpiarPantalla();
        escribir("c:/datos/personas.dat");
        leer("c:/datos/personas.dat");
    }
}