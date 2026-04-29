package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-score-from-grid-operations
 */

public class LC3225MaximumScoreFromGridOperations {
    public static void main(String[] args) {
        int[][] g1 = {{0, 0, 3, 0, 0}, {0, 0, 3, 0, 0}, {0, 1, 0, 0, 0}, {5, 0, 0, 3, 0}, {0, 0, 0, 0, 2}};
        System.out.println(maximumScore(g1)); // 11

        int[][] g2 = {{10, 9, 0, 0, 15}, {7, 1, 0, 8, 0}, {5, 20, 0, 11, 0}, {0, 0, 0, 1, 2}, {8, 12, 1, 10, 3}};
        System.out.println(maximumScore(g2)); // 94
    }

    public static long maximumScore(int[][] grid) {
        final int n = grid.length;
        long[][] prefix = new long[n][n + 1];
        long[] prevPick = new long[n + 1];
        long[] prevSkip = new long[n + 1];

        for (int j = 0; j < n; ++j)
            for (int i = 0; i < n; ++i)
                prefix[j][i + 1] = prefix[j][i] + grid[i][j];

        for (int j = 1; j < n; ++j) {
            long[] currPick = new long[n + 1];
            long[] currSkip = new long[n + 1];
            for (int curr = 0; curr <= n; ++curr)
                for (int prev = 0; prev <= n; ++prev)
                    if (curr > prev) {
                        final long score = prefix[j - 1][curr] - prefix[j - 1][prev];
                        currPick[curr] = Math.max(currPick[curr], prevSkip[prev] + score);
                        currSkip[curr] = Math.max(currSkip[curr], prevSkip[prev] + score);
                    } else {
                        final long score = prefix[j][prev] - prefix[j][curr];
                        currPick[curr] = Math.max(currPick[curr], prevPick[prev] + score);
                        currSkip[curr] = Math.max(currSkip[curr], prevPick[prev]);
                    }
            prevPick = currPick;
            prevSkip = currSkip;
        }

        return Arrays.stream(prevPick).max().orElse(0L);
    }
}
