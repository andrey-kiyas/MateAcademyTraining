package MateAcademy.leetcode.LC02Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid
 */

public class LC1391CheckIfThereIsAValidPathInAGrid {
    private static final int[][][] DIRECTIONS = {
            {},
            {{0, -1}, {0, 1}},  // 1: вліво, вправо
            {{-1, 0}, {1, 0}},  // 2: вгору, вниз
            {{0, -1}, {1, 0}},  // 3: вліво, вниз
            {{0, 1}, {1, 0}},   // 4: вправо, вниз
            {{0, -1}, {-1, 0}}, // 5: вліво, вгору
            {{0, 1}, {-1, 0}}   // 6: вправо, вгору
    };

    public static void main(String[] args) {
        int[][] g1 = {{2, 4, 3}, {6, 5, 2}};
        System.out.println(hasValidPath(g1)); // true

        int[][] g2 = {{1, 2, 1}, {1, 2, 1}};
        System.out.println(hasValidPath(g2)); // false

        int[][] g3 = {{1, 1, 2}};
        System.out.println(hasValidPath(g3)); // false
    }

    public static boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1) return true;

            int streetType = grid[r][c];
            for (int[] dir : DIRECTIONS[streetType]) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if (canConnect(nr, nc, r, c, grid)) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }

    private static boolean canConnect(int nr, int nc, int r, int c, int[][] grid) {
        int nextStreetType = grid[nr][nc];
        for (int[] dir : DIRECTIONS[nextStreetType]) {
            if (nr + dir[0] == r && nc + dir[1] == c) {
                return true;
            }
        }
        return false;
    }
}
