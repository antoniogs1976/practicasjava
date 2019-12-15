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
        // Ajustar la edad de libro2
        libro2.setEdadRecomendada(7);

        // limpiar pantalla...
        limpiarPantalla();
        // comprobar si están abiertos o no los libros:
        if (libro1.isAbierto()) {
            escribir("El libro \"" + libro1.getTitulo() + "\" ha sido abierto.");
            libro1.abrirLibro();
        } else {
            escribir("El libro \"" + libro1.getTitulo() + "\" no ha sido abierto.");            
        }
        if (libro1.isAbierto()) {
            escribir("El libro \"" + libro1.getTitulo() + "\" ha sido abierto.");
        } else {
            escribir("El libro \"" + libro1.getTitulo() + "\" no ha sido abierto.");            
        }
        // ******************************************************************************************
        // libro 2
        if (libro2.isAbierto()){
            escribir("El libro \"" + libro2.getTitulo() + "\" ha sido abierto.");
            libro2.abrirLibro();
        } else {
            escribir("El libro \"" + libro2.getTitulo() + "\" no ha sido abierto.");            
        }
        escribir("*------------------------------------------------------------*");
        if (libro2.isAbierto()){
            escribir("El libro \"" + libro2.getTitulo() + "\" ha sido abierto.");
        } else {
            escribir("El libro \"" + libro2.getTitulo() + "\" no ha sido abierto.");            
        }
        // mostramos la edad recomendada
        escribir("Edad recomendada: "+libro2.getEdadRecomendada());
        if (libro2.getEdadRecomendada() < 18){
            escribir("Libro recomendado para menores.");
        } else {
            escribir("Libro no recomendado para menores de 18 años.");
        }
    }
}