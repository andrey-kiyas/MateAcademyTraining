package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-removals-to-balance-array
 */

public class LC3634MinimumRemovalsToBalanceArray {
    public static void main(String[] args) {
        System.out.println(minRemoval(new int[]{2, 1, 5}, 2));    // 1
        System.out.println(minRemoval(new int[]{1, 6, 2, 9}, 3)); // 2
        System.out.println(minRemoval(new int[]{4, 6}, 2));       // 0
    }

    public static int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return 0;

        Arrays.sort(nums);

        int maxLen = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && (long) nums[j] <= (long) k * nums[i]) {
                j++;
            }

            maxLen = Math.max(maxLen, j - i);
        }

        return n - maxLen;
    }
}
