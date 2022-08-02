package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Exam_19_June_2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cubics_Messages_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        while (!"Over!".equals(input = scanner.nextLine())) {
            int wordLength = Integer.parseInt(scanner.nextLine());

            String regex = "^(?<start>[0-9]+)(?<word>[a-zA-Z]+)(?<end>[^a-zA-Z]*)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String word = matcher.group("word");
                

                if (word.length() == wordLength) {
                    String secretWord = matcher.group("word");

                    String numbers = matcher.group("start").concat(matcher.group("end"));
                    List<Integer> indexes = new ArrayList<>();
                    for (int i = 0; i < numbers.length(); i++) {
                        if (Character.isDigit(numbers.charAt(i))) {
                            int current = Integer.parseInt(String.valueOf(numbers.charAt(i)));
                            indexes.add(current);
                        }

                    }

                    printResult(wordLength, secretWord, indexes);
                }
            }


        }
    }


    public static void printResult(int wordLength, String secretWord, List<Integer> indexes) {
        StringBuilder verificationCode = new StringBuilder();
        for (Integer index : indexes) {
            if (index < wordLength) {
                verificationCode.append(String.valueOf(secretWord.charAt(index)));
            } else {
                verificationCode.append(" ");
            }
        }

        System.out.println(secretWord + " == " + verificationCode.toString());
    }
}
