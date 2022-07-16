package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Copy_Bytes_03 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Acer\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\JavaOOP.input.txt";

        FileInputStream inputStream = new FileInputStream(path);


        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("copy-bites.txt");

        while (nextByte != -1) {

            if (nextByte == ' ') {
                printStream.print((char) nextByte);
            } else if (nextByte == 10) {
                printStream.println();
            } else {
                printStream.print(nextByte);
            }


            nextByte = inputStream.read();
        }

    }
}
