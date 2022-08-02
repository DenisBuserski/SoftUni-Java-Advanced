package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Retake_Exam_16_December_2020;

import java.util.Scanner;

public class Selling_02 {
    static int money = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int[] startPosition = new int[2];
        findStartingPosition(scanner, n, matrix, startPosition);

        boolean isOut = false;


        while (money < 50 || isOut) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                isOut = move(startPosition, matrix, -1, 0);
            } else if (command.equals("down")) {
                isOut = move(startPosition, matrix, +1, 0);
            } else if (command.equals("left")) {
                isOut = move(startPosition, matrix, 0, -1);
            } else if (command.equals("right")) {
                isOut = move(startPosition, matrix, 0, +1);
            }


            if (isOut) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }

        }

        System.out.println("Money: " + money);
        printMatrix(matrix);

    }

    public static boolean move(int[] start, char[][] matrix, int rowModification, int colModification) {
        boolean isOut = false;
        int row = start[0];
        int col = start[1];
        int newRow = checkIndex(row + rowModification, matrix.length);
        int newCol = checkIndex(col + colModification, matrix.length);

        if (newRow == -1 || newCol == -1) {
            matrix[row][col] = '-';
            isOut = true;
        } else {
            if (Character.isDigit(matrix[newRow][newCol])) {
                money += Character.getNumericValue(matrix[newRow][newCol]);
                matrix[row][col] = '-';
                matrix[newRow][newCol] = 'S';
                start[0] = newRow;
                start[1] = newCol;
            } else if (matrix[newRow][newCol] == '-') {
                matrix[row][col] = '-';
                matrix[newRow][newCol] = 'S';
                start[0] = newRow;
                start[1] = newCol;
            } else if (matrix[newRow][newCol] == 'O') {
                matrix[row][col] = '-';
                matrix[newRow][newCol] = '-';
                for (int i = 0, matrixLength = matrix.length; i < matrixLength; i++) {
                    char[] chars = matrix[i];
                    for (int j = 0, charsLength = chars.length; j < charsLength; j++) {
                        char c = chars[j];
                        if (c == 'O') {
                            start[0] = i;
                            start[1] = j;
                        }
                    }
                }
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

    public static void findStartingPosition(Scanner scanner, int n, char[][] matrix, int[] startPosition) {
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("S")) {
                startPosition[0] = row;
                startPosition[1] = line.indexOf("S");
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
