package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/transformed-array
 */

public class LC3379TransformedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructTransformedArray(new int[]{3, -2, 1, 1}))); // Вивід: [1, 1, 1, 3]
        System.out.println(Arrays.toString(constructTransformedArray(new int[]{-1, 4, -1})));   // Вивід: [-1, -1, 4]
    }

    public static int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int targetIndex = ((i + nums[i]) % n + n) % n;
            result[i] = nums[targetIndex];
        }

        return result;
    }
}
