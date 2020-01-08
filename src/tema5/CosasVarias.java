package tema5;

/**
 * CosasVarias
 */
public class CosasVarias {

    public static void escribeLinea(String texto){
        System.out.println(texto);
    }

    public static void escribe(String texto){
        System.out.print(texto);
    }

    public static void limpiarPantalla(){
        System.out.flush();
        System.out.print("\033\143");
        System.out.flush();
    }

}