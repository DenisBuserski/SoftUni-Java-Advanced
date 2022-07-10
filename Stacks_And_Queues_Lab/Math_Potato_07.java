package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Math_Potato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);

        int cycle = 1;
        while (children.size() > 1) {
            for (int i = 1; i < n; i++)
                children.offer(children.poll());

            if (isPrime(cycle)) {
                System.out.println("Prime " + children.peek());
            } else {
                System.out.println("Removed " + children.poll());
            }

            cycle++;
        }
        System.out.println("Last is " + children.poll());


    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;

        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
