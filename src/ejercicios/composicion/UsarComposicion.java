package ejercicios.composicion;

/**
 * UsarComposicion
 */
public class UsarComposicion {
    // para limpiar la pantalla antes de escribir
    public static void limpiarPantalla() {
		System.out.print("\033\143");
    }
    
    // para no tener que escribir tanto...
    public static void escribir(String texto){
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Coche miCoche = new Coche("Seat","Ibiza","Verde");
        Motor miMotor = new Motor(1200, 100, "Gasolina");
        Rueda miRueda = new Rueda(16);
        Puerta miPuerta = new Puerta(true);

        // Limpiar
        limpiarPantalla();
        // Mostramos algunos datos
        escribir("*------------------------------------------------------------------------------*");
        escribir("*                      D A T O S   D E   M I   C O C H E                       *");
        escribir("*------------------------------------------------------------------------------*");
        escribir("*      Marca : "+miCoche.getMarca() + "       -       Modelo:"+miCoche.getModelo() +"       -       Color : " + miCoche.getColor()+"     *");
        escribir("*   Motor de "+miMotor.getCilindrada()+"cc - Potencia de " + miMotor.getPotencia()+" caballos - Usa de combustible: "+miMotor.getCombustible()+"  *");
        escribir("*-------------------------------- E X T R A S ---------------------------------*");
        escribir("*        Elevalunas Eléctrico: " + miPuerta.isElevalunasElectrico()+"        -        Ruedas de " + miRueda.getDiametro()+" pulgadas        *");
        escribir("*------------------------------------------------------------------------------*");
    }
}