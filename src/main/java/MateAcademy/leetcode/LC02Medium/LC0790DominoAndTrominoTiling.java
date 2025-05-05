package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/domino-and-tromino-tiling
 */

public class LC0790DominoAndTrominoTiling {
    public static void main(String[] args) {
        System.out.println(numTilings(3));  // Output: 5
        System.out.println(numTilings(1));  // Output: 1
    }

    public static int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
    }
}
