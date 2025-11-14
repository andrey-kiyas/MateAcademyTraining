package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/increment-submatrices-by-one
 */

public class LC2536IncrementSubmatricesByOne {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                rangeAddQueries(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}})
        ));
        System.out.println(Arrays.deepToString(
                rangeAddQueries(2, new int[][]{{0, 0, 1, 1}})
        ));
    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            diff[r1][c1] += 1;
            if (c2 + 1 < n) diff[r1][c2 + 1] -= 1;
            if (r2 + 1 < n) diff[r2 + 1][c1] -= 1;
            if (r2 + 1 < n && c2 + 1 < n) diff[r2 + 1][c2 + 1] += 1;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 1; c < n; c++) {
                diff[r][c] += diff[r][c - 1];
            }
        }

        for (int c = 0; c < n; c++) {
            for (int r = 1; r < n; r++) {
                diff[r][c] += diff[r - 1][c];
            }
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(diff[i], 0, result[i], 0, n);
        }

        return result;
    }
}
