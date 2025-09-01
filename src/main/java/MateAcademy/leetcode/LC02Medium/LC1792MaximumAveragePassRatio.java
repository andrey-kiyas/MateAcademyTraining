package MateAcademy.leetcode.LC02Medium;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-average-pass-ratio
 */

public class LC1792MaximumAveragePassRatio {
    public static void main(String[] args) {
        int[][] classes1 = {{1,2},{3,5},{2,2}};
        int extra1 = 2;
        System.out.println(maxAverageRatio(classes1, extra1)); // 0.78333

        int[][] classes2 = {{2,4},{3,9},{4,5},{2,10}};
        int extra2 = 4;
        System.out.println(maxAverageRatio(classes2, extra2)); // 0.53485
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = gain(a[0], a[1]);
            double gainB = gain(b[0], b[1]);
            return Double.compare(gainB, gainA);
        });

        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }

        while (extraStudents-- > 0) {
            int[] cur = pq.poll();
            assert cur != null;
            cur[0]++;
            cur[1]++;
            pq.offer(cur);
        }

        double sum = 0.0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            sum += (double) c[0] / c[1];
        }

        return sum / classes.length;
    }

    private static double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double)pass / total;
    }
}
