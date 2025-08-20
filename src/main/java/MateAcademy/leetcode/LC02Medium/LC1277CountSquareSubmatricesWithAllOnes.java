package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones
 */

public class LC1277CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] m1 = {
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        };
        int[][] m2 = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(countSquares(m1)); // 15
        System.out.println(countSquares(m2)); // 7
    }

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]
                        );
                    }
                    total += dp[i][j];
                }
            }
        }
        return total;
    }
}
