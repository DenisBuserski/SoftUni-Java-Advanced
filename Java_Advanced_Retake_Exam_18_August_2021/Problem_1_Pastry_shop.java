package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Retake_Exam_18_August_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_1_Pastry_shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);

        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int sum = liquids.peek() + ingredients.peek();

            if (sum == 25) {
                biscuit++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 50) {
                cake++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 75) {
                pastry++;
                liquids.poll();
                ingredients.pop();
            } else if (sum == 100) {
                pie++;
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                int newIngredient = ingredients.peek() + 3;
                ingredients.pop();
                ingredients.push(newIngredient);
            }
        }

        if (biscuit >= 1 && cake >= 1 && pastry >= 1 && pie >= 1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }


        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquids.toString().replaceAll("[\\[\\]]", ""));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredients.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.println("Biscuit: " + biscuit);
        System.out.println("Cake: " + cake);
        System.out.println("Pie: " + pie);
        System.out.println("Pastry: " + pastry);
    }
}
