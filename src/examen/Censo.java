package examen;

public class Censo {
    private int codigo; // entero (8)
    private String nombre; // varchar (80)
    private int edad; // varchar (3)

    // Constructor SIN parámetros
    public Censo(){
        this.codigo = 0;
        this.nombre = "";
        this.edad = 0;
    }

    // Constructor CON parámetros
    public Censo(int codigo, String nombre, int edad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}