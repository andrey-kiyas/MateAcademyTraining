package MateAcademy.leetcode.LC03Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-balanced-subarray-ii
 */

public class LC3721LongestBalancedSubarrayII {
    private static int[] min, max, lazy;

    public static void main(String[] args) {
        System.out.println(longestBalanced(new int[]{2, 5, 4, 3}));    // 4
        System.out.println(longestBalanced(new int[]{3, 2, 2, 5, 4})); // 5
        System.out.println(longestBalanced(new int[]{1, 2, 3, 2}));    // 3
    }

    public static int longestBalanced(int[] nums) {
        int n = nums.length;
        min = new int[4 * n];
        max = new int[4 * n];
        lazy = new int[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        int maxLen = 0;

        for (int r = 0; r < n; r++) {
            int val = nums[r];
            int prevIdx = lastSeen.getOrDefault(val, -1);
            int delta = (val % 2 == 0) ? 1 : -1;

            update(1, 0, n - 1, prevIdx + 1, r, delta);

            int leftmostL = findLeftmostZero(1, 0, n - 1, 0, r);
            if (leftmostL != -1) {
                maxLen = Math.max(maxLen, r - leftmostL + 1);
            }

            lastSeen.put(val, r);
        }

        return maxLen;
    }

    private static void push(int v) {
        if (lazy[v] != 0) {
            lazy[2 * v] += lazy[v];
            min[2 * v] += lazy[v];
            max[2 * v] += lazy[v];
            lazy[2 * v + 1] += lazy[v];
            min[2 * v + 1] += lazy[v];
            max[2 * v + 1] += lazy[v];
            lazy[v] = 0;
        }
    }

    private static void update(int v, int tl, int tr, int l, int r, int add) {
        if (l > r) return;
        if (l == tl && r == tr) {
            lazy[v] += add;
            min[v] += add;
            max[v] += add;
        } else {
            push(v);
            int tm = (tl + tr) / 2;
            update(2 * v, tl, tm, l, Math.min(r, tm), add);
            update(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r, add);
            min[v] = Math.min(min[2 * v], min[2 * v + 1]);
            max[v] = Math.max(max[2 * v], max[2 * v + 1]);
        }
    }

    private static int findLeftmostZero(int v, int tl, int tr, int l, int r) {
        if (l > r || min[v] > 0 || max[v] < 0) return -1;
        if (tl == tr) return tl;

        push(v);
        int tm = (tl + tr) / 2;
        int res = findLeftmostZero(2 * v, tl, tm, l, Math.min(r, tm));
        if (res == -1) {
            res = findLeftmostZero(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r);
        }
        return res;
    }
}
