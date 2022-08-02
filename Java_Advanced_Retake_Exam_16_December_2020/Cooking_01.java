package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Retake_Exam_16_December_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquids::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredients::push);

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int sum = liquids.peek() + ingredients.peek();

            if (sum == 25) {
                bread++;
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
                fruitPie++;
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                int newIngredient = ingredients.peek() + 3;
                ingredients.pop();
                ingredients.push(newIngredient);
            }
        }

        if (bread >= 1 && cake >= 1 && pastry >= 1 && fruitPie >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
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

        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);

    }
}
