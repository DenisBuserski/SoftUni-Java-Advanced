package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Simple_Text_Editor_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> stack = new ArrayDeque<>();
        String text = "";

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split(" ");

            switch (token[0]) {
                case "1":
                    stack.push(text);
                    text += token[1];
                    break;
                case "2":
                    stack.push(text);
                    int count = Integer.parseInt(token[1]);
                    text = text.substring(0, text.length() - count);
                    break;
                case "3":
                    int index = Integer.parseInt(token[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case "4":
                    text = stack.pop();
                    break;
            }
        }



    }
}
