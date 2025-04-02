package MateAcademy.leetcode.easy;

/**
 * https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i
 */

public class LC2873MaximumValueOfAnOrderedTripletI {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[]{12, 6, 1, 2, 7}));  // 77
        System.out.println(maximumTripletValue(new int[]{1, 10, 3, 4, 19})); // 133
        System.out.println(maximumTripletValue(new int[]{1, 2, 3}));         // 0
    }

    public static long maximumTripletValue(int[] nums) {
        long maxValue = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long value = (long) (nums[i] - nums[j]) * nums[k];
                    maxValue = Math.max(maxValue, value);
                }
            }
        }

        return maxValue;
    }
}
