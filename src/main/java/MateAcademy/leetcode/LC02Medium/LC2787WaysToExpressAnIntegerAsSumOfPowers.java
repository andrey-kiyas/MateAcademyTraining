package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers
 */

public class LC2787WaysToExpressAnIntegerAsSumOfPowers {
    public static void main(String[] args) {
        System.out.println(numberOfWays(10, 2)); // 1
        System.out.println(numberOfWays(4, 1));  // 2
    }

    public static int numberOfWays(int n, int x) {
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[n + 1][n + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            long k = (long) Math.pow(i, x);
            for (int j = 0; j <= n; ++j) {
                f[i][j] = f[i - 1][j];
                if (k <= j) {
                    f[i][j] = (f[i][j] + f[i - 1][j - (int) k]) % mod;
                }
            }
        }
        return f[n][n];
    }
}
