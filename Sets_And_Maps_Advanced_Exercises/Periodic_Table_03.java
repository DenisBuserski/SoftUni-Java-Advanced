package Sets_And_Maps_Advanced_Exercises;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Periodic_Table_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int compoundCompounds = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        for (int compound = 1; compound <= compoundCompounds; compound++) {
            String chemicalCompound = scanner.nextLine();
            String[] chemicalElements = chemicalCompound.split("\\s+");

            //elements.addAll(Arrays.asList(chemicalElements));
            Collections.addAll(elements, chemicalElements);
        }

        elements.stream().map(element -> element + " ").forEach(System.out::print);
    }
}
