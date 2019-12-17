package ejercicios.tema5;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Condicionales
 */
public class Condicionales {
    public static double redondear(double numero) {
        // Método cutre para redondear números a 2 decimales
        numero = numero * 100;
        numero = Math.floor(numero);
        numero = numero / 100;
        return numero;
    }

    public static void escribir(String texto) {
        System.out.println(texto);
    }

    public static void main(String[] args) {
        // Variables varias
        int dia;
        double nota;
        LocalTime hora = LocalTime.now();
        // 1.- Simple
        // dada una nota, escribir "Aprobado" si es mayo o igual a 5
        // Limpiar pantalla
        System.out.print("\033\143");
        escribir("*---------------------------------------------*");
        escribir("Comparación simple (if):");
        nota = redondear(Math.random() * 10);
        escribir("La nota es de: " + nota);
        escribir("(si es menor de 5 no imprime nada)");
        if (nota >= 5) {
            escribir("Aprobado");
        }
        // 2.- Doble
        // dada una nota, escribir Aprobado si es mayor o igual a 5 y suspenso si es
        // menor que 5
        escribir("*---------------------------------------------*");
        escribir("Comparación doble (if-else):");
        nota = redondear(Math.random() * 10);
        escribir("La nota es de: " + nota);
        if (nota >= 5) {
            escribir("Aprobado");
        } else {
            escribir("Suspendido");
        }
        // 3.- Aninada
        // Dada una nota, escribir:
        // 10: matricula de honor
        // 9 y <10 : Sobresaliente
        // 7-9: Notable
        // 6-7: Bien
        // 5-6: Suficiente
        // 0-5: Suspenso
        escribir("*---------------------------------------------*");
        escribir("Comparación anidada (if-else-if):");
        nota = redondear(Math.random() * 10);
        escribir("La nota es de: " + nota);
        if ((nota > 10) || (nota < 0)) {
            escribir("Error: La nota no es correcta.");
        } else if (nota == 10) {
            escribir("Matricula de honor");
        } else if ((nota < 10) && (nota >= 9)) {
            escribir("Sobresaliente");
        } else if ((nota < 9) && (nota >= 7)) {
            escribir("Notable");
        } else if ((nota < 7) && (nota >= 6)) {
            escribir("Bien");
        } else if ((nota < 6) && (nota >= 5)) {
            escribir("Suficiente");
        } else {
            escribir("Suspenso");
        }

        // 4.- Multiple
        // Dado un día de la semana en número, de 0 a 6, escribir el día que es con
        // letras
        escribir("*---------------------------------------------*");
        escribir("Comparación múltiple (switch)");
        dia = (int) Math.round(Math.random() * 7);
        escribir("El valor del día de la semana es: " + dia);
        switch (dia) {
        case 0:
            escribir("domingo");
            break;
        case 1:
            escribir("lunes");
            break;
        case 2:
            escribir("martes");
            break;
        case 3:
            escribir("miércoles");
            break;
        case 4:
            escribir("jueves");
            break;
        case 5:
            escribir("viernes");
            break;
        case 6:
            escribir("sábado");
            break;
        default:
            escribir("Error en el día introducido");
        }

        // cosa de horas y demás
        // de 20:01 hasta las 7:59 - Buenas noches
        // de 8:00 a 13:59 - Buenos días
        // de 14:00 a 20:00 - buenas tardes
        if ((hora.getHour() >= 8) && ((hora.getHour() <= 14) && (hora.getMinute() == 0))) {
            escribir("Buenos días");
        } else if ((hora.getHour() >= 14) && (hora.getHour() <= 20)) {
            escribir("Buenas tardes");
        }
        
        // Prueba STrings
        String cosa1 = "hola1";
        String cosa2 = "hola1";
        escribir("Comparar 2 Strings con == en un if:");
        if (cosa1 == cosa2){
            escribir("son iguales");
        } else {
            escribir("no son iguales");
        }
        //
        escribir("Comparar con equals");
        if (cosa1.equals(cosa2)){
            escribir("son iguales");
        } else {
            escribir("no son iguales");
        }
        escribir("**********");
        // creamos otras dos variables String en forma de objeto
        String cosa11 = new String("cosa");
        String cosa22 = new String("cosa");
        // Al crearlos como objeto, con == no se pueden comprar
        // comparar con ==
        if (cosa11 == cosa22){
            escribir("son iguales");
        } else {
            escribir("no son iguales");
        }
        //
        if (cosa11.toString() == cosa22.toString())
            escribir("con toString, son iguales");
        else
            escribir("con toString, no son iguales");
            //
        escribir(cosa11.toString()+" "+cosa22.toString());
        if (cosa1.toString() == cosa2.toString())
            escribir("con to-string en cosa1-2 si son iguales");
        else
            escribir("con to-string en cosa1-2 no son iguales");
    }   
}
