package tema3;

/**
 * UsaCirculo
 */
public class UsarCirculo {

    public static void main(String[] args) {
        // Creación de variables
        Circulo circulo1 = new Circulo(1.5);
        Circulo circulo2 = new Circulo(2.4);
        Circulo circulo1Copia = null;

        // Asignar valores a circulo1
        circulo1.setX(2);
        circulo1.setY(5);
        ;

        // Asignar los mismos valores a circulo2
        circulo2.setX(2);
        circulo2.setY(5);
        ;

        // Para limpiar la terminal antes de escribir, según stackoverflow
        System.out.print("\033\143");

        // System.out.println("------------------------------------------------------------------------------------------");
        // System.out.println("Valores de los atributos de \"circulo1\"");
        // System.out.println("circulo1.x: " + circulo1.x);
        // System.out.println("circulo1.y: " + circulo1.y);
        // System.out.println("circulo1.radio: " + circulo1.radio);
        // System.out.println("Valores de los atributos de \"circulo2\"");
        // System.out.println("circulo2.x: " + circulo2.x);
        // System.out.println("circulo2.y: " + circulo2.y);
        // System.out.println("circulo2.radio: " + circulo2.radio);
        // System.out.println("------------------------------------------------------------------------------------------");
        // System.out.println("if (circulo1 == circulo2)");
        // if (circulo1 == circulo2) {
        // System.out.println("circulo1 y circulo2 son iguales.");
        // } else {
        // System.out.println("circulo1 y circulo2 no son iguales.");
        // }
        // System.out.println("Explicación: circulo1 y circulo2 NO son tipos
        // \"primitivos\" y lo que se comprueba en el IF no es el valor, es la
        // \"referencia\", que es la posición en memoria (el puntero). Como cada objeto
        // está en una posición de memoria distinta, aunque tengan los mismos valores en
        // sus atributos, esta comparación da FALSE.");
        // System.out.println("------------------------------------------------------------------------------------------");
        // System.out.println("Comparación de valores.");
        // System.out.println("if (circulo1.x == circulo2.x)");
        // if (circulo1.x == circulo2.x) {
        // System.out.println("circulo1.x y circulo2.x son iguales.");
        // } else {
        // System.out.println("circulo1.x y circulo2.x no son iguales.");
        // }
        // System.out.println("------------------------------------------------------------------------------------------");
        // System.out.println("Valores por \"referencia\": ");
        // System.out.println("println(circulo1): " + circulo1);
        // System.out.println("println(circulo2): " + circulo2);
        // System.out.println("println(circulo1Copia): " + circulo1Copia);
        // System.out.println("------------------------------------------------------------------------------------------");
        //// BackUp del circulo 1
        // circulo1Copia = circulo1;
        // circulo1 = circulo2;
        // System.out.println("if (circulo1 == circulo2) (esto da TRUE, puesto que ahora
        // apuntan a la misma dirección de memoria)");
        // if (circulo1 == circulo2) {
        // System.out.println("circulo1.x y circulo2.x son iguales.");
        // } else {
        // System.out.println("circulo1.x y circulo2.x no son iguales.");
        // }
        // System.out.println("------------------------------------------------------------------------------------------");
        // System.out.println("Lo comprobamos ahora: circulo1 y circulo2 apuntan a la
        // dirección de circulo2.");
        // System.out.println("circulo1Copia, que no estaba asignado a anda, ahora
        // apunta a la dirección de circulo1.");
        // System.out.println("circulo1: " + circulo1);
        // System.out.println("circulo2: " + circulo2);
        // System.out.println("circuloAuxilia: " + circulo1Copia);
        // System.out.println("------------------------------------------------------------------------------------------");
        // System.out.println("Asignamos valores a circulo1.");
        // circulo1.x = 5;
        // circulo1.y = 7;
        // circulo1.radio = 9;
        // System.out.println("Valores de los atributos de \"circulo1\"");
        // System.out.println("circulo1.x: " + circulo1.x);
        // System.out.println("circulo1.y: " + circulo1.y);
        // System.out.println("circulo1.radio: " + circulo1.radio);
        // System.out.println("Valores de los atributos de \"circulo2\"");
        // System.out.println("circulo2.x: " + circulo2.x);
        // System.out.println("circulo2.y: " + circulo2.y);
        // System.out.println("circulo2.radio: " + circulo2.radio);
        // System.out.println("Explicación:");
        // System.out.println("Al apuntar a la misma dirección de memoria, circulo1 y
        // circulo2 son dos nombres para los mismos datos.");
        // System.out.println("Sin embargo, circulo1Copia sigue teniendo los valores
        // originales de circulo1.");
        // System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Circulo 1 - Radio: " + circulo1.getRadio());
        System.out.println("Circulo 1 - Perímetro: " + circulo1.calcularPerimetro());
        System.out.println("Circulo 1 - Área: " + circulo1.calcularArea());
        System.out.println("--------------------");
        System.out.println("Circulo 2 - Radio: " + circulo2.getRadio());
        System.out.println("Circulo 2 - Perímetro: " + circulo2.calcularPerimetro());
        System.out.println("Circulo 2 - Área: " + circulo2.calcularArea());
        circulo1Copia = circulo1;
        System.out.println("--------------------");
        System.out.println("Circulo 1 Copia - Radio: " + circulo1Copia.getRadio());
        System.out.println("Circulo 1 Copia - Perímetro: " + circulo1Copia.calcularPerimetro());
        System.out.println("Circulo 1 Copia - Área: " + circulo1Copia.calcularArea());
        System.out.println("Cuadrado (Math.sqr(numero)) del número 2= "+Math.sqrt(2));
    }
}