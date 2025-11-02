package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid
 */

public class LC2257CountUnguardedCellsInTheGrid {
    public static void main(String[] args) {
        int m1 = 4, n1 = 6;
        int[][] guards1 = {{0,0},{1,1},{2,3}};
        int[][] walls1 = {{0,1},{2,2},{1,4}};
        System.out.println("Example 1: " + countUnguarded(m1, n1, guards1, walls1)); // 7

        int m2 = 3, n2 = 3;
        int[][] guards2 = {{1,1}};
        int[][] walls2 = {{0,1},{1,0},{2,1},{1,2}};
        System.out.println("Example 2: " + countUnguarded(m2, n2, guards2, walls2)); // 4
    }

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] w : walls) grid[w[0]][w[1]] = 1;  // wall
        for (int[] g : guards) grid[g[0]][g[1]] = 2; // guard

        for (int[] g : guards) {
            int r = g[0], c = g[1];

            for (int i = r - 1; i >= 0 && grid[i][c] != 1 && grid[i][c] != 2; i--) {
                if (grid[i][c] == 0) grid[i][c] = 3;
            }
            for (int i = r + 1; i < m && grid[i][c] != 1 && grid[i][c] != 2; i++) {
                if (grid[i][c] == 0) grid[i][c] = 3;
            }
            for (int j = c - 1; j >= 0 && grid[r][j] != 1 && grid[r][j] != 2; j--) {
                if (grid[r][j] == 0) grid[r][j] = 3;
            }
            for (int j = c + 1; j < n && grid[r][j] != 1 && grid[r][j] != 2; j++) {
                if (grid[r][j] == 0) grid[r][j] = 3;
            }
        }

        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) unguarded++;
            }
        }
        return unguarded;
    }
}
