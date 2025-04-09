package MateAcademy.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k
 */

public class LC3375MinimumOperationsToMakeArrayValuesEqualToK {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{5, 2, 5, 4, 5}, 2)); // 2
        System.out.println(minOperations(new int[]{2, 1, 2}, 2));       // -1
        System.out.println(minOperations(new int[]{9, 7, 5, 3}, 1));    // 4
    }

    public static int minOperations(int[] nums, int k) {
        Set<Integer> greaterThanK = new HashSet<>();

        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (num > k) {
                greaterThanK.add(num);
            }
        }

        return greaterThanK.size();
    }
}
