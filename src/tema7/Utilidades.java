package tema7;

/**
 * Utilidades
 * 
 * utilidades varias
 */
public class Utilidades {

    /**
     * Método que devuelve el día de la semana como texto
     * @param numeroDia Número (0 a 6) del día de la semana
     * @return Texto con el día de la semana
     */
    public static String diaSemana(int numeroDia){
        final String[] dias = {"domingo", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado"};
        if (numeroDia >= 0 && numeroDia <= 6){
            return dias[numeroDia];
        } else {
            return "* ERROR * : numeroDia debe estar entre 0 y 6.";
        }
    }
}