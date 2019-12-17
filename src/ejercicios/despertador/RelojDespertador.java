package ejercicios.despertador;
/**
 * RelojDespertador
 */

public class RelojDespertador {

    // Horas, minutos y segundos del reloj
    int horaReloj = 0;
    int minutoReloj = 0;
    int segundoReloj = 0;
    // Horas, minutos y segundos de la alarma
    int horaAlarma = 0;
    int minutoAlarma = 0;
    int segundoAlarma = 0;
    // Control de la alarma
    boolean alarmaActiva = false;
    boolean retrasarAlarma = false;
    // Añadidos y extras
    boolean formato24h = false;
    int tiempoRetrasoAlarma = 0;

    // Constructor sin parámetros
    public RelojDespertador() {
        this.horaReloj = 0;
        this.minutoReloj = 0;
        this.segundoReloj = 0;
        this.horaAlarma = 0;
        this.minutoAlarma = 0;
        this.segundoAlarma = 0;
        alarmaActiva = false;
        retrasarAlarma = false;
        formato24h = true;
        tiempoRetrasoAlarma = 0;
    }

    // Getters y Setters
    public int gethHora() {
        return horaReloj;
    }

    public void sethHora(int horaReloj) {
        this.horaReloj = horaReloj;
    }

    public int gethMinuto() {
        return minutoReloj;
    }

    public void sethMinuto(int minutoReloj) {
        this.minutoReloj = minutoReloj;
    }

    public int gethSegundo() {
        return segundoReloj;
    }

    public void sethSegundo(int segundoReloj) {
        this.segundoReloj = segundoReloj;
    }

    public int getaHora() {
        return horaAlarma;
    }

    public void setaHora(int horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public int getaMinuto() {
        return minutoAlarma;
    }

    public void setaMinuto(int minutoAlarma) {
        this.minutoAlarma = minutoAlarma;
    }

    public int getaSegundo() {
        return segundoAlarma;
    }

    public void setaSegundo(int segundoAlarma) {
        this.segundoAlarma = segundoAlarma;
    }

    public boolean isAlarmaActiva() {
        return alarmaActiva;
    }

    public void setAlarmaActiva(boolean alarmaActiva) {
        this.alarmaActiva = alarmaActiva;
    }

    public boolean isRetrasarAlarma() {
        return retrasarAlarma;
    }

    public void setRetrasarAlarma(boolean retrasarAlarma) {
        this.retrasarAlarma = retrasarAlarma;
    }

    public boolean isFormato24h() {
        return formato24h;
    }

    public void setFormato24h(boolean formato24h) {
        this.formato24h = formato24h;
    }

    public int getTiempoRetrasoAlarma() {
        return tiempoRetrasoAlarma;
    }

    public void setTiempoRetrasoAlarma(int tiempoRetrasoAlarma) {
        this.tiempoRetrasoAlarma = tiempoRetrasoAlarma;
    }

    // Otros métodos
    // Ajustar la hora del reloj
    public void ajustarHora(int hora, int minuto) {
        this.horaReloj = hora;
        this.minutoReloj = minuto;
        this.segundoReloj = 0;
    }

    // Ajustar la hora de la alarma del reloj
    public void ajustarAlarma(int hora, int minuto) {
        this.horaAlarma = hora;
        this.minutoAlarma = minuto;
        this.segundoAlarma = 0;
    }

    // Mostrar la hora
    public String mostrarHora() {
        if (isFormato24h() == true) {
            return (horaReloj + ":" + minutoReloj);
        } else {
            if (gethHora() > 12) {
                return ((horaReloj % 12) + ":" + minutoReloj);
            } else {
                return (horaReloj + ":" + minutoReloj);
            }
        }
    }

    // Mostrar la hora
    public String mostrarHoraAlarma() {
        if (isFormato24h() == true) {
            return (horaAlarma + ":" + minutoAlarma);
        } else {
            if (gethHora() > 12) {
                return ((horaAlarma % 12) + ":" + minutoAlarma);
            } else {
                return (horaAlarma + ":" + minutoAlarma);
            }
        }
    }

}