package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/equal-sum-grid-partition-i
 */

public class LC3546EqualSumGridPartition {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 4}, {2, 3}};
        System.out.println(canPartitionGrid(grid1)); // true (рядок 0: 5, рядок 1: 5)

        int[][] grid2 = {{1, 3}, {2, 4}};
        System.out.println(canPartitionGrid(grid2)); // false
    }

    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                totalSum += ints[j];
            }
        }

        if (totalSum % 2 != 0) return false;
        long target = totalSum / 2;

        long currentRowSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                currentRowSum += grid[i][j];
            }
            if (currentRowSum == target) return true;
        }

        long currentColSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int[] ints : grid) {
                currentColSum += ints[j];
            }
            if (currentColSum == target) return true;
        }

        return false;
    }
}
