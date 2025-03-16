package MateAcademy.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-time-to-repair-cars
 */

public class LC2594MinimumTimeToRepairCars {
    public static void main(String[] args) {
        System.out.println(repairCars(new int[]{4, 2, 3, 1}, 10)); // 16
        System.out.println(repairCars(new int[]{5, 1, 8}, 6));     // 16
    }

    public static long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);

        long left = 1, right = (long) ranks[0] * (long) cars * cars;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAll(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canRepairAll(int[] ranks, int cars, long maxTime) {
        long totalCars = 0;
        for (int r : ranks) {
            totalCars += (long) Math.sqrt(maxTime / r);
            if (totalCars >= cars) return true;
        }
        return false;
    }
}
