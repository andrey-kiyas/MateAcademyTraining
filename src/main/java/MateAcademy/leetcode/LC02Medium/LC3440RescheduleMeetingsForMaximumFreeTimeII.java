package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii
 */

public class LC3440RescheduleMeetingsForMaximumFreeTimeII {
    public static void main(String[] args) {
        System.out.println(maxFreeTime(5, new int[]{1, 3}, new int[]{2, 5}));                   // 2
        System.out.println(maxFreeTime(10, new int[]{0, 7, 9}, new int[]{1, 8, 10}));           // 7
        System.out.println(maxFreeTime(10, new int[]{0, 3, 7, 9}, new int[]{1, 4, 8, 10}));     // 6
        System.out.println(maxFreeTime(5, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5})); // 0
    }

    public static int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        final int n = startTime.length;
        final int[] gaps = getGaps(eventTime, startTime, endTime);
        int ans = 0;
        int[] maxLeft = new int[n + 1];
        int[] maxRight = new int[n + 1];

        maxLeft[0] = gaps[0];
        maxRight[n] = gaps[n];

        for (int i = 1; i < n + 1; ++i)
            maxLeft[i] = Math.max(gaps[i], maxLeft[i - 1]);

        for (int i = n - 1; i >= 0; --i)
            maxRight[i] = Math.max(gaps[i], maxRight[i + 1]);

        for (int i = 0; i < n; ++i) {
            final int currMeetingTime = endTime[i] - startTime[i];
            final int adjacentGapsSum = gaps[i] + gaps[i + 1];
            final boolean canMoveMeeting =
                    currMeetingTime <= Math.max(i > 0 ? maxLeft[i - 1] : 0, //
                            i + 2 < n + 1 ? maxRight[i + 2] : 0);
            ans = Math.max(ans, adjacentGapsSum + (canMoveMeeting ? currMeetingTime : 0));
        }

        return ans;
    }

    private static int[] getGaps(int eventTime, int[] startTime, int[] endTime) {
        int[] gaps = new int[startTime.length + 1];
        gaps[0] = startTime[0];
        for (int i = 1; i < startTime.length; ++i)
            gaps[i] = startTime[i] - endTime[i - 1];
        gaps[startTime.length] = eventTime - endTime[endTime.length - 1];
        return gaps;
    }
}
