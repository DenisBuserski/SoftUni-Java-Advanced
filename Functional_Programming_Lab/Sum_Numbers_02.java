package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Sum_Numbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tokens = scanner.nextLine().split(", ");

        Function<String[], Stream<Integer>> map = arr -> Arrays.stream(arr).map(Integer::parseInt);

        Function<Stream<Integer>, Integer> sum = str -> str.mapToInt(e -> e).sum();
        Function<Stream<Integer>, Long> count = str -> str.mapToInt(e -> e).count();


        Consumer<Long> printCountConsumer = num -> System.out.println("Count = " + num);
        Consumer<Integer> printSumConsumer = num -> System.out.println("Sum = " + num);

        printCountConsumer.accept(count.apply(map.apply(tokens)));
        //System.out.println("Count = " + count.apply(map.apply(tokens)));
        printSumConsumer.accept(sum.apply(map.apply(tokens)));
        //System.out.println("Sum = " + sum.apply(map.apply(tokens)));

    }
}
