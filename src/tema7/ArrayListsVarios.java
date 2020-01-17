package tema7;

import java.util.ArrayList; // import the ArrayList class
//import java.util.Collections;
import miscosas.MisClases;

/**
 * ArrayListsVarios
 */
public class ArrayListsVarios {
    public static void main(String[] args) {
        ArrayList<String> coches = new ArrayList<String>(); // Create an ArrayList object
        coches.add("Seat");
        coches.add("Volvo");
        coches.add("Saab");
        for (int i = 0; i < 100; i++){
            coches.add("Mierda y Peo");
        }

        // Limpiar la pantalla
        MisClases.limpiarPantalla();

        System.out.println("--------------------------------------------------");
        System.out.println("leer los datos con bucle");
        for (int i = 0; i < coches.size(); i++){
            System.out.println(coches.get(i));
        }

        System.out.println("--------------------------------------------------");
        System.out.println("\nLeer los datos a capón (println(coches))");
        System.out.println(coches);

        System.out.println("--------------------------------------------------");
        System.out.println("Leer los datos con posición (coches.get(0))");
        System.out.println(coches.get(0));

        System.out.println("--------------------------------------------------");
        System.out.println("Ver el tamaño que tiene (coches.size())");
        System.out.println(coches.size());

        System.out.println("--------------------------------------------------");
        System.out.println("Modificar valor en la posición 1 (borrando \"Volvo\") (coches.insert(1, \"FIAT\"))");
        coches.set(1, "Fiat");

        System.out.println("--------------------------------------------------");
        System.out.println("Volver a leer todo a ver como está");
        System.out.println(coches);

        System.out.println("--------------------------------------------------");
        System.out.println("Insertar elemento en una posición (en este caso, posición 2 (tercer elemento))");
        coches.add(2, "BMW");
        System.out.println(coches);

        System.out.println("--------------------------------------------------");
        System.out.println("Borra un elemento (vamos a borrar el BMW de antes)");
        coches.remove(2);
        System.out.println(coches);

        System.out.println("--------------------------------------------------");
        System.out.println("Eliminar todos los \"Mierda y Peo\"  que hemos puesto:");
        while (coches.remove("Mierda y Peo")){
            System.out.println("\"Mierda y Peo\" borrado...");
        }
        System.out.println(coches);


        System.out.println("--------------------------------------------------");
        System.out.println("Eliminar todos los valores");
        coches.clear();
        System.out.println(coches);
    }

}