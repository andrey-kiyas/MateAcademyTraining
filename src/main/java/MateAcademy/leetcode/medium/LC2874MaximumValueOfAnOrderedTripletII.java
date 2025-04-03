package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii
 */

public class LC2874MaximumValueOfAnOrderedTripletII {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12, 6, 1, 2, 7}));  // 77
        System.out.println(maximumTripletValue(new int[]{1, 10, 3, 4, 19})); // 133
        System.out.println(maximumTripletValue(new int[]{1, 2, 3}));         // 0

    }

    public static long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;

        int maxLeft = 0;
        int[] maxRight = new int[n];

        maxRight[n - 1] = nums[n - 1];
        for (int k = n - 2; k >= 0; k--) {
            maxRight[k] = Math.max(maxRight[k + 1], nums[k]);
        }

        for (int j = 1; j < n - 1; j++) {
            maxLeft = Math.max(maxLeft, nums[j - 1]);
            long value = (long) (maxLeft - nums[j]) * maxRight[j + 1];
            maxValue = Math.max(maxValue, value);
        }

        return maxValue;
    }
}
