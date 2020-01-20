package tema8;

import java.io.*;

/**
 * fiecheros
 */
public class fiecheros {

    public static void escribir() {
        FileWriter fichero;
        fichero = new FileWriter("c:\\datos\\archivo01.txt");
        




        fichero.close();
        
        
        
        //try {
        //    File myObj = new File("c:\\datos\\archivo01.txt");
        //    if (myObj.createNewFile()) {
        //        System.out.println("File created: " + myObj.getName());
        //    } else {
        //        System.out.println("File already exists.");
        //    }
        //} catch (IOException e) {
        //    System.out.println("An error occurred.");
        //    e.printStackTrace();
        //} // try crear
//
        //try {
        //    FileWriter myWriter = new FileWriter("c:\\datos\\archivo01.txt");
        //    myWriter.write("Files in Java might be tricky, but it is fun enough!");
        //    myWriter.close();
        //    System.out.println("Successfully wrote to the file.");
        //} catch (IOException e) {
        //    System.out.println("An error occurred.");
        //    e.printStackTrace();
        //}
    } // try escribir

    public static void leer() {

    }

    public static void main(String[] args) {
        escribir();
        leer();
    }
}