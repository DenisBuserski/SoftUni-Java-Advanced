package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_03_May_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LetterExpresion_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //The correct regex should be: "([-]?[0-9]*\\.[0-9]+|[0-9]+)"
        String regX = "([-]?[0-9]+)";
        String input = reader.readLine();
        ArrayDeque<String> junkSymbols = new ArrayDeque<>(Arrays.asList(input.split(regX))
                .stream().filter(s -> !s.isEmpty())
                .collect(Collectors.toList()));

        ArrayDeque<Double> nums = new ArrayDeque<>();
        Predicate<String> isEven = s -> s.length() % 2 == 0;
        Pattern pattern = Pattern.compile(regX);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            nums.add(Double.parseDouble(matcher.group()));
        }

        double sum = nums.pop();

        while (!nums.isEmpty()) {
            if (isEven.test(junkSymbols.peek())) {
                sum += nums.pop();
            } else {
                sum -= nums.pop();
            }
            junkSymbols.pop();
        }
        DecimalFormat f = new DecimalFormat("##.#######");
        System.out.println(f.format(sum));
    }
}