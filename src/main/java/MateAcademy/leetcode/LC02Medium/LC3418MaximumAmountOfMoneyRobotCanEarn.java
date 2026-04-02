package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn
 */

public class LC3418MaximumAmountOfMoneyRobotCanEarn {
    public static void main(String[] args) {
            int[][] coins1 = {{0, 1, -1}, {1, -2, 3}, {2, -3, 4}};
            System.out.println(maximumAmount(coins1)); // 8

            int[][] coins2 = {{10, 10, 10}, {10, 10, 10}};
            System.out.println(maximumAmount(coins2)); // 40
    }

    public static int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE / 2);
            }
        }

        for (int k = 0; k < 3; k++) {
            if (coins[0][0] < 0) {
                dp[0][0][k] = coins[0][0];
                if (k > 0) dp[0][0][k] = 0;
            } else {
                dp[0][0][k] = coins[0][0];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {
                    int val = coins[i][j];

                    int fromTop = (i > 0) ? dp[i - 1][j][k] : Integer.MIN_VALUE / 2;
                    int fromLeft = (j > 0) ? dp[i][j - 1][k] : Integer.MIN_VALUE / 2;
                    int prevMax = Math.max(fromTop, fromLeft);

                    dp[i][j][k] = Math.max(dp[i][j][k], prevMax + val);

                    if (val < 0 && k > 0) {
                        int fromTopNeutral = (i > 0) ? dp[i - 1][j][k - 1] : Integer.MIN_VALUE / 2;
                        int fromLeftNeutral = (j > 0) ? dp[i][j - 1][k - 1] : Integer.MIN_VALUE / 2;
                        dp[i][j][k] = Math.max(dp[i][j][k], Math.max(fromTopNeutral, fromLeftNeutral));
                    }
                }
            }
        }

        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}
