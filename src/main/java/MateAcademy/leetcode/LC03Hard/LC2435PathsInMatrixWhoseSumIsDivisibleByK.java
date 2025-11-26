package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k
 */

public class LC2435PathsInMatrixWhoseSumIsDivisibleByK {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(numberOfPaths(
                new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}}, 3));          // 2
        System.out.println(numberOfPaths(
                new int[][]{{0, 0}}, 5));                                   // 1
        System.out.println(numberOfPaths(
                new int[][]{{7, 3, 4, 9}, {2, 3, 6, 2}, {2, 3, 7, 0}}, 1)); // 10
    }

    public static int numberOfPaths(int[][] grid, int k) {
        Integer[][][] mem = new Integer[grid.length][grid[0].length][k];
        return numberOfPaths(grid, 0, 0, 0, k, mem);
    }

    private static int numberOfPaths(int[][] grid, int i, int j, int sum, int k, Integer[][][] mem) {
        if (i == grid.length || j == grid[0].length)
            return 0;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return (sum + grid[i][j]) % k == 0 ? 1 : 0;
        if (mem[i][j][sum] != null)
            return mem[i][j][sum];
        final int newSum = (sum + grid[i][j]) % k;
        return mem[i][j][sum] = (numberOfPaths(grid, i + 1, j, newSum, k, mem) +
                numberOfPaths(grid, i, j + 1, newSum, k, mem)) %
                MOD;
    }
}
