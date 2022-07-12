package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Multidimensional_Arrays_Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Wrong_Measurements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(rows, 0, scanner, "\\s+");
        int[] coordinates = readArray(scanner.nextLine(), "\\s+");
        int wrongValue = matrix[coordinates[0]][coordinates[1]];

        List<int[]> updatedValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    updatedValues.add(new int[]{row, col, getClosestItemsSum(row, col, matrix, wrongValue)});
                }
            }
        }

        for (int[] updatedValue : updatedValues) {
            matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
        }
        printMatrix(matrix);


    }

    public static boolean isInBounds(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    public static boolean isOutOfBounds(int row, int col, int[][] matrix) {
        return !isInBounds(row, col, matrix);
    }

    private static int getClosestItemsSum(int row, int col, int[][] matrix, int wrongValue) {
        int sum = 0;

        if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        return sum;
    }

    public static int[][] getMaxSumSubMatrix2By2(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum =
                        matrix[row][col] +
                                matrix[row][col + 1] +
                                matrix[row + 1][col] +
                                matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
    }

    public static char[][] getMatricesIntersection(char[][] first, char[][] second) {
        char[][] out = new char[first.length][];
        for (int row = 0; row < first.length; row++) {
            out[row] = new char[first[row].length];
            for (int col = 0; col < first[row].length; col++) {
                out[row][col] = first[row][col] == second[row][col]
                        ? first[row][col] : '*';
            }
        }
        return out;
    }

    private static int getElementsSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }

    public static List<int[]> findNumberOccurrences(int[][] matrix, int number) {
        List<int[]> out = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    out.add(new int[]{row, col});
                }
            }
        }
        return out;
    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArray = firstMatrix[row];
            int[] secondArray = secondMatrix[row];

            if (firstArray.length != secondArray.length) {
                return false;
            }

            for (int col = 0; col < firstArray.length; col++) {
                if (firstArray[col] != secondArray[col]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[][] readMatrix(int rows, int cols, Scanner scanner, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = readArray(scanner.nextLine(), pattern);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}