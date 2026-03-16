package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid
 */

public class LC1878GetBiggestThreeRhombusSumsInAGrid {
    public static void main(String[] args) {
        int[][] grid1 = {
                {3, 4, 5, 1, 3},
                {3, 3, 4, 2, 3},
                {20, 30, 200, 40, 10},
                {1, 5, 5, 4, 1},
                {4, 3, 2, 2, 5}
        };
        System.out.println(Arrays.toString(getBiggestThree(grid1))); // [228, 216, 211]

        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(getBiggestThree(grid2))); // [20, 9, 8]

        int[][] grid3 = {
                {7, 7, 7}
        };
        System.out.println(Arrays.toString(getBiggestThree(grid3))); // [7]
    }

    public static int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> sums = new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                sums.add(grid[r][c]);
                if (sums.size() > 3) sums.pollLast();

                for (int L = 1; r - L >= 0 && r + L < m && c - L >= 0 && c + L < n; L++) {
                    int currentSum = 0;
                    for (int i = 0; i < L; i++) {
                        currentSum += grid[r - L + i][c + i];
                        currentSum += grid[r + i][c + L - i];
                        currentSum += grid[r + L - i][c - i];
                        currentSum += grid[r - i][c - L + i];
                    }
                    sums.add(currentSum);

                    if (sums.size() > 3) {
                        sums.pollLast();
                    }
                }
            }
        }

        int[] result = new int[sums.size()];
        int i = 0;
        for (int s : sums) {
            result[i++] = s;
        }
        return result;
    }
}
