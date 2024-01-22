package MateAcademy.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-mismatch
 */

public class SetMismatch645 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4}))); // [2, 3]
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));       // [1, 2]
        System.out.println(Arrays.toString(findErrorNums(new int[]{2, 2})));       // [2, 1]

        System.out.println(Arrays.toString(findErrorNums(null)));                  // [0, 0]
    }

    public static int[] findErrorNums(int[] nums) {
        if (nums == null) {
            return new int[]{0, 0};
        }
        int[] result = new int[2];
        int n = nums.length;
        int[] count = new int[n + 1];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == 2) {
                result[0] = i; // Duplicate number
            } else if (count[i] == 0) {
                result[1] = i; // Missing number
            }
        }
        return result;
    }
}
