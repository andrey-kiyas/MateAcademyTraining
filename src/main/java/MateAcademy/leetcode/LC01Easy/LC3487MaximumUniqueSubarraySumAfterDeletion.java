package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion
 */

public class LC3487MaximumUniqueSubarraySumAfterDeletion {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 1, 0, 1, 1};
        int[] nums3 = {1, 2, -1, -2, 1, 0, -1};
        System.out.println(maxSum(nums1)); // 15
        System.out.println(maxSum(nums2)); // 1
        System.out.println(maxSum(nums3)); // 3
    }

    public static int maxSum(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();

        if (max <= 0) {
            return max;
        }

        boolean[] seen = new boolean[201];
        int result = 0;

        for (int num : nums) {

            if (num < 0 || seen[num]) {
                continue;
            }

            result += num;
            seen[num] = true;
        }

        return result;
    }
}
