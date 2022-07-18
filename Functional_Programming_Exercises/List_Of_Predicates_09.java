package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Functional_Programming_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class List_Of_Predicates_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int [] divisibleSequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            numbers.add(i);
        }

        Predicate<Integer> check = (i) -> {
            for (Integer a : divisibleSequence) {
                if (a == 0)
                    continue;
                if (i % a != 0)
                    return false;
            }
            return true;
        };

        for (Integer i : numbers)
            if (check.test(i))
                System.out.printf("%d ", i);

    }
}
