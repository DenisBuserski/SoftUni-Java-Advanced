package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class Population_Counter_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, TreeMap<String, Long>> countryInfo = new LinkedHashMap<>();

        while (!input.equals("report")) {
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);

            countryInfo.putIfAbsent(country, new TreeMap<>(Collections.reverseOrder()));
            TreeMap<String, Long> cityInfo = countryInfo.get(country);

            if (!cityInfo.containsKey(city)) {
                cityInfo.put(city, population);
            } else {
                cityInfo.put(city, cityInfo.get(city) + population);
            }

            input = scanner.nextLine();
        }

        List<Map.Entry<String, TreeMap<String, Long>>> sortList = new ArrayList<>();

        for (Map.Entry<String, TreeMap<String, Long>> country : countryInfo.entrySet()) {
            sortList.add(country);
        }

        sortList.sort((country1, country2) -> country2.getValue().values().stream().reduce(0L, Long::sum)
                .compareTo(country1.getValue().values().stream().reduce(0L, Long::sum)));

        for (Map.Entry<String, TreeMap<String, Long>> country : sortList) {
            System.out.printf("%s (total population: %d)%n",
                    country.getKey(),country.getValue().values().stream().reduce(0L, Long::sum));

            country.getValue()
                .entrySet()
                .stream()
                .sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                .forEach(city -> System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
        }
    }
}
