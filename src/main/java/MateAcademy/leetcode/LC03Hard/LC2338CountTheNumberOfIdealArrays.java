package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/count-the-number-of-ideal-arrays
 */

public class LC2338CountTheNumberOfIdealArrays {
    static final int MOD = 1_000_000_007; // (int)1e9 + 7
    private static long[] options;

    public static void main(String[] args) {
        System.out.println(idealArrays(2, 5)); // 10
        System.out.println(idealArrays(5, 3)); // 11
    }

    public static int idealArrays(int n, int maxValue) {
        long[][] count = new long[15][10005];
        long[][] prefixSum = new long[15][10005];
        options = new long[15];

        for (int i = 1; i <= 10000; ++i) {
            count[1][i] = 1;
            prefixSum[1][i] = i;
        }

        for (int i = 2; i <= 14; ++i) {
            for (int j = i; j <= 10000; ++j) {
                count[i][j] = prefixSum[i - 1][j - 1];
                prefixSum[i][j] = (count[i][j] + prefixSum[i][j - 1]) % MOD;
                count[i][j] %= MOD;
            }
        }

        for (int i = 1; i <= maxValue; ++i) {
            countUniqueSequences(i, 1, maxValue);
        }

        long result = 0;
        for (int i = 1; i <= 14; ++i) {
            long ways = (count[i][n] * options[i]) % MOD;
            result = (result + ways) % MOD;
        }
        return (int) result;
    }

    private static void countUniqueSequences(int curr, int idx, int maxValue) {
        options[idx]++;
        for (int j = 2; curr * j <= maxValue; ++j) {
            countUniqueSequences(curr * j, idx + 1, maxValue);
        }
    }
}
