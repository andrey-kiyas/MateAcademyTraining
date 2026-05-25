package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/jump-game-vii
 */

public class LC1871JumpGameVII {
    public static void main(String[] args) {
        System.out.println(canReach("011010", 2, 3));   // true
        System.out.println(canReach("01101110", 2, 3)); // false
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int availableJumpsCount = 0;

        for (int i = 1; i < n; i++) {
            if (i >= minJump && dp[i - minJump]) {
                availableJumpsCount++;
            }

            if (i > maxJump && dp[i - maxJump - 1]) {
                availableJumpsCount--;
            }

            if (availableJumpsCount > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}
