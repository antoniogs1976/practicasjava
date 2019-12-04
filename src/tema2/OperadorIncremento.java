package tema2;

/**
 * OperadorIncremento
 */
public class OperadorIncremento {
    public static void main(String[] args) {
        // El resultado final de la operación es el mismo en ambos casos, pero:
        // - Si el incremento va detrás, primero se usa el valor de la variable y luego se incrementa.
        // - Si el incremento va delante, primero incrementa y después usa el valor
        int a = 1;
        // Para limpiar la consola según stackoverflow
        System.out.print("\033\143");
        System.out.println("------------------------------------------------------------");
        System.out.println("La variable a tiene un valor de: " + a);
        System.out.println("Incremento detrás (a++): " + (a++));
        System.out.println("Valor de la variable a: " + a + "\n");
        a = 1;
        System.out.println("La variable a tiene un valor de: " + a);
        System.out.println("Incremento delante (++a): " + (++a));
        System.out.println("Valor de la variable a: " + a);
        System.out.println("------------------------------------------------------------");
    }
}