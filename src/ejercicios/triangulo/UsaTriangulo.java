package ejercicios.triangulo;

/**
 * UsaTriangulo
 */
public class UsaTriangulo {

    public static void main(String[] args) {
        Triangulo miTriangulo = new Triangulo(30, 10, 10);
        if (miTriangulo.esEquilatero(miTriangulo.getLadoA(), miTriangulo.getLadoB(), miTriangulo.getLadoC())){
            System.out.println("miTriangulo es un triángulo equilátero");
        } else {
            System.out.println("miTriangulo no es un triángulo equilátero");
        }
    }
}