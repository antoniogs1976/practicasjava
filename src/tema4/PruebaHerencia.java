package tema4;

/**
 * PruebaHerencia
 */
public class PruebaHerencia {
	public static void limpiarPantalla() {
		System.out.print("\033\143");
	}

	public static void main(String[] args) {
		// creación de instancias de la superclase Vehiculo y de las subclases Turismo,
		// Deportivo y Furgoneta
		Vehiculo miVehiculo = new Vehiculo("4050 ABJ", "VW", "GTI", "Blanco", 100.0);
		Turismo miTurismo = new Turismo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, 2, false);
		Deportivo miDeportivo = new Deportivo("4070 DEP", "Ford", "Mustang", "Rojo", 150.0, 2000);
		Furgoneta miFurgoneta = new Furgoneta("4080 FUR", "Fiat", "Ducato", "Azul", 80.0, 1200, 8);
		limpiarPantalla();
		// invocación del método getAtributos() de cada objeto
		System.out.println("=================================================================");
		System.out.println("miVehiculo.getAtributos()");
		System.out.println("Vehículo : " + miVehiculo.getAtributos());
		// miVehiculo es una instancia de la clase Vehiculo, se invoca el método
		// getAtributos() de Vehiculo
		System.out.println("=================================================================");
		System.out.println("miTurismo.getAtributos()");
		System.out.println("Turismo " + miTurismo.getAtributos());
		// miTurismo es una instancia de la clase Turismo, se invoca el método
		// getAtributos() de Turismo
		System.out.println("=================================================================");
		System.out.println("miDeportivo.getAtributos()");
		System.out.println("Deportivo " + miDeportivo.getAtributos());
		// miDeportivo es una instancia de la clase Deportivo, se invoca el método
		// getAtributos() de Deportivo
		System.out.println("=================================================================");
		System.out.println("miFurgoneta.getAtributos()");
		System.out.println("Furgoneta " + miFurgoneta.getAtributos());
		// miFurgoneta es una instancia de la clase Furgoneta, se invoca el método
		// getAtributos() de Furgoneta el objeto miTurismo pertenece a la subclase
		// ------------------------------------------------------------------------
		// Turismo, es un vehículo y puede invocar a los métodos de la superclase
		// Vehiculo: getMatricula(), getMarca() y getModelo()
		System.out.println("=================================================================");
		System.out.println("(acceso a los atributos de la superclase)");
		System.out.println("miTurismo.getMatricula() + miTurismo.getMarca() + miTurismo.getModelo()");
		System.out.println("Turismo : " + miTurismo.getMatricula() + " " + miTurismo.getMarca() + " " + miTurismo.getModelo());
		// Compatibilidad y conversión de tipos
		// Se puede asignar, por ejemplo, un "Turismo" a un "Vehículo" de manera
		// automática.
		// Al revés, asignar un "Vehículo" a un "Turismo", aunque sea la clase de la que
		// desciende "Turismo"
		// hay que hacer el "casting" de tipos.
		// Ejemplos:
		// Este primero es el "casting automático". miOtroVehiculo se "construye" con el
		// constructor de Turismo
		// y por eso nos deja hacer la operación.
		System.out.println("=================================================================");
		Turismo miOtroTurismo = new Turismo("4199 TUR", "VWs", "Polos", "Rojos", 80.1, 3, true);
		Vehiculo miVehiculo2 = miOtroTurismo;
		System.out.println("Mi otro vehículo: (miOtroVehiculo.getAtributos()) ");
		System.out.println("Otro Vehículo " + miVehiculo2.getAtributos());
		System.out.println("=================================================================");
		Turismo miTurismo2 = (Turismo) miVehiculo2;
		System.out.println("Otro Turismo " + miTurismo2.getAtributos());
		System.out.println("=================================================================");
		System.out.println("Mostramos las posiciones de memoria de cada objeto (por curiosidad)");
		System.out.println("miVehiculo - " + miVehiculo);
		System.out.println("miTurismo - " + miTurismo);
		System.out.println("miFurgoneta - " + miFurgoneta);
		System.out.println("miDeportivo - " + miDeportivo);
		System.out.println("miVehiculo2 - " + miVehiculo2);
		System.out.println("miOtroTurismo - " + miOtroTurismo);
		System.out.println("miTurismo2 - " + miTurismo2);
	}
}