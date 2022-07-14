package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class Logs_Aggregator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, TreeMap<String, Integer>> users = new TreeMap<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            String ip = input.split("\\s+")[0];
            String user = input.split("\\s+")[1];
            int duration = Integer.parseInt(input.split("\\s+")[2]);

            users.putIfAbsent(user, new TreeMap<>());
            TreeMap<String, Integer> IPs = users.get(user);

            int newMinutes = 0;
            if (IPs.containsKey(ip)) {
                newMinutes = IPs.get(ip);
            }
            IPs.put(ip, newMinutes + duration);


        }

        for (var user : users.entrySet()) {
            String currentUser = user.getKey();
            TreeMap<String, Integer> IPs = user.getValue();
            System.out.print(currentUser + ": ");

            int finalTime = 0;
            for (var time : IPs.entrySet()) {
                int currentTime = time.getValue();
                finalTime += currentTime;
            }
            System.out.print(finalTime + " [");


            int count = 1;
            for (var IP : IPs.entrySet()) {
                String output =
                        String.format(count < IPs.entrySet().size() ? IP.getKey() + ", " : IP.getKey());
                System.out.printf("%s", output);
                count++;
            }
            System.out.printf("]%n");
        }


    }
}
