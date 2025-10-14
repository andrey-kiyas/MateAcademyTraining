package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-the-number-of-complete-components
 */

public class LC2685CountTheNumberOfCompleteComponents {
    public static void main(String[] args) {
        System.out.println(countCompleteComponents(6,
                new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}}));         // 3
        System.out.println(countCompleteComponents(6,
                new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}})); // 1
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        // 1. Построим граф (список смежности)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 2. Поиск всех компонент связности
        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(graph, visited, i, component);

                // 3. Проверим, является ли компонент связности полным графом
                if (isCompleteGraph(graph, component)) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }

    // DFS для поиска всех узлов в компоненте связности
    private static void dfs(List<List<Integer>> graph, boolean[] visited, int node, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor, component);
            }
        }
    }

    // Проверка, является ли компонент полным графом
    private static boolean isCompleteGraph(List<List<Integer>> graph, List<Integer> component) {
        int size = component.size();
        for (int node : component) {
            if (graph.get(node).size() != size - 1) { // У каждого узла должно быть size-1 ребер
                return false;
            }
        }
        return true;
    }
}
