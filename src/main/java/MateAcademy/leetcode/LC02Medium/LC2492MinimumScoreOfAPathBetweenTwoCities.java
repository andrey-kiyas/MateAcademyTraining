package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities
 */

public class LC2492MinimumScoreOfAPathBetweenTwoCities {
    public static void main(String[] args) {
        int[][] roads1 = {{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}};
        System.out.println(minScore(4, roads1)); // 5

        int[][] roads2 = {{1, 2, 2}, {1, 3, 4}, {3, 4, 7}};
        System.out.println(minScore(4, roads2)); // 2
    }

    public static int minScore(int n, int[][] roads) {
        List<List<Road>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int dist = road[2];
            adj.get(u).add(new Road(v, dist));
            adj.get(v).add(new Road(u, dist));
        }

        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (Road road : adj.get(curr)) {
                minScore = Math.min(minScore, road.distance);

                if (!visited[road.to]) {
                    visited[road.to] = true;
                    queue.offer(road.to);
                }
            }
        }

        return minScore;
    }

    private static class Road {
        int to;
        int distance;

        Road(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}
