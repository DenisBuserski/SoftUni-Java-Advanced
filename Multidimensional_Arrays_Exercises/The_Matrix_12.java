package Multidimensional_Arrays_Exercises;

import java.util.Scanner;

public class The_Matrix_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        Character [][] matrix = new Character[rows][cols];
        readMatrix(rows, cols, scanner, matrix);

        char fillChar = scanner.nextLine().charAt(0);
        String [] startRowAndCol = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(startRowAndCol[0]);
        int startCol = Integer.parseInt(startRowAndCol[1]);
        char firstSymbol = matrix[startRow][startCol];
        matrix[startRow][startCol] = fillChar;

        startCol(cols, matrix, fillChar, startRow, startCol, firstSymbol);

        rowsUpAndDown(rows, cols, matrix, fillChar, startRow, firstSymbol);

        printMatrix(matrix);
    }

    public static void rowsUpAndDown(int rows, int cols, Character[][] matrix, char fillChar, int startRow, char firstSymbol) {
        if (startRow == 0) {
            int rowUp = startRow + 1;
            for (int row = rowUp; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == firstSymbol && matrix[row - 1][col] == fillChar) {
                        matrix[row][col] = fillChar;
                    }
                }
            }
        } else if (startRow > 0) {
            int rowUp = startRow + 1;
            for (int row = rowUp; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == firstSymbol && matrix[row - 1][col] == fillChar) {
                        matrix[row][col] = fillChar;
                    }
                }
            }
            int rowDown = startRow - 1;
            for (int row = rowDown; row >= 0; row--) {
                for (int col = 0; col < cols; col++) {
                    if (matrix[row][col] == firstSymbol && matrix[row + 1][col] == fillChar) {
                        matrix[row][col] = fillChar;
                    }
                }
            }
        }
    }

    public static void startCol(int cols, Character[][] matrix, char fillChar, int startRow, int startCol, char firstSymbol) {
        if (startCol == 0) {
            for (int col = startCol; col < cols - 1; col++) {
                if (matrix[startRow][col + 1] == firstSymbol) {
                    matrix[startRow][col + 1] = fillChar;
                } else {
                    break;
                }
            }
        } else if (startCol > 0) {
            for (int col = startCol; col < cols - 1; col++) {
                if (matrix[startRow][col + 1] == firstSymbol) {
                    matrix[startRow][col + 1] = fillChar;
                } else {
                    break;
                }
            }
            for (int col = startCol; col > 0; col--) {
                if (matrix[startRow][col - 1] == firstSymbol) {
                    matrix[startRow][col - 1] = fillChar;
                } else {
                    break;
                }
            }
        }
    }

    public static void readMatrix(int rows, int cols, Scanner scanner, Character [][] matrix) {
        for(int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for(int col = 0; col < tokens.length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
    }

    public static void printMatrix(Character [][] matrix) {
        for(Character []arr : matrix) {
            for(char element : arr) {
                System.out.print(element + "");
            }
            System.out.println();
        }
    }
    
}
