package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/maximum-ascending-subarray-sum
 */

public class LC1800MaximumAscendingSubarraySum {

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 40, 50}));
        System.out.println(maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
    }

    public static int maxAscendingSum(int[] nums) {
        int maxSum = nums[0], curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                curSum += nums[i];
            } else {
                curSum = nums[i];
            }
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }
}
