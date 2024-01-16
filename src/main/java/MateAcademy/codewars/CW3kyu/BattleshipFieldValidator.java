package MateAcademy.codewars.CW3kyu;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7/train/java
 */

public class BattleshipFieldValidator {

    public static void main(String[] args) {
        int[][] validField0 = {
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(fieldValidator(validField0)); // Output: true
    }

//    public static void main(String[] args) {
//        int[][] validField0 = {
//                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//                {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//        };
//        System.out.println(fieldValidator(validField0)); // Output: true
//        int[][] validField = {
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
//        };
//        System.out.println(fieldValidator(validField)); // Output: true
//        int[][] invalidField = {
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1} // Invalid ship count
//        };
//        System.out.println(fieldValidator(invalidField)); // Output: false
//    }







    public static boolean fieldValidator(int[][] field) {
        Integer submarines = 0;
        int cruisers = 0;
        int destroyers = 0;
        int battleship = 0;
        for (int y = 0; y < 10; y++)
            for (int x = 0; x < 10; x++) {
                if (field[x][y] == 1) {
                    if ((x > 0) && (field[x - 1][y] == 1)) continue;
                    if ((y > 0) && (field[x][y - 1] == 1)) continue;
                    switch (checkvsl(x, y, field)) {
                        case 1:
                            submarines++;
                            break;
                        case 2:
                            destroyers++;
                            break;
                        case 3:
                            cruisers++;
                            break;
                        case 4:
                            battleship++;
                            break;
                        default:
                            return false;
                    }
                }
            }
        System.out.println(destroyers);
        if (submarines != 4) return false;
        if (destroyers != 3) return false;
        if (cruisers != 2) return false;
        if (battleship != 1) return false;
        return true;
    }

    public static Integer checkvsl(int x, int y, int[][] field) {
        if ((x > 0) && (y < 9))
            if (field[x - 1][y + 1] == 1) return 5;
        if ((x < 9) && (y < 9)) {
            if (field[x + 1][y + 1] == 1) return 5;
            if ((field[x + 1][y] == 1) && (field[x][y + 1] == 1)) return 5;
        }
        if (y < 9)
            if (field[x][y + 1] == 1) return 1 + checkvsl(x, y + 1, field);

        if (x < 9)
            if (field[x + 1][y] == 1) return 1 + checkvsl(x + 1, y, field);
        return 1;
    }





//    public static boolean fieldValidator(int[][] field) {
//        Set<String> visitedCells = new HashSet<>();
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                if (field[i][j] == 1 && !visitedCells.contains(i + "," + j)) {
//                    if (!isValidShip(field, visitedCells, i, j)) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    private static boolean isValidShip(int[][] field, Set<String> visitedCells, int row, int col) {
//        int shipSize = 0;
//        while (row < 10 && field[row][col] == 1 && !visitedCells.contains(row + "," + col)) {
//            visitedCells.add(row + "," + col);
//            shipSize++;
//            row++;
//        }
//        if (shipSize == 0 || shipSize > 4) {
//            return false;  // Invalid ship size
//        }
//        int endRow = row - 1;
//        int endCol = col;
//        // Check for ship overlap
//        for (int i = 0; i < shipSize; i++) {
//            if (endRow + 1 < 10 && field[endRow + 1][endCol] == 1 && !visitedCells.contains((endRow + 1) + "," + endCol)) {
//                return false;
//            }
//            endRow--;
//        }
//        return true;
//    }
}
