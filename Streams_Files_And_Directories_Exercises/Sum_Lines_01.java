package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Streams_Files_And_Directories_Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Sum_Lines_01 {
    public static void main(String[] args) {

        //String path = "C:\\Users\\Acer\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\JavaOOP.input.txt";
        Path path = Path.of
                ("C:\\Users\\Acer\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\JavaOOP.input.txt");

        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        } catch (NoSuchFileException e) {
            System.out.println("There is no such file on this path");
        } catch (IOException io) {
            System.out.println("Another error with reading file");
        }


        for (String line : lines) {
            printSumOfAscii(line);
        }




    }

    public static void printSumOfAscii(String line) {
        int sum = 0;
        for (char symbol : line.toCharArray()) {
            sum += symbol;
        }
        System.out.println(sum);
    }
}
