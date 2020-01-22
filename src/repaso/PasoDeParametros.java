package repaso;

import java.util.Scanner;
import miscosas.MisClases;
/**
 * PasoDeParametros
 */
public class PasoDeParametros {

    public static Cliente clienteMayor(Cliente[] listadoClientes){
        int tmp = 0, indice = 0;
        for(int i =0;i<listadoClientes.length;i++){
            if (i==0){
                tmp = listadoClientes[i].getEdad();
                indice = i;
            } else {
                if (listadoClientes[i].getEdad() > tmp){
                    tmp = listadoClientes[i].getEdad();
                    indice = i;
                }
            }
        }
        return listadoClientes[indice];
    } // clienteMayor

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "utf-8");
        Cliente[] clientes = new Cliente[5];
        Cliente clienteMasViejo;
        String nombre;
        int edad;
        // limpiar pantalla
        MisClases.limpiarPantalla();
        // introducir los datos de los clientes uno a uno
        for(int i = 0; i<clientes.length;i++){
            MisClases.escribe("Introduce el nombre del cliente "+(i+1)+": ");
            nombre = entrada.nextLine();
            MisClases.escribe("Introduce la edad del cliente "+(i+1)+": ");
            edad = entrada.nextInt();
            MisClases.escribeLinea(""); // retorno de carro
            entrada.nextLine(); // Vaciar el buffer
            clientes[i] = new Cliente(nombre, edad);
        }
        // Averiguar cual es el más viejo
        clienteMasViejo = clienteMayor(clientes);
        // mostrar los datos:
        MisClases.escribeLinea("El cliente de mayor edad es:");
        MisClases.escribeLinea(clienteMasViejo.getDatos());
        // cerrar entrada
        entrada.close();
    }
}