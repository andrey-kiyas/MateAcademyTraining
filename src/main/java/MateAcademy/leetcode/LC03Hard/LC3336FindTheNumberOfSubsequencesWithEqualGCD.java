package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd
 */

public class LC3336FindTheNumberOfSubsequencesWithEqualGCD {
    public static void main(String[] args) {
        System.out.println(subsequencePairCount(new int[]{1, 2, 3, 4})); // 10
        System.out.println(subsequencePairCount(new int[]{10, 20, 30})); // 2
        System.out.println(subsequencePairCount(new int[]{1, 1, 1, 1})); // 50
    }

    public static int subsequencePairCount(int[] nums) {
        int MOD = 1_000_000_007;

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[][] dp = new int[maxVal + 1][maxVal + 1];

        dp[0][0] = 1;

        int[][] gcdMemo = new int[maxVal + 1][maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            for (int j = 0; j <= maxVal; j++) {
                gcdMemo[i][j] = gcd(i, j);
            }
        }

        for (int num : nums) {
            int[][] nextDp = new int[maxVal + 1][maxVal + 1];

            for (int g1 = 0; g1 <= maxVal; g1++) {
                for (int g2 = 0; g2 <= maxVal; g2++) {
                    if (dp[g1][g2] == 0) continue;

                    long currentWays = dp[g1][g2];

                    nextDp[g1][g2] = (int) ((nextDp[g1][g2] + currentWays) % MOD);

                    int nextG1 = gcdMemo[g1][num];
                    nextDp[nextG1][g2] = (int) ((nextDp[nextG1][g2] + currentWays) % MOD);

                    int nextG2 = gcdMemo[g2][num];
                    nextDp[g1][nextG2] = (int) ((nextDp[g1][nextG2] + currentWays) % MOD);
                }
            }
            dp = nextDp;
        }

        long totalPairs = 0;
        for (int g = 1; g <= maxVal; g++) {
            totalPairs = (totalPairs + dp[g][g]) % MOD;
        }

        return (int) totalPairs;
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
