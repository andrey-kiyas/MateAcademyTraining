package MateAcademy.leetcode.LC02Medium;

/*
  https://leetcode.com/problems/rotating-the-box
 */

import java.util.Arrays;

public class LC1861RotatingTheBox {
    public static void main(String[] args) {
        char[][] box = {{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        char[][] result = rotateTheBox(box);
        for (char[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static char[][] rotateTheBox(char[][] boxGrid) {
            int m = boxGrid.length;
            int n = boxGrid[0].length;

            for (int i = 0; i < m; i++) {
                int emptySlot = n - 1;
                for (int j = n - 1; j >= 0; j--) {
                    if (boxGrid[i][j] == '*') {
                        emptySlot = j - 1;
                    } else if (boxGrid[i][j] == '#') {
                        boxGrid[i][j] = '.';
                        boxGrid[i][emptySlot] = '#';
                        emptySlot--;
                    }
                }
            }

            char[][] rotatedBox = new char[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotatedBox[j][m - 1 - i] = boxGrid[i][j];
                }
            }

            return rotatedBox;
    }
}
