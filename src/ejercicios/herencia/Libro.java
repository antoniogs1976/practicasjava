package ejercicios.herencia;

/**
 * Libro
 */
public class Libro {

    private String titulo;
    private String isbn;
    private int numPaginas;
    private boolean abierto = false;
    private int paginaActual = 0;

    // Constructor
    public Libro(String titulo, String isbn, int numPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAbierto() {
        return abierto;
    }

    // este lo comento por no tenerlo duplicado con el "abrirLibro"
    // public void setAbierto(boolean abierto) {
    //     this.abierto = abierto;
    // }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    // Otros métodos
    public void abrirLibro(){
        this.abierto = true;
    }

    public void cerrarLibro(){
        this.abierto = false;
    }
}