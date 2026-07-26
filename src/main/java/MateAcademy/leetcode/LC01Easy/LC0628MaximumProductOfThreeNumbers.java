package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers
 */

public class LC0628MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{1, 2, 3}));        // 6
        System.out.println(maximumProduct(new int[]{1, 2, 3, 4}));     // 24
        System.out.println(maximumProduct(new int[]{-1, -2, -3}));     // -6
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        return Math.max(
                nums[n - 1] * nums[n - 2] * nums[n - 3],
                nums[0] * nums[1] * nums[n - 1]
        );
    }
}
