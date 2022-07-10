package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Decimal_To_Binary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (decimal == 0) {
            stack.push(0);
        } else {
            while (decimal > 0) {
                stack.push(decimal % 2);
                decimal /= 2;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }


    }
}
