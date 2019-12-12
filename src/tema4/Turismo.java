package tema4;

/**
 * Turismo
 */
public class Turismo extends Vehiculo {
    private int puertas;
    private boolean marchaAutomatica;

    /*
     * Constructor A este hay que pasarle los parámetros de la clase padre (super
     * clase) y también los de la clase hija (sub clase). El orden es el mismo del
     * original y el que se haya definido en la sub clase
     */
    public Turismo(String matricula, String marca, String modelo, String color, double tarifa, int puertas,
            boolean marchaAutomatica) {
        // Aquí se llama al constructor del padre
        super(matricula, marca, modelo, color, tarifa);
        // y aquí se inicializa la subclase
        this.puertas = puertas;
        this.marchaAutomatica = marchaAutomatica;
    }

    // métodos ‘get’ de la subclase Turismo
    public int getPuertas() {
        return this.puertas;
    }

    public boolean getMarchaAutomatica() {
        return this.marchaAutomatica;
    }

    public String getAtributos() {
        return super.getAtributos() + " Puertas: " + this.puertas + " Marcha automática: " + this.marchaAutomatica;
    }
}