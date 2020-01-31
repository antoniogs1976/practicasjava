package tema8;

import java.io.File;
import java.io.IOException;
import miscosas.Utilidades;


/**
 * ficheros5
 */
public class ficheros5 {

    public static void main(String[] args) {
        File fichero = new File("c:/datos/contactos2.txt");

        Utilidades.limpiarPantalla();
        // crear fichero
        try {
            fichero.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InfoArchivo.info(fichero.getPath());
        System.out.println(fichero.list());
        // crear 5 carpetas en c:/datos con el nombre base de "cosa"
        InfoArchivo.cearCarpetas(5, "c:/datos", "Cosa");
    }
}