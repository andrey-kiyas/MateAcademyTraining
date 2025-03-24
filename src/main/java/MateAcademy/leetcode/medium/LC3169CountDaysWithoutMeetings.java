package MateAcademy.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/count-days-without-meetings
 */

public class LC3169CountDaysWithoutMeetings {
    public static void main(String[] args) {
        System.out.println(countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}})); // Output: 2
        System.out.println(countDays(5, new int[][]{{2, 4}, {1, 3}}));           // Output: 1
        System.out.println(countDays(6, new int[][]{{1, 6}}));                   // Output: 0
    }

    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int busyDays = 0, lastEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            if (start > lastEnd + 1) {
                busyDays += (end - start + 1);
            } else {
                busyDays += Math.max(0, end - lastEnd);
            }

            lastEnd = Math.max(lastEnd, end);
        }

        return days - busyDays;
    }
}
