package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Exam_22_Oct_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Little_Alchemy_02 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stones = new ArrayDeque<>();

        int gold = 0;

        Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(stones::addLast);

        String input = bf.readLine();

        while (!"Revision".equals(input)) {
            String[] tokens = input.split("\\s+");
            int value = Integer.parseInt(tokens[2]);
            if ("Apply".equals(tokens[0])) {
                for (int a = 0; a < value; a++) {
                    if (!stones.isEmpty()) {
                        int stone = stones.pop();
                        stone--;
                        if (stone > 0) {
                            stones.addLast(stone);
                        } else {
                            gold++;
                        }
                    }
                }
            } else if ("Air".equals(tokens[0])) {
                if (gold > 0) {
                    gold--;
                    stones.addLast(value);
                }
            }
            input = bf.readLine();
        }
        System.out.println(stones.toString().replaceAll("[\\[,\\]]", ""));
        System.out.println(gold);
    }
}