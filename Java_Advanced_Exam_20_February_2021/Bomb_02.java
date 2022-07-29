package Java_Advanced_Exam_20_February_2021;

import java.util.Scanner;

public class Bomb_02 {
    static int startRow;
    static int startCol;
    static int countBombs = 0;
    static int numberOfAllBombs = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] inputCommands = scanner.nextLine().split(",");
        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().split(" ");
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    numberOfAllBombs++;
                }
                if (matrix[row][col].equals("s")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        boolean isNotTheEnd = true;

        for (int i = 0; i < inputCommands.length; i++) {
            String currentCommand = inputCommands[i];

            while (numberOfAllBombs > 0 && isNotTheEnd) {
                if ("up".equals(currentCommand)) {
                    isNotTheEnd = move(startRow - 1, startCol, matrix);
                    break;
                } else if ("down".equals(currentCommand)) {
                    isNotTheEnd = move(startRow + 1, startCol, matrix);
                    break;
                } else if ("left".equals(currentCommand)) {
                    isNotTheEnd = move(startRow, startCol - 1, matrix);
                    break;
                } else if ("right".equals(currentCommand)) {
                    isNotTheEnd = move(startRow, startCol + 1, matrix);
                    break;
                }
            }

            if (numberOfAllBombs == 0) {
                System.out.println("Congratulations! You found all bombs!");
                break;
            }
        }

        if (numberOfAllBombs > 0 && isNotTheEnd) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", numberOfAllBombs, startRow, startCol);
        }
    }


    private static boolean move(int newRow, int newCol, String[][] matrix) {
        matrix[startRow][startCol] = "+";
        if (isOutOdBounds(newRow, newCol, matrix)) {
            matrix[startRow][startCol] = "s";
            return true;
        }

        String currentSymbol = matrix[newRow][newCol];
        if (currentSymbol.equals("e")) {
            System.out.printf("END! %d bombs left on the field", numberOfAllBombs);
            startRow = newRow;
            startCol = newCol;
            return false;
        } else if (currentSymbol.equals("B")) {
            matrix[newRow][newCol] = "+";
            numberOfAllBombs--;
            countBombs++;
            System.out.println("You found a bomb!");
        }

        startRow = newRow;
        startCol = newCol;
        return true;
    }

    private static boolean isOutOdBounds(int row, int col, String[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }
    
}
