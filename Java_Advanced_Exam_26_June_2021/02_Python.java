package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exams.Java_Advanced_Exam_26_June_2021;

import java.util.Scanner;

public class Problem_2_Python {
    static int pythonLength = 1;
    static int foodCount = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(", ");
        char[][] matrix = new char[size][size];
        int[] playerPositions = new int[2];

        for (int row = 0; row < size; row++) {
            String[] line = scan.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col].charAt(0);

                if (matrix[row][col] == 's') {
                    playerPositions[0] = row;
                    playerPositions[1] = col;
                }

                if (matrix[row][col] == 'f') {
                    foodCount++;
                }
            }
        }


        boolean isNotFinished = true;


        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            while (isNotFinished && foodCount > 0) {

                if (currentCommand.equals("up")) {
                    isNotFinished = movePython(playerPositions, matrix, -1, 0);
                    break;
                } else if (currentCommand.equals("down")) {
                    isNotFinished = movePython(playerPositions, matrix, +1, 0);
                    break;
                } else if (currentCommand.equals("left")) {
                    isNotFinished = movePython(playerPositions, matrix, 0, -1);
                    break;
                } else if (currentCommand.equals("right")) {
                    isNotFinished = movePython(playerPositions, matrix, 0, +1);
                    break;
                }

            }
            if (foodCount == 0) {
                System.out.printf("You win! Final python length is %d%n", pythonLength);
                break;
            }
        }

        if (foodCount > 0 && isNotFinished) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
        }

    }

    public static void printMatrix(char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean movePython(int[] playerPositions, char[][] matrix, int rowModifier, int colModifier) {
        int row = playerPositions[0];
        int col = playerPositions[1];

        matrix[row][col] = '*';

        int newRol = isInBounds(row + rowModifier, matrix.length);
        int newCol = isInBounds(col + colModifier, matrix.length);

        char currentSymbol = matrix[newRol][newCol];


        if (currentSymbol == 'f') {
            matrix[newRol][newCol] = '*';
            pythonLength++;
            foodCount--;
        } else if (currentSymbol == 'e') {
            System.out.println("You lose! Killed by an enemy!");
            return false;
        }

        matrix[newRol][newCol] = 's';
        playerPositions[0] = newRol;
        playerPositions[1] = newCol;

        return true;

    }

    private static int isInBounds(int index, int length) {
        if (index < 0) {
            index = length - 1;
        } else if (index >= length) {
            index = 0;
        }
        return index;
    }

}