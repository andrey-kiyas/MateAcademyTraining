package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i
 */
public class LC3372MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};
        int k = 2;
        System.out.println(Arrays.toString(maxTargetNodes(edges1, edges2, k)));    // [9, 7, 9, 8, 8]

        int[][] e1 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}};
        int[][] e2 = {{0, 1}, {1, 2}, {2, 3}};
        k = 1;
        System.out.println(Arrays.toString(maxTargetNodes(e1, e2, k)));            // [6, 3, 3, 3, 3]
    }

    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> g2 = build(edges2);
        int m = edges2.length + 1;
        int t = 0;

        for (int i = 0; i < m; ++i) {
            t = Math.max(t, dfs(g2, i, -1, k - 1));
        }

        List<List<Integer>> g1 = build(edges1);
        int n = edges1.length + 1;
        int[] answer = new int[n];
        Arrays.fill(answer, t);

        for (int i = 0; i < n; ++i) {
            answer[i] += dfs(g1, i, -1, k);
        }

        return answer;
    }

    private static List<List<Integer>> build(int[][] edges) {
        int numOfNodes = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>(numOfNodes);
        for (int i = 0; i < numOfNodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return graph;
    }

    private static int dfs(List<List<Integer>> graph, int currentNode, int parentNode, int remainingMoves) {
        if (remainingMoves < 0) {
            return 0;
        }

        int count = 1;
        for (int adjacentNode : graph.get(currentNode)) {
            if (adjacentNode != parentNode) {
                count += dfs(graph, adjacentNode, currentNode, remainingMoves - 1);
            }
        }

        return count;
    }
}
