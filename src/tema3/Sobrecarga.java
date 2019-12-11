package tema3;

/**
 * Sobrecarga
 */
public class Sobrecarga {
    // Atributos
    private int num1;
    private int num2;
    private int num3;

    // Métodos constructores
    public Sobrecarga(int num1, int num2) {
        // this.num1 corresponde atributo de este objeto y no al parámetro.
        // num1 corresopnde al parámetro.
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = 0;
    }

    public Sobrecarga(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }
    // getters

    // setters

    // Métodos de operación
    // public int sumar(int num1, int num2){
    // return num1 + num2;
    // }
    // public int sumar(int num1, int num2, int num3){
    // return num1 + num2 + num3;
    // }
    public int sumar() {
        return num1 + num2;
    }

    public int sumar(String tipo) {
        if (tipo == "dos") {
            return num1 + num2;
        }
        if (tipo == "tres") {
            return num1 + num2 + num3;
        }
        return 0;
    }

}