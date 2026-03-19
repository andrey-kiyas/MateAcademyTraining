package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y
 */

public class LC3212CountSubmatricesWithEqualFrequencyOfXAndY {
    public static void main(String[] args) {
        char[][] grid1 = {{'X', 'Y', '.'}, {'Y', '.', '.'}};
        System.out.println(numberOfSubmatrices(grid1)); // 3

        char[][] grid2 = {{'X', 'X'}, {'X', 'Y'}};
        System.out.println(numberOfSubmatrices(grid2)); // 0

        char[][] grid3 = {{'.', '.'}, {'.', '.'}};
        System.out.println(numberOfSubmatrices(grid3)); // 0
    }

    public static int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] diff = new int[m][n];
        int[][] countX = new int[m][n];

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentDiff = (grid[i][j] == 'X') ? 1 : (grid[i][j] == 'Y' ? -1 : 0);
                int currentX = (grid[i][j] == 'X') ? 1 : 0;

                int topDiff = (i > 0) ? diff[i - 1][j] : 0;
                int leftDiff = (j > 0) ? diff[i][j - 1] : 0;
                int topLeftDiff = (i > 0 && j > 0) ? diff[i - 1][j - 1] : 0;

                int topX = (i > 0) ? countX[i - 1][j] : 0;
                int leftX = (j > 0) ? countX[i][j - 1] : 0;
                int topLeftX = (i > 0 && j > 0) ? countX[i - 1][j - 1] : 0;

                diff[i][j] = currentDiff + topDiff + leftDiff - topLeftDiff;
                countX[i][j] = currentX + topX + leftX - topLeftX;

                if (diff[i][j] == 0 && countX[i][j] > 0) {
                    result++;
                }
            }
        }

        return result;
    }
}
