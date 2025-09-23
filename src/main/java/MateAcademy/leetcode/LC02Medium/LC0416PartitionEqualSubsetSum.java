package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum
 */

public class LC0416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5})); // true
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));  // false
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
