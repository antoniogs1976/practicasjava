package ejercicios.tema5;

/**
 * ClasesAsociadas
 */
public class ClasesAsociadas {

    public static void saludo(String nombre) {
        System.out.println("Hola " + nombre);
    }

    public static void main(String[] args) {
        String miNombre = new String("Antonio");
        Character miCaracter = new Character('A');
        Integer miNumero1 = new Integer(100);
        Integer miNumero2 = new Integer(100);
        String cosa1, cosa2;
        saludo(miNombre);
        saludo(miCaracter.toString());
        saludo(miNumero1.toString());
        saludo(miNombre.toUpperCase());
        saludo(miNombre.toLowerCase());
        //
        int num1 = 100;
        int num2 = 100;
        if (num1 == num2) {
            System.out.println("num1 y num2 son iguales");
        } else {
            System.out.println("num1 y num2 no son iguales.");
        }
        // si son objetos la cosa no funciona...
        if (miNumero1 == miNumero2) {
            System.out.println("miNumero1 y miNumero2 son iguales");
        } else {
            System.out.println("miNumero1 y miNumero2 no son iguales.");
        }
        // al ser objetos, se debe ahacer con otro sistema
        if (miNumero1.equals(miNumero2)) {
            System.out.println("miNumero1 y miNumero2 son iguales");
        } else {
            System.out.println("miNumero1 y miNumero2 no son iguales.");
        }
        cosa1 = "hola";
        cosa2 = "hola";

        if (cosa1 == cosa2){
            System.out.println("son iguales");
        }
    }
}