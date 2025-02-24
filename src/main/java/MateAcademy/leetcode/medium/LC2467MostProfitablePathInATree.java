package MateAcademy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/most-profitable-path-in-a-tree
 */

public class LC2467MostProfitablePathInATree {
    public static void main(String[] args) {
        System.out.println(mostProfitablePath(
                new int[][]{{1, 0}, {1, 2}, {1, 3}, {3, 4}},
                3,
                new int[]{-2, 4, 2, -4, 6}));   // 6
        System.out.println(mostProfitablePath(
                new int[][]{{0, 1}},
                1,
                new int[]{-7280, 2350}));       // -7280
    }

    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] timeBob = new int[n];
        Arrays.fill(timeBob, Integer.MAX_VALUE);
        findBobPath(graph, bob, 0, 0, new boolean[n], timeBob, new ArrayList<>());

        return dfsAlice(graph, 0, 0, new boolean[n], timeBob, amount);
    }

    private static boolean findBobPath(List<Integer>[] graph, int node, int target, int time, boolean[] visited, int[] timeBob, List<Integer> path) {
        visited[node] = true;
        path.add(node);

        if (node == target) {
            for (int t = 0; t < path.size(); t++) {
                timeBob[path.get(t)] = t;
            }
            return true;
        }

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (findBobPath(graph, neighbor, target, time + 1, visited, timeBob, path)) return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private static int dfsAlice(List<Integer>[] graph, int node, int timeAlice, boolean[] visited, int[] timeBob, int[] amount) {
        visited[node] = true;

        int income = 0;
        if (timeAlice < timeBob[node]) {
            income += amount[node];
        } else if (timeAlice == timeBob[node]) {
            income += amount[node] / 2;
        }

        int maxChildProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                isLeaf = false;
                maxChildProfit = Math.max(maxChildProfit, dfsAlice(graph, neighbor, timeAlice + 1, visited, timeBob, amount));
            }
        }

        visited[node] = false;

        return income + (isLeaf ? 0 : maxChildProfit);
    }
}
