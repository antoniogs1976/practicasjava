package tema4;

/**
 * MisVehiculos
 */
public class MisVehiculos {

    public static void main(String args[]) {
        // se crean dos instancias de la clase Vehiculo
        Vehiculo vehiculo1 = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
        Vehiculo vehiculo2 = new Vehiculo("2345 JVM", "SEAT", "León", "Negro", 80.0);
        // se crea una instancia de la clase Cliente
        Cliente cliente1 = new Cliente("30435624X", "Juan", "Pérez");
        /*------------------------------------------------------------------------------
         * se crea una instancia de la clase VehiculoAlquilado que relaciona al cliente1
         * con el vehiculo1, el vehículo se alquila con fecha 11/11/2011 durante 2 días
         * Creamos el objeto alquiler 1, con dos objetos dentro: - uno de tipo
         * "vehiculo" - otro de tipo "clientee
         -----------------------------------------------------------------------------*/
        VehiculoAlquilado alquiler1 = new VehiculoAlquilado(cliente1, vehiculo1, 11, 11, 2011, 2);

        /*------------------------------------------------------------------------------
         * Mostramos algunos datos de ejemplo De esta forma accedemos con el "." a todos
         * los niveles de objetos que hay
         -----------------------------------------------------------------------------*/
        System.out.println("Vehículo alquilado");
        System.out.println("Cliente : " + alquiler1.getCliente().getNif() + " " + alquiler1.getCliente().getNombre()
                + " " + alquiler1.getCliente().getApellidos());
        System.out.println("Vehículo: " + alquiler1.getVehiculo().getMatricula());

        /*----------------------------------------------------------------------------
         * Hacer lo mismo de otra forma. De esta forma accedemos primero a un nivel de
         * objeto y desde ese accedemos con el "."
         ---------------------------------------------------------------------------*/
        System.out.println("Vehículo alquilado (mostrado de otra forma)");
        // obtener el objeto cliente
        Cliente clienteAux = alquiler1.getCliente();
        // obtener el objeto vehiculo
        Vehiculo vehiculoAux = alquiler1.getVehiculo();
        // obtenemos los datos de las variables auxiliares
        System.out.println(
                "Cliente : " + clienteAux.getNif() + " " + clienteAux.getNombre() + " " + clienteAux.getApellidos());
        System.out.println("Vehículo: " + vehiculoAux.getMatricula());

        // EJERCICIO 1: Cambiar el objeto "vehiculo1" por "vehiculo2" en "alquiler1"
        alquiler1.setVehiculo(vehiculo2);
        System.out.println("----- Cambio de vehículo -----");
        System.out.println("Vehículo alquilado (opción de acceso 1)");
        System.out.println("Cliente : " + alquiler1.getCliente().getNif() + " " + alquiler1.getCliente().getNombre()
                + " " + alquiler1.getCliente().getApellidos());
        System.out.println("Vehículo: " + alquiler1.getVehiculo().getMatricula());

        System.out.println("Vehículo alquilado (mostrado de otra forma)(opción 2)");
        // obtener el objeto cliente
        clienteAux = alquiler1.getCliente();
        // obtener el objeto vehiculo
        vehiculoAux = alquiler1.getVehiculo();
        // obtenemos los datos de las variables auxiliares
        System.out.println(
                "Cliente : " + clienteAux.getNif() + " " + clienteAux.getNombre() + " " + clienteAux.getApellidos());
        System.out.println("Vehículo: " + vehiculoAux.getMatricula());

        // vamos a por un deportivo...
        Deportivo vacile1 = new Deportivo("0000 AAA", "Ferrari", "F40", "rojo", 350.99, 5000);
        System.out.println("------------------------------------------------------------");
        System.out.println(vacile1.getAtributos());
    }
}