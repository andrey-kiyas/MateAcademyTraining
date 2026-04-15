package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-total-distance-traveled
 */

public class LC2463MinimumTotalDistanceTraveled {
    public static void main(String[] args) {
        List<Integer> robots1 = Arrays.asList(0, 4, 6);
        int[][] factory1 = {{2, 2}, {6, 2}};
        System.out.println("Result 1: " + minimumTotalDistance(robots1, factory1)); // 4

        List<Integer> robots2 = Arrays.asList(1, -1);
        int[][] factory2 = {{-2, 1}, {2, 1}};
        System.out.println("Result 2: " + minimumTotalDistance(robots2, factory2)); // 2
    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        List<Integer> factorySlots = new ArrayList<>();
        for (int[] f : factory) {
            for (int k = 0; k < f[1]; k++) {
                factorySlots.add(f[0]);
            }
        }

        int n = robot.size();
        int m = factorySlots.size();

        long[][] dp = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = (long) 1e16;
        }

        for (int j = 1; j <= m; j++) {
            for (int i = 0; i <= n; i++) {
                dp[i][j] = dp[i][j - 1];

                if (i > 0) {
                    long dist = Math.abs(robot.get(i - 1) - factorySlots.get(j - 1));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dist);
                }
            }
        }

        return dp[n][m];
    }
}
