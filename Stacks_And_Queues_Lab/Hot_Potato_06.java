package Stacks_And_Queues_Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Hot_Potato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] names = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);

        while (children.size() > 1) {
            for (int pass = 1; pass < n; pass++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }
            System.out.println("Removed " + children.poll());
        }

        System.out.println("Last is " + children.poll());
    }
}
