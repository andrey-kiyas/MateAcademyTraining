package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph
 */

public class LC3108MinimumCostWalkInWeightedGraph {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minimumCost(5,
                new int[][]{{0, 1, 7}, {1, 3, 7}, {1, 2, 1}},
                new int[][]{{0, 3}, {3, 4}})));                           // [1,-1]
        System.out.println(Arrays.toString(minimumCost(3,
                new int[][]{{0, 2, 7}, {0, 1, 15}, {1, 2, 6}, {1, 2, 1}},
                new int[][]{{1, 2}})));                                   // [0]
    }

    public static int[] minimumCost(int n, int[][] edges, int[][] query) {
        int i;
        int[] parent = new int[n];
        int[] bitwise = new int[n];
        int[] size = new int[n];
        for (i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            bitwise[i] = -1;
        }
        int len = edges.length;
        for (i = 0; i < len; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            int weight = edges[i][2];
            int parent1 = findParent(node1, parent);
            int parent2 = findParent(node2, parent);
            if (parent1 == parent2) {
                bitwise[parent1] &= weight;
            } else {
                int bitwiseVal;
                boolean check1 = bitwise[parent1] == -1;
                boolean check2 = bitwise[parent2] == -1;
                if (check1 && check2) {
                    bitwiseVal = weight;
                } else if (check1) {
                    bitwiseVal = weight & bitwise[parent2];
                } else if (check2) {
                    bitwiseVal = weight & bitwise[parent1];
                } else {
                    bitwiseVal = weight & bitwise[parent1] & bitwise[parent2];
                }
                if (size[parent1] >= size[parent2]) {
                    parent[parent2] = parent1;
                    size[parent1] += size[parent2];
                    bitwise[parent1] = bitwiseVal;
                } else {
                    parent[parent1] = parent2;
                    size[parent2] += size[parent1];
                    bitwise[parent2] = bitwiseVal;
                }
            }
        }
        int queryLen = query.length;
        int[] result = new int[queryLen];
        for (i = 0; i < queryLen; i++) {
            int start = query[i][0];
            int end = query[i][1];
            int parentStart = findParent(start, parent);
            int parentEnd = findParent(end, parent);
            if (start == end) {
                result[i] = 0;
            } else if (parentStart == parentEnd) {
                result[i] = bitwise[parentStart];
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    private static int findParent(int node, int[] parent) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }
}
