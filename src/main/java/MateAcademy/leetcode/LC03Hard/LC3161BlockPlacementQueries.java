package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/block-placement-queries
 */

public class LC3161BlockPlacementQueries {
    private static int[] tree;

    public static void main(String[] args) {
        int[][] queries1 = {{1, 2}, {2, 3, 3}, {2, 3, 1}, {2, 2, 2}};
        System.out.println(getResults(queries1)); // [false, true, true]

        int[][] queries2 = {{1, 7}, {2, 7, 6}, {1, 2}, {2, 7, 5}, {2, 7, 6}};
        System.out.println(getResults(queries2)); // [true, true, false]
    }

    public static List<Boolean> getResults(int[][] queries) {
        int maxCoord = 0;
        for (int[] q : queries) {
            maxCoord = Math.max(maxCoord, q[1]);
        }
        maxCoord += 1;

        tree = new int[4 * maxCoord];

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(maxCoord);

        update(1, 0, maxCoord, maxCoord, maxCoord);

        List<Boolean> results = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];

            if (type == 1) {
                int prev = obstacles.lower(x);
                int next = obstacles.higher(x);

                obstacles.add(x);

                update(1, 0, maxCoord, x, x - prev);
                update(1, 0, maxCoord, next, next - x);
            } else {
                int sz = q[2];

                int maxInterval = query(1, 0, maxCoord, 0, x);

                int prev = obstacles.floor(x);
                maxInterval = Math.max(maxInterval, x - prev);

                results.add(maxInterval >= sz);
            }
        }

        return results;
    }

    private static void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    private static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int leftMax = query(2 * node, start, mid, l, r);
        int rightMax = query(2 * node + 1, mid + 1, end, l, r);
        return Math.max(leftMax, rightMax);
    }
}
