package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/equal-sum-grid-partition-ii
 */

public class LC3548EqualSumGridPartitionII {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 4}, {2, 3}};
        System.out.println(canPartitionGrid(grid1)); // true (5 = 5)

        int[][] grid2 = {{1, 2}, {3, 4}};
        System.out.println(canPartitionGrid(grid2)); // true (4 и 6, 6-2=4)

        int[][] grid3 = {{1, 2, 4}, {2, 3, 5}};
        System.out.println(canPartitionGrid(grid3)); // false
    }

    public static boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;

        long[] rowSums = new long[m];
        long[] colSums = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
                rowSums[i] += grid[i][j];
                colSums[j] += grid[i][j];
            }
        }

        long s1 = 0;
        for (int i = 0; i < m - 1; i++) {
            s1 += rowSums[i];
            long s2 = totalSum - s1;
            if (s1 == s2) return true;

            if (s1 > s2) { // Шукаємо в S1 (рядки 0..i)
                if (existsAndConnected(grid, 0, i, 0, n - 1, s1 - s2)) return true;
            } else { // Шукаємо в S2 (рядки i+1..m-1)
                if (existsAndConnected(grid, i + 1, m - 1, 0, n - 1, s2 - s1)) return true;
            }
        }

        s1 = 0;
        for (int j = 0; j < n - 1; j++) {
            s1 += colSums[j];
            long s2 = totalSum - s1;
            if (s1 == s2) return true;

            if (s1 > s2) { // Шукаємо в S1 (стовпці 0..j)
                if (existsAndConnected(grid, 0, m - 1, 0, j, s1 - s2)) return true;
            } else { // Шукаємо в S2 (стовпці j+1..n-1)
                if (existsAndConnected(grid, 0, m - 1, j + 1, n - 1, s2 - s1)) return true;
            }
        }

        return false;
    }

    private static boolean existsAndConnected(int[][] grid, int r1, int r2, int c1, int c2, long target) {
        if (target > 1000000) return false;
        int t = (int) target;

        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        if (rows > 1 && cols > 1) {
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (grid[i][j] == t) return true;
                }
            }
        }
        else if (rows == 1) {
            return grid[r1][c1] == t || grid[r1][c2] == t;
        }
        else if (cols == 1) {
            return grid[r1][c1] == t || grid[r2][c1] == t;
        }

        return false;
    }
}
