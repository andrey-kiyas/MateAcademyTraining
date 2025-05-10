package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros
 */

public class LC2918MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public static void main(String[] args) {
        int[] nums1a = {3, 2, 0, 1, 0}, nums2a = {6, 5, 0};
        int[] nums1b = {2, 0, 2, 0}, nums2b = {1, 4};

        System.out.println(minSum(nums1a, nums2a)); // 12
        System.out.println(minSum(nums1b, nums2b)); // -1
    }

    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;

        for (int n : nums1) {
            if (n == 0) zero1++;
            else sum1 += n;
        }

        for (int n : nums2) {
            if (n == 0) zero2++;
            else sum2 += n;
        }

        if (zero1 == 0 && zero2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        }

        long minSum1 = sum1 + zero1;
        long minSum2 = sum2 + zero2;

        if (minSum1 > minSum2 && zero2 == 0) return -1;
        if (minSum2 > minSum1 && zero1 == 0) return -1;

        return Math.max(minSum1, minSum2);
    }
}
