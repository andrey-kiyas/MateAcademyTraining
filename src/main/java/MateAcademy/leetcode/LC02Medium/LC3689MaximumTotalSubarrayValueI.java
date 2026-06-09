package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/maximum-total-subarray-value-i
 */

public class LC3689MaximumTotalSubarrayValueI {
    public static void main(String[] args) {
        System.out.println(maxTotalValue(new int[]{1, 3, 2}, 2));    // 4
        System.out.println(maxTotalValue(new int[]{4, 2, 5, 1}, 3)); // 12
    }

    public static long maxTotalValue(int[] nums, int k) {
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > globalMax) {
                globalMax = num;
            }
            if (num < globalMin) {
                globalMin = num;
            }
        }

        long maxSingleValue = (long) globalMax - globalMin;

        return maxSingleValue * k;
    }
}
