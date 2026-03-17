package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-submatrix-with-rearrangements
 */

public class LC1727LargestSubmatrixWithRearrangements {
    public static void main(String[] args) {
        int[][] mat1 = {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};
        System.out.println(largestSubmatrix(mat1)); // 4

        int[][] mat2 = {{1, 0, 1, 0, 1}};
        System.out.println(largestSubmatrix(mat2)); // 3

        int[][] mat3 = {{1, 1, 0}, {1, 0, 1}};
        System.out.println(largestSubmatrix(mat3)); // 2
    }

    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        for (int[] ints : matrix) {
            int[] currentRow = ints.clone();
            Arrays.sort(currentRow);

            for (int k = 1; k <= n; k++) {
                int height = currentRow[n - k];
                maxArea = Math.max(maxArea, height * k);
            }
        }

        return maxArea;
    }
}
