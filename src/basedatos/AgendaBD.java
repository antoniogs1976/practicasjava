package basedatos;

import java.sql.Connection;
import java.util.Scanner;

/**
 * AgendaBD
 */
public class AgendaBD {

    public static void main(String[] args) {
        // Scanner par la entrada de datos
        Scanner entrada = new Scanner(System.in);
        int opcion;
        
        // abrir conexion
        Connection con = BDUtil.conexion();
        if (con != null){
            System.out.println("Conexión establecida con éxito");
        }

        // dibujamos el menú principal en bucle
        do{
            BDUtil.menuPrincipal(entrada);
            do{
                System.out.print("Elige una opción: ");
                while (!entrada.hasNextInt()) {
                    String input = entrada.next();
                    System.out.printf("\"%s\" no es una opción válida.\n", input);
                }
                opcion = entrada.nextInt();
            } while (opcion < 0);

            // vamos llamando cosas
            switch (opcion){
                case 1: BDUtil.alta();
                        break;
                case 2: BDUtil.baja();
                        break;
                case 3: BDUtil.modificar();
                        break;
                case 4: BDUtil.consulta();
                        break;
            }
        } while (opcion != 9);

















        // cerrar la conexión a la BBDD
        BDUtil.cerrarConexion(con);
        // cerrar el scanner
        entrada.close();
    }
}