package tema8;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import miscosas.Utilidades;

/**
 * PaginaWeb2
 * 
 * lee una página web y la guarda en un fichero (sólo tipo texto y sin CSS ni nada)
 * (reduce las instrucciones)
 */
public class PaginaWeb2 {

    public static void main(String[] args) {
        final String RUTA_DESCARGAS = "/datos/webs/";
        
        // medir la carga.
        long inicio = System.nanoTime();
        try {
            System.out.println("conectando a internet...");
            URL direccion = new URL("http://jumilla.org/");
            //URLConnection conexion = direccion.openConnection();
            InputStream canalEntrada = direccion.openStream();
            InputStreamReader lector = new InputStreamReader(canalEntrada);
            BufferedReader entrada = new BufferedReader(lector);
            String linea = "";
            FileWriter fichero = new FileWriter(RUTA_DESCARGAS+"jumilla2.html");
            PrintWriter salida = new PrintWriter(fichero);
            long inicio2 = System.nanoTime();
            do{
                linea = entrada.readLine();
                if (linea != null){
                    salida.println(linea);
                }
            } while (linea != null);
            long fin2 =System.nanoTime();
            salida.close();
            System.out.println(Utilidades.medirTiempoEjecucion("guardar página en disco", inicio2, fin2));

        } catch (Exception e) {
            System.out.println("* ERROR: " + e.getMessage());
            System.out.println("* ERROR: " + e.getCause());
            System.out.println("* ERROR:");
            e.printStackTrace();
            System.out.println("* ERROR:");
            e.getSuppressed();
        }
        long fin = System.nanoTime();
        System.out.println(Utilidades.medirTiempoEjecucion("tiempo total", inicio, fin));
    }
}