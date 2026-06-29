package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging
 */

public class Lc1846MaximumElementAfterDecreasingAndRearranging {
    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1})); // 2
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));  // 3
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5})); // 5
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        return arr[arr.length - 1];
    }
}
