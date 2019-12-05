package tema3;

/**
 * UsandoVehiculos
 */
public class UsandoVehiculos {

    public static void main(String[] args) {
        // Instanciar un objeto de tipo vehiculo (en este caso 2)
        Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
        Vehiculo vehiculo2 = new Vehiculo("2345 JVM", "SEAT", "León", "Negro", 80.0);

        // Para limpiar la terminal antes de escribir, según stackoverflow
        System.out.print("\033\143");
        System.out.flush();
        // mostar los datos de vehiculo1
        System.out.println("Matricula : " + vehiculo1.getMatricula());
        System.out.println("Marca     : " + vehiculo1.getMarca());
        System.out.println("Modelo    : " + vehiculo1.getModelo());
        System.out.println("Color     : " + vehiculo1.getColor());
        System.out.println("Tarifa    : " + vehiculo1.getTarifa());
        System.out.print("Disponible: ");
        if (vehiculo1.disponible == true) {
            System.out.print("Si\n");
        } else {
            System.out.print("No\n");
        }

    }
}