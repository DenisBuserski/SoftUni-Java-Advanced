package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Retake_Exam_19_August_2020;

import java.util.Scanner;

public class Bee_02 {
    static int pollinatedFlowers = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int[] startPosition = new int[2];
        findBeeStartingPosition(scanner, n, matrix, startPosition);

        boolean beeIsOut = false;

        String command = scanner.nextLine();
        while (!command.equals("End") || beeIsOut) {
            //up  ->  nextStep(startPosition, matrix, -1, 0);
            //down  ->  nextStep(startPosition, matrix, +1, 0);
            //left  ->  nextStep(startPosition, matrix, 0, -1);
            //right  ->  nextStep(startPosition, matrix, 0, +1);
            if (command.equals("up")) {
                beeIsOut = moveBee(startPosition, matrix, -1, 0, command);
            } else if (command.equals("down")) {
                beeIsOut = moveBee(startPosition, matrix, +1, 0, command);
            } else if (command.equals("left")) {
                beeIsOut = moveBee(startPosition, matrix, 0, -1, command);
            } else if (command.equals("right")) {
                beeIsOut = moveBee(startPosition, matrix, 0, +1, command);
            }

            if (beeIsOut) {
                System.out.printf("The bee got lost!%n");
                break;
            }

            command = scanner.nextLine();
        }

        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }

        printMatrix(matrix);
    }

    public static boolean moveBee(int[] start, char[][] matrix, int rowModification, int colModification, String command) {
        boolean isOut = false;
        int row = start[0];
        int col = start[1];
        int newRow = checkIndex(row + rowModification, matrix.length);
        int newCol = checkIndex(col + colModification, matrix.length);

        if (newRow == -1 || newCol == -1) {
            matrix[row][col] = '.';
            isOut = true;
        } else {
            if (matrix[newRow][newCol] == 'f') {
                pollinatedFlowers++;
                matrix[row][col] = '.';
                matrix[newRow][newCol] = 'B';
                start[0] = newRow;
                start[1] = newCol;
            } else if (matrix[newRow][newCol] == 'O') {
                matrix[row][col] = '.';
                start[0] = newRow;
                start[1] = newCol;
                matrix[newRow][newCol] = '.';
                moveBee(start, matrix, rowModification, colModification, command);

            } else if (matrix[newRow][newCol] == '.') {
                matrix[row][col] = '.';
                matrix[newRow][newCol] = 'B';
                start[0] = newRow;
                start[1] = newCol;
            }
        }
        return isOut;
    }

    public static int checkIndex(int index, int bounds) {
        if (index >= bounds) {
            index = -1;
        }
        return index;
    }

    public static void findBeeStartingPosition(Scanner scanner, int n, char[][] matrix, int[] startPosition) {
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("B")) {
                startPosition[0] = row;
                startPosition[1] = line.indexOf("B");
            }
        }
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }

    }
}
