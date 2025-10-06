package MateAcademy.leetcode.LC03Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/swim-in-rising-water
 */

public class LC0778SwimInRisingWater {
    public static void main(String[] args) {
        int[][] grid1 = {{0, 2}, {1, 3}};
        int[][] grid2 = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };

        System.out.println(swimInWater(grid1)); // 3
        System.out.println(swimInWater(grid2)); // 16
    }

    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1], h = cur[2];

            if (i == n - 1 && j == n - 1) {
                return h;
            }

            if (visited[i][j]) continue;
            visited[i][j] = true;

            for (int[] d : dirs) {
                int ni = i + d[0];
                int nj = j + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < n && !visited[ni][nj]) {
                    pq.offer(new int[]{ni, nj, Math.max(h, grid[ni][nj])});
                }
            }
        }

        return -1;
    }
}
