package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Matching_Brackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= input.length() - 1; i++) {
            char symbol = input.charAt(i);

            if (symbol == '(') {
                stack.push(i);
            } else if (symbol == ')'){
                int startIndex = stack.pop();
                String contents =input.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
