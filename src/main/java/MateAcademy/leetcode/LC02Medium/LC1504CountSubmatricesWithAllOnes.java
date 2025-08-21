package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-submatrices-with-all-ones/description
 */

public class LC1504CountSubmatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] mat1 = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        int[][] mat2 = {
                {0,1,1,0},
                {0,1,1,1},
                {1,1,1,0}
        };
        System.out.println(numSubmat(mat1)); // 13
        System.out.println(numSubmat(mat2)); // 24
    }

    public static int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == 0) heights[i][j] = 0;
                else heights[i][j] = (i == 0 ? 1 : heights[i-1][j] + 1);
            }
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minHeight = heights[i][j];
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, heights[i][k]);
                    result += minHeight;
                }
            }
        }

        return result;
    }
}
