package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_26_June_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_1_OS_Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(threads::offer);

        int taskToKilled = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {

            int task = tasks.peek();
            int thread= threads.peek();


            if (thread >= task ) {

                if (task == taskToKilled) {
                    System.out.printf("Thread with value %d killed task %s%n", thread, taskToKilled);
                    System.out.print(threads.toString().replaceAll("[\\[\\],]", ""));
                    break;
                } else {
                    threads.poll();
                    tasks.pop();
                }
            } else {
                if (task == taskToKilled) {
                    System.out.printf("Thread with value %d killed task %s%n", thread, taskToKilled);
                    System.out.print(threads.toString().replaceAll("[\\[\\],]", ""));
                    break;
                } else {
                    threads.poll();
                }

            }

        }




    }
}
