package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix
 */

public class LC1594MaximumNonNegativeProductInAMatrix {
    public static void main(String[] args) {
        int[][] grid1 = {{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}};
        System.out.println(maxProductPath(grid1)); // -1

        int[][] grid2 = {{1, -2, 1}, {1, -2, 1}, {3, -4, 1}};
        System.out.println(maxProductPath(grid2)); // 8

        int[][] grid3 = {{1, 3}, {0, -4}};
        System.out.println(maxProductPath(grid3)); // 0
    }

    public static int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1_000_000_007;

        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];

        maxDP[0][0] = minDP[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            maxDP[i][0] = minDP[i][0] = maxDP[i - 1][0] * grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            maxDP[0][j] = minDP[0][j] = maxDP[0][j - 1] * grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                long p1 = maxDP[i - 1][j] * val;
                long p2 = minDP[i - 1][j] * val;
                long p3 = maxDP[i][j - 1] * val;
                long p4 = minDP[i][j - 1] * val;

                maxDP[i][j] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
                minDP[i][j] = Math.min(Math.min(p1, p2), Math.min(p3, p4));
            }
        }

        long res = maxDP[m - 1][n - 1];
        return res < 0 ? -1 : (int) (res % MOD);
    }
}
