package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Streams_Files_And_Directories_Lab;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Extract_Integers_04 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Acer\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\JavaOOP.input.txt";

        FileReader reader = new FileReader(path);

        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
