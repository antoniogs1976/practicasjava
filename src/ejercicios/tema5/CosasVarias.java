package ejercicios.tema5;

import java.time.LocalDateTime;

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
        escribe("\033\143");
    }

    public static void main(String[] args) {
        LocalDateTime cosaCalendario = LocalDateTime.now();
    }

}