package Streams_Files_And_Directories_Exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Line_Numbers_05 {
    public static int countRow = 1;
    public static void main(String[] args) throws IOException {

        String path = "inputLineNumbers.txt";
        String outputPath = "outputLine.txt";
        PrintWriter writer = new PrintWriter(outputPath);

        Files.readAllLines(Path.of(path))
                .forEach(line -> writer.println(countRow++ + ". " + line));

        writer.close();
    }
}
