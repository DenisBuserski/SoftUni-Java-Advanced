package Functional_Programming_Exercises;

import java.util.Scanner;
import java.util.function.Consumer;

public class Knights_Of_Honor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] names = input.split("\\s+");

        Consumer<String> printSir = s -> System.out.println("Sir " + s);

        for (String name : names) {
            printSir.accept(name);
        }
        
    }
}
