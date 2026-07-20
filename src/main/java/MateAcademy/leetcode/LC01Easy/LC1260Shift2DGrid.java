package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shift-2d-grid
 */

public class LC1260Shift2DGrid {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(shiftGrid(grid1, 1));
        // Виведе: [[9, 1, 2], [3, 4, 5], [6, 7, 8]]

        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(shiftGrid(grid2, 9));
        // Виведе: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k = k % total;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < total; i++) {
            int originalIndex = (i - k + total) % total;

            int origRow = originalIndex / n;
            int origCol = originalIndex % n;

            int targetRow = i / n;
            result.get(targetRow).add(grid[origRow][origCol]);
        }

        return result;
    }
}
