package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/largest-color-value-in-a-directed-graph
 */

public class LC1857LargestColorValueInADirectedGraph {
    public static void main(String[] args) {
        System.out.println(largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}})); // 3
        System.out.println(largestPathValue("a", new int[][]{{0, 0}}));                             // -1
    }

    public static int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] colorCount = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int visited = 0, maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIndex = colors.charAt(node) - 'a';
            colorCount[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, colorCount[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], colorCount[node][c]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return visited == n ? maxColorValue : -1;
    }
}
