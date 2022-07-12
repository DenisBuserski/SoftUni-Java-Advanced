package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Multidimensional_Arrays_Lab;

import java.util.Scanner;

public class Print_Diagonals_Of_Square_Matrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int rows = size;
        int cols = size;
        int [][] matrix = new int[rows][cols];
        matrix = readMatrix(scanner, rows, matrix);


        first(size, matrix);
        second(size, matrix);


    }

    public static void second(int size, int[][] matrix) {
        for (int i = size; i >= 0; i--) {
            for (int j = 0; j <= size; j++) {

                if (i + j + 1 == size) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println("");
    }

    public static void first(int size, int[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println("");
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int col = 0; col < tokens.length; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }
        return matrix;
    }


}
