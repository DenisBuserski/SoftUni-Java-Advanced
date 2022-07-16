package Streams_Files_And_Directories_Lab;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class Nested_Folders_08 {
    public static void main(String[] args) throws IOException {

        File file = new File(" ");

        ArrayDeque<File> files = new ArrayDeque<>();

        files.offer(file);

        PrintStream printStream = new PrintStream("nested-out.txt");

        while (!files.isEmpty()) {
            File innerFile = files.poll();
            printStream.println(innerFile.getName());

            for (File f : innerFile.listFiles()) {
                if (f.isDirectory()) {
                    files.offer(f);
                } else {
                    printStream.println(f.getName());
                }
            }
        }

    }
}
