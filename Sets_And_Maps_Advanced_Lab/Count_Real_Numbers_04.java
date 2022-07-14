package Sets_And_Maps_Advanced_Lab;

import java.util.*;

public class Count_Real_Numbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> values = new LinkedHashMap<>();

        for (double number : numbers) {
            if (!values.containsKey(number)) {
                values.put(number, 1);
            } else {
                values.put(number, values.get(number) + 1);
            }
        }

        for (Double key : values.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, values.get(key)));
        }

    }
}
