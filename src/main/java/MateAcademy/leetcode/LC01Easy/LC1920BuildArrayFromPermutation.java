package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/build-array-from-permutation
 */

public class LC1920BuildArrayFromPermutation {
    public static void main(String[] args) {
        int[] nums1 = {0, 2, 1, 5, 3, 4};
        int[] nums2 = {5, 0, 1, 2, 3, 4};

        System.out.println(Arrays.toString(buildArray(nums1)));
        System.out.println(Arrays.toString(buildArray(nums2)));
    }

    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
