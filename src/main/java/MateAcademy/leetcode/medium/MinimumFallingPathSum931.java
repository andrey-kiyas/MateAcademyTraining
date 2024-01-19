package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum
 */

public class MinimumFallingPathSum931 {

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}})); // Output: 13
        System.out.println(minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));            // Output: -59
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int minPrev = matrix[row - 1][col];
                if (col > 0) {
                    minPrev = Math.min(minPrev, matrix[row - 1][col - 1]);
                }
                if (col < n - 1) {
                    minPrev = Math.min(minPrev, matrix[row - 1][col + 1]);
                }

                matrix[row][col] += minPrev;
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, matrix[n - 1][col]);
        }
        return minSum;
    }
}
