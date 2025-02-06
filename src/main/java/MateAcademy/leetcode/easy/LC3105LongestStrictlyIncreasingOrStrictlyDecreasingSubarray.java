package MateAcademy.leetcode.easy;

/**
 * https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray
 */

public class LC3105LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {

    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{1, 4, 3, 3, 2}));
        System.out.println(longestMonotonicSubarray(new int[]{3, 3, 3, 3}));
        System.out.println(longestMonotonicSubarray(new int[]{3, 2, 1}));
        System.out.println(longestMonotonicSubarray(new int[]{3}));
    }

    public static int longestMonotonicSubarray(int[] nums) {
//        if (nums.length == 1) return 1;

        int maxLen = 1, incr = 1, decr = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                incr++;
                decr = 1;
            } else if (nums[i - 1] > nums[i]) {
                decr++;
                incr = 1;
            } else {
                incr = 1;
                decr = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incr, decr));
        }

        return maxLen;
    }
}
