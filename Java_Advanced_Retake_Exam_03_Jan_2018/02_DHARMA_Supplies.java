package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_03_Jan_2018;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMA_Supplies_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> crates = new ArrayList<>();
        Integer cratesCount = 0;
        Integer validCratesCount = 0;
        Integer linesCount = 0;

        Integer amountOfFood = 0;
        Integer amountOfDrinks = 0;

        String line;
        while (!"Collect".equals(line = scanner.nextLine())) {
            Pattern cratesPattern = Pattern.compile("\\[.*?]");
            Matcher cratesMatcher = cratesPattern.matcher(line);
            while (cratesMatcher.find()) {
                cratesCount++;
                crates.add(cratesMatcher.group());
            }

            linesCount++;
        }
        Integer N = cratesCount / linesCount;

        Pattern pattern = Pattern.compile("\\[(#\\d{" + N + "}|#[a-z]{" + N + "})([a-zA-Z0-9\\s]*)\\1\\]");

        for (String crate : crates) {
            Matcher match = pattern.matcher(crate);

            while (match.find()) {
                String supplyBody = match.group(2);
                String supplyTag = match.group(1);

                validCratesCount++;
                if (Character.isDigit(supplyTag.charAt(1))) {
                    int food = 0;
                    Set<Character> uniqueChars = new HashSet<>();
                    for (int i = 0; i < supplyBody.length(); i++) {
                        uniqueChars.add(supplyBody.charAt(i));
                    }
                    for (char ch : uniqueChars) {
                        food += ch;
                    }
                    food *= supplyTag.length() - 1;
                    amountOfFood += food;
                } else {
                    int drink = 0;
                    int tagSum = 0;
                    for (int i = 0; i < supplyBody.length(); i++) {
                        drink += supplyBody.charAt(i);
                    }
                    for (int i = 1; i < supplyTag.length(); i++) {
                        tagSum += supplyTag.charAt(i);
                    }
                    drink *= tagSum;
                    amountOfDrinks += drink;
                }
            }
        }

        if (validCratesCount > 0) {
            System.out.printf("Number of supply crates: %d%n", validCratesCount);
            System.out.printf("Amount of food collected: %d%n", amountOfFood);
            System.out.printf("Amount of drinks collected: %d%n", amountOfDrinks);
        } else {
            System.out.println("No supplies found!");
        }
    }
}