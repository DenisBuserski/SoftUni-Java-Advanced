package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Streams_Files_And_Directories_Lab;

import java.io.File;
import java.io.IOException;

public class List_Files_07 {
    public static void main(String[] args) throws IOException {

        File file =
                new File("C:\\Users\\Acer\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File [] files  = file.listFiles();

        for (File f : files) {

            if (!f.isDirectory()) {
                System.out.printf("%s: [%d]%n", f.getName(), f.length());
            }
        }



    }
}
