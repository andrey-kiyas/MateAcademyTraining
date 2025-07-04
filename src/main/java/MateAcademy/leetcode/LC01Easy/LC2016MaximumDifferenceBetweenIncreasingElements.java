package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/maximum-difference-between-increasing-elements
 */

public class LC2016MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{7, 1, 5, 4}));    // 4
        System.out.println(maximumDifference(new int[]{9, 4, 3, 2}));    // -1
        System.out.println(maximumDifference(new int[]{1, 5, 2, 10}));   // 9
    }

    public static int maximumDifference(int[] nums) {
        int minSoFar = nums[0];
        int maxDiff = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minSoFar) {
                maxDiff = Math.max(maxDiff, nums[i] - minSoFar);
            } else {
                minSoFar = nums[i];
            }
        }

        return maxDiff;
    }
}
