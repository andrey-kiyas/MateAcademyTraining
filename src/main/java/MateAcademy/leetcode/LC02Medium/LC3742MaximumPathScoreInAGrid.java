package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-path-score-in-a-grid
 */

public class LC3742MaximumPathScoreInAGrid {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 1}, {2, 0}};
        System.out.println(maxPathScore(grid1, 1)); // 2

        int[][] grid2 = {{0, 1}, {1, 2}};
        System.out.println(maxPathScore(grid2, 1)); // -1
    }

    public static int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    if (dp[i][j][c] == -1) continue;

                    // Рух ВПРАВО
                    if (j + 1 < n) {
                        update(grid, dp, i, j + 1, c, dp[i][j][c], k);
                    }

                    // Рух ВНИЗ
                    if (i + 1 < m) {
                        update(grid, dp, i + 1, j, c, dp[i][j][c], k);
                    }
                }
            }
        }

        int maxScore = -1;
        for (int c = 0; c <= k; c++) {
            maxScore = Math.max(maxScore, dp[m - 1][n - 1][c]);
        }

        return maxScore;
    }

    private static void update(int[][] grid, int[][][] dp, int r, int c, int prevCost, int prevScore, int maxK) {
        int val = grid[r][c];
        int cellScore = (val == 2) ? 2 : (val == 1 ? 1 : 0);
        int cellCost = (val >= 1) ? 1 : 0;

        int newCost = prevCost + cellCost;
        if (newCost <= maxK) {
            dp[r][c][newCost] = Math.max(dp[r][c][newCost], prevScore + cellScore);
        }
    }
}
