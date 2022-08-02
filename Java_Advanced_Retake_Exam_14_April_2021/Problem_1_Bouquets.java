package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Retake_Exam_14_April_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_1_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(lilies::push);
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(roses::offer);

        int wreaths = 0;
        int flowersLeft = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int sum = lilies.peek() + roses.peek();

            if (sum == 15) {
                wreaths++;
                lilies.pop();
                roses.poll();
            } else if (sum > 15) {
                int newLilies = lilies.peek() - 2;
                lilies.pop();
                lilies.push(newLilies);
            } else if (sum < 15) {
                flowersLeft += sum;
                lilies.pop();
                roses.poll();
            }

        }

        double additionalWreaths = 0;
        if (flowersLeft != 0) {
            additionalWreaths = flowersLeft / 15;
        }

        int totalWreaths = (int)additionalWreaths + wreaths;
        if (totalWreaths >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", totalWreaths);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - totalWreaths);
        }





    }
}
