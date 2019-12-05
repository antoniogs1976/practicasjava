package tema2;

// la clase Circulo no está en el paquete "tema2" y es necesario importarla
import tema3.Circulo;

/**
 * UsaCirculo
 */
public class UsaCirculo {

    public static void main(String[] args) {
        // Creación de variables
        Circulo circulo1 = new Circulo();
        Circulo circulo2 = new Circulo();
        Circulo circulo1Copia = new Circulo();

        // Asignar valores a circulo1
        circulo1.x = 2;
        circulo1.y = 5;
        circulo1.radio = 1;

        // Asignar los mismos valores a circulo2
        circulo2.x = 2;
        circulo2.y = 5;
        circulo2.radio = 1;

        // Para limpiar la terminal antes de escribir, según stackoverflow
        System.out.print("\033\143");

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Valores de los atributos de \"circulo1\"");
        System.out.println("circulo1.x: " + circulo1.x);
        System.out.println("circulo1.y: " + circulo1.y);
        System.out.println("circulo1.radio: " + circulo1.radio);
        System.out.println("Valores de los atributos de \"circulo2\"");
        System.out.println("circulo2.x: " + circulo2.x);
        System.out.println("circulo2.y: " + circulo2.y);
        System.out.println("circulo2.radio: " + circulo2.radio);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("if (circulo1 == circulo2)");
        if (circulo1 == circulo2) {
            System.out.println("circulo1 y circulo2 son iguales.");
        } else {
            System.out.println("circulo1 y circulo2 no son iguales.");
        }
        System.out.println("Explicación: circulo1 y circulo2 NO son tipos \"primitivos\" y lo que se comprueba en el IF no es el valor, es la \"referencia\", que es la posición en memoria (el puntero). Como cada objeto está en una posición de memoria distinta, aunque tengan los mismos valores en sus atributos, esta comparación da FALSE.");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Comparación de valores.");
        System.out.println("if (circulo1.x == circulo2.x)");
        if (circulo1.x == circulo2.x) {
            System.out.println("circulo1.x y circulo2.x son iguales.");
        } else {
            System.out.println("circulo1.x y circulo2.x no son iguales.");
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Valores por \"referencia\": ");
        System.out.println("println(circulo1): " + circulo1);
        System.out.println("println(circulo2): " + circulo2);
        System.out.println("println(circulo1Copia): " + circulo1Copia);
        System.out.println("------------------------------------------------------------------------------------------");
        // BackUp del circulo 1
        circulo1Copia = circulo1;
        circulo1 = circulo2;
        System.out.println("if (circulo1 == circulo2) (esto da TRUE, puesto que ahora apuntan a la misma dirección de memoria)");
        if (circulo1 == circulo2) {
            System.out.println("circulo1.x y circulo2.x son iguales.");
        } else {
            System.out.println("circulo1.x y circulo2.x no son iguales.");
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Lo comprobamos ahora: circulo1 y circulo2 apuntan a la dirección de circulo2.");
        System.out.println("circulo1Copia, que no estaba asignado a anda, ahora apunta a la dirección de circulo1.");
        System.out.println("circulo1: " + circulo1);
        System.out.println("circulo2: " + circulo2);
        System.out.println("circuloAuxilia: " + circulo1Copia);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Asignamos valores a circulo1.");
        circulo1.x = 5;
        circulo1.y = 7;
        circulo1.radio = 9;
        System.out.println("Valores de los atributos de \"circulo1\"");
        System.out.println("circulo1.x: " + circulo1.x);
        System.out.println("circulo1.y: " + circulo1.y);
        System.out.println("circulo1.radio: " + circulo1.radio);
        System.out.println("Valores de los atributos de \"circulo2\"");
        System.out.println("circulo2.x: " + circulo2.x);
        System.out.println("circulo2.y: " + circulo2.y);
        System.out.println("circulo2.radio: " + circulo2.radio);
        System.out.println("Explicación:");
        System.out.println("Al apuntar a la misma dirección de memoria, circulo1 y circulo2 son dos nombres para los mismos datos.");
        System.out.println("Sin embargo, circulo1Copia sigue teniendo los valores originales de circulo1.");
        System.out.println("------------------------------------------------------------------------------------------");
    }
}