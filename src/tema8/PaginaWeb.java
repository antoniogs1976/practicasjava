package tema8;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import miscosas.Utilidades;

/**
 * PaginaWeb
 */
public class PaginaWeb {

    public static void main(String[] args) {
        final String RUTA_DESCARGAS = "/datos/webs/";
        final String WEB = "http://jumilla.org/";

        URL direccion = null;
        URLConnection conexion = null;
        InputStream canalEntrada = null;
        BufferedReader bufferEntrada = null;

        FileWriter paginaEscribir = null;
        PrintWriter bloqueEscribir = null;

        String contenido = "";
        long inicio = System.nanoTime();
        try {
            // direccion a la que conectar
            System.out.println("conectando a internet...");
            direccion = new URL(WEB);
            // conexión a usar ("tunel" a usar)
            conexion = direccion.openConnection();
            conexion.connect();
            // canal de lectura ("Tunel" a usar)
            canalEntrada = conexion.getInputStream();
            // crear el buffer de entrada para ir leyendo la página
            bufferEntrada = new BufferedReader(new InputStreamReader(canalEntrada));
            String inputLine;
            System.out.println("leyendo web...");
            while ((inputLine = bufferEntrada.readLine()) != null) {
                contenido += inputLine + "\n";
            }
            
        } catch (Exception e) {
            System.out.println("* ERROR: "+e.getMessage()+e.getCause());
        }
        long fin = System.nanoTime();
        System.out.println("página leída, intentando escribirla en disco");
        System.out.println("Página leída en " + Utilidades.medirTiempoEjecucion(inicio, fin) + "ms");

        // escribir el arhcivo leido
        inicio = System.nanoTime();
        try {
            System.out.println("escribiendo...");
            paginaEscribir = new FileWriter(RUTA_DESCARGAS+"jumilla2.html", false);
            bloqueEscribir = new PrintWriter(paginaEscribir);
            bloqueEscribir.write(contenido);
            paginaEscribir.close();
            System.out.println("página escrita.");
        } catch (IOException e) {
            System.out.println("* ERROR: " + e.getMessage() + e.getCause());
        } catch (NullPointerException e) {
            System.out.println("* ERROR: " + e.getMessage()+e.getCause());
        }
        fin = System.nanoTime();
        System.out.println("Página escirta en " + Utilidades.medirTiempoEjecucion(inicio, fin)+"ms");
    }
}