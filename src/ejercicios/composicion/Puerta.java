package ejercicios.composicion;

/**
 * Puerta
 */
public class Puerta {

    private boolean elevalunasElectrico;

    // Constructor
    public Puerta(boolean elevalunasElectrico) {
        this.elevalunasElectrico = elevalunasElectrico;
    }

    // Getters y Setters
    public String isElevalunasElectrico() {
        if (this.elevalunasElectrico == true) {
            return "Si";
        } else {
            return "No";
        }
    }

    public void setElevalunasElectrico(boolean elevalunasElectrico) {
        this.elevalunasElectrico = elevalunasElectrico;
    }
    
}