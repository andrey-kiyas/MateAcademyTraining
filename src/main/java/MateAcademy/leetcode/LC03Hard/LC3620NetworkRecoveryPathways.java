package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/network-recovery-pathways
 */

public class LC3620NetworkRecoveryPathways {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1, 5}, {1, 3, 10}, {0, 2, 3}, {2, 3, 4}};
        boolean[] online1 = {true, true, true, true};
        System.out.println(findMaxPathScore(edges1, online1, 10)); // 3

        int[][] edges2 = {{0, 1, 7}, {1, 4, 5}, {0, 2, 6}, {2, 3, 6}, {3, 4, 2}, {2, 4, 6}};
        boolean[] online2 = {true, true, true, false, true};
        System.out.println(findMaxPathScore(edges2, online2, 12)); // 6
    }

    public static int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int maxCost = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (v != n - 1 && !online[v]) continue;
            if (u != 0 && !online[u]) continue;

            adj.get(u).add(new Edge(v, cost));
            maxCost = Math.max(maxCost, cost);
        }

        int low = 0, high = maxCost;
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (hasValidPath(n, adj, mid, k)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private static boolean hasValidPath(int n, List<List<Edge>> adj, int minEdgeCost, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (u == n - 1) {
                return d <= k;
            }

            if (d > dist[u]) continue;

            for (Edge edge : adj.get(u)) {
                if (edge.cost < minEdgeCost) continue;

                long nextDist = d + edge.cost;
                if (nextDist < dist[edge.to] && nextDist <= k) {
                    dist[edge.to] = nextDist;
                    pq.offer(new long[]{nextDist, edge.to});
                }
            }
        }

        return dist[n - 1] <= k;
    }

    private static class Edge {
        int to;
        int cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
