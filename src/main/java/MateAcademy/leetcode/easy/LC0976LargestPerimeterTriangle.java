package MateAcademy.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle
 */

public class LC0976LargestPerimeterTriangle {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{2, 1, 2}));    // 5
        System.out.println(largestPerimeter(new int[]{1, 2, 1, 10})); // 0
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }
}
