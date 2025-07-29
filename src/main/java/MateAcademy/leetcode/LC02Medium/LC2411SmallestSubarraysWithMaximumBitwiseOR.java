package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or
 */

public class LC2411SmallestSubarraysWithMaximumBitwiseOR {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, 2, 1, 3};
        int[] nums2 = {1, 2};

        System.out.println(Arrays.toString(smallestSubarrays(nums1))); // [3,3,2,2,1]
        System.out.println(Arrays.toString(smallestSubarrays(nums2))); // [2,1]
    }

    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] lastSeen = new int[32];

        Arrays.fill(lastSeen, -1);

        for (int i = n - 1; i >= 0; i--) {
            for (int bit = 0; bit < 32; bit++) {
                if (((nums[i] >> bit) & 1) == 1) {
                    lastSeen[bit] = i;
                }
            }

            int farthest = i;
            for (int bit = 0; bit < 32; bit++) {
                if (lastSeen[bit] != -1) {
                    farthest = Math.max(farthest, lastSeen[bit]);
                }
            }

            result[i] = farthest - i + 1;
        }

        return result;
    }
}
