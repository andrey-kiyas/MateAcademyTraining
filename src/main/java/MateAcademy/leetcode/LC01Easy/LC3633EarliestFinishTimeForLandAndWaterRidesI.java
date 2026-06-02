package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i
 */

public class LC3633EarliestFinishTimeForLandAndWaterRidesI {
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

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minFinishTime = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int landFinish = landStartTime[i] + landDuration[i];
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int finishScenario1 = waterStart + waterDuration[j];

                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landStart = Math.max(waterFinish, landStartTime[i]);
                int finishScenario2 = landStart + landDuration[i];

                minFinishTime = Math.min(minFinishTime, Math.min(finishScenario1, finishScenario2));
            }
        }

        return minFinishTime;
    }
}
