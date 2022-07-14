package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Srubsko_Unleashed_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Integer>> singersInfo = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String pattern = "(?<singer>[A-z ]*) [@](?<town>[A-z ]*) (?<ticketPrice>[0-9]+) (?<count>[0-9]+)";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(input);

            while (matcher.find()) {
                String singer = matcher.group("singer");
                String town = matcher.group("town");
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int ticketCount = Integer.parseInt(matcher.group("count"));
                int totalPrice = ticketPrice * ticketCount;

                singersInfo.putIfAbsent(town, new LinkedHashMap<>());
                LinkedHashMap<String, Integer> ticketsInfo = singersInfo.get(town);

                int newInput = 0;
                if (ticketsInfo.containsKey(singer)) {
                    newInput = ticketsInfo.get(singer);
                }
                ticketsInfo.put(singer, newInput + totalPrice);
            }



            input = scanner.nextLine();
        }

        singersInfo.forEach((key, ticketInfo) -> {
            System.out.println(key);

            ticketInfo.entrySet().stream().sorted((a, b) -> {
                int result = b.getValue().compareTo(a.getValue());
                if (result == 0)
                    result = a.getValue().compareTo(b.getValue());
                return result;
            }).forEach(entry -> System.out.println("#  " + entry.getKey() + " -> " + entry.getValue()));


        });





    }
}
