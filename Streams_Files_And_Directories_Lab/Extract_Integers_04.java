package Streams_Files_And_Directories_Lab;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Extract_Integers_04 {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileReader reader = new FileReader(path);

        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
        
    }
}
