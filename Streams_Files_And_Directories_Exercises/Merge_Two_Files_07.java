package Streams_Files_And_Directories_Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Merge_Two_Files_07 {
    public static void main(String[] args) throws IOException {
        String pathOne = "inputOne.txt";
        String pathTwo = "inputTwo.txt";
        String outputPath = "outputMerge.txt";

        PrintWriter writer = new PrintWriter(outputPath);
        Files.readAllLines(Path.of(pathOne))
                .forEach(writer::println);
        
        Files.readAllLines(Path.of(pathTwo))
                .forEach(writer::println);

        writer.close();
    }
}
