package MateAcademy.leetcode.LC02Medium;

/*
  https://leetcode.com/problems/minimum-absolute-difference-in-sliding-submatrix
 */

import java.util.Arrays;
import java.util.TreeSet;

public class LC3567MinimumAbsoluteDifferenceInSlidingSubmatrix {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 8}, {3, -2}};
        System.out.println(Arrays.deepToString(minAbsDiff(grid1, 2))); // [[2]]

        int[][] grid2 = {{3, -1}};
        System.out.println(Arrays.deepToString(minAbsDiff(grid2, 2))); // [[0, 0]]

        int[][] grid3 = {{1, -2, 3}, {2, 3, 5}};
        System.out.println(Arrays.deepToString(minAbsDiff(grid3, 2))); // [[1, 2]]
    }

    public static int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int rows = m - k + 1;
        int cols = n - k + 1;
        int[][] ans = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i][j] = solve(grid, i, j, k);
            }
        }
        return ans;
    }

    private static int solve(int[][] grid, int r, int c, int k) {
        TreeSet<Integer> distinctValues = new TreeSet<>();

        for (int i = r; i < r + k; i++) {
            for (int j = c; j < c + k; j++) {
                distinctValues.add(grid[i][j]);
            }
        }

        if (distinctValues.size() <= 1) return 0;

        int minDiff = Integer.MAX_VALUE;
        Integer prev = null;

        for (int current : distinctValues) {
            if (prev != null) {
                minDiff = Math.min(minDiff, current - prev);
            }
            prev = current;
        }

        return minDiff;
    }
}
