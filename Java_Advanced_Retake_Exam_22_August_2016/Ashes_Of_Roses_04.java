package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_22_August_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ashes_Of_Roses_04 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> desertRoses = new HashMap<>();

        String input = "";
        while (!"Icarus, Ignite!".equals(input = reader.readLine())) {

            Pattern pat = Pattern.compile("^Grow <(?<regionName>[A-Z][a-z]+)> <(?<colorName>[a-zA-Z0-9]+)> (?<roseAmount>[0-9]+)$");
            Matcher matcher = pat.matcher(input);

            if (matcher.find()) {
                String region = matcher.group("regionName");
                String color = matcher.group("colorName");
                long amount = Long.parseLong(matcher.group("roseAmount"));

                if (!desertRoses.containsKey(region)) {
                    desertRoses.put(region, new HashMap<>());
                }

                if (!desertRoses.get(region).containsKey(color)) {
                    desertRoses.get(region).put(color, 0L);
                }

                amount += desertRoses.get(region).get(color);
                desertRoses.get(region).put(color, amount);

            }
        }

        // region1 -> key
        // region2 -> map(value)
        desertRoses
                .entrySet()
                .stream()
                .sorted((region1, region2) -> {
                    long sum1 = region1.getValue().values().stream().mapToLong(e -> e).sum();
                    long sum2 = region2.getValue().values().stream().mapToLong(e -> e).sum();

                    if (sum1 == sum2) {
                        return region1.getKey().compareTo(region2.getKey());
                    }

                    return Long.compare(sum2, sum1);

                }).forEach(region -> {
            System.out.println(region.getKey());
            region.getValue().entrySet().stream().sorted((color1, color2) -> {
                if (Long.compare(color1.getValue(), color2.getValue()) == 0) {
                    return color1.getKey().compareTo(color2.getKey());
                }
                return Long.compare(color1.getValue(), color2.getValue());
            }).forEach(color -> {
                System.out.println("*--" + color.getKey() + " | " + color.getValue());
            });
        });


    }


}
