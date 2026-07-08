package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-covered-intervals
 */

public class LC1288RemoveCoveredIntervals {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(removeCoveredIntervals(intervals1)); // 2

        int[][] intervals2 = {{1, 4}, {2, 3}};
        System.out.println(removeCoveredIntervals(intervals2)); // 1
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int remainingCount = 0;
        int maxRight = 0;

        for (int[] interval : intervals) {
            int currentRight = interval[1];

            if (currentRight > maxRight) {
                remainingCount++;
                maxRight = currentRight;
            }
        }

        return remainingCount;
    }
}
