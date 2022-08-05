package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Sample_Exam_May_2014;

import java.math.BigInteger;
import java.util.Scanner;

public class Simple_Loops_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger t1 = BigInteger.valueOf(Integer.parseInt(scanner.nextLine()));
        BigInteger t2 = BigInteger.valueOf(Integer.parseInt(scanner.nextLine()));
        BigInteger t3 = BigInteger.valueOf(Integer.parseInt(scanner.nextLine()));

        int N = Integer.parseInt(scanner.nextLine());
        BigInteger[] arrayOfTElements = new BigInteger[N + 1];
        arrayOfTElements[0] = t1;
        arrayOfTElements[1] = t2;
        arrayOfTElements[2] = t3;
        BigInteger consecutiveElement = new BigInteger("0");

        if (N == 1 || N == 2 || N == 3) {
            if (N == 1) {
                System.out.println(t1);
            } else if (N == 2) {
                System.out.println(t2);
            } else if (N == 3) {
                System.out.println(t3);
            }

        } else if (N > 3) {
            for (int i = 0; i < N - 3; i++) {
                consecutiveElement = arrayOfTElements[i].add(arrayOfTElements[i + 2]).add(arrayOfTElements[i + 1]);
                arrayOfTElements[i + 3] = consecutiveElement;
            }
            System.out.println(consecutiveElement);
        }
    }
}
