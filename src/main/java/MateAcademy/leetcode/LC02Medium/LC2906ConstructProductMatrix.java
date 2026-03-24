package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/construct-product-matrix
 */

public class LC2906ConstructProductMatrix {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(constructProductMatrix(grid1)));
        // [[24, 12], [8, 6]]

        int[][] grid2 = {{12345}, {2}, {1}};
        System.out.println(Arrays.deepToString(constructProductMatrix(grid2)));
        // [[2], [0], [0]]
    }

    public static int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] p = new int[n][m];
        int MOD = 12345;

        long runningProduct = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) runningProduct;
                runningProduct = (runningProduct * (grid[i][j] % MOD)) % MOD;
            }
        }

        runningProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) ((p[i][j] * runningProduct) % MOD);
                runningProduct = (runningProduct * (grid[i][j] % MOD)) % MOD;
            }
        }

        return p;
    }
}
