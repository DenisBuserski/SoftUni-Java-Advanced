package Functional_Programming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Custom_Min_Function_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] numbers = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> getMin = array -> System.out.println(Arrays.stream(array).min().orElse(0));

        getMin.accept(numbers);
    }
}
