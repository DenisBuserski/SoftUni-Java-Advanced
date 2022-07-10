package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Simple_Calculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] expressionElements = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = expressionElements.length - 1; i >= 0; i--) {
            stack.push(expressionElements[i]);
        }

        while (stack.size() > 1) {
            int leftOperand = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int rightOperand = Integer.parseInt(stack.pop());

            int result = operator.equals("+")
                    ? leftOperand + rightOperand
                    : leftOperand - rightOperand;

            stack.push(String.valueOf(result));
        }

        System.out.println(stack.pop());

    }
}
