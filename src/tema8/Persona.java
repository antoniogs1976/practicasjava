package tema8;

import java.io.Serializable;

/**
 * Persona
 */
public class Persona implements Serializable {
    
    private static final long serialVersionUID = -9149882142193462278L;
    private String nif;
    private String nombre;
    private String apellidos;
    private String telefono;

    // CONSTRUCTOR
    public Persona(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono ="";
    }

    // GETTERS Y SETTERS
    public String getdni() {
        return nif;
    }

    public void setdni(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // OTROS MÉTODOS
    public String getAtributos() {
        return "NIF: " + this.nif + "\tTLF: " + this.telefono + "\n" + this.apellidos + ", " + this.nombre;
    }

}