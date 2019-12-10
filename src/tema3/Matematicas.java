package tema3;

/**
 * Matematicas
 */
public class Matematicas {
    // Atributos
    int num1;
    int num2;
    // Atributo de clase (común a todos los objetos)
    // (Atributo estático o de clase)
    static double PI = 3.1416;
    // Método constructor
    public Matematicas(int valor1, int valor2) {
        num1 = valor1;
        num2 = valor2;
    }
    // Método de operación normal (NO ESTÁTICO)
    public int sumar (){
        return num1 + num2;
    }
    // Método de operación ESTÁTICO
    public static int sumarEstatico(int cosa1, int cosa2) {
        // Estamos en un ámbito estático y no podemos usar num1 y num2 porque no son estáticos
        // return num1 + num2;
        return cosa1 + cosa2;
    }

}

