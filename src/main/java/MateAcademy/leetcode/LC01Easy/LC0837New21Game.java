package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/new-21-game
 */

public class LC0837New21Game {
    public static void main(String[] args) {
        System.out.println(new21Game(10, 1, 10));  // 1.0
        System.out.println(new21Game(6, 1, 10));   // 0.6
        System.out.println(new21Game(21, 17, 10)); // ~0.73278
    }

    public static double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;
        double windowSum = 1.0;
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                windowSum += dp[i];
            } else {
                result += dp[i];
            }

            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }
        return result;
    }
}
