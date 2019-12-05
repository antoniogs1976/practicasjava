package tema3;

public class Vehiculo {
    // ATRIBUTOS -> Definen características de los objetos
    String matricula;
    String marca;
    String modelo;
    String color;
    double tarifa;
    boolean disponible;

    // METODOS -> Definen el comportamiento de los objetos
    // - Constructores
    public Vehiculo(String matricula, String marca, String modelo, String color, double tarifa) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = false;
    }

    // - GETTER -> lee valores de los ATRIBUTOS
    public String getMatricula() {
        return this.matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getColor() {
        return this.color;
    }

    public double getTarifa() {
        return this.tarifa;
    }

    public boolean getDisponible() {
        return this.disponible;
    }

    // - SETTER -> asigna valores a los ATRIBUTOS
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    // - OTROS METODOS
}