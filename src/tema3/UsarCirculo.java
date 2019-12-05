package tema3;

/**
 * UsarCirculo
 */
public class UsarCirculo {

    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(), circulo2 = new Circulo();
        circulo1.x=100;
        circulo1.y=100;
        circulo1.radio=200;
        System.out.print("\033\143");
        System.out.println("circulo1: " + circulo1);
        System.out.println("circulo2: " + circulo2);
    }
}