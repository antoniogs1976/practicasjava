package tema3;

/**
 * MisVehiculos
 */

public class MisVehiculos {
    public static void recibirVehiculoAlquilado(Vehiculo v) {
        v.setDisponible(true);
    }

    public static void entregarVehiculoAlquilado(Vehiculo v){
        v.setDisponible(false);
    }

    public static void main(String args[]) {
        Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
        // el valor del atributo disponible de vehiculo1 es false
        System.out.println("El objeto vehiculo1 está disponible: " + vehiculo1.getDisponible());
        recibirVehiculoAlquilado(vehiculo1);
        // el valor del atributo disponible de vehiculo1 es true
        System.out.println("El objeto vehiculo1 está disponible: " + vehiculo1.getDisponible());
        entregarVehiculoAlquilado(vehiculo1);
        System.out.println("El objeto vehiculo1 está disponible: " + vehiculo1.getDisponible());
    }
}