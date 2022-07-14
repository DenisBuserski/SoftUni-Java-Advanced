package Sets_And_Maps_Advanced_Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Parking_Lot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String car = input.split("\\s+")[1];
            if (input.contains("IN")) {
                parkingLot.add(car);
            } else {
                parkingLot.remove(car);
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020.Parking_03.Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }

    }
}
