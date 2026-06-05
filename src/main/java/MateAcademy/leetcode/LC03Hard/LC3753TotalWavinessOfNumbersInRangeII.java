package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii
 */

public class LC3753TotalWavinessOfNumbersInRangeII {
    private static long[][][][][] dp;

    public static void main(String[] args) {
        System.out.println(totalWaviness(120, 130));   // 3
        System.out.println(totalWaviness(198, 202));   // 3
        System.out.println(totalWaviness(4848, 4848)); // 2
    }

    public static long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private static long solve(long num) {
        if (num < 100) return 0;

        String s = Long.toString(num);
        int n = s.length();

        dp = new long[n][11][11][2][];

        long[] result = countWaviness(0, 10, 10, true, true, s);
        return result[0];
    }

    private static long[] countWaviness(int idx, int prev, int prevPrev, boolean isLeadingZero, boolean isTight, String s) {
        if (idx == s.length()) {
            return new long[]{0, 1};
        }

        if (!isTight && dp[idx][prev][prevPrev][isLeadingZero ? 1 : 0] != null) {
            return dp[idx][prev][prevPrev][isLeadingZero ? 1 : 0];
        }

        long totalWaviness = 0;
        long totalCount = 0;

        int limit = isTight ? (s.charAt(idx) - '0') : 9;

        for (int d = 0; d <= limit; d++) {
            boolean nextTight = isTight && (d == limit);
            boolean nextLeadingZero = isLeadingZero && (d == 0);

            int wavinessBonus = 0;
            if (!isLeadingZero && prevPrev != 10 && prev != 10) {
                if ((prev > prevPrev && prev > d) || (prev < prevPrev && prev < d)) {
                    wavinessBonus = 1;
                }
            }

            int nextPrev = nextLeadingZero ? 10 : d;
            int nextPrevPrev = nextLeadingZero ? 10 : prev;

            long[] nextRes = countWaviness(idx + 1, nextPrev, nextPrevPrev, nextLeadingZero, nextTight, s);

            long countFromRemaining = nextRes[1];
            long wavinessFromRemaining = nextRes[0];

            totalWaviness += wavinessBonus * countFromRemaining + wavinessFromRemaining;
            totalCount += countFromRemaining;
        }

        long[] res = new long[]{totalWaviness, totalCount};
        if (!isTight) {
            dp[idx][prev][prevPrev][isLeadingZero ? 1 : 0] = res;
        }

        return res;
    }
}
