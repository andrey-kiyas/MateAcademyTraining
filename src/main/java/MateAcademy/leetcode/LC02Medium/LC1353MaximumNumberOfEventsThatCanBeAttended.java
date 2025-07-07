package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description
 */

public class LC1353MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        System.out.println(maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}}));         // 3
        System.out.println(maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}})); // 4
    }

    public static int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, res = 0;
        int n = events.length;
        int day = 1;

        // Find the last possible day
        int maxDay = 0;
        for (int[] event : events) {
            maxDay = Math.max(maxDay, event[1]);
        }

        while (day <= maxDay) {
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }

            day++;
        }

        return res;
    }
}
