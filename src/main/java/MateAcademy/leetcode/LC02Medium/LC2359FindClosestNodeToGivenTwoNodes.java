package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-closest-node-to-given-two-nodes
 */

public class LC2359FindClosestNodeToGivenTwoNodes {
    public static void main(String[] args) {
        int[] edges1 = {2, 2, 3, -1};
        System.out.println(closestMeetingNode(edges1, 0, 1)); // 2

        int[] edges2 = {1, 2, -1};
        System.out.println(closestMeetingNode(edges2, 0, 2)); // 2
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        dfs(edges, node1, dist1);
        dfs(edges, node2, dist2);

        int minDist = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    answer = i;
                }
            }
        }

        return answer;
    }

    private static void dfs(int[] edges, int start, int[] dist) {
        int d = 0;
        while (start != -1 && dist[start] == -1) {
            dist[start] = d++;
            start = edges[start];
        }
    }
}
