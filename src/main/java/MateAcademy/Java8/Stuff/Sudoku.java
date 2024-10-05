package MateAcademy.Java8.Stuff;

public class Sudoku {
    private final int[][] grid;

    public Sudoku(int[][] initialGrid) {
        this.grid = initialGrid;
    }

    public void printSudoku() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-------------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" |  ");
                }
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col, int num) {
        // Check if the number is not present in the same row or column
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false;
            }
        }

        // Check if the number is not present in the 3x3 subgrid
        int subgridStartRow = row - row % 3;
        int subgridStartCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[subgridStartRow + i][subgridStartCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (grid[row][col] == 0) {
                    // Try placing numbers from 1 to 9
                    for (int num = 1; num <= 9; num++) {
                        if (isValidMove(row, col, num)) {
                            // If the move is valid, place the number and try to solve the rest
                            grid[row][col] = num;

                            if (solve()) {
                                return true; // If the rest of the Sudoku is solved, return true
                            }

                            // If the rest cannot be solved, backtrack and try the next number
                            grid[row][col] = 0;
                        }
                    }
                    return false; // If no number can be placed, backtrack
                }
            }
        }
        return true; // Sudoku is solved
    }

    public static void main(String[] args) {
//        int[][] initialGrid = {
//                {7, 3, 2, 0, 9, 0, 0, 0, 0},
//                {4, 0, 0, 0, 6, 7, 5, 0, 0},
//                {5, 0, 9, 1, 0, 0, 0, 3, 7},
//                {0, 5, 0, 0, 0, 9, 0, 4, 6},
//                {0, 0, 0, 0, 3, 8, 0, 0, 5},
//                {0, 9, 7, 5, 0, 0, 0, 0, 0},
//                {0, 4, 0, 0, 0, 6, 0, 0, 8},
//                {9, 1, 6, 8, 0, 4, 7, 5, 3},
//                {2, 0, 8, 0, 0, 0, 6, 1, 0}
//        };
//        int[][] initialGrid = {
//                {7, 0, 0, 0, 0, 0, 9, 0, 0},
//                {4, 3, 0, 0, 0, 6, 0, 0, 1},
//                {0, 0, 6, 0, 0, 0, 0, 7, 0},
//                {0, 0, 0, 9, 0, 0, 0, 0, 8},
//                {0, 9, 5, 6, 8, 0, 0, 0, 0},
//                {0, 0, 0, 0, 5, 0, 0, 0, 7},
//                {0, 0, 0, 0, 0, 0, 0, 0, 4},
//                {0, 1, 2, 0, 0, 0, 6, 8, 0},
//                {0, 0, 4, 5, 3, 8, 0, 0, 0}
//        };
        int[][] initialGrid = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        Sudoku sudoku = new Sudoku(initialGrid);
        System.out.println("Initial Sudoku:");
        sudoku.printSudoku();

        if (sudoku.solve()) {
            System.out.println("\nSolved Sudoku:");
            sudoku.printSudoku();
        } else {
            System.out.println("\nNo solution exists.");
        }
    }
}
