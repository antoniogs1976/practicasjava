package ejercicios.composicion;

/**
 * Motor
 */
public class Motor {
    private int cilindrada;
    private int potencia;
    private String combustible;

    //Constructor
    public Motor(int cilindrada, int potencia, String combustible) {
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.combustible = combustible;
    }

    // Getters y Setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    
}