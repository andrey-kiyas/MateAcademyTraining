package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i
 */

public class LC3439RescheduleMeetingsForMaximumFreeTimeI {
    public static void main(String[] args) {
        System.out.println(maxFreeTime(5, 1, new int[]{1, 3}, new int[]{2, 5}));                   // 2
        System.out.println(maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10}));           // 6
        System.out.println(maxFreeTime(5, 2, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5})); // 0
    }

    public static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        if (eventTime > endTime[endTime.length - 1]) {
            int[] newStartTime = new int[startTime.length + 1];
            int[] newEndTime = new int[endTime.length + 1];
            System.arraycopy(startTime, 0, newStartTime, 0, startTime.length);
            System.arraycopy(endTime, 0, newEndTime, 0, endTime.length);
            newStartTime[startTime.length] = eventTime;
            newEndTime[endTime.length] = eventTime;
            startTime = newStartTime;
            endTime = newEndTime;
        }

        int n = startTime.length;
        int max_sum = 0;
        int win_sum = 0;
        int pos = 0;
        int last_end = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        while (pos < n) {
            win_sum += (startTime[pos] - last_end);
            dq.addLast(startTime[pos] - last_end);
            max_sum = Math.max(max_sum, win_sum);
            if (dq.size() > k) {
                win_sum -= dq.removeFirst();
            }
            last_end = endTime[pos];
            pos++;
        }
        return max_sum;
    }
}
