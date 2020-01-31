package tema8;

import java.io.File;

/**
 * InfoArchivo
 */
public class InfoArchivo {
    // Constantes
    private static final String SI = "Si";
    private static final String NO = "No";

    public static void info(String archivo) {
        File fichero = new File(archivo);
        System.out.println("##···················· INFORMACIÓN DEL ARCHIVO ····················##");
        System.out.println("##  Archivo            : " + fichero.getName());
        System.out.println("##  Path               : " + fichero.getPath());
        System.out.println("##  Path Absoluto:     : " + fichero.getAbsolutePath());
        System.out.println("##  Path Superior      : " + fichero.getParent());
        System.out.println("##·································································##");
        if (fichero.exists()) {
            System.out.println("##  Existe             : " + SI + "                                        ##");
            if (fichero.canWrite()){
                System.out.println("##  ¿Se puede escribir?: " + SI + "                                        ##");
            } else {
                System.out.println("##  ¿Se puede escribir?: " + NO + "                                        ##");
            }
            if (fichero.canRead()){
                System.out.println("##  ¿Se puede leer?    : " + SI + "                                        ##");
            } else {
                System.out.println("##  ¿Se puede leer?    : " + NO + "                                        ##");
            }
            if (fichero.isDirectory()){
                System.out.println("##  ¿Es un directorio? : " + SI + "                                        ##");
            } else {
                System.out.println("##  ¿Es un directorio? : " + NO + "                                        ##");
            }
            System.out.println("    Tamaño en bytes    : " + fichero.length());
        } else {
            System.out.println("##     El archivo no existe y no se puede ver su información     ##");
        }
        System.out.println("##·································································##");
    }

    public static void cearCarpetas(int numeroCarpetas, String directorioBase, String baseNombre){
        File carpeta = null;
        String nombreCompleto = directorioBase+"/"+baseNombre;
        for (int i=1; i <= numeroCarpetas;i++){
            carpeta = new File(nombreCompleto+i);
            carpeta.mkdir();
            System.out.println("Carpeta "+nombreCompleto+i+" creada");
        }
    }

}