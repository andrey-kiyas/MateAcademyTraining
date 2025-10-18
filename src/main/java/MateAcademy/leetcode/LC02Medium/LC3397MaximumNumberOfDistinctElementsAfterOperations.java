package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 *
 */

public class LC3397MaximumNumberOfDistinctElementsAfterOperations {
    public static void main(String[] args) {
        System.out.println(maxDistinctElements(new int[]{1, 2, 2, 3, 3, 4}, 2)); // 6
        System.out.println(maxDistinctElements(new int[]{4, 4, 4, 4}, 1));       // 3
        System.out.println(maxDistinctElements(new int[]{10, 10, 10}, 0));       // 1
    }

    public static int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int distinct = 0;
        long prev = Long.MIN_VALUE;

        for (int num : nums) {
            long left = (long) num - k;
            long right = (long) num + k;

            long cur = Math.max(prev + 1, left);

            if (cur <= right) {
                distinct++;
                prev = cur;
            }
        }
        return distinct;
    }
}
