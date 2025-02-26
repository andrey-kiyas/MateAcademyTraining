package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray
 */

public class LC1749MaximumAbsoluteSumOfAnySubarray {
    public static void main(String[] args) {
        System.out.println(maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));     // 5
        System.out.println(maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2})); // 8
    }

    public static int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0;
        int currentMax = 0, currentMin = 0;

        for (int num : nums) {
            currentMax = Math.max(0, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(0, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}
