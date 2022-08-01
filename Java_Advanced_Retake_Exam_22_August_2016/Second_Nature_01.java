package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_22_August_2016;

import java.util.*;

public class Second_Nature_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> flowers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(flowers::offer);

        ArrayDeque<Integer> water = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(water::push);

        List<Integer> secondNature = new ArrayList<>();

        while (!flowers.isEmpty() && !water.isEmpty()) {
            int firstFlower = flowers.peek();
            int lastWater = water.peek();

            int pollination = lastWater - firstFlower;

            if (pollination == 0) {
                secondNature.add(firstFlower);
                water.pop();
            }

            if (pollination > 0 && water.size() > 1) {
                water.pop();
                int nextBucket= water.pop() + pollination;
                water.push(nextBucket);
            } else if (pollination > 0 && water.size() == 1 && !flowers.isEmpty()) {
                water.pop();
                water.push(pollination);
            }
            flowers.poll();

            if (pollination < 0) {
                firstFlower -= lastWater;
                water.pop();
                flowers.addFirst(firstFlower);
            }

        }

        if (flowers.isEmpty()) {
            System.out.println(water.toString().replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println(flowers.toString().replaceAll("[\\[\\],]", ""));
        }

        if (secondNature.isEmpty()) {
            System.out.println("None");
        } else {
            System.out.print(secondNature.toString().replaceAll("[\\[\\],]", ""));
        }

    }
}
