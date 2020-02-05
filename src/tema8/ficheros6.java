package tema8;

/**
 * https://1lineart.kulaone.com/
 * para sacar las "caritas"
 */

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ficheros6
 */
public class ficheros6 {

    public static void main(String[] args) {
        File carpeta = new File("c:/datos/carpeta");
        File carpeta2 = new File("c:/datos");
        File cosa = null;

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
         * for (int i = 1; i <= 10; i++) { carpeta = new File("carpeta" + i);
         * System.out.println("Eliminando "+carpeta.getName()); carpeta.delete(); }
         */
        System.out.println("");
        System.out.println("*******************************************************************");
        System.out.println("");
        // listado
        System.out.println("Listado de archivos de " + carpeta2.getPath());
        String[] lista = carpeta2.list();
        for (int i = 0; i < lista.length; i++) {
            cosa = new File(carpeta2.getPath() + "/" + lista[i].intern());
            if (cosa.exists()) {
                if (cosa.isFile())
                    System.out.println("Archivo: " + lista[i]);
                else if (cosa.isDirectory())
                    System.out.println("Carpeta: " + lista[i]);
                else
                    System.out.println("Ha pasado algo y no se si es un archivo o una carpeta... ⨌⨀_⨀⨌ ");
            } else {
                System.out.println("El archivo/carpeta no existe (¿?) y no se puede saber qué es... ┌∩┐ (◣_◢) ┌∩┐");
            }
        }

        System.out.println("");
        System.out.println("*******************************************************************");
        System.out.println("");
        // lo mismo, pero primero directorios y luego archivos, en dos pasadas
        for (int i = 0; i < lista.length; i++) {
            cosa = new File(carpeta2.getPath() + "/" + lista[i].intern());
            if (cosa.exists()) {
                if (cosa.isDirectory())
                    System.out.println("Carpeta: " + lista[i]);
            } else {
                System.out.println("El archivo/carpeta no existe (¿?) y no se puede saber qué es... ┌∩┐ (◣_◢) ┌∩┐");
            }
        }

        for (int i = 0; i < lista.length; i++) {
            cosa = new File(carpeta2.getPath() + "/" + lista[i].intern());
            if (cosa.exists()) {
                if (cosa.isFile())
                    System.out.println("Archivo: " + lista[i]);
            } else {
                System.out.println("El archivo/carpeta no existe (¿?) y no se puede saber qué es... ┌∩┐ (◣_◢) ┌∩┐");
            }
        }
        System.out.println("------------------------");
        System.out.println("      ¯\\_(ツ)_/¯ ");

        // *****************************************************************
        // listado con contador de ficheros y tamaño de arhcivos y total:
        System.out.println("Listado de archivos de " + carpeta2.getPath());
        lista = carpeta2.list();
        long totalArchivos = 0, totalCarpetas = 0, tamanoTotal = 0;
        for (int i = 0; i < lista.length; i++) {
            long tamano = 0;
            long ms = 0; // ms de la "fecha"
            String bytes = "", churro = "";
            Date fecha = null;
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/mm/yyyy - HH:mm:ss");
            
            cosa = new File(carpeta2.getPath() + "/" + lista[i].intern());
            if (cosa.exists()) {
                if (cosa.isFile()) {
                    tamano = cosa.length();
                    churro = "Archivo:\t";
                    totalArchivos++;
                    tamanoTotal += tamano;
                } else if (cosa.isDirectory()) {
                    churro = "Carpeta:\t";
                    totalCarpetas++;
                } else {
                    churro ="Ha pasado algo y no se si es un archivo o una carpeta... ⨌⨀_⨀⨌ ";
                }

                churro += lista[i];
                if (cosa.getName().length() < 9){
                    churro+="\t\tbytes\t\t";
                } else {
                    churro+="\tbytes\t";
                }
            } else {
               churro = "El archivo/carpeta no existe (¿?) y no se puede saber qué es... ┌∩┐ (◣_◢) ┌∩┐";
            }
            ms = cosa.lastModified();
            fecha = new Date(ms);
            System.out.println(churro + "\tTamaño:\t" + tamano + bytes + sdf2.format(fecha));
        }
        System.out.println("----------------------------------------");
        System.out.println("Total Carpetas:\t" + totalCarpetas);
        System.out.println("Total Archvios:\t" + totalArchivos);
        System.out.println("Tamaño total:\t" + tamanoTotal + " Bytes");
    }
}