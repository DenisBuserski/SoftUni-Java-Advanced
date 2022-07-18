package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Add_VAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> mapWithVat = str -> Double.parseDouble(str) * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .map(mapWithVat)
                .forEach(e -> System.out.printf("%.2f%n", e));







    }
}
