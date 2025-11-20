package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/set-intersection-size-at-least-two
 */

public class LC0757SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        System.out.println(intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {8, 9}}));         // 5
        System.out.println(intersectionSizeTwo(new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}})); // 3
        System.out.println(intersectionSizeTwo(new int[][]{{1, 2}, {2, 3}, {2, 4}, {4, 5}})); // 5
    }

    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        int a = -1, b = -1;
        int result = 0;

        for (int[] it : intervals) {
            int start = it[0];
            int end = it[1];

            boolean aIn = (a >= start && a <= end);
            boolean bIn = (b >= start && b <= end);

            if (aIn && bIn) {
                continue;
            }

            if (bIn) {
                result += 1;
                a = b;
                b = end;
            } else {
                result += 2;
                a = end - 1;
                b = end;
            }
        }

        return result;
    }
}
