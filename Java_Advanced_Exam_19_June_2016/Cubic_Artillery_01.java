package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Exam_19_June_2016;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Cubic_Artillery_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());

        ArrayDeque<ArrayDeque<Integer>> bunkerStorages = new ArrayDeque<>();
        ArrayDeque<String> bunkerNames = new ArrayDeque<>();

        Map<String, Integer> bunkers = new HashMap<>();
        Map<String, ArrayDeque<Integer>> overflowedBunkers = new HashMap<>();


        while (true) {
            String input = reader.readLine();
            if (input.equals("Bunker Revision")) {
                break;
            }

            String[] inputParams = input.split("\\s+");

            for (String inputParam : inputParams) {
                var weaponCapacity = 0;
                boolean isNumber;

                try {
                    Integer.parseInt(inputParam);
                    isNumber = true;
                } catch (NumberFormatException e) {
                    isNumber = false;
                }

                if (!isNumber) {
                    String bunkerName = inputParam;
                    bunkerNames.offer(bunkerName);
                    bunkers.put(bunkerName, 0);
                    bunkerStorages.offer(new ArrayDeque<>());
                    continue;
                }

                var isWeaponTaken = false;

                while (bunkerStorages.size() > 1) {
                    var currentBunker = bunkerStorages.peek();
                    String bunkerName = bunkerNames.peek();
                    int sum = bunkers.get(bunkerName);

                    if (sum + weaponCapacity <= capacity) {
                        isWeaponTaken = true;
                        currentBunker.offer(weaponCapacity);
                        int newValue = bunkers.get(bunkerName) + weaponCapacity;
                        bunkers.put(bunkerName, newValue);
                        break;
                    }

                    bunkerName = bunkerNames.poll();
                    var bunkerStorage = bunkerStorages.poll();
                    overflowedBunkers.put(bunkerName, bunkerStorage);
                }

                if (!isWeaponTaken) {
                    if (weaponCapacity > capacity) {
                        continue;
                    }

                    var currentBunker = bunkerStorages.peek();
                    String bunkerName = bunkerNames.peek();
                    int sum = bunkers.get(bunkerName);
                    while (sum + weaponCapacity > capacity && currentBunker.size() > 0) {
                        sum -= currentBunker.poll();
                    }

                    currentBunker.offer(weaponCapacity);
                    int newValue = bunkers.get(bunkerName) + weaponCapacity;
                    bunkers.put(bunkerName, newValue);
                }
            }
        }

        for (var bunker : overflowedBunkers.entrySet()) {
            System.out.println(bunker.getKey() + " -> ");
            if (bunker.getValue().size() == 0) {
                System.out.print("Empty");
            } else {
                System.out.print(String.join(", ", Arrays.toString(bunker.getValue().toArray())));
            }
        }




    }
}

