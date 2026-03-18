package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-submatrices-with-top-left-element-and-sum-less-than-k
 */

public class LC3070CountSubmatricesWithTopLeftElementAndSumLessThanK {
    public static void main(String[] args) {
        int[][] grid1 = {{7, 6, 3}, {6, 6, 1}};
        System.out.println(countSubmatrices(grid1, 18)); // 4

        int[][] grid2 = {{7, 2, 9}, {1, 5, 0}, {2, 6, 6}};
        System.out.println(countSubmatrices(grid2, 20)); // 6
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        long[][] prefixSum = new long[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long current = grid[i][j];

                long top = (i > 0) ? prefixSum[i - 1][j] : 0;
                long left = (j > 0) ? prefixSum[i][j - 1] : 0;
                long topLeft = (i > 0 && j > 0) ? prefixSum[i - 1][j - 1] : 0;

                prefixSum[i][j] = current + top + left - topLeft;

                if (prefixSum[i][j] <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
