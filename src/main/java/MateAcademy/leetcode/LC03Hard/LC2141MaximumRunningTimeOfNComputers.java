package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/maximum-running-time-of-n-computers
 */

public class LC2141MaximumRunningTimeOfNComputers {
    public static void main(String[] args) {
        System.out.println(maxRunTime(2, new int[]{3, 3, 3}));    // 4
        System.out.println(maxRunTime(2, new int[]{1, 1, 1, 1})); // 2
    }

    public static long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int x : batteries) sum += x;

        long left = 0;
        long right = sum / n;

        while (left < right) {
            long mid = (left + right + 1) / 2;

            if (canRun(mid, n, batteries)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static boolean canRun(long T, int n, int[] batteries) {
        long total = 0;

        for (int b : batteries) {
            total += Math.min(b, T);
            if (total >= T * n) return true;
        }
        return total >= T * n;
    }
}
