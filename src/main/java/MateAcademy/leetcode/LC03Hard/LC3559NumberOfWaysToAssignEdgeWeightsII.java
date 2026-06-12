package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-ways-to-assign-edge-weights-ii
 */
public class LC3559NumberOfWaysToAssignEdgeWeightsII {
    private static List<List<Integer>> adj;
    private static int[][] up;
    private static int[] depth;
    private static int LOG;
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}};
        int[][] queries1 = {{1, 1}, {1, 2}};
        System.out.println(Arrays.toString(assignEdgeWeights(edges1, queries1))); // [0, 1]

        int[][] edges2 = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
        int[][] queries2 = {{1, 4}, {3, 4}, {2, 5}};
        System.out.println(Arrays.toString(assignEdgeWeights(edges2, queries2))); // [2, 1, 4]
    }

    public static int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        LOG = 31 - Integer.numberOfLeadingZeros(n) + 1;
        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        dfs(1, 1, 0);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            if (u == v) {
                answer[i] = 0;
                continue;
            }

            int lca = getLCA(u, v);
            int pathLength = depth[u] + depth[v] - 2 * depth[lca];

            answer[i] = pow2[pathLength - 1];
        }

        return answer;
    }

    private static void dfs(int node, int parent, int d) {
        depth[node] = d;
        up[node][0] = parent;
        for (int child : adj.get(node)) {
            if (child != parent) {
                dfs(child, node, d + 1);
            }
        }
    }

    private static int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];
        for (int j = LOG - 1; j >= 0; j--) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}