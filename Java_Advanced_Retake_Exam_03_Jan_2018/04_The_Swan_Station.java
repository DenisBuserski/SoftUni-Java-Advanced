package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_03_Jan_2018;

import java.util.*;

public class The_Swan_Station_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> theNumbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(theNumbers::offer);

        ArrayDeque<Integer> integers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(integers::offer);

        List<Integer> output = new ArrayList<>();

        while (output.size() < 6) {
            int firstInteger = integers.peek();
            int firstNumber = theNumbers.peek();

            if (firstInteger % firstNumber == 0) {
                output.add(firstInteger);
                theNumbers.poll();
                integers.poll();
            } else {
                integers.poll();
                integers.offerLast(firstInteger + 1);
            }


        }
        System.out.print(output.toString().replaceAll("[\\[\\]]", ""));


    }
}
