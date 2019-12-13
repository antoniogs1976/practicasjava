package ejercicios.composicion;

/**
 * Coche
 */
public class Coche {
    // Atributos
    private String marca;
    private String modelo;
    private String color;

    // Constructor
    public Coche(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    // Getter y Setter
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Otros métodos
    public void getAtributos() {
        System.out.println("Atributos del coche:");
        System.out.println("Marca  :"+this.marca);
        System.out.println("Modelo :"+this.modelo);
        System.out.println("Color  :"+this.color);
    }
    
}