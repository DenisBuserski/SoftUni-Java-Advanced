package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Sample_Exam_May_2014;

import java.util.Collections;
import java.util.Scanner;

public class Draw_Figure_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int n = size;
        boolean upper = true;
        for (int i = 0; size % 2 == 0 ?
                i < size - 1 : i < size; i++) {
            String str = String.join("", Collections.nCopies(n, "*"));
            String pad = String.join("", Collections.nCopies((size - n) / 2, "."));
            System.out.println(pad + str + pad);

            if (n - 2 > 0 && upper) {
                n -= 2;
            } else {
                n += 2;
                upper = false;
            }
        }


    }
}
