package Java_Advanced_Exam_20_February_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Magic_Box_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstBox::offer);

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondBox::push);

        int totalSum = 0;

//        System.out.println(firstBox.peek());
//        System.out.println(secondBox.peek());

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int sum = firstBox.peek() + secondBox.peek();
            if (sum % 2 == 0) {
                totalSum += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                int item = secondBox.peek();
                secondBox.pop();
                firstBox.offer(item);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (totalSum >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + totalSum);
        } else {
            System.out.println("Poor prey... Value: " + totalSum);
        }

    }
}
