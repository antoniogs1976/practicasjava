package ejercicios.herencia;

/**
 * LibroInfantil
 */
public class LibroInfantil extends Libro{

    private int edadRecomendada = 18;
    
    // Constructor
    public LibroInfantil(String titulo, String isbn, int numPaginas) {
        super(titulo, isbn, numPaginas);
    }

    // Getters y Setters
    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    // Otros métodos
    public boolean esRecomendable(int edadNinyo){
        if (edadNinyo < 18){
            return false;
        } else {
            return true;
        }
    }
    

}