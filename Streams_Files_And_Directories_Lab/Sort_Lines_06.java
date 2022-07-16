package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Streams_Files_And_Directories_Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort_Lines_06 {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = new FileInputStream("C:\\\\Users\\\\Acer\\\\Desktop\\\\SoftUni\\\\Advanced - Java\\\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\\\JavaOOP.input.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        List<String> lines = new ArrayList<>();

        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        Collections.sort(lines);

        //Files.write(Path.of("sorted-lines.txt"), lines);

        BufferedWriter writer = new BufferedWriter(new FileWriter("out-test.txt"));

        writer.write(String.join(System.lineSeparator(), lines));

        writer.flush();
        writer.close();


    }
}
