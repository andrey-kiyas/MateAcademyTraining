package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/longest-common-subsequence
 */

public class LongestCommonSubsequence1143 {

    public static void main(String[] args) {
        String text1_1 = "abcde";
        String text2_1 = "ace";
        System.out.println("Expected: 3, Output: " + longestCommonSubsequence(text1_1, text2_1));

        String text1_2 = "abc";
        String text2_2 = "abc";
        System.out.println("Expected: 3, Output: " + longestCommonSubsequence(text1_2, text2_2));

        String text1_3 = "abc";
        String text2_3 = "def";
        System.out.println("Expected: 0, Output: " + longestCommonSubsequence(text1_3, text2_3));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // Создаем двумерный массив для хранения результатов подзадач
        int[][] dp = new int[m + 1][n + 1];

        // Заполняем массив значениями для всех подзадач
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Возвращаем длину наибольшей общей подпоследовательности
        return dp[m][n];
    }
}
