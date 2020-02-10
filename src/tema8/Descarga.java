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
 */
public class Descarga {
    public static void main(String[] args) {
        
        long inicioGeneral = System.nanoTime(); // para medir el tiempo general 
        //String url = "https://si.ua.es/es/documentos/documentacion/pdf-s/mozilla12-pdf.pdf";
        String url = "https://upload.wikimedia.org/wikipedia/commons/d/d5/Jumilla._Plaza_de_Arriba.JPG";
        String fichero = "/datos/imagen.jpg";

        URL direccion = null; // lo asignamos luego en el try-catch
        URLConnection conexion = null; // lo asignamos luego en el try-catch
        InputStream entrada; // lo asignamos luego en el try-catch
        File archivoDescarga =  new File(fichero);
        OutputStream salida = null; // = new FileOutputStream(archivoDescarga);
        int leido;
        try {
            // Preparar la enetrada
            direccion = new URL(url);
            conexion = direccion.openConnection();
            entrada = conexion.getInputStream();
            // preparar salida
            salida = new FileOutputStream(archivoDescarga);
            // bucle de lectura-escritura
            long inicioBucle = System.nanoTime();
            do{
                leido = entrada.read();   // sin buffer
                if (leido != -1){
                    salida.write(leido);   
                }
            } while (leido != -1);
            long finBucle = System.nanoTime();
            salida.close();
            
            System.out.println(Utilidades.medirTiempoEjecucion("bucle de lectura-escritura", inicioBucle, finBucle));
        } catch (MalformedURLException murl){
            System.out.println("* ERROR: " + murl.getMessage());
            System.out.println("* CAUSA: " + murl.getCause());
            murl.printStackTrace();
        } catch (IOException ioe){
            System.out.println("* ERROR: " + ioe.getMessage());
            System.out.println("* CAUSA: " + ioe.getCause());
            ioe.printStackTrace();

        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
            System.out.println("* CAUSA: " + e.getCause());
            e.printStackTrace();
        }

        long finalGeneral = System.nanoTime();
        System.out.println(Utilidades.medirTiempoEjecucion("general", inicioGeneral, finalGeneral));
    }
}