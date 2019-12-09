package tema3;

/**
 * Circulo página 26
 */
public class Circulo {

    public int x;
    public int y;
    public double radio;
    public static final double PI = 3.1415926536;

    // Constructor
    public Circulo(double radio) {
        this.radio = radio;
    }

    // Getters
    public double getRadio() {
        return this.radio;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Otros
    public double calcularPerimetro() {
        return 2 * PI * this.radio;
    }

    public double calcularArea() {
        return PI * this.radio * this.radio;
    }

}
