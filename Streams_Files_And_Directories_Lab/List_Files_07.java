package Streams_Files_And_Directories_Lab;

import java.io.File;
import java.io.IOException;

public class List_Files_07 {
    public static void main(String[] args) throws IOException {

        File file = new File("Files-and-Streams");

        File [] files  = file.listFiles();

        for (File f : files) {
            if (!f.isDirectory()) {
                System.out.printf("%s: [%d]%n", f.getName(), f.length());
            }
        }

    }
}
