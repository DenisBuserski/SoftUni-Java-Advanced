package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_03_Jan_2018;

import java.util.*;

public class The_DHARMA_Initiative_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<String, Integer>> recruits = new TreeMap<>();
        recruits.put("Arrow", new HashMap<>());
        recruits.put("Hydra", new HashMap<>());
        recruits.put("Flame", new HashMap<>());
        recruits.put("Pearl", new HashMap<>());
        recruits.put("Orchid", new HashMap<>());

        Map<String, String> stationNames = new HashMap<String, String>() {{
            put("Arrow", "Development of defensive strategies, and Intelligence gathering");
            put("Hydra", "Zoological Research");
            put("Flame", "Communication");
            put("Pearl", "Psychological Research and/or Observation");
            put("Orchid", "Space-time manipulation research, disguised as a Botanical station");
        }};

        String line;
        while (!"Recruit".equals(line = scanner.nextLine())) {
            String[] data = line.split(":");
            String personName = data[0];
            Integer facilityNumber = Integer.parseInt(data[1]);
            String stationName = data[2];

            if (recruits.containsKey(stationName)) {
                recruits.get(stationName).put(personName, facilityNumber);
            }
        }

        String command = scanner.nextLine();
        if (command.equals("DHARMA Initiative")) {
            recruits
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue().size(), a.getValue().size()))
                    .forEach(x -> System.out.printf("The %s has %d DHARMA recruits in it.%n", x.getKey(), x.getValue().size()));
        } else {
            if (recruits.containsKey(command)) {
                if (recruits.get(command).size() > 0) {
                    System.out.printf("The %s station: %s.%n", command, stationNames.get(command));
                    recruits
                            .get(command).entrySet().stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(x -> System.out.printf("###%s - %d%n", x.getKey(), x.getValue()));
                } else {
                    System.out.printf("The %s station: %s.%n", command, stationNames.get(command));
                    System.out.println("No recruits.");
                }
            } else {
                System.out.println("DHARMA Initiative does not have such a station!");
            }
        }
    }
}