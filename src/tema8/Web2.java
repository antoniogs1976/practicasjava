package tema8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Web2
 */
public class Web2 {

    public static String getContenidoHTML(String direccionWeb) throws IOException {
        URL url = new URL(direccionWeb);
        URLConnection uc = url.openConnection();
        uc.connect();
        //Creamos el objeto con el que vamos a leer
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        String contenido = "";
        while ((inputLine = in.readLine()) != null) {
            contenido += inputLine + "\n";
        }
        in.close();
        return contenido;
    }

    public static void main(String[] args) {
        try{
            System.out.println(getContenidoHTML("http://www.jumilla.org"));

        } catch (IOException e){
            System.out.println("* Error: "+e.getMessage());
            System.out.println("* Error: "+e.getCause());
        }
    }
}