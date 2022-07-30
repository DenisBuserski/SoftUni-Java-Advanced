package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Datura Bombs: 40
        //Cherry Bombs: 60
        //Smoke Decoy Bombs: 120

        int daturaBomb = 0;
        int cherryBomb = 0;
        int smokeBomb = 0;

        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(bombEffects::offer);
        ArrayDeque<Integer> bombCasings = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(bombCasings::push);

        while (!bombEffects.isEmpty() && !bombCasings.isEmpty()) {
            if (daturaBomb >= 3 && cherryBomb >= 3 && smokeBomb >= 3 ) {
                break;
            }

            int sum = bombEffects.peek() + bombCasings.peek();

            if (sum == 40) {
                daturaBomb++;
                bombEffects.poll();
                bombCasings.pop();
            } else if (sum == 60) {
                cherryBomb++;
                bombEffects.poll();
                bombCasings.pop();
            } else if (sum == 120) {
                smokeBomb++;
                bombEffects.poll();
                bombCasings.pop();
            } else {
                int currentBomb = bombCasings.peek() - 5;
                bombCasings.pop();
                bombCasings.push(currentBomb);
            }


        }

        if (cherryBomb >= 3 && daturaBomb >= 3 && smokeBomb >= 3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (!bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: " + bombEffects.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Bomb Effects: empty");
        }

        if (!bombCasings.isEmpty()) {
            System.out.println("Bomb Casings: " + bombCasings.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("Bomb Casings: empty");
        }


        System.out.println("Cherry Bombs: " + cherryBomb);
        System.out.println("Datura Bombs: " + daturaBomb);
        System.out.println("Smoke Decoy Bombs: " + smokeBomb);



    }
}
