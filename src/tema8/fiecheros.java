package tema8;

import java.io.*;
import java.util.Scanner;

/**
 * fiecheros
 */
public class fiecheros {

    private static void escribir() {
        try {
            File myObj = new File("c:\\datos\\archivo01.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // try createNewFile

        try {
            FileWriter myWriter = new FileWriter("c:\\datos\\archivo01.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } // try FileWriter
    } // escribir

    private static void leer() {
        try {
            File myObj = new File("c:\\datos\\archivo01.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    } // leer

    private static void info(){
        File myObj = new File("c:\\datos\\archivo01.txt");
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
          } else {
            System.out.println("The file does not exist.");
          }
    }

    public static void main(String[] args) {
        escribir();
        leer();
        info();
    }
}