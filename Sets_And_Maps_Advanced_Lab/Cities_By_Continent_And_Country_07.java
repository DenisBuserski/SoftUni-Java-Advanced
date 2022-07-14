package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class Cities_By_Continent_And_Country_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String> > > infoTable = new LinkedHashMap<>();


        while (n-- > 0) {
        String [] tokens = scanner.nextLine().split("\\s+");
        String continent = tokens[0];
        String country = tokens[1];
        String city = tokens[2];

        infoTable.putIfAbsent(continent, new LinkedHashMap<>());

        LinkedHashMap<String, List<String>> innerMap = infoTable.get(continent);

        innerMap.putIfAbsent(country, new ArrayList<>());

        innerMap.get(country).add(city);


        }

        for (var entry : infoTable.entrySet()) {
            String key = entry.getKey();
            LinkedHashMap<String, List<String>> innerMap = entry.getValue();

            System.out.println(key + ":");
            for (var innerEntry : innerMap.entrySet()) {
                System.out.println("  " + innerEntry.getKey() + " -> " + String.join(", ", innerEntry.getValue()));
            }


        }


    }
}
