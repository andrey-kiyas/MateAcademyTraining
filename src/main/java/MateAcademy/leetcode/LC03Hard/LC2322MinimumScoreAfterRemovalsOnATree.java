package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-score-after-removals-on-a-tree
 */

public class LC2322MinimumScoreAfterRemovalsOnATree {
    static List<Integer>[] graph;
    static int[] xorSubtree, inTime, outTime;
    static int time = 0;

    public static void main(String[] args) {
        int[] nums1 = {1, 5, 5, 4, 11};
        int[][] edges1 = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        System.out.println(minimumScore(nums1, edges1)); // 9

        int[] nums2 = {5, 5, 2, 4, 4, 2};
        int[][] edges2 = {{0, 1}, {1, 2}, {5, 2}, {4, 3}, {1, 3}};
        System.out.println(minimumScore(nums2, edges2)); // 0

        int[] nums3 = {29, 29, 23, 32, 17};
        int[][] edges3 = {{3, 1}, {2, 3}, {4, 1}, {0, 4}};
        System.out.println(minimumScore(nums3, edges3)); // 15
    }

    public static int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        graph = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        xorSubtree = new int[n];
        inTime = new int[n];
        outTime = new int[n];

        dfs(0, -1, nums);

        int totalXor = xorSubtree[0];
        int minScore = Integer.MAX_VALUE;

        List<int[]> edgeList = new ArrayList<>();
        for (int[] e : edges) {
            int parent = e[0], child = e[1];
            if (isAncestor(parent, child)) {
                edgeList.add(new int[]{parent, child});
            } else {
                edgeList.add(new int[]{child, parent});
            }
        }

        int m = edgeList.size();
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                int[] e1 = edgeList.get(i);
                int[] e2 = edgeList.get(j);
                int u1 = e1[1], u2 = e2[1];

                int xor1 = xorSubtree[u1];
                int xor2 = xorSubtree[u2];
                int xor3;

                if (isAncestor(u1, u2)) {
                    xor2 = xorSubtree[u2];
                    xor1 = xorSubtree[u1] ^ xor2;
                    xor3 = totalXor ^ xorSubtree[u1];
                } else if (isAncestor(u2, u1)) {
                    xor1 = xorSubtree[u1];
                    xor2 = xorSubtree[u2] ^ xor1;
                    xor3 = totalXor ^ xorSubtree[u2];
                } else {
                    xor3 = totalXor ^ xor1 ^ xor2;
                }

                int maxVal = Math.max(xor1, Math.max(xor2, xor3));
                int minVal = Math.min(xor1, Math.min(xor2, xor3));
                minScore = Math.min(minScore, maxVal - minVal);
            }
        }

        return minScore;
    }

    private static void dfs(int u, int parent, int[] nums) {
        inTime[u] = time++;
        xorSubtree[u] = nums[u];
        for (int v : graph[u]) {
            if (v != parent) {
                dfs(v, u, nums);
                xorSubtree[u] ^= xorSubtree[v];
            }
        }
        outTime[u] = time++;
    }

    private static boolean isAncestor(int u, int v) {
        return inTime[u] <= inTime[v] && outTime[v] <= outTime[u];
    }
}
