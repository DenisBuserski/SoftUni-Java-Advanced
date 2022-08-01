package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_03_May_2017;

import java.util.*;
import java.util.stream.Collectors;

public class FootballStats_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> teamResults = new HashMap<>();

        String line;
        while (!"Season End".equals(line = scanner.nextLine())) {

            String[] gameData = line.split(" ");
            String homeTeam = gameData[0];
            String awayTeam = gameData[2];
            String homeTeamGoals = gameData[4].split(":")[0] + "";
            String awayTeamGoals = gameData[4].split(":")[1] + "";
            String homeTeamResult = String.format("%s -> %s:%s", awayTeam, homeTeamGoals, awayTeamGoals);
            String awayTeamResult = String.format("%s -> %s:%s", homeTeam, awayTeamGoals, homeTeamGoals);

            teamResults.putIfAbsent(homeTeam, new LinkedList<>());
            teamResults.get(homeTeam).add(homeTeamResult);
            teamResults.putIfAbsent(awayTeam, new LinkedList<>());
            teamResults.get(awayTeam).add(awayTeamResult);
        }

        List<String> printTeams = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        for (String printTeam : printTeams) {

            teamResults.get(printTeam)
                    .stream()
                    .sorted(Comparator.comparing(a -> a.split(" -> ")[0]))
                    .forEach(x -> {
                        System.out.println(String.format("%s - %s", printTeam, x));
                    });
        }
    }
}