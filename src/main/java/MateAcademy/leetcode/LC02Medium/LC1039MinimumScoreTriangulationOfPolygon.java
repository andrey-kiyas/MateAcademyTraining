package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-score-triangulation-of-polygon
 */

public class LC1039MinimumScoreTriangulationOfPolygon {
    public static void main(String[] args) {
        System.out.println(minScoreTriangulation(new int[]{1, 2, 3}));          // 6
        System.out.println(minScoreTriangulation(new int[]{3, 7, 4, 5}));       // 144
        System.out.println(minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5})); // 13
    }

    public static int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
