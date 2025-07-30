package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description
 */

public class LC2419LongestSubarrayWithMaximumBitwiseAND {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 2, 2};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(longestSubarray(nums1)); // 2
        System.out.println(longestSubarray(nums2)); // 1
    }

    public static int longestSubarray(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int maxLength = 0;
        int currentLength = 0;

        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }

        return maxLength;
    }
}
