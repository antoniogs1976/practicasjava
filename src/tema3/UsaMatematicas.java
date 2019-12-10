package tema3;

/**
 * UsaMatematicas
 */
public class UsaMatematicas {

    public static void main(String[] args) {
        /*
         * Matematicas mate1 = new Matematicas(5, 7);
         * Matematicas mate2 = new Matematicas(10, 14);
         * 
         * System.out.println("La suma de 5 y 7 es: " + mate1.sumar());
         * System.out.println("(Estático) La suma de 5 y 7 es: " +
         * mate1.sumarEstatico(mate1.num1, mate1.num2)); System.out.
         * println("(Estático) (Matematicas.sumarEstatico()) La suma de 5 y 7 es: " +
         * Matematicas.sumarEstatico(mate1.num1, mate1.num2));
         * 
         * System.out.println("La suma de 10 y 14 es: " + mate2.sumar()); System.out.
         * println("(Estático) (Matematicas.sumarEstatico()) La suma de 10 y 14 es: " +
         * Matematicas.sumarEstatico(mate2.num1, mate2.num2));
         * 
         * // Uso de métodos y atributos estáticos // No es necesario crear objetos
         * System.out.
         * println("(Estático) (Matematicas.sumarEstatico()) La suma de 5 y 7 es: " +
         * Matematicas.sumarEstatico(5, 7));
         * System.out.println("(Estático) (Matemáticas.PI) Número PI: " +
         * Matematicas.PI);
         */
        // Más opciones de llamada (en este caso, estático)
        int n1 = 1;
        int n2 = 5;
        int n3 = 7;
        int tmp = 0;
        // paso intermedio
        tmp = n1 + n2;
        System.out.println("Suma de 3 números con paso intermedio: " + Matematicas.sumarEstatico(tmp, n3));
        // Pasando una llamad dentro de otra
        System.out.println("Suma de 3 números con método de 2 números: " + Matematicas.sumarEstatico((Matematicas.sumarEstatico(n1, n2)), n3));

        //System.out.println("(Estático) La suma de mate1.num1 (" + mate1.num1 + ") y mate1.num2 (" + mate1.num2 + ") es : " + Matematicas.sumarEstatico(mate1.num1, mate1.num2));
        //System.out.println("(Estático) La suma de 25 y 23 es : " + Matematicas.sumarEstatico(25, 23));

    }
}