package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-i
 */

public class LC3558NumberOfWaysToAssignEdgeWeightsI {
    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}};
        System.out.println(assignEdgeWeights(edges1)); // 1

        int[][] edges2 = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
        System.out.println(assignEdgeWeights(edges2)); // 2
    }

    public static int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int maxEdges = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int u = curr[0];
            int dist = curr[1];

            maxEdges = Math.max(maxEdges, dist);

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(new int[]{v, dist + 1});
                }
            }
        }

        return powerOfTwo(maxEdges - 1);
    }

    private static int powerOfTwo(int exp) {
        if (exp < 0) return 0;
        long res = 1;
        long base = 2;
        long mod = 1_000_000_007;

        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return (int) res;
    }
}
