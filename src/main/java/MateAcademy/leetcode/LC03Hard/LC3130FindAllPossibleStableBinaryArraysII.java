package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/find-all-possible-stable-binary-arrays-ii
 */

public class LC3130FindAllPossibleStableBinaryArraysII {
    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(1, 1, 2)); // 2
        System.out.println(numberOfStableArrays(1, 2, 1)); // 1
        System.out.println(numberOfStableArrays(3, 3, 2)); // 14
    }

    public static int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        int[][][] dp = new int[zero + 1][one + 1][2];

        for (int i = 1; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                long val0 = (long) dp[i - 1][j][0] + dp[i - 1][j][1];
                if (i > limit) {
                    val0 -= dp[i - limit - 1][j][1];
                }
                dp[i][j][0] = (int) ((val0 + MOD) % MOD);

                long val1 = (long) dp[i][j - 1][0] + dp[i][j - 1][1];
                if (j > limit) {
                    val1 -= dp[i][j - limit - 1][0];
                }
                dp[i][j][1] = (int) ((val1 + MOD) % MOD);
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;
    }
}
