package Streams_Files_And_Directories_Exercises;

import java.io.File;

public class Get_Folder_Size_08 {
    public static void main(String[] args) {

        String path = " ";
        File folder = new File(path);

        int size = 0;
        for (File file : folder.listFiles()) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);
    }
}
