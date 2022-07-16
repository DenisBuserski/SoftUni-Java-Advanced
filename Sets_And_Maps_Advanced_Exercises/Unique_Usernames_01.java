package Sets_And_Maps_Advanced_Exercises;

import java.util.*;

public class Unique_Usernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> word = new LinkedHashSet<>();

        while (n-- > 0) {
            String input = scanner.nextLine();
            word.add(input);
        }

        for (String a : word) {
            System.out.println(a);
        }

    }
}
