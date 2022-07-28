package Iterators_And_Comparators_Exercises.Comparing_Objects_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String [] data = command.split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]), data[2]);
            people.add(person);

            command = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());
        Person searchedPerson = people.get(n - 1);

        int countEquals = 0;
        for (Person p : people) {
            if (searchedPerson.compareTo(p) == 0) {
                countEquals++;
            }
        }

        if (countEquals == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(countEquals + " " + (people.size()  - countEquals) + " " + people.size());
        }

    }
}
