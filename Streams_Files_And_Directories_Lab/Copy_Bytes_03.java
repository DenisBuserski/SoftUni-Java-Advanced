package Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Copy_Bytes_03 {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

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
