package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii
 */

public class LC3756ConcatenateNonZeroDigitsAndMultiplyBySumII {
    public static void main(String[] args) {
        String s1 = "10203004";
        int[][] q1 = {{0, 7}, {1, 3}, {4, 6}};
        System.out.println(Arrays.toString(sumAndMultiply(s1, q1))); // [12340, 4, 9]

        String s2 = "1000";
        int[][] q2 = {{0, 3}, {1, 1}};
        System.out.println(Arrays.toString(sumAndMultiply(s2, q2))); // [1, 0]
    }

    public static int[] sumAndMultiply(String s, int[][] queries) {
        int m = s.length();
        long MOD = 1_000_000_007;

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefSum = new long[m + 1];
        long[] prefX = new long[m + 1];
        int[] nonZeroCount = new int[m + 1];

        for (int i = 0; i < m; i++) {
            int digit = s.charAt(i) - '0';

            prefSum[i + 1] = prefSum[i] + digit;

            if (digit != 0) {
                prefX[i + 1] = (prefX[i] * 10 + digit) % MOD;
                nonZeroCount[i + 1] = nonZeroCount[i] + 1;
            } else {
                prefX[i + 1] = prefX[i];
                nonZeroCount[i + 1] = nonZeroCount[i];
            }
        }

        int numQueries = queries.length;
        int[] answer = new int[numQueries];

        for (int q = 0; q < numQueries; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            long sum = prefSum[r + 1] - prefSum[l];

            if (sum == 0) {
                answer[q] = 0;
                continue;
            }

            int cnt = nonZeroCount[r + 1] - nonZeroCount[l];

            long x = prefX[r + 1] - (prefX[l] * pow10[cnt]) % MOD;
            if (x < 0) {
                x += MOD;
            }

            long res = (x * (sum % MOD)) % MOD;
            answer[q] = (int) res;
        }

        return answer;
    }
}
