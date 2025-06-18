package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/divide-array-into-arrays-with-max-difference
 */

public class LC2966DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
        System.out.println(Arrays.deepToString(divideArray(new int[]{2, 4, 2, 2, 5, 2}, 2)));
        System.out.println(Arrays.deepToString(divideArray(new int[]{4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11}, 14)));
    }

    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            if (c - a > k) {
                return new int[0][];
            }
            result.add(new int[]{a, b, c});
        }

        return result.toArray(new int[0][]);
    }
}
