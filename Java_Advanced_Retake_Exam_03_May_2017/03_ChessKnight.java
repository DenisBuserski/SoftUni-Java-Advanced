package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_03_May_2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChessKnight_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Character[][] board = new Character[8][8];

        readMatrix(scanner, board);

        int countInvalid = 0;
        int boardOutOf = 0;
        List<Character> pieces = new ArrayList<>();

        int startCoordinates = Integer.parseInt(scanner.nextLine());

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                System.out.printf("Pieces take: %s%n", pieces.toString().replaceAll("\\[|\\]", ""));
                System.out.println("Invalid moves: " + countInvalid);
                System.out.println("Board out moves: " + boardOutOf);
                break;
            }

            int[] coordinates = Arrays.stream(input.split("->"))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (!isValidMove(coordinates[0], coordinates[1])) {
                countInvalid++;
            } else if (coordinates[1] % 10 > 7 || coordinates[1] % 10 > 7) {
                boardOutOf++;
            } else {
                Character toAdd = board[(coordinates[1] / 10)][(coordinates[1] % 10)];
                if (toAdd != ' ') {
                    pieces.add(toAdd);
                    board[(coordinates[1] / 10)][(coordinates[1] % 10)] = ' ';
                }
            }

        }
    }

    private static void readMatrix(Scanner scanner, Character[][] board) {
        for (int i = 0; i <= 7; i++) {
            String[] row = scanner.nextLine().split("\\|");
            for (int j = 0; j <= 7; j++) {
                board[i][j] = row[j].toCharArray()[0];
            }
        }
    }

    private static boolean isValidMove(int start, int end) {
        int rowS = start / 10;
        int colS = start % 10;
        int rowF = end / 10;
        int colF = end % 10;
        if (colS - 2 == colF && (rowS - 1 == rowF || rowS + 1 == rowF)) {
            return true;
        }
        if (colS + 2 == colF && (rowS - 1 == rowF || rowS + 1 == rowF)) {
            return true;
        }
        if (rowS + 2 == rowF && (colS - 1 == colF || colS + 1 == colF)) {
            return true;
        }
        if (rowS - 2 == rowF) {
            if (colS - 1 == colF || colS + 1 == colF) {
                return true;
            }
        }
        return false;
    }
}

