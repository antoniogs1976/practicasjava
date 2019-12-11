package tema3;

/**
 * VariableLocal
 */
public class VariableLocal {
    public static String saludo(String nombre) {
        // Variable local sólo accesible desde este método
        String texto = "Buenos días ";
        return texto + nombre;
    }
    public static void main(String[] args) {
        String miNombre = "Antonio";

        System.out.println(saludo(miNombre));
    }
}