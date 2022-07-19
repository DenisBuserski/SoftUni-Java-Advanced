package Functional_Programming_Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Predicate_For_Names_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String [] names = scanner.nextLine().split("\\s+");

        Predicate<String> checkLength = name -> name.length() <= length;

        Arrays.stream(names).filter(checkLength).forEach(System.out::println);
    }
}
