package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades
 */

public class LC3600MaximizeSpanningTreeStabilityWithUpgrades {
    public static void main(String[] args) {
        System.out.println(maxStability(3, new int[][]{{0, 1, 2, 1}, {1, 2, 3, 0}}, 1));               // 2
        System.out.println(maxStability(3, new int[][]{{0, 1, 4, 0}, {1, 2, 3, 0}, {0, 2, 1, 0}}, 2)); // 6
        System.out.println(maxStability(3, new int[][]{{0, 1, 1, 1}, {1, 2, 1, 1}, {2, 0, 1, 1}}, 2)); // 0
    }

    public static int maxStability(int n, int[][] edges, int k) {
        int low = 1, high = 200000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean isValid(int n, int[][] edges, int k, int threshold) {
        DSU dsu = new DSU(n);
        int edgesInTree = 0;

        for (int[] e : edges) {
            if (e[3] == 1) {
                if (e[2] < threshold) return false;
                if (!dsu.union(e[0], e[1])) return false;
                edgesInTree++;
            }
        }

        for (int[] e : edges) {
            if (e[3] == 0 && e[2] >= threshold) {
                if (dsu.union(e[0], e[1])) edgesInTree++;
            }
        }

        int upgradesUsed = 0;
        for (int[] e : edges) {
            if (e[3] == 0 && e[2] < threshold && e[2] * 2 >= threshold) {
                if (upgradesUsed < k && dsu.union(e[0], e[1])) {
                    edgesInTree++;
                    upgradesUsed++;
                }
            }
        }

        return edgesInTree == n - 1;
    }

    static class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }
        boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }
}