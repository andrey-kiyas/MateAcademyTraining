package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/solving-questions-with-brainpower
 */

public class LC2140SolvingQuestionsWithBrainpower {
    public static void main(String[] args) {
        System.out.println(mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}));         // 5
        System.out.println(mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}})); // 7
    }

    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int next = i + brainpower + 1;

            long solve = points + (next < n ? dp[next] : 0);
            long skip = dp[i + 1];

            dp[i] = Math.max(solve, skip);
        }

        return dp[0];
    }
}
