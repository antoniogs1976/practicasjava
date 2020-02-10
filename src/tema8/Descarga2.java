package tema8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import miscosas.Utilidades;

/**
 * Descarga
 * 
 * Descarga cualquier URL (página web, PDF, imágen...) y la guarda en un fichero
 * utiliza un buffer para leer los datos en bloque
 */
public class Descarga2 {
    public static void main(String[] args) {
        // String url =
        // "https://si.ua.es/es/documentos/documentacion/pdf-s/mozilla12-pdf.pdf";
        //String url = "https://socialescepcor.files.wordpress.com/2017/04/atlas9.jpg";
        // String url = "https://archive.org/download/TheBookOf100Homes1952/TheBookOf100Homes-19520001_jp2.zip";
        String url = "https://cdimage.debian.org/debian-cd/current/amd64/iso-cd/debian-10.2.0-amd64-netinst.iso";
        //String fichero = "/datos/atlas.jpg";
        String fichero = "/datos/debian.iso";

        URL direccion = null; // lo asignamos luego en el try-catch
        URLConnection conexion = null; // lo asignamos luego en el try-catch
        InputStream entrada; // lo asignamos luego en el try-catch
        File archivoDescarga = new File(fichero);
        OutputStream salida = null; // lo asignamos ¿dónde? ¡EXACTO! en el try-catch
        int numBytes;
        byte[] buffer = new byte[65535];
        try {
            // Preparar la enetrada
            direccion = new URL(url);
            conexion = direccion.openConnection();
            entrada = conexion.getInputStream();
            // preparar salida
            salida = new FileOutputStream(archivoDescarga);
            // bucle de lectura-escritura
            // lectura sin buffer
            long inicioBucle = System.nanoTime();
            // do {
            // numBytes = entrada.read(); // sin buffer
            // if (numBytes != -1) {
            // salida.write(numBytes);
            // }
            // } while (numBytes != -1);
            // lectura con buffer

            // Sacamos por pantalla el tipo de fichero
            System.out.println("Tipo de contenido: " + conexion.getContentType());
            System.out.println("Descargando...");
            do {
                numBytes = entrada.read(buffer); // con buffer
                if (numBytes != -1) {
                    salida.write(buffer, 0, numBytes);
                }
            } while (numBytes != -1);
            salida.close();
            System.out.println();
            long finBucle = System.nanoTime();
            System.out.println(Utilidades.medirTiempoEjecucion("bucle de lectura-escritura", inicioBucle, finBucle));
        } catch (MalformedURLException murl) {
            System.out.println("* ERROR: " + murl.getMessage());
            System.out.println("* CAUSA: " + murl.getCause());
            murl.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("* ERROR: " + ioe.getMessage());
            System.out.println("* CAUSA: " + ioe.getCause());
            ioe.printStackTrace();

        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
            System.out.println("* CAUSA: " + e.getCause());
            e.printStackTrace();
        }
    }
}