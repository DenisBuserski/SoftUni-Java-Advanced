package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Functional_Programming_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Find_The_Smallest_Element_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> printMinElement = list -> {
            int min = Integer.MAX_VALUE;
            for (int number : list) {
                if (number < min) {
                    min = number;
                }
            }
            System.out.println(list.lastIndexOf(min));
        };

        printMinElement.accept(numbers);

    }
}
