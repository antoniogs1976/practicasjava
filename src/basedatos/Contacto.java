package basedatos;

/**
 * Contacto
 */
public class Contacto {

    private int codigo; // entero (ver autoincremento)
    private String nombre; // varchar (50)
    private String telefono; // varchar (9)

    // Constructor automático sin parámetros
    public Contacto() {
        this.codigo = 0;
        this.nombre = "";
        this.telefono = "";
    }

    // Constructor con parámetros
    public Contacto(int codigo, String nombre, String telefono){
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // OTROS MÉTODOS
    public String getDatos() {
        return codigo + "\t - " + nombre + "\t - " + telefono;
    }

}