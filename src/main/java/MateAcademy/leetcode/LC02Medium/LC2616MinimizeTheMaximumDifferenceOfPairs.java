package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/description
 */

public class LC2616MinimizeTheMaximumDifferenceOfPairs {
    public static void main(String[] args) {
        int[] nums1 = {10, 1, 2, 7, 1, 3};
        int[] nums2 = {4, 2, 1, 2};
        System.out.println(minimizeMax(nums1, 2)); // Output: 1
        System.out.println(minimizeMax(nums2, 1)); // Output: 0
    }

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, p, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2;
            } else {
                i += 1;
            }
        }
        return count >= p;
    }
}
