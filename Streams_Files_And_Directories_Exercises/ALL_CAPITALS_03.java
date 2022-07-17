package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Streams_Files_And_Directories_Exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ALL_CAPITALS_03 {
    public static void main(String[] args) {

        Path path = Path.of
                ("C:\\Users\\Acer\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\JavaOOP.input.txt");
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        } catch (IOException io) {
            System.out.println("Another error with reading file");
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            for (String line : lines) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static int getSumAsciiLine(String line) {
        int sum = 0;
        for (char symbol : line.toCharArray()) {
            sum += symbol;
        }
        return sum;
    }

}
