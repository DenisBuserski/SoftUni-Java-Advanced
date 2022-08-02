package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Retake_Exam_18_August_2021;

import java.util.Scanner;

public class Problem_2_Formula_One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int linesCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int[] position = new int[2];


        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("P")) {
                position[0] = row;
                position[1] = line.indexOf("P");
            }
        }

        boolean playerWon = false;

        while (linesCount-- > 0 && !playerWon) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                playerWon = movePlayer(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                playerWon = movePlayer(position, matrix, 1, 0);
            } else if (command.equals("left")) {
                playerWon = movePlayer(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                playerWon = movePlayer(position, matrix, 0, 1);
            }


        }


        if (playerWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);

    }

    private static boolean movePlayer(int[] position, char[][] matrix, int rowModification, int colModification) {
        int row = position[0];
        int col = position[1];
        int newRow = ensureIndexIsInBounds(row + rowModification, matrix.length);
        int newCol = ensureIndexIsInBounds(col + colModification, matrix.length);


        boolean hasWon = false;

        if (matrix[newRow][newCol] == 'B') {
            newRow = ensureIndexIsInBounds(newRow + rowModification, matrix.length);
            newCol = ensureIndexIsInBounds(newCol + colModification, matrix.length);
        } else if (matrix[newRow][newCol] == 'T') {
            newRow = row;
            newCol = col;
        }

        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        }

        matrix[row][col] = '.';
        matrix[newRow][newCol] = 'P';
        position[0] = newRow;
        position[1] = newCol;
        return hasWon;

    }

    private static int ensureIndexIsInBounds(int index, int bounds) {
        if (index < 0) {
            index = bounds - 1;
        } else if (index >= bounds) {
            index = 0;
        }
        return index;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}