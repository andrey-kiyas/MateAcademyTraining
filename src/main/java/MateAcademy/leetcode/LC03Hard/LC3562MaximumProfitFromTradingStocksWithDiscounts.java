package MateAcademy.leetcode.LC03Hard;

import java.util.*;

public class LC3562MaximumProfitFromTradingStocksWithDiscounts {

    public static void main(String[] args) {
        System.out.println(maxProfit(
                2,
                new int[]{1, 2},
                new int[]{4, 3},
                new int[][]{{1, 2}},
                3
        )); // 5

        System.out.println(maxProfit(
                2,
                new int[]{3, 4},
                new int[]{5, 8},
                new int[][]{{1, 2}},
                4
        )); // 4

        System.out.println(maxProfit(
                3,
                new int[]{4, 6, 8},
                new int[]{7, 9, 11},
                new int[][]{{1, 2}, {1, 3}},
                10
        )); // 10

        System.out.println(maxProfit(
                3,
                new int[]{5, 2, 3},
                new int[]{8, 5, 6},
                new int[][]{{1, 2}, {2, 3}},
                7
        )); // 12
    }

    public static int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        @SuppressWarnings("unchecked")
        List<Integer>[] tree = (List<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] h : hierarchy) {
            tree[h[0] - 1].add(h[1] - 1);
        }

        int[][] res = dfs(0, tree, present, future, budget);

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, res[b][0]);
        }
        return ans;
    }

    private static int[][] dfs(int u, List<Integer>[] tree, int[] present, int[] future, int budget) {
        int[] knapBoughtU = new int[budget + 1];
        int[] knapNotBoughtU = new int[budget + 1];

        for (int v : tree[u]) {
            int[][] childRes = dfs(v, tree, present, future, budget);

            for (int b = budget; b >= 0; b--) {
                int maxB = knapBoughtU[b];
                int maxNB = knapNotBoughtU[b];
                for (int j = 0; j <= b; j++) {
                    maxB = Math.max(maxB, knapBoughtU[b - j] + childRes[j][1]);
                    maxNB = Math.max(maxNB, knapNotBoughtU[b - j] + childRes[j][0]);
                }
                knapBoughtU[b] = maxB;
                knapNotBoughtU[b] = maxNB;
            }
        }

        int[][] res = new int[budget + 1][2];
        int costFull = present[u];
        int costDisc = present[u] / 2;
        int profitFull = future[u] - costFull;
        int profitDisc = future[u] - costDisc;

        for (int b = 0; b <= budget; b++) {
            res[b][0] = knapNotBoughtU[b];
            if (b >= costFull) {
                res[b][0] = Math.max(res[b][0], knapBoughtU[b - costFull] + profitFull);
            }

            res[b][1] = knapNotBoughtU[b];
            if (b >= costDisc) {
                res[b][1] = Math.max(res[b][1], knapBoughtU[b - costDisc] + profitDisc);
            }
        }
        return res;
    }
}
