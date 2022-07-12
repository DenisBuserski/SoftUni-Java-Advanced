package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Multidimensional_Arrays_Exercises;

import java.util.Scanner;

public class Maximal_Sum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(scanner, matrix, rows, cols);

        int newRows = 3;
        int newCols = 3;
        int[][] newMatrix = new int[newRows][newCols];

        int maxSum = 0;
        int[][] bestMatrix = new int[3][3];
        int [][] best = new int[3][3];

        int currentRow = 0;
        int currentCol = 0;
        int startCol = 0;
        int startRow = 0;

        while (currentRow + 3 <= rows) {
            while (currentCol + 3 <= cols) {
                for (int row = currentRow; row < newRows; row++) {
                    for (int col = currentCol; col < newCols; col++) {
                        newMatrix[row - startRow][col - startCol] = matrix[row][col];
                    }
                }
                bestMatrix = getBestMatrix(newMatrix, maxSum, best);
                maxSum = getElementsSumMax(newMatrix, maxSum);

                currentCol++;
                newCols++;
                startCol++;

            }
            currentRow++;
            newRows++;
            startRow++;
            startCol = 0;
            currentCol = 0;
            newCols = 3;
        }


        System.out.println("Sum = " + maxSum);
        printMatrix(bestMatrix, 3, 3);


    }

    
    private static int[][] getBestMatrix(int[][] newMatrix, int maxSum, int [][] best) {
        int sum = 0;
        int max = 0;
        max = maxSum;

        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {
                sum += newMatrix[row][col];
            }
        }
        if (sum > max) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    best[row][col] = newMatrix[row][col];
                }
            }
            best = newMatrix;
            return best;
        } else {
            return best;
        }


    }

    private static int getElementsSumMax(int[][] newMatrix, int maxSum) {
        int sum = 0;
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {
                sum += newMatrix[row][col];
            }
        }
        if (sum > maxSum) {
            maxSum = sum;
            return maxSum;
        } else {
            return maxSum;
        }
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    public static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
