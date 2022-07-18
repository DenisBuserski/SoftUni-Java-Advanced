package Functional_Programming_Exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class Consumer_Print_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] names = input.split("\\s+");

        Consumer<String[]> printStrings = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };

        printStrings.accept(names);
    }
}
