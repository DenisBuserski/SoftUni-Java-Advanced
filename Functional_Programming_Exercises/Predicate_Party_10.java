package Functional_Programming_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Predicate_Party_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> newPeople = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] command = input.split("\\s+");
            String commandName = command[0];
            String commandOption = command[1];
            String criteria = command[2];

            addOrRemove(people, commandName, commandOption, criteria, newPeople);

            input = scanner.nextLine();
        }

        people.addAll(newPeople);
        List<String> sortedPeople = people.stream().sorted().collect(Collectors.toList());
        if (sortedPeople.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(sortedPeople.toString().replaceAll("[\\[\\]]", ""));
            System.out.print(" are going to the party!");
        }

    }

    private static void addOrRemove(List<String> people, String commandName, String commandOption, String criteria, List<String> newPeople) {
        switch (commandName) {
            case "Remove":
                switch (commandOption) {
                    case "StartsWith":
                        people.removeIf(person -> person.startsWith(criteria));
                        break;
                    case "EndsWith":
                        people.removeIf(person -> person.endsWith(criteria));
                        break;
                    case "Length":
                        int length = Integer.parseInt(criteria);
                        people.removeIf(person -> person.length() == length);
                        break;
                }
                break;
            case "Double":
                switch (commandOption) {
                    case "StartsWith":
                        people.stream().filter(person -> person.startsWith(criteria)).forEach(newPeople::add);
                        break;
                    case "EndsWith":
                        people.stream().filter(person -> person.endsWith(criteria)).forEach(newPeople::add);
                        break;
                    case "Length":
                        int length = Integer.parseInt(criteria);
                        people.stream().filter(person -> person.length() == length).forEach(newPeople::add);
                        break;
                }
                people.addAll(newPeople);
                newPeople.clear();
                break;
        }
    }
    
}
