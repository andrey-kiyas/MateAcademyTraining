package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/left-and-right-sum-differences
 */

public class LC2574LeftAndRightSumDifferences {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRightDifference(new int[]{10, 4, 8, 3}))); // [15, 1, 11, 22]
        System.out.println(Arrays.toString(leftRightDifference(new int[]{1})));           // [0]
    }

    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int rightSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];

            answer[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return answer;
    }
}
