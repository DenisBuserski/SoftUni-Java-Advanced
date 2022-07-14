package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Sets_And_Maps_Advanced_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class A_Miner_Task_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Integer> resourceInfo = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            int resource = Integer.parseInt(scanner.nextLine());

            if (!resourceInfo.containsKey(input)) {
                resourceInfo.put(input, resource);
            } else {
                resourceInfo.put(input, resourceInfo.get(input) + resource);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourceInfo.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " -> " + value);
        }
    }
}
