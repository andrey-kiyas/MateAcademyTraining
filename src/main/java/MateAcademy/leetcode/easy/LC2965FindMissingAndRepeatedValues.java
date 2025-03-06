package MateAcademy.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-missing-and-repeated-values
 */

public class LC2965FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));                  // [2,4]
        System.out.println(Arrays.toString(
                findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}}))); // [9,5]
    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nSquared = n * n;
        Set<Integer> seen = new HashSet<>();
        int repeated = -1;

        for (int[] row : grid) {
            for (int value : row) {
                if (!seen.add(value)) {
                    repeated = value;
                }
            }
        }

        int missing = -1;
        for (int i = 1; i <= nSquared; i++) {
            if (!seen.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{repeated, missing};
    }
}
