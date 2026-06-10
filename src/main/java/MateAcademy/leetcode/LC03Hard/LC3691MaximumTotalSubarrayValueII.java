package MateAcademy.leetcode.LC03Hard;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-total-subarray-value-ii
 */

public class LC3691MaximumTotalSubarrayValueII {
    private static int[][] stMax;
    private static int[][] stMin;
    private static int[] logTable;

    public static void main(String[] args) {
        System.out.println(maxTotalValue(new int[]{1, 3, 2}, 2));    // 4
        System.out.println(maxTotalValue(new int[]{4, 2, 5, 1}, 3)); // 12
    }

    public static long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        initSparseTable(nums, n);

        PriorityQueue<Subarray> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.value, a.value));
        Set<Long> visited = new HashSet<>();

        Subarray start = new Subarray(0, n - 1, getValue(0, n - 1));
        maxHeap.add(start);
        visited.add(((long) 0 << 32) | (n - 1));

        long totalValue = 0;

        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            Subarray curr = maxHeap.poll();
            totalValue += curr.value;

            if (curr.l < curr.r) {
                long codeA = ((long) (curr.l + 1) << 32) | curr.r;
                if (!visited.contains(codeA)) {
                    visited.add(codeA);
                    maxHeap.add(new Subarray(curr.l + 1, curr.r, getValue(curr.l + 1, curr.r)));
                }

                long codeB = ((long) curr.l << 32) | (curr.r - 1);
                if (!visited.contains(codeB)) {
                    visited.add(codeB);
                    maxHeap.add(new Subarray(curr.l, curr.r - 1, getValue(curr.l, curr.r - 1)));
                }
            }
        }

        return totalValue;
    }

    private static class Subarray {
        int l, r;
        long value;

        Subarray(int l, int r, long value) {
            this.l = l;
            this.r = r;
            this.value = value;
        }
    }

    private static void initSparseTable(int[] nums, int n) {
        int maxLog = 31 - Integer.numberOfLeadingZeros(n) + 1;
        stMax = new int[n][maxLog];
        stMin = new int[n][maxLog];
        logTable = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }

        for (int i = 0; i < n; i++) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }

        for (int j = 1; j < maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[i + (1 << (j - 1))][j - 1]);
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    private static long getValue(int l, int r) {
        int j = logTable[r - l + 1];
        int max = Math.max(stMax[l][j], stMax[r - (1 << j) + 1][j]);
        int min = Math.min(stMin[l][j], stMin[r - (1 << j) + 1][j]);
        return (long) max - min;
    }
}
