package tema3;

/**
 * UsandoVehiculos
 */
public class UsandoVehiculos {
    public static void main(String[] args) {
        // Instanciar un objeto de tipo vehiculo (en este caso 2)
        Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
        Vehiculo vehiculo2 = new Vehiculo("2345 JVM", "SEAT", "León", "Negro", 80.0);
        Vehiculo vehiculo3;

        // Para limpiar la terminal antes de escribir, según stackoverflow
        //System.out.print("\033\143");
        //System.out.flush();
        // mostar los datos de vehiculo1
        //vehiculo1.muestraDatos("Vehiculo 1"); // Mi antiguo método
        vehiculo1.getAtributos();
        // Cambiamos la tarifa
        vehiculo1.setTarifa(90.0);
       // System.out.println("********** CAMBIO DE TARIFA **********");
        // Mostramos los cambios
        System.out.println(vehiculo1.getAtributos());
        // Igualar 3 a 1
        vehiculo3 = vehiculo1;
        // vehiculo1.muestraDatos("Vehículo 1");
        // vehiculo2.muestraDatos("Vehículo 2");
        // vehiculo3.muestraDatos("Vehículo 3");
        System.out.println(vehiculo1.getAtributos());
        System.out.println(vehiculo2.getAtributos());
        System.out.println(vehiculo3.getAtributos());
        // cambiamos la tarifa de "vehiculo3"...
        System.out.println("Cambio de tarifa a vehiculo3");
        vehiculo3.setTarifa(125.99);
        // vemos el cambio
        // vehiculo1.muestraDatos("Vehículo 1");
        // vehiculo2.muestraDatos("Vehículo 2");
        // vehiculo3.muestraDatos("Vehículo 3");
        System.out.println(vehiculo1.getAtributos());
        System.out.println(vehiculo2.getAtributos());
        System.out.println(vehiculo3.getAtributos());
    }
}