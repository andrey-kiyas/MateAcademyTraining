package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description
 */

public class LC3373MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {
    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2))); // [8,7,7,8,8]

        int[][] e1 = {{0,1},{0,2},{0,3},{0,4}};
        int[][] e2 = {{0,1},{1,2},{2,3}};
        System.out.println(Arrays.toString(maxTargetNodes(e1, e2)));         // [3,6,6,6,6]
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildGraph(n, edges1);
        List<List<Integer>> tree2 = buildGraph(m, edges2);

        int[] depth1 = new int[n];
        int[] depth2 = new int[m];

        dfs(tree1, 0, -1, 0, depth1);
        dfs(tree2, 0, -1, 0, depth2);

        int even2 = 0, odd2 = 0;
        for (int d : depth2) {
            if (d % 2 == 0) even2++;
            else odd2++;
        }

        int even1 = 0, odd1 = 0;
        for (int d : depth1) {
            if (d % 2 == 0) even1++;
            else odd1++;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int localTargets = (depth1[i] % 2 == 0) ? even1 : odd1;
            int externalTargets = Math.max(even2, odd2);
            answer[i] = localTargets + externalTargets;
        }

        return answer;
    }

    private static void dfs(List<List<Integer>> graph, int node, int parent, int depth, int[] depthArray) {
        depthArray[node] = depth;
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                dfs(graph, neighbor, node, depth + 1, depthArray);
            }
        }
    }

    private static List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
