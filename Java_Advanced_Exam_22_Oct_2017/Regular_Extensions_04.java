package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Exam_22_Oct_2017;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_Extensions_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String line;

        while (!"Print".equals(line = scanner.nextLine())){
            String[] inputs = line.split("%", -1);

            for (int i = 0; i < inputs.length; i++) {
                inputs[i] = Pattern.quote(inputs[i]);
            }

            Pattern pattern = Pattern.compile(String.join("\\S*", inputs));
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                String currentWord = matcher.group();
                StringBuilder reversed = new StringBuilder(currentWord).reverse();
                input = input.replace(currentWord, reversed.toString());
            }
        }

        System.out.println(input);


    }
}
