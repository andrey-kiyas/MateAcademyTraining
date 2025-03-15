package MateAcademy.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber-iv
 */

public class LC2560HouseRobberIV {
    public static void main(String[] args) {
        System.out.println(minCapability(new int[]{2, 3, 5, 9}, 2));    // 5
        System.out.println(minCapability(new int[]{2, 7, 9, 3, 1}, 2)); // 2
    }

    public static int minCapability(int[] nums, int k) {
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();

        while (left < right) {
            final int m = (left + right) / 2;
            if (numStolenHouses(nums, m) >= k)
                right = m;
            else
                left = m + 1;
        }

        return left;
    }

    private static int numStolenHouses(int[] nums, int capacity) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] <= capacity) {
                ++result;
                ++i;
            }
        return result;
    }
}
