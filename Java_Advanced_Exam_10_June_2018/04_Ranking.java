package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Exam_10_June_2018;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new HashMap<>();
        String line;
        while (!"end of contests".equals(line = scanner.nextLine())) {
            String[] data = line.split(":");
            contests.putIfAbsent(data[0], data[1]);
        }

        Map<String, Map<String, Integer>> usersData = new TreeMap<>();
        while (!"end of submissions".equals(line = scanner.nextLine())){
            String[] data = line.split("=>");
            String contest = data[0];
            String password = data[1];
            String username = data[2];
            Integer points = Integer.parseInt(data[3]);

            if (contests.containsKey(contest)){
                if (contests.get(contest).equals(password)){
                    usersData.putIfAbsent(username, new HashMap<>());
                    usersData.get(username).putIfAbsent(contest, 0);
                    if (usersData.get(username).get(contest) < points) {
                        usersData.get(username).replace(contest, points);
                    }
                }
            }
        }

        usersData.entrySet()
                .stream()
                .sorted((x, y) -> {
                    int result = Integer.compare(y.getValue().values().stream().mapToInt(Integer::valueOf).sum(),
                            x.getValue().values().stream().mapToInt(Integer::valueOf).sum());

                    return result;
                })
                .limit(1)
                .forEach(z -> System.out.printf("Best candidate is %s with total %d points.%n", z.getKey(), z.getValue().values().stream().mapToInt(Integer::valueOf).sum()));

        System.out.println("Ranking: ");
        usersData.entrySet().stream()
                .forEach(z -> {
                    System.out.printf("%s%n", z.getKey());
                    z.getValue().entrySet()
                            .stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(w -> System.out.printf("#  %s -> %d%n",
                                    w.getKey(),
                                    w.getValue()));
                });
    }
}