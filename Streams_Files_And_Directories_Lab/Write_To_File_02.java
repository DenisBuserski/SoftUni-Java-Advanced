package Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Set;

public class Write_To_File_02 {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

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
