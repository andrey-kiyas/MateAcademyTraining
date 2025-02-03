package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/house-robber
 */

public class LC0198HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));          // 1 + 3 = 4
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));       // 2 + 9 + 1 = 12
        System.out.println(rob(new int[]{1, 9, 2, 8, 3, 7, 4})); // 9 + 8 + 7 = 24
        System.out.println(rob(new int[]{2, 1, 1, 2}));          // 2 + 2 = 4
    }

    public static int rob2(int[] nums) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        return Math.max(even, odd);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
