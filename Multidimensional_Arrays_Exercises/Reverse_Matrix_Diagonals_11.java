package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Java_Advanced_2.Java_Advanced_Exercises.Multidimensional_Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Matrix_Diagonals_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int dim1 = input[0];
        int dim2 = input[1];
        String[][] matrix = new String[dim1][];

        for (int i = 0; i < dim1; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            matrix[i] = line;
        }

        int row = dim1 - 1;
        int col = dim2 - 1;

        while (row >= 0) {
            int r = row;
            int c = col;
            while (c < dim2 && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;
            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }

}
