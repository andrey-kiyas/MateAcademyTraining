package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/longest-nice-subarray
 */

public class LC2401LongestNiceSubarray {
    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{1, 3, 8, 48, 10})); // 3
        System.out.println(longestNiceSubarray(new int[]{3, 1, 5, 11, 13})); // 1
    }

    public static int longestNiceSubarray(int[] nums) {
        int left = 0, bitmask = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left];
                left++;
            }

            bitmask |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
