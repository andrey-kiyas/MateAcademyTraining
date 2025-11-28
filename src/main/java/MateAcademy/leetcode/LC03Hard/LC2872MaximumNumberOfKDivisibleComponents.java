package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-number-of-k-divisible-components
 */

public class LC2872MaximumNumberOfKDivisibleComponents {
    public static void main(String[] args) {
        System.out.println(maxKDivisibleComponents(
                5,
                new int[][]{{0, 2}, {1, 2}, {1, 3}, {2, 4}},
                new int[]{1, 8, 1, 4, 4},
                6
        )); // 2

        System.out.println(maxKDivisibleComponents(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}},
                new int[]{3, 0, 6, 1, 5, 2, 1},
                3
        )); // 3
    }

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int[] ans = new int[1];

        dfs(0, g, values, k, visited, ans);

        return ans[0];
    }

    private static long dfs(int u, List<List<Integer>> g, int[] values, int k, boolean[] visited, int[] ans) {
        visited[u] = true;

        long sum = values[u];

        for (int v : g.get(u)) {
            if (!visited[v]) {
                long child = dfs(v, g, values, k, visited, ans);
                sum += child;
            }
        }

        if (sum % k == 0) {
            ans[0]++;
            return 0;
        }

        return sum % k;
    }
}
