package tema3;

/**
 * UsaSobrecarga
 */
public class UsaSobrecarga {

    public static void main(String[] args) {
        Sobrecarga cosa1 = new Sobrecarga(1, 2);
        Sobrecarga cosa2 = new Sobrecarga(11, 22, 33);

        System.out.println("Suma de dos de cosa1: " + cosa1.sumar());
        System.out.println("Suma de dos por parámetro de cosa1: " + cosa1.sumar("dos"));

        System.out.println("Suma de dos por parámetro de cosa2: " + cosa2.sumar("dos"));
        System.out.println("Suma de tres por parámetro de cosa2: " + cosa2.sumar("tres"));
    }
}