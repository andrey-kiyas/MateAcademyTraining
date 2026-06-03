package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii
 */

public class LC3635EarliestFinishTimeForLandAndWaterRidesII {
    public static void main(String[] args) {
        int[] landStart1 = {2, 8};
        int[] landDur1 = {4, 1};
        int[] waterStart1 = {6};
        int[] waterDur1 = {3};
        System.out.println(earliestFinishTime(landStart1, landDur1, waterStart1, waterDur1)); // 9

        int[] landStart2 = {5};
        int[] landDur2 = {3};
        int[] waterStart2 = {1};
        int[] waterDur2 = {10};
        System.out.println(earliestFinishTime(landStart2, landDur2, waterStart2, waterDur2)); // 14
    }

    private static class Ride implements Comparable<Ride> {
        int start, duration, end;

        Ride(int start, int duration) {
            this.start = start;
            this.duration = duration;
            this.end = start + duration;
        }

        @Override
        public int compareTo(Ride o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ansScenarioA = solveOneWay(landStartTime, landDuration, waterStartTime, waterDuration);
        int ansScenarioB = solveOneWay(waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(ansScenarioA, ansScenarioB);
    }

    private static int solveOneWay(int[] start1, int[] dur1, int[] start2, int[] dur2) {
        int n = start1.length;
        int m = start2.length;

        Ride[] rides2 = new Ride[m];
        for (int j = 0; j < m; j++) {
            rides2[j] = new Ride(start2[j], dur2[j]);
        }
        Arrays.sort(rides2);

        int[] prefMinDur = new int[m];
        prefMinDur[0] = rides2[0].duration;
        for (int j = 1; j < m; j++) {
            prefMinDur[j] = Math.min(prefMinDur[j - 1], rides2[j].duration);
        }

        int[] suffMinEnd = new int[m];
        suffMinEnd[m - 1] = rides2[m - 1].end;
        for (int j = m - 2; j >= 0; j--) {
            suffMinEnd[j] = Math.min(suffMinEnd[j + 1], rides2[j].end);
        }

        int minOverallFinish = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int f1 = start1[i] + dur1[i];

            int idx = binarySearch(rides2, f1);

            if (idx >= 0) {
                int minDur = prefMinDur[idx];
                minOverallFinish = Math.min(minOverallFinish, f1 + minDur);
            }

            if (idx + 1 < m) {
                int minEnd = suffMinEnd[idx + 1];
                minOverallFinish = Math.min(minOverallFinish, minEnd);
            }
        }

        return minOverallFinish;
    }

    private static int binarySearch(Ride[] rides, int target) {
        int left = 0, right = rides.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (rides[mid].start <= target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
