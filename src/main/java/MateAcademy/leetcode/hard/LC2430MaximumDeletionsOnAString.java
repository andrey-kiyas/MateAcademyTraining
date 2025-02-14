package MateAcademy.leetcode.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-deletions-on-a-string
 */

public class LC2430MaximumDeletionsOnAString {
    public static void main(String[] args) {
        System.out.println(deleteString("abcabcdabc")); // 2
        System.out.println(deleteString("aaabaab"));    // 4
        System.out.println(deleteString("aaaaa"));      // 5
    }

    public static int deleteString(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[][] lcp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int len = 1; i + len * 2 <= n; len++) {
                if (lcp[i][i + len] >= len) {
                    dp[i] = Math.max(dp[i], 1 + dp[i + len]);
                }
            }
        }

        return dp[0];
    }

    public static int deleteString2(String s) {
        int result = 0;

        while (!s.isEmpty()) {
            int maxLen = 1;
            for (int len = 1; len <= s.length() / 2; len++) {
                if (s.substring(0, len).equals(s.substring(len, len * 2))) {
                    maxLen = len;
                }
            }
            s = s.substring(maxLen);
            result++;
        }

        return result;
    }
}
