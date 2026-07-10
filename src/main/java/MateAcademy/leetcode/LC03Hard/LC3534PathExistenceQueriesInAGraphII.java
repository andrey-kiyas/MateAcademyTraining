package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/path-existence-queries-in-a-graph-ii
 */

public class LC3534PathExistenceQueriesInAGraphII {
    public static void main(String[] args) {
        int[] nums1 = {1, 8, 3, 4, 2};
        int[][] q1 = {{0, 3}, {2, 4}};
        System.out.println(Arrays.toString(pathExistenceQueries(5, nums1, 3, q1)));
        // [1, 1]

        int[] nums2 = {5, 3, 1, 9, 10};
        int[][] q2 = {{0, 1}, {0, 2}, {2, 3}, {4, 3}};
        System.out.println(Arrays.toString(pathExistenceQueries(5, nums2, 2, q2)));
        // [1, 2, -1, 1]

        int[] nums3 = {3, 6, 1};
        int[][] q3 = {{0, 0}, {0, 1}, {1, 2}};
        System.out.println(Arrays.toString(pathExistenceQueries(3, nums3, 1, q3)));
        // [0, -1, -1]
    }

    public static int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        int m = 20;
        int[][] f = new int[n][m];
        int r = n - 1;
        for (int l = n - 1; l >= 0; l--) {
            while (pairs[r][0] - pairs[l][0] > maxDiff) {
                r--;
            }
            int i = pairs[l][1], j = pairs[r][1];
            f[i][0] = j;
            for (int k = 1; k < m; k++) {
                f[i][k] = f[f[i][k - 1]][k - 1];
            }
        }

        int[] ans = new int[queries.length];
        for (int t = 0; t < queries.length; t++) {
            int i = queries[t][0], j = queries[t][1];
            if (nums[i] > nums[j]) {
                int tmp = i;
                i = j;
                j = tmp;
            }
            if (i == j) {
                ans[t] = 0;
                continue;
            }
            if (nums[i] == nums[j]) {
                ans[t] = 1;
                continue;
            }
            int d = 0;
            for (int k = m - 1; k >= 0; k--) {
                if (nums[f[i][k]] < nums[j]) {
                    d |= 1 << k;
                    i = f[i][k];
                }
            }
            if (nums[f[i][0]] < nums[j]) {
                ans[t] = -1;
            } else {
                ans[t] = d + 1;
            }
        }
        return ans;
    }
}
