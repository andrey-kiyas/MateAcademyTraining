package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-the-safest-path-in-a-grid
 */

public class LC2812FindTheSafestPathInAGrid {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        List<List<Integer>> grid1 = List.of(
                List.of(1, 0, 0),
                List.of(0, 0, 0),
                List.of(0, 0, 1)
        );
        System.out.println(maximumSafenessFactor(grid1)); // 0

        List<List<Integer>> grid2 = List.of(
                List.of(0, 0, 1),
                List.of(0, 0, 0),
                List.of(0, 0, 0)
        );
        System.out.println(maximumSafenessFactor(grid2)); // 2
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        // Крайові випадки: якщо старт або фініш містять злодіїв, коефіцієнт безпеки = 0
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] safeness = new int[n][n];
        for (int[] row : safeness) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.offer(new int[]{r, c});
                    safeness[r][c] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && safeness[nr][nc] == -1) {
                    safeness[nr][nc] = safeness[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        boolean[][] visited = new boolean[n][n];

        maxHeap.offer(new int[]{safeness[0][0], 0, 0});
        visited[0][0] = true;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            int safeDist = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == n - 1 && c == n - 1) {
                return safeDist;
            }

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    int nextSafe = Math.min(safeDist, safeness[nr][nc]);
                    maxHeap.offer(new int[]{nextSafe, nr, nc});
                }
            }
        }

        return 0;
    }
}
