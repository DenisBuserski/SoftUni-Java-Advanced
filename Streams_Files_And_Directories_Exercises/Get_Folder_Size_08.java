package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Streams_Files_And_Directories_Exercises;

import java.io.File;

public class Get_Folder_Size_08 {
    public static void main(String[] args) {

        String path = "C:\\Users\\Acer\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);

        int size = 0;
        for (File file : folder.listFiles()) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);

    }
}
