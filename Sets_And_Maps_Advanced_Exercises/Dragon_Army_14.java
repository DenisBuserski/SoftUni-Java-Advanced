package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class Dragon_Army_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            String damageInput = input[2];
            String healthInput = input[3];
            String armorInput = input[4];
            int damage = getStats(damageInput, 45);
            int health = getStats(healthInput, 250);
            int armor = getStats(armorInput, 10);

            dragons.putIfAbsent(type, new TreeMap<>());
            TreeMap<String, List<Integer>> dragonNames = dragons.get(type);
            dragonNames.putIfAbsent(name, new ArrayList<>());

            checkDragons(dragons, type, name, damage, health, armor, dragonNames);
        }

        for (var a : dragons.entrySet()) {
            String dragon = a.getKey();
            TreeMap<String, List<Integer>> dragonNames = a.getValue();

            double avgDamage = average(dragonNames, 0);
            double avgHealth = average(dragonNames, 1);
            double avgArmor = average(dragonNames, 2);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dragon, avgDamage, avgHealth, avgArmor);

            dragonNames.forEach((name, stats) ->
                    System.out.println("-" + name + " -> " + "damage: " + stats.get(0) + ", health: " + stats.get(1) + ", armor: " + stats.get(2)));
        }
    }

    public static void checkDragons(Map<String, TreeMap<String, List<Integer>>> dragons, String type, String name, int damage, int health, int armor, TreeMap<String, List<Integer>> dragonNames) {
        if (dragons.containsKey(type) && dragonNames.containsKey(name)) {
            dragonNames.replace(name, new ArrayList<>());
            dragonNames.get(name).add(damage);
            dragonNames.get(name).add(health);
            dragonNames.get(name).add(armor);
        } else {
            dragonNames.get(name).add(damage);
            dragonNames.get(name).add(health);
            dragonNames.get(name).add(armor);
        }
    }

    private static int getStats(String input, int num) {
        int stats = 0;
        if (input.equals("null")) {
            stats = num;
        } else {
            stats = Integer.parseInt(input);
        }
        return stats;
    }

    private static double average(TreeMap<String, List<Integer>> dragonNames, int num) {
        double average = 0;
        int count = 0;
        for (var b : dragonNames.entrySet()) {
            count++;
            List<Integer> stats = b.getValue();
            average += stats.get(num);
        }
        return average / count;
    }

}
