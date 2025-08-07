package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/find-the-maximum-number-of-fruits-collected
 */

public class LC3363FindTheMaximumNumberOfFruitsCollected {
    public static void main(String[] args) {
        int[][] fruits1 = {{1, 2, 3, 4}, {5, 6, 8, 7}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] fruits2 = {{1, 1}, {1, 1}};

        System.out.println(maxCollectedFruits(fruits1)); // 100
        System.out.println(maxCollectedFruits(fruits2)); // 4
    }

    public static int maxCollectedFruits(int[][] fruits) {
        final int n = fruits.length;
        return getTopLeft(fruits) + getTopRight(fruits) + getBottomLeft(fruits)
                - 2 * fruits[n - 1][n - 1];
    }

    private static int getTopLeft(int[][] fruits) {
        final int n = fruits.length;
        int res = 0;
        for (int i = 0; i < n; ++i)
            res += fruits[i][i];
        return res;
    }

    private static int getTopRight(int[][] fruits) {
        final int n = fruits.length;
        int[][] dp = new int[n][n];
        dp[0][n - 1] = fruits[0][n - 1];
        for (int x = 0; x < n; ++x)
            for (int y = 0; y < n; ++y) {
                if (x >= y && !(x == n - 1 && y == n - 1))
                    continue;
                for (int[] dir : new int[][] {{1, -1}, {1, 0}, {1, 1}}) {
                    final int i = x - dir[0];
                    final int j = y - dir[1];
                    if (i < 0 || i == n || j < 0 || j == n)
                        continue;
                    if (i < j && j < n - 1 - i)
                        continue;
                    dp[x][y] = Math.max(dp[x][y], dp[i][j] + fruits[x][y]);
                }
            }
        return dp[n - 1][n - 1];
    }

    private static int getBottomLeft(int[][] fruits) {
        final int n = fruits.length;
        int[][] dp = new int[n][n];
        dp[n - 1][0] = fruits[n - 1][0];
        for (int y = 0; y < n; ++y)
            for (int x = 0; x < n; ++x) {
                if (x <= y && !(x == n - 1 && y == n - 1))
                    continue;
                for (int[] dir : new int[][] {{-1, 1}, {0, 1}, {1, 1}}) {
                    final int i = x - dir[0];
                    final int j = y - dir[1];
                    if (i < 0 || i == n || j < 0 || j == n)
                        continue;
                    if (j < i && i < n - 1 - j)
                        continue;
                    dp[x][y] = Math.max(dp[x][y], dp[i][j] + fruits[x][y]);
                }
            }
        return dp[n - 1][n - 1];
    }
}
