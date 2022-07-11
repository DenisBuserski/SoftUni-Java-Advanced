package Stacks_And_Queues_Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Reverse_Numbers_With_A_Stack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbers = scanner.nextLine();
        String [] numbersArray = numbers.split("\\s+");

        ArrayDeque<Integer> nums = new ArrayDeque<>();

        for (String element : numbersArray) {
            nums.push(Integer.parseInt(element));
        }

        while (!nums.isEmpty()) {
            System.out.print(nums.pop() + " ");
        }
    }
}
