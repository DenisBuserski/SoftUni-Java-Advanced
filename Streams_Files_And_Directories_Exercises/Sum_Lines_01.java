package Streams_Files_And_Directories_Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Sum_Lines_01 {
    public static void main(String[] args) {

        // String path = "input.txt";
        Path path = Path.of("input.txt");

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
