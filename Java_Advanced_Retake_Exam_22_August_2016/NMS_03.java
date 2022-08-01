package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_22_August_2016;

import java.util.Scanner;

public class NMS_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder();
        char current = 0;

        String input;
        while (!"---NMS SEND---".equals(input = scanner.nextLine())) {

            for (int index = 0; index < input.length(); index++) {

                if (current <= input.toLowerCase().charAt(index)) {
                    text.append(input.charAt(index));
                } else {
                    text.append(" ").append(input.charAt(index));
                }
                current = input.toLowerCase().charAt(index);

            }
        }

        String delimiter = scanner.nextLine();
        if (delimiter.equals("(space)")) {
            delimiter = " ";
        }

        String newWord = text.toString().replace(" ", delimiter);
        System.out.println(newWord);
    }
}
