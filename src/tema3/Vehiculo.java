package tema3;

public class Vehiculo {
    // ATRIBUTOS -> Definen características de los objetos
    String matricula;
    String marca;
    String modelo;
    String color;
    double tarifa;
    boolean disponible;

    // MÉTODOS -> Definen el comportamiento de los objetos
    // - Constructores
    // IMPORTANTE
    // El orden marcado en el CONSTRUCTOR hay que respetarlo a la hora de asignar
    // los valores.
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

    public String getDisponible() {
        if (this.disponible == true){
            return ("Disponible");
        } else {
            return ("No disponible");
        }
    }

    // - SETTER -> asigna valores a los ATRIBUTOS
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // - OTROS MÉTODOS
    // Método para leer los atributos y escribir en pantalla
    // PÁGINA 43
    public String getAtributos() {
        return "Matrícula: " + this.matricula + "\nModelo: " + this.marca + " " + this.modelo + "\nColor: " + this.color
                + "\nTarifa: " + this.tarifa + "\nDisponible: " + this.disponible + "\n";
    }
}