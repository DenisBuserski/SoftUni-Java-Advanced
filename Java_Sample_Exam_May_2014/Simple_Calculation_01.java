package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Sample_Exam_May_2014;

import java.math.BigDecimal;
import java.util.Scanner;

public class Simple_Calculation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        BigDecimal xCoordinate = scanner.nextBigDecimal();
        BigDecimal yCoordinate = scanner.nextBigDecimal();
        BigDecimal zero = BigDecimal.ZERO;

        if ((xCoordinate.compareTo(zero) == 1) && (yCoordinate.compareTo(zero) == 1)) {
            System.out.println(1);
        }
        else if ((xCoordinate.compareTo(zero) == -1) && (yCoordinate.compareTo(zero)) == 1) {
            System.out.println(2);
        }
        else if ((xCoordinate.compareTo(zero) == -1) && yCoordinate.compareTo(zero) == -1) {
            System.out.println(3);
        }
        else if ((xCoordinate.compareTo(zero) == 1) && (yCoordinate.compareTo(zero)) == -1) {
            System.out.println(4);
        }
        else if(xCoordinate.compareTo(zero) == 0 && yCoordinate.compareTo(zero) == 0) {
            System.out.println(0);
        }
        else if (xCoordinate.compareTo(zero) == 0) {
            System.out.println(5);
        }
        else {
            System.out.println(6);
        }

    }
}
