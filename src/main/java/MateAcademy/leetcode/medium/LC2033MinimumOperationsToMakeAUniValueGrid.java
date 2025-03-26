package MateAcademy.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid
 */

public class LC2033MinimumOperationsToMakeAUniValueGrid {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[][]{{2, 4}, {6, 8}}, 2));  // 4
        System.out.println(minOperations(new int[][]{{1, 5}, {2, 3}}, 1));  // 5
        System.out.println(minOperations(new int[][]{{1, 2}, {3, 4}}, 2));  // -1
    }

    public static int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;

        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

        int remainder = arr[0] % x;
        for (int num : arr) {
            if (num % x != remainder) {
                return -1;
            }
        }

        Arrays.sort(arr);
        int median = arr[arr.length / 2];

        int operations = 0;
        for (int num : arr) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
