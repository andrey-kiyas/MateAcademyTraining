package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-the-number-of-fair-pairs
 */

public class LC2563CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 7, 4, 4, 5};
        int[] nums2 = {1, 7, 9, 2, 5};
        System.out.println(countFairPairs(nums1, 3, 6));   // Output: 6
        System.out.println(countFairPairs(nums2, 11, 11)); // Output: 1
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairs(nums, upper) - countPairs(nums, lower - 1);
    }

    private static long countPairs(int[] nums, int limit) {
        long count = 0;
        int n = nums.length;
        int j = n - 1;

        for (int i = 0; i < n; i++) {
            while (j > i && nums[i] + nums[j] > limit) {
                j--;
            }
            count += Math.max(0, j - i);
        }

        return count;
    }
}
