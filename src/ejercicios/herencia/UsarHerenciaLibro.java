package ejercicios.herencia;

/**
 * UsarHerenciaLibro
 */
public class UsarHerenciaLibro {
     // para limpiar la pantalla antes de escribir
     public static void limpiarPantalla() {
		System.out.print("\033\143");
    }
    
    // para no tener que escribir tanto...
    public static void escribir(String texto){
        System.out.println(texto);
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro("Halloween, la muerte sale de fiesta", "978-84-17645-06-9", 304);
        LibroInfantil libro2 = new LibroInfantil("La cosa", "978-84-9182-999-7", 32);

        // limpiar pantalla...
        limpiarPantalla();
        // comprobar si están abiertos o no los libros:
        if (libro1.isAbierto()) {
            escribir("El libro \"" + libro1.getTitulo() + "\" ha sido abierto.");
        } else {
            escribir("El libro \"" + libro1.getTitulo() + "\" no ha sido abierto.");            
        }
        // libro 2
        if (libro2.isAbierto()){
            escribir("El libro \"" + libro2.getTitulo() + "\" ha sido abierto.");
        } else {
            escribir("El libro \"" + libro2.getTitulo() + "\" no ha sido abierto.");            
        }
    }
}