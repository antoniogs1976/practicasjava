package tema8;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Ejemplo de descarga de un fichero de imagen desde la web.
 * 
 * @author chuidiang
 * 
 */
public class PruebaWebJPG {

	/**
	 * Descarga un fichero jpeg y lo guarda en e:/foto.jpg
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
            
			// Url con la foto
            //URL url = new URL("http://mas.lne.es/fotos/img/2007/10/62/203093470447035b9bc5a095.43783284-foto_verano.jpg");

            URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/d/d5/Jumilla._Plaza_de_Arriba.JPG");

			// establecemos conexion
			URLConnection urlCon = url.openConnection();

			// Sacamos por pantalla el tipo de fichero
			System.out.println(urlCon.getContentType());

			// Se obtiene el inputStream de la foto web y se abre el fichero
			// local.
			InputStream is = urlCon.getInputStream();
			FileOutputStream fos = new FileOutputStream("/datos/plazaArriba.jpg");

			// Lectura de la foto de la web y escritura en fichero local
			byte[] array = new byte[4096]; // buffer temporal de lectura.
			int leido = is.read(array);
			while (leido > 0) {
				fos.write(array, 0, leido);
				leido = is.read(array);
			}

			// cierre de conexion y fichero.
			is.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}