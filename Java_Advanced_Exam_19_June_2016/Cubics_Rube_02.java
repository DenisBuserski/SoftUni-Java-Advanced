package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Exam_19_June_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Cubics_Rube_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        BigInteger sum = BigInteger.ZERO;
        int freeDimensions = (int)Math.pow(n,3);

        String line;
        while (!(line = reader.readLine()).equals("Analyze")) {
            Integer[] array = Arrays.stream(line.split("\\s")).map(Integer::parseInt).toArray(Integer[]::new);
            Integer d1 = array[0];
            Integer d2 = array[1];
            Integer d3 = array[2];
            Integer num = array[3];

            if ((d1 < n && d2 < n && d3 < n) && (d1 >= 0 && d2 >= 0 && d3 >= 0)) {
                sum = sum.add(BigInteger.valueOf(num));
                if (num > 0) {
                    freeDimensions--;
                }
            }
        }
        System.out.println(sum);
        System.out.println(freeDimensions);
    }
}