package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_22_August_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Natures_Prophet_02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] rowsAndCols = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int [][] matrix = new int[rows][cols];

        String input;
        while (!"Bloom Bloom Plow".equals(input = reader.readLine())) {
            String [] tokens = input.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            matrix[row][col] += 1;

            move(row, col, matrix);

        }

        printMatrix(matrix);

    }

    private static void move(int startRow, int startCol, int [][] matrix) {

        for (int rowDown = startRow - 1; rowDown >= 0; rowDown--) {
            matrix[rowDown][startCol] += 1;
        }
        for (int rowUp = startRow + 1; rowUp < matrix.length; rowUp++) {
            matrix[rowUp][startCol] += 1;
        }

        for (int colDown = startCol - 1; colDown >= 0; colDown--) {
            matrix[startRow][colDown] += 1;
        }
        for (int colUp = startCol + 1; colUp < matrix.length; colUp++) {
            matrix[startRow][colUp] += 1;
        }

    }

    public static void printMatrix (int[][] matrix) {
        for(int[]arr : matrix) {
            System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
        }

    }
}