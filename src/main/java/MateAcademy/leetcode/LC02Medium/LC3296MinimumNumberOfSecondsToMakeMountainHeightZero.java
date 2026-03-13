package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero
 */

public class LC3296MinimumNumberOfSecondsToMakeMountainHeightZero {
    public static void main(String[] args) {
        System.out.println(minNumberOfSeconds(4, new int[]{2, 1, 1}));     // 3
        System.out.println(minNumberOfSeconds(10, new int[]{3, 2, 2, 4})); // 12
        System.out.println(minNumberOfSeconds(5, new int[]{1}));           // 15
    }

    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0;
        long high = (long) 1e16;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canReduce(mountainHeight, workerTimes, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean canReduce(int mountainHeight, int[] workerTimes, long timeLimit) {
        long totalHeightReduced = 0;

        for (int wTime : workerTimes) {
            // Розв'язуємо x(x+1)/2 <= timeLimit / wTime
            long maxPossibleX = (long) ((-1 + Math.sqrt(1 + 8.0 * timeLimit / wTime)) / 2);
            totalHeightReduced = totalHeightReduced + maxPossibleX;

            if (totalHeightReduced >= mountainHeight) return true;
        }

        return totalHeightReduced >= mountainHeight;
    }
}
