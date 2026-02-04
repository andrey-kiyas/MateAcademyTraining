package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/trionic-array-ii
 */

public class LC3640TrionicArrayII {
    public static void main(String[] args) {
        System.out.println(maxSumTrionic(new int[]{0, -2, -1, -3, 0, 2, -1})); // -4
        System.out.println(maxSumTrionic(new int[]{1, 4, 2, 7}));              // 14
    }

    public static long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long INF = (long) 4e18;

        long[] f = new long[n];
        Arrays.fill(f, -INF);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                f[i] = (long) nums[i] + nums[i - 1];
                if (i > 1 && f[i - 1] != -INF) {
                    f[i] = Math.max(f[i], nums[i] + f[i - 1]);
                }
            }
        }

        long[] g = new long[n];
        Arrays.fill(g, -INF);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                g[i] = (long) nums[i] + nums[i + 1];
                if (i < n - 2 && g[i + 1] != -INF) {
                    g[i] = Math.max(g[i], nums[i] + g[i + 1]);
                }
            }
        }

        long[] P = new long[n + 1];
        for (int i = 0; i < n; i++) {
            P[i + 1] = P[i] + nums[i];
        }

        long maxTotal = -INF;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && nums[j] > nums[j + 1]) {
                j++;
            }

            if (j > i) {
                long bestFminusP = -INF;
                for (int k = i; k <= j; k++) {
                    if (g[k] != -INF && bestFminusP != -INF) {
                        maxTotal = Math.max(maxTotal, bestFminusP + P[k] + g[k]);
                    }
                    if (f[k] != -INF) {
                        bestFminusP = Math.max(bestFminusP, f[k] - P[k + 1]);
                    }
                }
            }
            i = (j == i) ? i + 1 : j;
        }

        return maxTotal;
    }
}
