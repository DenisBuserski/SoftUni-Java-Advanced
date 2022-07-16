package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class Write_To_File_02 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Acer\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\JavaOOP.input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Set<Character> separators = Set.of(',', '.', '!', '?');

        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("write-to-file.txt");

        while (nextByte != -1) {
            char symbol = (char) nextByte;

            if (!separators.contains(symbol)) {
                printStream.print(symbol);
            }

            nextByte = inputStream.read();
        }





    }
}
