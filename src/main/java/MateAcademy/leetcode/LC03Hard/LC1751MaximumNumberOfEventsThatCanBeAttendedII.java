package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii
 */

public class LC1751MaximumNumberOfEventsThatCanBeAttendedII {
    private static int[][] events;
    private static int[][] f;
    private static int n;

    public static void main(String[] args) {
        int[][] events1 = {{1, 2, 4}, {3, 4, 3}, {2, 3, 1}};
        int[][] events2 = {{1, 2, 4}, {3, 4, 3}, {2, 3, 10}};
        int[][] events3 = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};

        System.out.println(maxValue(events1, 2)); // Output: 7
        System.out.println(maxValue(events2, 2)); // Output: 10
        System.out.println(maxValue(events3, 3)); // Output: 9
    }

    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        LC1751MaximumNumberOfEventsThatCanBeAttendedII.events = events;
        n = events.length;
        f = new int[n][k + 1];
        return dfs(0, k);
    }

    private static int dfs(int i, int k) {
        if (i >= n || k <= 0) {
            return 0;
        }
        if (f[i][k] != 0) {
            return f[i][k];
        }
        int j = search(events, events[i][1], i + 1);
        int ans = Math.max(dfs(i + 1, k), dfs(j, k - 1) + events[i][2]);
        return f[i][k] = ans;
    }

    private static int search(int[][] events, int x, int lo) {
        int l = lo, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (events[mid][0] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
