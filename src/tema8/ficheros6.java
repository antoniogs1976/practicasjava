package tema8;

import java.io.File;

/**
 * ficheros6
 */
public class ficheros6 {

    public static void main(String[] args) {
        File carpeta = new File("c:/datos/carpeta");
        File carpeta2 = new File("c:/datos");
       
        carpeta.mkdir();
        System.out.println("Carpeta creada");
        // Crear 10 carpetas
        for (int i = 1; i <= 10; i++) {
            carpeta = new File("c:/datos/carpeta " + i);
            System.out.println("Carpeta creada " + carpeta.getName());
            carpeta.mkdir();           
        }
        // Borrar 10 carpetas
        /*
        for (int i = 1; i <= 10; i++) {
            carpeta = new File("carpeta" + i);
            System.out.println("Eliminando "+carpeta.getName());
            carpeta.delete();           
        }
        */
        // listado
        String[] lista = carpeta2.list();
        for (int i = 0; i < lista.length; i++){
            System.out.println("Listado de carpeta2: "+lista[i]);
        }

    }
}