package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/cyclically-rotating-a-grid
 */

public class LC1914CyclicallyRotatingAGrid {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] result = rotateGrid(grid, 2);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();
            int rMax = m - 1 - layer;
            int cMax = n - 1 - layer;

            for (int j = layer; j < cMax; j++) elements.add(grid[layer][j]);
            for (int i = layer; i < rMax; i++) elements.add(grid[i][cMax]);
            for (int j = cMax; j > layer; j--) elements.add(grid[rMax][j]);
            for (int i = rMax; i > layer; i--) elements.add(grid[i][layer]);

            int L = elements.size();

            int index = k % L;
            for (int j = layer; j < cMax; j++) grid[layer][j] = elements.get(index++ % L);
            for (int i = layer; i < rMax; i++) grid[i][cMax] = elements.get(index++ % L);
            for (int j = cMax; j > layer; j--) grid[rMax][j] = elements.get(index++ % L);
            for (int i = rMax; i > layer; i--) grid[i][layer] = elements.get(index++ % L);
        }

        return grid;
    }
}
