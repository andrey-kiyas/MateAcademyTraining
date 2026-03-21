package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flip-square-submatrix-vertically
 */

public class LC3643FlipSquareSubmatrixVertically {
    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.deepToString(reverseSubmatrix(grid1, 1, 0, 3)));
        // [[1, 2, 3, 4], [13, 14, 15, 8], [9, 10, 11, 12], [5, 6, 7, 16]]

        int[][] grid2 = {
                {3, 4, 2, 3},
                {2, 3, 4, 2}
        };
        System.out.println(Arrays.deepToString(reverseSubmatrix(grid2, 0, 2, 2)));
        // [[3, 4, 4, 2], [2, 3, 2, 3]]
    }

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x + k - 1;

        while (top < bottom) {
            for (int j = y; j < y + k; j++) {
                int temp = grid[top][j];
                grid[top][j] = grid[bottom][j];
                grid[bottom][j] = temp;
            }
            top++;
            bottom--;
        }

        return grid;
    }
}
