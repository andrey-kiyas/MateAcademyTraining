package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix
 */

public class LC1582SpecialPositionsInABinaryMatrix {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(numSpecial(mat1)); // 1

        int[][] mat2 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        System.out.println(numSpecial(mat2)); // 3
    }

    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int specialCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    specialCount++;
                }
            }
        }

        return specialCount;
    }
}
