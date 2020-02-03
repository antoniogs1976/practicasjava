package tema8;

import java.io.File;
import java.io.IOException;
import miscosas.Utilidades;


/**
 * ficheros5
 */
public class ficheros5 {

    public static void main(String[] args) {
        File archivo = new File("datos/contactos2.txt");

        Utilidades.limpiarPantalla();
        // crear archivo
        try {
            archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // info del archivo
        InfoArchivo.info(archivo.getAbsolutePath());
        // crear 5 carpetas en datos con el nombre base de "cosa"
        InfoArchivo.cearCarpetas(5, "datos", "Cosa");
    }
}