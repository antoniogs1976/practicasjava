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
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in, "utf-8");
        Cliente[] clientes = new Cliente[5];
        Cliente clienteMasViejo;
        String nombre, apellido="";
        int edad;
        // limpiar pantalla
        MisClases.limpiarPantalla();
        // asignar clientes a mano
        //clientes[0] = new Cliente("Antonio", "", 30);
        //clientes[1] = new Cliente("Basilio", "", 25);
        //clientes[2] = new Cliente("Carlos", "", 50);
        //clientes[3] = new Cliente("Daniel", "", 60);
        //clientes[4] = new Cliente("Francisco", "", 35);

        // introducir los datos de los clientes a mano
        for(int i = 0; i<clientes.length;i++){
            MisClases.escribe("Introduce el nombre del cliente "+(i+1)+": ");
            nombre = entrada.nextLine();
            MisClases.escribe("Introduce la edad del cliente "+(i+1)+": ");
            edad = entrada.nextInt();
            MisClases.escribeLinea(""); // retorno de carro
            entrada.nextLine(); // Vaciar el buffer
            clientes[i] = new Cliente(nombre, apellido, edad);
        }
        // Averiguar cual es el más viejo
        clienteMasViejo = clienteMayor(clientes);
        
        // mostrar los datos:
        MisClases.escribeLinea("El cliente de mayor edad es:");
        MisClases.escribeLinea(clienteMasViejo.getNombre() + " con una edad de " + clienteMasViejo.getEdad());
        // cerrar entrada
        entrada.close();
    }
}