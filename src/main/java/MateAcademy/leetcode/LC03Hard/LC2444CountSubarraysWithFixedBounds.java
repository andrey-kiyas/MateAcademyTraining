package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds
 */

public class LC2444CountSubarraysWithFixedBounds {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5)); // Output: 2
        System.out.println(countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));       // Output: 10
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int j = -1;
        int prevMinKIndex = -1;
        int prevMaxKIndex = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK)
                j = i;
            if (nums[i] == minK)
                prevMinKIndex = i;
            if (nums[i] == maxK)
                prevMaxKIndex = i;
            result += Math.max(0, Math.min(prevMinKIndex, prevMaxKIndex) - j);
        }

        return result;
    }
}
