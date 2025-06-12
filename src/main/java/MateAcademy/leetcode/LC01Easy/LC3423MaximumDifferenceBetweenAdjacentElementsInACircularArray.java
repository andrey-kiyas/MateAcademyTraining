package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/maximum-difference-between-adjacent-elements-in-a-circular-array
 */

public class LC3423MaximumDifferenceBetweenAdjacentElementsInACircularArray {
    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{1, 2, 4}));     // Output: 3
        System.out.println(maxAdjacentDistance(new int[]{-5, -10, -5})); // Output: 5
    }

    public static int maxAdjacentDistance(int[] nums) {
        int maxDiff = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int nextIndex = (i + 1) % n;
            int diff = Math.abs(nums[i] - nums[nextIndex]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}
