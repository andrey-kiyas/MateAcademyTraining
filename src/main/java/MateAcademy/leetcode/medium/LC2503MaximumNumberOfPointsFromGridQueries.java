package MateAcademy.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-number-of-points-from-grid-queries
 */

public class LC2503MaximumNumberOfPointsFromGridQueries {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxPoints(
                new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, new int[]{5, 6, 2}))); // [5,8,1]
        System.out.println(Arrays.toString(maxPoints(
                new int[][]{{5, 2, 1}, {1, 1, 2}}, new int[]{3})));                  // [0]
    }

    public static int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[queries.length];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int points = 0;

        for (int[] query : sortedQueries) {
            int qValue = query[0];
            int qIndex = query[1];

            while (!pq.isEmpty() && pq.peek()[0] < qValue) {
                int[] cell = pq.poll();
                int value = cell[0], x = cell[1], y = cell[2];
                points++;

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        pq.offer(new int[]{grid[nx][ny], nx, ny});
                    }
                }
            }
            result[qIndex] = points;
        }

        return result;
    }
}
