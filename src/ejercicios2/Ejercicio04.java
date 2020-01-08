package ejercicios2;

import java.util.Scanner;
import tema5.CosasVarias; 

/**
 * Ejercicio04
 * 
 * Programa que lea por teclado tres números enteros H, M, S correspondientes a
 * hora, minutos y segundos respectivamente, y comprueba si la hora que indican
 * es una hora válida.
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int HH, MM, SS;
        boolean bucle = true;
        char SioNo;

        CosasVarias.escribeLinea("------------------------------------------------------------");        
        CosasVarias.escribeLinea("-             Horas, Minutos y Segundos válidos            -");        
        CosasVarias.escribeLinea("------------------------------------------------------------");        
        while (bucle){
            CosasVarias.escribe("Introduce las horas (HH): ");
            HH = entrada.nextInt();
            CosasVarias.escribe("Introduce los minutos (MM): ");
            MM = entrada.nextInt();
            CosasVarias.escribe("Introduce los segundos (SS): ");
            SS = entrada.nextInt();
            // Comprobar que los datos son válidos
            // HH debe tener un valor entre 0 y 23
            // MM y SS debe tener un valor entre 0 y 59
            if ((HH >= 0 && HH <= 23) && (MM >= 0 && MM <= 59) && (SS >= 0 && SS <= 59)){
                CosasVarias.escribeLinea("La hora "+HH+":"+MM+":"+SS+" es válida.");
            } else {
                CosasVarias.escribeLinea("La hora "+HH+":"+MM+":"+SS+" no es válida.");
            }
            //
            CosasVarias.escribe("¿Desea comprobar más horas? (S/N): ");
            SioNo = entrada.next().charAt(0);
            if (SioNo == 'n' || SioNo == 'N'){
                bucle = false;
            } else {
                bucle = true;
            }
        }

        // cerrar scanner
        entrada.close();
    }
}