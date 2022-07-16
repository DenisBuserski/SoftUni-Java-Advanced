package Streams_Files_And_Directories_Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Read_File_01 {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);

        int nextByte = inputStream.read();
        while (nextByte != -1) {
            System.out.print(Integer.toBinaryString(nextByte) + " ");
            nextByte = inputStream.read();
        }
        
    }
}
