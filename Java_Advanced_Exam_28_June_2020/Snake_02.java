package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_28_June_2020;

import java.util.Scanner;

public class Snake_02 {
    static int snakeRow = 0;
    static int snakeCol = 0;
    static int foodEaten = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[n][n];
        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            field[row] = line.toCharArray();
            if (line.contains("S")) {
                snakeRow = row;
                snakeCol = line.indexOf("S");
            }
        }

        boolean isInField = true;

        while (foodEaten < 10 && isInField) {
            String direction = scanner.nextLine();

            if (direction.equals("up")) {
                isInField = moveSnake(field, -1, 0);
            } else if (direction.equals("down")) {
                isInField = moveSnake(field, 1, 0);
            } else if (direction.equals("left")) {
                isInField = moveSnake(field, 0, -1);
            } else if (direction.equals("right")) {
                isInField = moveSnake(field, 0, 1);
            }

            if (!isInField) {
                break;
            }

        }

        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }

        System.out.println("Food eaten: " + foodEaten);
        System.out.println(getFieldString(field));

    }

    public static boolean moveSnake(char[][] field, int rowAddition, int colAddition) {
        field[snakeRow][snakeCol] = '.';
        boolean isInBounds = inBounds(field, snakeRow + rowAddition, snakeCol + colAddition);
        if (isInBounds) {
            if (field[snakeRow + rowAddition][snakeCol + colAddition] == '*') {
                foodEaten += 1;
            } else if (field[snakeRow + rowAddition][snakeCol + colAddition] == 'B') {
                field[snakeRow + rowAddition][snakeCol + colAddition] = '.';

                for (int r = 0; r < field.length; r++) {
                    for (int c = 0; c < field[r].length; c++) {
                        if (field[r][c] == 'B') {
                            snakeRow = r;
                            snakeCol = c;
                            field[snakeRow][snakeCol] = 'S';
                            return isInBounds;

                        }
                    }
                }
            }

            snakeRow += rowAddition;
            snakeCol += colAddition;
            field[snakeRow][snakeCol] = 'S';
        }
        return isInBounds;
    }

    private static boolean inBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }


    public static String getFieldString(char[][] matrix) {
        StringBuilder out = new StringBuilder();
        for (char[] arr : matrix) {
            for (char element : arr) {
                out.append(element);
            }
            out.append(System.lineSeparator());
        }
        return out.toString();
    }
}