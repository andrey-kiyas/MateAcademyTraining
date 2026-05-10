package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index
 */

public class LC2770MaximumNumberOfJumpsToReachTheLastIndex {
    public static void main(String[] args) {
        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2)); // 3
        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3)); // 5
        System.out.println(maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 0)); // -1
    }

    public static int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && Math.abs((long)nums[i] - nums[j]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
