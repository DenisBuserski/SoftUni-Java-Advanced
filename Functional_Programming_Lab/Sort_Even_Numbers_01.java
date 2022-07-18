package Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sort_Even_Numbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        Function<IntStream, String> formatNumbers = str ->
                str.mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        IntStream stream = Arrays.stream(numbers);

        String evenNumbers = formatNumbers.apply(Arrays.stream(numbers));
        System.out.println(evenNumbers);

        String sortedNumbers = formatNumbers.apply(Arrays.stream(numbers).sorted());
        System.out.println(sortedNumbers);
    }
}
