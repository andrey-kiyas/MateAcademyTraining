package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii
 */

public class LC3342FindMinimumTimeToReachLastRoomII {
    public static void main(String[] args) {
        int[][] moveTime1 = {{0, 4}, {4, 4}};
        int[][] moveTime2 = {{0, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] moveTime3 = {{0, 1}, {1, 2}};

        System.out.println(minTimeToReach(moveTime1)); // 7
        System.out.println(minTimeToReach(moveTime2)); // 6
        System.out.println(minTimeToReach(moveTime3)); // 4
    }

    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (var row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});
        int[] dirs = {-1, 0, 1, 0, -1};
        while (true) {
            int[] p = pq.poll();
            assert p != null;
            int d = p[0], i = p[1], j = p[2];

            if (i == n - 1 && j == m - 1) {
                return d;
            }
            if (d > dist[i][j]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int t = Math.max(moveTime[x][y], dist[i][j]) + (i + j) % 2 + 1;
                    if (dist[x][y] > t) {
                        dist[x][y] = t;
                        pq.offer(new int[]{t, x, y});
                    }
                }
            }
        }
    }
}
