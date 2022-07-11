package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Stacks_And_Queues_Exercises;

import java.util.Scanner;

public class Recursive_Fibonacci_07 {

    public static long [] memoryForFib;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memoryForFib = new long [n + 1];
        System.out.println(fib(n));


    }

    public static long fib (int n) {
        if (n <= 1) {
            return 1;
        }

        if (memoryForFib[n] != 0) {
            return memoryForFib[n];
        }

        return memoryForFib[n] = fib(n - 1) + fib(n - 2);
    }
}
