package Defining_Classes_Exercises.Cat_Lady_09;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> catData = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String catType = tokens[0];
            String catName = tokens[1];

            Cat cat = null;

            switch (catType) {
                case "Siamese":
                    String earSize = tokens[2];
                    cat = new Cat(catName, catType, earSize);
                    catData.put(catName, cat);
                    break;
                case "Cymric":
                    String furLength = tokens[2];
                    cat = new Cat(catName, catType, furLength);
                    catData.put(catName, cat);
                    break;
                case "StreetExtraordinaire":
                    String meowingDecibels = tokens[2];
                    cat = new Cat(catName, catType, meowingDecibels);
                    catData.put(catName, cat);
                    break;
            }

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();

        for (var entry : catData.entrySet()) {
            if (name.equals(entry.getKey())) {
                String catName = entry.getKey();
                String catType = entry.getValue().getCatType();
                double thirdParameterToDouble = Double.parseDouble(entry.getValue().getThirdParameter());
                System.out.printf("%s %s %.2f", catType, catName, thirdParameterToDouble);
            }
        }

    }
}
