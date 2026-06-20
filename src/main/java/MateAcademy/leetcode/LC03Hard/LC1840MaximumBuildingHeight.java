package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-building-height
 */

public class LC1840MaximumBuildingHeight {
    public static void main(String[] args) {
        System.out.println(maxBuilding(5, new int[][]{{2, 1}, {4, 1}}));                   // 2
        System.out.println(maxBuilding(6, new int[][]{}));                                 // 5
        System.out.println(maxBuilding(10, new int[][]{{5, 3}, {2, 5}, {7, 4}, {10, 3}})); // 5
    }

    public static int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        int[][] arr = new int[m + 2][2];
        arr[0] = new int[]{1, 0};
        arr[1] = new int[]{n, n - 1};

        System.arraycopy(restrictions, 0, arr, 2, m);

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < arr.length; i++) {
            int dist = arr[i][0] - arr[i - 1][0];
            arr[i][1] = Math.min(arr[i][1], arr[i - 1][1] + dist);
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            int dist = arr[i + 1][0] - arr[i][0];
            arr[i][1] = Math.min(arr[i][1], arr[i + 1][1] + dist);
        }

        int maxGlobalHeight = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int id1 = arr[i][0];
            int h1 = arr[i][1];
            int id2 = arr[i + 1][0];
            int h2 = arr[i + 1][1];

            // Формула перетину двох ліній під кутом 45 градусів
            int peak = (h1 + h2 + (id2 - id1)) / 2;
            maxGlobalHeight = Math.max(maxGlobalHeight, peak);
        }

        return maxGlobalHeight;
    }
}
