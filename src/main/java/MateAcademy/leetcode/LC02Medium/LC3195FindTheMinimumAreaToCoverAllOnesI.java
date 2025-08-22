package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i
 */

public class LC3195FindTheMinimumAreaToCoverAllOnesI {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 1, 0}, {1, 0, 1}};
        int[][] grid2 = {{1, 0}, {0, 0}};
        System.out.println(minimumArea(grid1)); // 6
        System.out.println(minimumArea(grid2)); // 1
    }

    public static int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int minRow = m, maxRow = -1;
        int minCol = n, maxCol = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}
