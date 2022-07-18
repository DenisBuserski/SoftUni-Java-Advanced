package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Functional_Programming_Lab;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Find_Evens_Or_Odds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] tokens = scanner.nextLine().split("\\s+");
        int lower = Integer.parseInt(tokens[0]);
        int upper = Integer.parseInt(tokens[1]);
        String oddOrEven = scanner.nextLine();

        Predicate<Integer> filter = getFilter(oddOrEven);
        Consumer<Integer> printer = x -> System.out.print(x + " ");

        IntStream
                .rangeClosed(lower, upper)
                .boxed()
                .filter(filter)
                .forEach(printer);

    }

    public static Predicate<Integer> getFilter(String oddOrEven) {
        if (oddOrEven.equals("odd")) {
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }

}
